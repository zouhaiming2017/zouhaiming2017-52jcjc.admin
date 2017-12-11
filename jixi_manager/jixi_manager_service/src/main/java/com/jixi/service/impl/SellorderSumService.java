package com.jixi.service.impl;

import com.jixi.mapper.CustomerMapper;
import com.jixi.mapper.SellorderSumMapper;
import com.jixi.pojo.SellorderSum;
import com.jixi.pojo.SellorderSumExample;
import com.jixi.service.ISellorderSumService;
import com.jixi.utils.DoubleFormatUtil;
import com.jixi.utils.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by zhm on 2017/9/5.
 */
@Service
public class SellorderSumService implements ISellorderSumService {
    @Autowired
    private  SellorderSumMapper sellorderSumMapper;

    @Autowired
    private CustomerMapper customerMapper;

    /**
     * 判断sellordercode是否存在
     *
     * @param sellordercode
     * @return
     */
    public boolean isExist(String sellordercode) {
        try {
            SellorderSum sellorderSum = sellorderSumMapper.selectByPrimaryKey(sellordercode);
            if (sellorderSum == null) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    /**
     * 判断sellordercode是否为空
     */
    public boolean isNull(String sellordercode) {
        if (sellordercode != null && !"".equals(sellordercode)) {
            return true;
        }
        return false;
    }

    /**
     * 分页查询
     * @return
     */
    @Override
    public List<SellorderSum> getSellorderSumList() {
        //执行查询
        SellorderSumExample example = new SellorderSumExample();
        List<SellorderSum> list = sellorderSumMapper.selectByExample(example);

        return list;
    }

    /**
     * 根据业务员查找订单
     * @param sellman
     * @return
     */
    @Override
    public List<SellorderSum> selectBySellman(String sellman) {
        return sellorderSumMapper.selectBySellman(sellman);
    }


    /**
     * 按条件搜索
     * @param map
     * @return
     */
    @Override
    public List<SellorderSum> like(Map map) {
        List<SellorderSum> list=sellorderSumMapper.like(map);
        return list;
    }

    @Override
    public SellorderSum selectOne(String sellordercode) {
        SellorderSum sellorderSum=sellorderSumMapper.selectByPrimaryKey(sellordercode);
        return sellorderSum;
    }

    /**
     * 新增
     *
     * @param sellorderSum
     * @return
     * @throws Exception
     */
    @Override
    public void createSellorderSum(SellorderSum sellorderSum) throws Exception {
        sellorderSum.setAllsum(sellorderSum.getOnlinesum()+sellorderSum.getUnderlinesum()+sellorderSum.getFreight());
        sellorderSum.setReceivedsum(0.0);
        sellorderSum.setNoreceivedsum(sellorderSum.getDiscountprice());
        sellorderSumMapper.insertSelective(sellorderSum);
    }

    /**
     * 更新
     *
     * @param sellorderSum
     * @return
     * @throws Exception
     */
    @Override
    public void updateSellorderSum(SellorderSum sellorderSum) throws Exception {
        if(sellorderSum.getOnlinesum()!=null&&sellorderSum.getUnderlinesum()!=null&&sellorderSum.getFreight()!=null){
            sellorderSum.setAllsum(sellorderSum.getOnlinesum()+sellorderSum.getUnderlinesum()+sellorderSum.getFreight());
        }

        sellorderSumMapper.updateByPrimaryKeySelective(sellorderSum);

    }

    /**
     * 删除
     *
     * @param sellordercode
     * @return
     */
    @Override
    public void deleteSellorderSum(String[] sellordercode) {
        for (int i = 0; i < sellordercode.length; i++) {
            sellorderSumMapper.deleteByPrimaryKey(sellordercode[i]);
        }
    }

    @Override
    public void deleteOne(String sellordercode) {
        sellorderSumMapper.deleteByPrimaryKey(sellordercode);

    }


    /**
     * 从excel导入数据
     * @return
     * @throws ParseException
     */
    @Override
    public void saveBath(MultipartFile myFile, String path) throws Exception {
        List<List<List<String>>> ss= ExcelUtil.readExcel(myFile.getInputStream(),path,true);
        for(List<String> list:ss.get(0)) {
            SellorderSum sellorderSum = new SellorderSum();
            //获得订单编号
            String sellordercode =list.get(0);
            //添加数据或更新
            if (isNull(sellordercode)) {
                sellorderSum.setSellordercode(list.get(0));
                sellorderSum.setMaketableman(list.get(1));
                sellorderSum.setProjectname(list.get(2));
                sellorderSum.setCompany(list.get(3));
                sellorderSum.setCustomername(list.get(4));
                sellorderSum.setCustomerphone(list.get(5));
                sellorderSum.setSellman(list.get(6));
                sellorderSum.setSendman(list.get(7));
                sellorderSum.setPickman(list.get(8));
                sellorderSum.setPickmanphone(list.get(9));
                sellorderSum.setAddress(list.get(10));
                sellorderSum.setSendtype(list.get(11));
                sellorderSum.setOnlinesum(DoubleFormatUtil.getFormatDouble(list.get(13)));
                sellorderSum.setUnderlinesum(DoubleFormatUtil.getFormatDouble(list.get(15)));
                sellorderSum.setFreight(DoubleFormatUtil.getFormatDouble(list.get(17)));
                sellorderSum.setAllsum(DoubleFormatUtil.getFormatDouble(list.get(19)));
                sellorderSum.setDiscountprice(DoubleFormatUtil.getFormatDouble(list.get(21)));

                //获得时间
                String selldateStr = sellorderSum.getSellordercode().substring(0, 8);
                SimpleDateFormat format1 = new SimpleDateFormat("yyyyMMdd");
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                Date selldateDate = format1.parse(selldateStr);
                String selldate = format.format(selldateDate);
                sellorderSum.setSelldate(format.parse(selldate));
                //补充其它字段
                sellorderSum.setReceivedsum(0.0);
                sellorderSum.setNoreceivedsum(sellorderSum.getDiscountprice());
                sellorderSum.setAllpaystatue("0");
                sellorderSum.setTicketstatus("0");

                if (!isExist(sellordercode)) {
                    //不存在就添加
                    sellorderSumMapper.insertSelective(sellorderSum);
                } else {
                    //存在就跳过
                    continue;
                }
            }

        }
    }

    /**
     * 导出表数据到excel
     * @return
     */
    @Override
    public void exportExcel(OutputStream outputStream, String[] sellordercodes) throws Exception {
        List<List<String>> stringList=new ArrayList<>();
        //创建表头内容
        List<String> headList = new ArrayList<>();
        headList.add("订单编号");
        headList.add("项目名称");
        headList.add("公司名称");
        headList.add("线上商品合计");
        headList.add("线下商品合计");
        headList.add("运费");
        headList.add("总计");
        //获得表尾数据
        List<String> tails=new ArrayList<>();
        Double onlineSums=0.0;
        Double underLineSums=0.0;
        Double freights=0.0;
        Double discountprices=0.0;

        for(int i=0;i<sellordercodes.length;i++) {
            List<String> ss = new ArrayList<>();
            SellorderSum sellorderSum=sellorderSumMapper.selectByPrimaryKey(sellordercodes[i]);

            ss.add(sellorderSum.getSellordercode());
            ss.add(sellorderSum.getProjectname());
            ss.add(sellorderSum.getCompany());
            ss.add(sellorderSum.getOnlinesum().toString());
            ss.add(sellorderSum.getUnderlinesum().toString());
            ss.add(sellorderSum.getFreight().toString());
            ss.add(sellorderSum.getDiscountprice().toString());

            onlineSums+=sellorderSum.getOnlinesum();
            underLineSums+=sellorderSum.getUnderlinesum();
            freights+=sellorderSum.getFreight();
            discountprices+=sellorderSum.getDiscountprice();

            stringList.add(ss);
        }
        tails.add(DoubleFormatUtil.getFormatSums(onlineSums).toString());
        tails.add(DoubleFormatUtil.getFormatSums(underLineSums).toString());
        tails.add(DoubleFormatUtil.getFormatSums(freights).toString());
        tails.add(DoubleFormatUtil.getFormatSums(discountprices).toString());

        ExcelUtil.outputToExcel(stringList,headList,tails,"客户订单表",outputStream);
    }


    /**
     * 导出表数据到excel(按业务员提成导出)
     * @return
     */
    @Override
    public void exportExcelAsSellman(OutputStream outputStream, String[] sellordercodes,String sheetName) throws Exception {
        List<List<String>> stringList=new ArrayList<>();
        //创建表头内容
        List<String> headList = new ArrayList<>();
        headList.add("订单编号");
        headList.add("项目名称");
        headList.add("公司名称");
        headList.add("线上商品合计");
        headList.add("线下商品合计");
        headList.add("运费");
        headList.add("总计");
        headList.add("已收款");
        headList.add("未收款");
        headList.add("提成");
        headList.add("付款状态");
        //获得表尾数据
        List<String> tails=new ArrayList<>();
        Double onlineSums=0.0;
        Double underLineSums=0.0;
        Double freights=0.0;
        Double discountprices=0.0;
        Double receivedsums=0.0;
        Double noReceivedsums=0.0;
        Double commissions=0.0;

        for(int i=0;i<sellordercodes.length;i++) {
            List<String> ss = new ArrayList<>();
            SellorderSum sellorderSum=sellorderSumMapper.selectByPrimaryKey(sellordercodes[i]);

            ss.add(sellorderSum.getSellordercode());
            ss.add(sellorderSum.getProjectname());
            ss.add(sellorderSum.getCompany());
            ss.add(sellorderSum.getOnlinesum().toString());
            ss.add(sellorderSum.getUnderlinesum().toString());
            ss.add(sellorderSum.getFreight().toString());
            ss.add(sellorderSum.getDiscountprice().toString());
            ss.add(sellorderSum.getReceivedsum().toString());
            ss.add(sellorderSum.getNoreceivedsum().toString());
            ss.add(sellorderSum.getCommission().toString());
            ss.add(sellorderSum.getAllpaystatue()==null ||sellorderSum.getAllpaystatue().equals("0")?"未结清":"已结清");

            onlineSums+=sellorderSum.getOnlinesum();
            underLineSums+=sellorderSum.getUnderlinesum();
            freights+=sellorderSum.getFreight();
            discountprices+=sellorderSum.getDiscountprice();
            receivedsums+=sellorderSum.getReceivedsum();
            noReceivedsums+=sellorderSum.getNoreceivedsum();
            commissions+=sellorderSum.getCommission();

            stringList.add(ss);
        }
        tails.add(DoubleFormatUtil.getFormatSums(onlineSums).toString());
        tails.add(DoubleFormatUtil.getFormatSums(underLineSums).toString());
        tails.add(DoubleFormatUtil.getFormatSums(freights).toString());
        tails.add(DoubleFormatUtil.getFormatSums(discountprices).toString());
        tails.add(DoubleFormatUtil.getFormatSums(receivedsums).toString());
        tails.add(DoubleFormatUtil.getFormatSums(noReceivedsums).toString());
        tails.add(DoubleFormatUtil.getFormatSums(commissions).toString());
        tails.add("");

        ExcelUtil.outputToExcel(stringList,headList,tails,sheetName,outputStream);
    }

    /**
     * 导出表数据到excel(财务人员导出)
     * @return
     */
    @Override
    public void exportExcelAsFinance(OutputStream outputStream, String[] sellordercodes,String sheetName) throws Exception {
        List<List<String>> stringList=new ArrayList<>();
        //创建表头内容
        List<String> headList = new ArrayList<>();
        headList.add("订单编号");
        headList.add("项目名称");
        headList.add("业务员");
        headList.add("总计");
        headList.add("已收款");
        headList.add("未收款");
        headList.add("收款状态");
        headList.add("开票状态");
        headList.add("发票单号");
        headList.add("收货地址");
        //获得表尾数据
        List<String> tails=new ArrayList<>();
        Double discountprices=0.0;
        Double receivedsums=0.0;
        Double noReceivedsums=0.0;

        for(int i=0;i<sellordercodes.length;i++) {
            List<String> ss = new ArrayList<>();
            SellorderSum sellorderSum=sellorderSumMapper.selectByPrimaryKey(sellordercodes[i]);

            ss.add(sellorderSum.getSellordercode());
            ss.add(sellorderSum.getProjectname());
            ss.add(sellorderSum.getSellman());
            ss.add(sellorderSum.getDiscountprice().toString());
            ss.add(sellorderSum.getReceivedsum().toString());
            ss.add(sellorderSum.getNoreceivedsum().toString());
            ss.add(sellorderSum.getAllpaystatue()==null ||sellorderSum.getAllpaystatue().equals("0")?"未结清":"已结清");
            ss.add(sellorderSum.getTicketstatus()==null ||sellorderSum.getTicketstatus().equals("0")?"未开票":"已开票");
            ss.add(sellorderSum.getTicketno());
            ss.add(sellorderSum.getAddress());

            discountprices+=sellorderSum.getDiscountprice();
            receivedsums+=sellorderSum.getReceivedsum();
            noReceivedsums+=sellorderSum.getNoreceivedsum();

            stringList.add(ss);
        }
        tails.add(DoubleFormatUtil.getFormatSums(discountprices).toString());
        tails.add(DoubleFormatUtil.getFormatSums(receivedsums).toString());
        tails.add(DoubleFormatUtil.getFormatSums(noReceivedsums).toString());
        tails.add("");
        tails.add("");
        tails.add("");
        tails.add("");


        ExcelUtil.outputToExcel(stringList,headList,tails,sheetName,outputStream);
    }


    /**
     * 去重复查询项目名称
     */
    @Override
    public List<SellorderSum> selectDistinctProjectname() {
        List<SellorderSum> list=sellorderSumMapper.selectDistinctProjectname();
        return list;
    }

    /**
     * 根据销售去重复查询项目名称
     */
    @Override
    public List<SellorderSum> selectDistinctProjectnameBySellman(String sellman) {
        return sellorderSumMapper.selectDistinctProjectnameBySellman(sellman);
    }

    /**
     * 根据业务员去重复查询客户类型
     * @param sellman
     * @return
     */
    @Override
    public List<SellorderSum> selectDistinctCustomerTypeBySellman(String sellman) {
        return sellorderSumMapper.selectDistinctCustomerTypeBySellman(sellman);
    }

    /**
     * 去重复查询公司名称
     */
    @Override
    public List<SellorderSum> selectDistinctCompany() {
        List<SellorderSum> list=sellorderSumMapper.selectDistinctCompany();
        return list;
    }

    /**
     * 去重复查询工地名称
     */
    @Override
    public List<SellorderSum> selectDistinctAddress() {
        List<SellorderSum> list=sellorderSumMapper.selectDistinctAddress();
        return list;
    }


    /**
     * 去重复查询客户名
     */
    @Override
    public List<SellorderSum> selectDistinctCustomerName() {
        return sellorderSumMapper.selectDistinctCustomerName();
    }


    /**
     * 去重复查询业务员
     */
    @Override
    public List<SellorderSum> selectDistinctSellman() {
        return sellorderSumMapper.selectDistinctSellman();
    }

    /**
     * 去重复查询客户类型
     * @return
     */
    @Override
    public List<SellorderSum> selectDistinctCustomerType() {
        return sellorderSumMapper.selectDistinctCustomerType();
    }

    /**
     * 去重复查询客户电话
     * @return
     */
    @Override
    public List<SellorderSum> selectDistinctCustomerPhone() {
        return sellorderSumMapper.selectDistinctCustomerPhone();
    }

    /**
     * 统计总数
     * @return
     */
    @Override
    public long countByExample() {
        SellorderSumExample example = new SellorderSumExample();
        return sellorderSumMapper.countByExample(example);
    }

    /**
     * 获得当天订单数量
     * @return
     */
    @Override
    public long getTodayCount() throws ParseException {
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        String today=format.format(new Date());

        return sellorderSumMapper.getDayCount(today);
    }

    /**
     * 获得前一天的数量
     * @return
     */
    @Override
    public long getYesterdayCount() {
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        Calendar  calendar=new GregorianCalendar();
        calendar.setTime(new Date());//设置起时间
        calendar.add(calendar.DATE,-1);//把日期往后增加一天.整数往后推,负数往前移动

        return sellorderSumMapper.getDayCount(format.format(calendar.getTime()));
    }

    /**
     * 获得本周数量
     * @return
     */
    @Override
    public long getWeekCount() {
        return sellorderSumMapper.getWheekCount();
    }

    /**
     * 获得本月数量
     * @return
     */
    @Override
    public long getMonthCount() {
        return sellorderSumMapper.getMonthCount();
    }

    /**
     * 获得规定时间段的数据量
     * @param map
     * @return
     */
    @Override
    public long getCount(Map map) {
        return sellorderSumMapper.getCount(map);
    }

    /**
     * 根据客户类型获得总数量
     * @param map
     * @return
     */
    @Override
    public Long getCountByCustomerType(Map map) {
        return sellorderSumMapper.getCountByCustomerType(map);
    }

    /**
     * 根据客户类型获得总计额
     * @param map
     * @return
     */
    @Override
    public Double getSumByCustomerType(Map map) {
        return sellorderSumMapper.getSumByCustomerType(map);
    }

    /**
     * 根据业务员查业绩
     * @param map
     * @return
     */
    @Override
    public Double getSumsBySellman(Map map) {
        return sellorderSumMapper.getSumsBySellman(map);
    }

    /**
     * 根据时间区间进行线上商品合计
     * @param map
     * @return
     */
    @Override
    public Double getOnlineSums(Map map) {
        return sellorderSumMapper.getOnlineSums(map);
    }

    /**
     * 根据时间区间进行线下商品合计
     * @param map
     * @return
     */
    @Override
    public Double getUnderlineSums(Map map) {
        return sellorderSumMapper.getUnderlineSums(map);
    }

    /**
     * 根据时间区间进行折扣后总价合计
     * @param map
     * @return
     */
    @Override
    public Double getDiscountPrices(Map map) {
        return sellorderSumMapper.getDiscountPrices(map);
    }

    /**
     * 根据时间区间进行运费合计
     * @param map
     * @return
     */
    @Override
    public Double getTfreights(Map map) {
        return sellorderSumMapper.getTfreights(map);
    }

    /**
     * 根据时间区间进行提成合计
     * @param map
     * @return
     */
    @Override
    public Double getCommissions(Map map) {
        return sellorderSumMapper.getCommissions(map);
    }

    /**
     * 根据时间区间进行已收款合计
     * @param map
     * @return
     */
    @Override
    public Double getReceivedSums(Map map) {
        return sellorderSumMapper.getReceivedSums(map);
    }

    /**
     * 根据时间区间进行未收款合计
     * @param map
     * @return
     */
    @Override
    public Double getNoReceivedSums(Map map) {
        return sellorderSumMapper.getNoReceivedSums(map);
    }


    /**
     * 获得规定时间段的总收入
     * @param map
     * @return
     */
    @Override
    public Double getSums(Map map) {
        return sellorderSumMapper.getSums(map);
    }

}
