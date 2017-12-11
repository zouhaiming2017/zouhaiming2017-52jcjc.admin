package com.jixi.service.impl;

import com.jixi.mapper.SellorderAllMapper;
import com.jixi.mapper.SellorderSumMapper;
import com.jixi.pojo.SellorderAll;
import com.jixi.service.ISellorderAllService;
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
 * Created by zhm on 2017/11/13.
 */
@Service
public class SellorderAllService implements ISellorderAllService {

    @Autowired
    private SellorderAllMapper sellorderAllMapper;
    @Autowired
    private SellorderSumMapper sellorderSumMapper;

    /**
     * 判断timeMonth是否存在
     *
     * @param timeMonth
     * @return
     */
    public boolean isExist(String timeMonth) {
        try {
            SellorderAll sellorderAll = sellorderAllMapper.selectByPrimaryKey(timeMonth);
            if (sellorderAll == null) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    /**
     * 获得数据
     * @return
     */
    @Override
    public List<SellorderAll> getSellorderAll() throws ParseException {
        List<SellorderAll> sellorderAlls=new ArrayList<>();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        //选择年月
        SimpleDateFormat yearFormat=new SimpleDateFormat("yyyy");
        SimpleDateFormat monthFormat=new SimpleDateFormat("MM");
        int maxYear=Integer.parseInt(yearFormat.format(new Date()));

        for(int i=2017;i<=maxYear;i++) {
            int maxMonth = Integer.parseInt(monthFormat.format(new Date()));
            int n = 1;
            if (i != maxYear) {
                maxMonth = 12;
            }
            if (i == 2017) {
                n = 10;
            }

            for (int j = n; j <= maxMonth; j++) {
                SellorderAll sellorderAll = new SellorderAll();
                String j_str = j + "";
                if (j < 10) {
                    j_str = "0" + j;
                }

                Map dates = DateUtil.getDates(i + "年", j_str + "月");
                String startDate = format.format(dates.get("startDate"));
                String endDate = format.format(dates.get("endDate"));
                Map map = new HashMap();
                map.put("startDate", startDate);
                map.put("endDate", endDate);

                String timeMonth=i + "-" + j_str;

                sellorderAll.setTimeMonth(timeMonth);
                sellorderAll.setAllsums(sellorderSumMapper.getSums(map)==null?0.0: DoubleFormatUtil.getFormatSums(sellorderSumMapper.getSums(map)));
                sellorderAll.setAllcounts(Integer.parseInt(sellorderSumMapper.getCount(map)+""));
                sellorderAll.setAllCustomerCount(sellorderSumMapper.getCustomerCounts(map));
                Map map1=new HashMap();
                map1.put("customertype","T4");
                map1.put("startDate", startDate);
                map1.put("endDate", endDate);
                sellorderAll.setdCount(Integer.parseInt(sellorderSumMapper.getCountByCustomerType(map1)+""));
                sellorderAll.setdSum(sellorderSumMapper.getSumByCustomerType(map1)==null?0.0:DoubleFormatUtil.getFormatSums(sellorderSumMapper.getSumByCustomerType(map1)));
                sellorderAll.setdCustomerCount(sellorderSumMapper.getCustomerCounts(map1));

                Map map2=new HashMap();
                map2.put("customertype","T3");
                map2.put("startDate", startDate);
                map2.put("endDate", endDate);
                sellorderAll.setcCount(Integer.parseInt(sellorderSumMapper.getCountByCustomerType(map2)+""));
                sellorderAll.setcSum(sellorderSumMapper.getSumByCustomerType(map2)==null?0.0:DoubleFormatUtil.getFormatSums(sellorderSumMapper.getSumByCustomerType(map2)));
                sellorderAll.setcCustomerCount(sellorderSumMapper.getCustomerCounts(map2));

                Map map3=new HashMap();
                map3.put("customertype","T2");
                map3.put("startDate", startDate);
                map3.put("endDate", endDate);
                sellorderAll.setbCount(Integer.parseInt(sellorderSumMapper.getCountByCustomerType(map3)+""));
                sellorderAll.setbSum(sellorderSumMapper.getSumByCustomerType(map3)==null?0.0:DoubleFormatUtil.getFormatSums(sellorderSumMapper.getSumByCustomerType(map3)));

                Map map4=new HashMap();
                map4.put("customertype","T1");
                map4.put("startDate", startDate);
                map4.put("endDate", endDate);
                sellorderAll.setaCount(Integer.parseInt(sellorderSumMapper.getCountByCustomerType(map4)+""));
                sellorderAll.setaSum(sellorderSumMapper.getSumByCustomerType(map4)==null?0.0:DoubleFormatUtil.getFormatSums(sellorderSumMapper.getSumByCustomerType(map4)));

                //获得T4类订单平均
                if(sellorderAll.getdCount()==0){
                    sellorderAll.setdSumAvg(0.0);
                }else {
                    sellorderAll.setdSumAvg(DoubleFormatUtil.getFormatSums(sellorderAll.getdSum()/sellorderAll.getdCount()));
                }
                //获得T3类订单平均
                if(sellorderAll.getcCount()==0){
                    sellorderAll.setcSumAvg(0.0);
                }else {
                    sellorderAll.setcSumAvg(DoubleFormatUtil.getFormatSums(sellorderAll.getcSum()/sellorderAll.getcCount()));
                }

                //获得T4、T3类各自交易占比
                if(sellorderAll.getAllsums()==0){
                    sellorderAll.setdSumPro("0%");
                    sellorderAll.setcSumPro("0%");
                }else {
                    sellorderAll.setdSumPro(DoubleFormatUtil.getFormatSums(sellorderAll.getdSum()/sellorderAll.getAllsums()*100)+"%");
                    sellorderAll.setcSumPro(DoubleFormatUtil.getFormatSums(sellorderAll.getcSum()/sellorderAll.getAllsums()*100)+"%");

                }

                //判断第一个月不计算增长率，计算其它月增长率
                if (i == 2017 && j == 10) {
                    sellorderAll.setdCountRategrowth("0%");
                    sellorderAll.setdSumRategrowth("0%");
                    sellorderAll.setcCountRategrowth("0%");
                    sellorderAll.setcSumRategrowth("0%");
                } else {
                    if (j == 1) {
                        i = i - 1;
                        j_str = "12";
                    } else if (j <= 10) {
                        j_str = "0" + (j - 1);
                    } else {
                        j_str = (j - 1) + "";
                    }

                    Map dates1 = DateUtil.getDates(i + "年", j_str + "月");
                    String startDate1 = format.format(dates1.get("startDate"));
                    String endDate1 = format.format(dates1.get("endDate"));
                    Map map5 = new HashMap();
                    map5.put("customertype","T4");
                    map5.put("startDate", startDate1);
                    map5.put("endDate", endDate1);
                    Double dCounts=Double.parseDouble(sellorderSumMapper.getCountByCustomerType(map5)+"");
                    Double dSums=DoubleFormatUtil.getFormatSums(sellorderSumMapper.getSumByCustomerType(map5));

                    Map map6 = new HashMap();
                    map6.put("customertype","T3");
                    map6.put("startDate", startDate1);
                    map6.put("endDate", endDate1);
                    Double cCounts=Double.parseDouble(sellorderSumMapper.getCountByCustomerType(map6)+"");
                    Double cSums=DoubleFormatUtil.getFormatSums(sellorderSumMapper.getSumByCustomerType(map6));

                    if(dCounts==null||dCounts==0){
                        sellorderAll.setdCountRategrowth("0%");
                    }else{
                        sellorderAll.setdCountRategrowth(new java.text.DecimalFormat("0.00").format((sellorderAll.getdCount()-dCounts)/dCounts*100)+"%");
                    }

                    if(dSums==null||dSums==0){
                        sellorderAll.setdSumRategrowth("0%");
                    }else{
                        sellorderAll.setdSumRategrowth(new java.text.DecimalFormat("0.00").format((sellorderAll.getdSum()-dSums)/dSums*100)+"%");
                    }

                    if(cCounts==null||cCounts==0){
                        sellorderAll.setcCountRategrowth("0%");
                    }else{
                        sellorderAll.setcCountRategrowth(new java.text.DecimalFormat("0.00").format((sellorderAll.getcCount()-cCounts)/cCounts*100)+"%");
                    }

                    if(cSums==null||cSums==0){
                        sellorderAll.setcSumRategrowth("0%");
                    }else{
                        sellorderAll.setcSumRategrowth(new java.text.DecimalFormat("0.00").format((sellorderAll.getcSum()-cSums)/cSums*100)+"%");
                    }
                }

                if (!isExist(timeMonth)) {
                    //不存在就添加
                    sellorderAllMapper.insertSelective(sellorderAll);
                } else {
                    //存在就更新
                    sellorderAllMapper.updateByPrimaryKeySelective(sellorderAll);
                }
                sellorderAlls.add(sellorderAll);
            }
        }

        return sellorderAlls;
    }

    /**
     * 导出
     * @param outputStream
     * @param timeMonthcodes
     * @throws Exception
     */
    @Override
    public void exportExcel(OutputStream outputStream, String[] timeMonthcodes) throws Exception {
        List<List<String>> stringList=new ArrayList<>();
        //创建表头内容
        List<String> headList = new ArrayList<>();
        headList.add("序号");
        headList.add("月度");
        headList.add("交易客户数");
        headList.add("总交易金额");
        headList.add("总订单数");

        headList.add("T4订单数");
        headList.add("T3订单数");
        headList.add("T2订单数");
        headList.add("T1订单数");

        headList.add("T4交易金额");
        headList.add("T3交易金额");
        headList.add("T2交易金额");
        headList.add("T1交易金额");

        headList.add("T4订单增长率");
        headList.add("T3订单增长率");
        headList.add("T4交易增长率");
        headList.add("T3交易增长率");

        headList.add("T4订单平均");
        headList.add("T3订单平均");
        headList.add("T4交易占比");
        headList.add("T3交易占比");
        headList.add("T4客户数");
        headList.add("T3客户数");
        //获得表尾数据
        List<String> tails=new ArrayList<>();
        //信息汇总
        Double allsums=0.0;
        int allcounts=0;
        int dCounts=0;
        int cCounts=0;
        int bCounts=0;
        int aCounts=0;
        Double dSums=0.0;
        Double cSums=0.0;
        Double bSums=0.0;
        Double aSums=0.0;

        for(int i=0;i<timeMonthcodes.length;i++) {
            List<String> ss = new ArrayList<>();
            SellorderAll sellorderAll=sellorderAllMapper.selectByPrimaryKey(timeMonthcodes[i]);

            ss.add((i+1)+"");
            ss.add(sellorderAll.getTimeMonth());
            ss.add(sellorderAll.getAllCustomerCount()+"");
            ss.add(sellorderAll.getAllsums().toString());
            ss.add(sellorderAll.getAllcounts()+"");

            ss.add(sellorderAll.getdCount().toString());
            ss.add(sellorderAll.getcCount().toString());
            ss.add(sellorderAll.getbCount().toString());
            ss.add(sellorderAll.getaCount().toString());

            ss.add(sellorderAll.getdSum().toString());
            ss.add(sellorderAll.getcSum().toString());
            ss.add(sellorderAll.getbSum().toString());
            ss.add(sellorderAll.getaSum().toString());

            ss.add(sellorderAll.getdCountRategrowth());
            ss.add(sellorderAll.getcCountRategrowth());
            ss.add(sellorderAll.getdSumRategrowth());
            ss.add(sellorderAll.getcSumRategrowth());

            ss.add(sellorderAll.getdSumAvg().toString());
            ss.add(sellorderAll.getcSumAvg().toString());
            ss.add(sellorderAll.getdSumPro());
            ss.add(sellorderAll.getcSumPro());
            ss.add(sellorderAll.getdCustomerCount().toString());
            ss.add(sellorderAll.getcCustomerCount().toString());

            allsums+=sellorderAll.getAllsums();
            allcounts+=sellorderAll.getAllcounts();
            dCounts+=sellorderAll.getdCount();
            cCounts+=sellorderAll.getcCount();
            bCounts+=sellorderAll.getbCount();
            aCounts+=sellorderAll.getaCount();
            dSums+=sellorderAll.getdSum();
            cSums+=sellorderAll.getcSum();
            bSums+=sellorderAll.getbSum();
            aSums+=sellorderAll.getaSum();

            stringList.add(ss);
        }
        tails.add(DoubleFormatUtil.getFormatSums(allsums).toString());
        tails.add(allcounts+"");
        tails.add(dCounts+"");
        tails.add(cCounts+"");
        tails.add(bCounts+"");
        tails.add(aCounts+"");

        tails.add(DoubleFormatUtil.getFormatSums(dSums).toString());
        tails.add(DoubleFormatUtil.getFormatSums(cSums).toString());
        tails.add(DoubleFormatUtil.getFormatSums(bSums).toString());
        tails.add(DoubleFormatUtil.getFormatSums(aSums).toString());

        tails.add("");
        tails.add("");
        tails.add("");
        tails.add("");

        tails.add("");
        tails.add("");
        tails.add("");
        tails.add("");
        tails.add("");
        tails.add("");

        ExcelUtil.outputToExcel(stringList,headList,tails,"通用客户分析",outputStream);
    }
}
