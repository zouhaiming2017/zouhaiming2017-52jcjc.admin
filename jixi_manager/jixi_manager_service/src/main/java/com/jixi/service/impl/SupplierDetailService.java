package com.jixi.service.impl;

import com.jixi.mapper.PickorderSumMapper;
import com.jixi.mapper.SupplierdetailMapper;
import com.jixi.pojo.PickorderSum;
import com.jixi.pojo.Supplierdetail;
import com.jixi.service.ISupplierDetailService;
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
public class SupplierDetailService implements ISupplierDetailService {

    @Autowired
    private SupplierdetailMapper supplierdetailMapper;
    @Autowired
    private PickorderSumMapper pickorderSumMapper;


    /**
     * 判断suppliermonthcode是否存在
     *
     * @param suppliermonthcode
     * @return
     */
    public boolean isExist(String suppliermonthcode) {
        try {
            Supplierdetail supplierdetail = supplierdetailMapper.selectByPrimaryKey(suppliermonthcode);
            if (supplierdetail == null) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    /**
     * 获得供应商月度明细
     * @param year
     * @param month
     * @return
     * @throws ParseException
     */
    @Override
    public List<Supplierdetail> updateSupplierDetailFromOrder(String year, String month) throws ParseException {
        List<Supplierdetail> supplierdetails=new ArrayList<>();
        //获得时间
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat format2=new SimpleDateFormat("yyyyMM");
        Map dates= DateUtil.getDates(year,month);
        String startDate=format.format(dates.get("startDate"));
        String endDate=format.format(dates.get("endDate"));
        //获得所有供应商名
        List<PickorderSum> suppliernames=pickorderSumMapper.selectDistinctSupplier();
        for(PickorderSum pickorderSum:suppliernames){
            Map map=new HashMap();
            map.put("supplier",pickorderSum.getSupplier());
            map.put("startDate",format.parse(startDate));
            map.put("endDate",format.parse(endDate));
            //根据供应商名和起止时间查出供应单数据
            List<PickorderSum> pickorderSumList=pickorderSumMapper.selectDetailBySupplier(map);
            //统计供应商总金额、总运费
            Double supplierSums=0.0;
            Double supplierFreights=0.0;
            //将数据添加到供应商月度明细表
            Supplierdetail supplierdetail=new Supplierdetail();
            String suppliermonthcode="";
            for(PickorderSum p:pickorderSumList){
                suppliermonthcode=format2.format(dates.get("startDate"))+p.getSupplier();

                supplierdetail.setSuppliermonthcode(suppliermonthcode);
                supplierdetail.setSuppliername(p.getSupplier());
                supplierdetail.setSuppliersums(DoubleFormatUtil.getFormatSums(supplierSums+=p.getAllsum()));
                supplierdetail.setSupplierfreights(DoubleFormatUtil.getFormatSums(supplierFreights+=p.getFreight()));
                supplierdetail.setFreightpro(new java.text.DecimalFormat("0.00").format(supplierdetail.getSupplierfreights()/supplierdetail.getSuppliersums()*100)+"%");
            }
            if(suppliermonthcode.equals("")){
                continue;
            }
            if (!isExist(suppliermonthcode)) {
                //不存在就添加
                supplierdetailMapper.insertSelective(supplierdetail);
            } else {
                //存在就更新
                supplierdetailMapper.updateByPrimaryKeySelective(supplierdetail);
            }
            supplierdetails.add(supplierdetail);

        }

        return supplierdetails;
    }

    /**
     * 导出数据到excel
     * @param outputStream
     * @param suppliermonthcodes
     * @throws Exception
     */
    @Override
    public void exportExcel(OutputStream outputStream, String[] suppliermonthcodes) throws Exception {
        List<List<String>> stringList=new ArrayList<>();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM");
        SimpleDateFormat format1=new SimpleDateFormat("yyyyMM");
        //创建表头内容
        List<String> headList = new ArrayList<>();
        headList.add("编号");
        headList.add("供应商名");
        headList.add("月份");
        headList.add("供应商金额");
        headList.add("供应商运费");
        headList.add("运费占比");

        //获得表尾数据
        List<String> tails=new ArrayList<>();
        Double supplierSums=0.0;
        Double supplierFreights=0.0;

        for(int i=0;i<suppliermonthcodes.length;i++) {
            List<String> ss = new ArrayList<>();
            Supplierdetail supplierdetail=supplierdetailMapper.selectByPrimaryKey(suppliermonthcodes[i]);

            ss.add(supplierdetail.getSuppliermonthcode());
            ss.add(supplierdetail.getSuppliername());
            Date month=format1.parse(supplierdetail.getSuppliermonthcode().substring(0,6));
            ss.add(format.format(month));
            ss.add(supplierdetail.getSuppliersums().toString());
            ss.add(supplierdetail.getSupplierfreights().toString());
            ss.add(supplierdetail.getFreightpro());

            supplierSums+=supplierdetail.getSuppliersums();
            supplierFreights+=supplierdetail.getSupplierfreights();

            stringList.add(ss);
        }
        tails.add(DoubleFormatUtil.getFormatSums(supplierSums).toString());
        tails.add(DoubleFormatUtil.getFormatSums(supplierFreights).toString());
        tails.add(DoubleFormatUtil.getFormatSums(supplierFreights/supplierSums*100)+"%");

        ExcelUtil.outputToExcel(stringList,headList,tails,"供应商月度明细表",outputStream);
    }
}
