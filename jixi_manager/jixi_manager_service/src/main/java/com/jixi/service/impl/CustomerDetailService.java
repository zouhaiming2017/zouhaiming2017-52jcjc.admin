package com.jixi.service.impl;

import com.jixi.mapper.CommissionMapper;
import com.jixi.mapper.CustomerdetailMapper;
import com.jixi.mapper.SellorderSumMapper;
import com.jixi.pojo.*;
import com.jixi.service.ICustomerDetailService;
import com.jixi.utils.DateUtil;
import com.jixi.utils.DoubleFormatUtil;
import com.jixi.utils.ExcelUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by zhm on 2017/11/9.
 */
@Service
public class CustomerDetailService implements ICustomerDetailService {
    @Autowired
    private CustomerdetailMapper customerdetailMapper;
    @Autowired
    private SellorderSumMapper sellorderSumMapper;
    @Autowired
    private CommissionMapper commissionMapper;

    /**
     * 判断customermonthcode是否存在
     *
     * @param customermonthcode
     * @return
     */
    public boolean isExist(String customermonthcode) {
        try {
            Customerdetail customerdetail = customerdetailMapper.selectByPrimaryKey(customermonthcode);
            if (customerdetail == null) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }


    /**
     * 查询客户明细列表
     * @return
     */
    @Override
    public List<Customerdetail> selectByExample() {
        CustomerdetailExample example=new CustomerdetailExample();
        List<Customerdetail> customerdetails=customerdetailMapper.selectByExample(example);
        return customerdetails;
    }

    /**
     * 查询单个客户明细列表
     * @param customermonthcode
     * @return
     */
    @Override
    public Customerdetail selectByPrimaryKey(String customermonthcode) {
        return customerdetailMapper.selectByPrimaryKey(customermonthcode);
    }

    /**
     * 从客户订单表更新客户明细列表
     * @return
     */
    @Override
    public List<Customerdetail> updateCustomerDetailFromOrder(String year,String month) throws ParseException {
        List<Customerdetail> customerdetails=new ArrayList<>();
        //查出所有客户姓名
        List<SellorderSum> customerNames=sellorderSumMapper.selectDistinctCustomerName();
        //获得时间
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat format2=new SimpleDateFormat("yyyyMM");
        Map dates=DateUtil.getDates(year,month);
        String startDate=format.format(dates.get("startDate"));
        String endDate=format.format(dates.get("endDate"));

        for(SellorderSum sellorderSum:customerNames){
            Map map=new HashMap();
            map.put("customername",sellorderSum.getCustomername());
            map.put("startDate",format.parse(startDate));
            map.put("endDate",format.parse(endDate));
            //根据客户姓名和起止时间查出客户订单数据
            List<SellorderSum> sellorderSumList=sellorderSumMapper.selectByCustomerName(map);
            //统计总金额、总运费、总提成
            Double discountPrices=0.0;
            Double freights=0.0;
            Double commissions=0.0;
            //将数据添加到客户明细表
            Customerdetail customerdetail=new Customerdetail();
            String customermonthcode="";
            for(SellorderSum s:sellorderSumList){

                customermonthcode=format2.format(dates.get("startDate"))+s.getCustomername();

                customerdetail.setCustomermonthcode(customermonthcode);
                customerdetail.setCustomername(s.getCustomername());
                customerdetail.setSellman(s.getSellman());
                customerdetail.setDiscountprices(DoubleFormatUtil.getFormatSums(discountPrices+=s.getDiscountprice()));
                customerdetail.setFreight(DoubleFormatUtil.getFormatSums(freights+=s.getFreight()));
                customerdetail.setFreightpro(new java.text.DecimalFormat("0.00").format(customerdetail.getFreight()/customerdetail.getDiscountprices()*100)+"%");
                customerdetail.setCount(Long.parseLong(sellorderSumList.size()+""));
                customerdetail.setCustomertype(s.getCustomertype());

                Commission commission=commissionMapper.selectByPrimaryKey(1);
                switch(customerdetail.getCustomertype()==null?"":customerdetail.getCustomertype()){
                    case "T1":
                        customerdetail.setCommissionpro(DoubleFormatUtil.getFormatSums(commission.getT1()*100)+"%");break;
                    case "T2":
                        customerdetail.setCommissionpro(DoubleFormatUtil.getFormatSums(commission.getT2()*100)+"%");break;
                    case "T3":
                        customerdetail.setCommissionpro(DoubleFormatUtil.getFormatSums(commission.getT3()*100)+"%");break;
                    case "T4":
                        customerdetail.setCommissionpro(DoubleFormatUtil.getFormatSums(commission.getT4()*100)+"%");break;
                    case "T5":
                        customerdetail.setCommissionpro(DoubleFormatUtil.getFormatSums(commission.getT5()*100)+"%");break;
                    default:
                        customerdetail.setCommissionpro("未定义客户类型");break;
                }
                customerdetail.setSellmancommission(DoubleFormatUtil.getFormatSums(commissions+=s.getCommission()));
            }
            if(customermonthcode.equals("")){
                continue;
            }
            if (!isExist(customermonthcode)) {
                //不存在就添加
                customerdetailMapper.insertSelective(customerdetail);
            } else {
                //存在就更新
                customerdetailMapper.updateByPrimaryKeySelective(customerdetail);
            }
            customerdetails.add(customerdetail);

        }
        return customerdetails;

    }


    /**
     * 导出数据到excel
     * @param outputStream
     * @param customermonthcodes
     * @throws Exception
     */
    @Override
    public void exportExcel(OutputStream outputStream, String[] customermonthcodes) throws Exception {
        List<List<String>> stringList=new ArrayList<>();
        //创建表头内容
        List<String> headList = new ArrayList<>();
        headList.add("编号");
        headList.add("客户姓名");
        headList.add("销售经理");
        headList.add("订单金额");
        headList.add("运费");
        headList.add("运费比例");
        headList.add("订单数量");
        headList.add("客户分类");
        headList.add("提成比例");
        headList.add("销售提成");
        //获得表尾数据
        List<String> tails=new ArrayList<>();
        Double discountPrices=0.0;
        Double freights=0.0;
        int counts=0;
        Double sellmanCommissions=0.0;

        for(int i=0;i<customermonthcodes.length;i++) {
            List<String> ss = new ArrayList<>();
            Customerdetail customerdetail=customerdetailMapper.selectByPrimaryKey(customermonthcodes[i]);

            ss.add(customerdetail.getCustomermonthcode());
            ss.add(customerdetail.getCustomername());
            ss.add(customerdetail.getSellman());
            ss.add(customerdetail.getDiscountprices().toString());
            ss.add(customerdetail.getFreight().toString());
            ss.add(customerdetail.getFreightpro());
            ss.add(customerdetail.getCount().toString());
            ss.add(customerdetail.getCustomertype());
            ss.add(customerdetail.getCommissionpro());
            ss.add(customerdetail.getSellmancommission().toString());

            discountPrices+=customerdetail.getDiscountprices();
            freights+=customerdetail.getFreight();
            counts+=customerdetail.getCount();
            sellmanCommissions+=customerdetail.getSellmancommission();


            stringList.add(ss);
        }
        tails.add(DoubleFormatUtil.getFormatSums(discountPrices).toString());
        tails.add(DoubleFormatUtil.getFormatSums(freights).toString());
        tails.add(DoubleFormatUtil.getFormatSums(freights/discountPrices*100)+"%");
        tails.add(counts+"");
        tails.add("");
        tails.add("");
        tails.add(DoubleFormatUtil.getFormatSums(sellmanCommissions).toString());

        ExcelUtil.outputToExcel(stringList,headList,tails,"客户月度明细表",outputStream);
    }


}
