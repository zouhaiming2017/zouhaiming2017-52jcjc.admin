package com.jixi.service.impl;

import com.jixi.mapper.SellmanMapper;
import com.jixi.mapper.SellmandetailMapper;
import com.jixi.mapper.SellorderSumMapper;
import com.jixi.pojo.Sellman;
import com.jixi.pojo.SellmanExample;
import com.jixi.pojo.Sellmandetail;
import com.jixi.pojo.SellorderSum;
import com.jixi.service.ISellmanDetailService;
import com.jixi.utils.DateUtil;
import com.jixi.utils.DoubleFormatUtil;
import com.jixi.utils.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by zhm on 2017/11/10.
 */
@Service
public class SellmanDetailService implements ISellmanDetailService {

    @Autowired
    private SellmandetailMapper sellmandetailMapper;
    @Autowired
    private SellorderSumMapper sellorderSumMapper;

    /**
     * 判断customermonthcode是否存在
     *
     * @param sellmanmonthcode
     * @return
     */
    public boolean isExist(String sellmanmonthcode) {
        try {
            Sellmandetail sellmandetail = sellmandetailMapper.selectByPrimaryKey(sellmanmonthcode);
            if (sellmandetail == null) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    /**
     * 获得销售月度明细
     * @param year
     * @param month
     * @return
     * @throws ParseException
     */
    @Override
    public List<Sellmandetail> updateSellmanDetailFromOrder(String year, String month) throws ParseException {
        List<Sellmandetail> sellmandetails=new ArrayList<>();
        //获得时间
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat format2=new SimpleDateFormat("yyyyMM");
        Map dates= DateUtil.getDates(year,month);
        String startDate=format.format(dates.get("startDate"));
        String endDate=format.format(dates.get("endDate"));
        //获得所有销售姓名
        List<SellorderSum> sellmannames=sellorderSumMapper.selectDistinctSellman();
        for(SellorderSum sellorderSum:sellmannames){
            Map map=new HashMap();
            map.put("sellman",sellorderSum.getSellman());
            map.put("startDate",format.parse(startDate));
            map.put("endDate",format.parse(endDate));
            //根据销售姓名和起止时间查出客户订单数据
            List<SellorderSum> sellorderSumList=sellorderSumMapper.selectDetailBysellman(map);
            //统计总金额、已收金额、未收金额、提成
            Double discountPrices=0.0;
            Double recieveprices=0.0;
            Double noRecieveprices=0.0;
            Double commissions=0.0;
            //将数据添加到销售月度明细表
            Sellmandetail sellmandetail=new Sellmandetail();
            String sellmanmonthcode="";
            for(SellorderSum s:sellorderSumList){

                sellmanmonthcode=format2.format(dates.get("startDate"))+s.getSellman();

                sellmandetail.setSellmanmonthcode(sellmanmonthcode);
                sellmandetail.setSellmanname(s.getSellman());
                sellmandetail.setDiscountprices(DoubleFormatUtil.getFormatSums(discountPrices+=s.getDiscountprice()));
                sellmandetail.setRecieveprices(DoubleFormatUtil.getFormatSums(recieveprices+=s.getReceivedsum()));
                sellmandetail.setNorecieveprices(DoubleFormatUtil.getFormatSums(noRecieveprices+=s.getNoreceivedsum()));
                sellmandetail.setCommissions(DoubleFormatUtil.getFormatSums(commissions+=s.getCommission()));
            }

            if(sellmanmonthcode.equals("")){
                continue;
            }

            if (!isExist(sellmanmonthcode)) {
                //不存在就添加
                sellmandetailMapper.insertSelective(sellmandetail);
            } else {
                //存在就更新
                sellmandetailMapper.updateByPrimaryKeySelective(sellmandetail);
            }
            sellmandetails.add(sellmandetail);
        }

        return sellmandetails;
    }

    /**
     * 导出销售月度明细
     * @param outputStream
     * @param sellmanmonthcodes
     * @throws Exception
     */
    @Override
    public void exportExcel(OutputStream outputStream, String[] sellmanmonthcodes) throws Exception {
        List<List<String>> stringList=new ArrayList<>();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM");
        SimpleDateFormat format1=new SimpleDateFormat("yyyyMM");
        //创建表头内容
        List<String> headList = new ArrayList<>();
        headList.add("编号");
        headList.add("销售姓名");
        headList.add("月份");
        headList.add("订单金额");
        headList.add("已收款金额");
        headList.add("未收款金额");
        headList.add("提成金额");
        //获得表尾数据
        List<String> tails=new ArrayList<>();
        Double discountPrices=0.0;
        Double recieveprices=0.0;
        Double noRecieveprices=0.0;
        Double sellmanCommissions=0.0;

        for(int i=0;i<sellmanmonthcodes.length;i++) {
            List<String> ss = new ArrayList<>();
            Sellmandetail sellmandetail=sellmandetailMapper.selectByPrimaryKey(sellmanmonthcodes[i]);

            ss.add(sellmandetail.getSellmanmonthcode());
            ss.add(sellmandetail.getSellmanname());
            Date month=format1.parse(sellmandetail.getSellmanmonthcode().substring(0,6));
            ss.add(format.format(month));
            ss.add(sellmandetail.getDiscountprices().toString());
            ss.add(sellmandetail.getRecieveprices().toString());
            ss.add(sellmandetail.getNorecieveprices().toString());
            ss.add(sellmandetail.getCommissions().toString());

            discountPrices+=sellmandetail.getDiscountprices();
            recieveprices+=sellmandetail.getRecieveprices();
            noRecieveprices+=sellmandetail.getNorecieveprices();
            sellmanCommissions+=sellmandetail.getCommissions();

            stringList.add(ss);
        }
        tails.add(DoubleFormatUtil.getFormatSums(discountPrices).toString());
        tails.add(DoubleFormatUtil.getFormatSums(recieveprices).toString());
        tails.add(DoubleFormatUtil.getFormatSums(noRecieveprices).toString());
        tails.add(DoubleFormatUtil.getFormatSums(sellmanCommissions).toString());

        ExcelUtil.outputToExcel(stringList,headList,tails,"销售月度明细表",outputStream);
    }
}
