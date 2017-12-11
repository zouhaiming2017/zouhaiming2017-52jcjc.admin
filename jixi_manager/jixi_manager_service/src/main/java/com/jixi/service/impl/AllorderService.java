package com.jixi.service.impl;

import com.jixi.mapper.AllorderMapper;
import com.jixi.mapper.PickorderSumMapper;
import com.jixi.mapper.SellorderSumMapper;
import com.jixi.mapper.TaxMapper;
import com.jixi.pojo.Allorder;
import com.jixi.service.IAllorderService;
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
 * Created by zhm on 2017/11/13.
 */
@Service
public class AllorderService implements IAllorderService {

    @Autowired
    private AllorderMapper allorderMapper;
    @Autowired
    private SellorderSumMapper sellorderSumMapper;
    @Autowired
    private PickorderSumMapper pickorderSumMapper;
    @Autowired
    private TaxMapper taxMapper;

    /**
     * 判断timemonth是否存在
     *
     * @param timemonth
     * @return
     */
    public boolean isExist(String timemonth) {
        try {
            Allorder allorder = allorderMapper.selectByPrimaryKey(timemonth);
            if (allorder == null) {
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
    public List<Allorder> getAllorder() throws ParseException {
        List<Allorder> allorders = new ArrayList<>();
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
                Map map = new HashMap();
                Allorder allorder = new Allorder();
                String j_str = j + "";
                if (j < 10) {
                    j_str = "0" + j;
                }

                Map dates = DateUtil.getDates(i + "年", j_str + "月");
                String startDate = format.format(dates.get("startDate"));
                String endDate = format.format(dates.get("endDate"));
                map.put("startDate", startDate);
                map.put("endDate", endDate);

                String timeMonth=i + "-" + j_str;

                allorder.setTimeMonth(timeMonth);
                allorder.setSellSums(sellorderSumMapper.getSums(map)==null?0.0: DoubleFormatUtil.getFormatSums(sellorderSumMapper.getSums(map)));
                allorder.setSellCounts(Integer.parseInt(sellorderSumMapper.getCount(map)+ ""));
                if(allorder.getSellCounts()==0){
                    allorder.setSellSumsAvg(0.0);
                }else{
                    allorder.setSellSumsAvg(DoubleFormatUtil.getFormatSums(allorder.getSellSums()/allorder.getSellCounts()));
                }
                //判断月份天数，闰年、二月天数,用来判断平均额和平均数量
                int days=1;
                if((i%4==0&&i%100!=0)||i%400==0){
                    if(j==2){
                        days=28;
                    }else if(j==4||j==6||j==9||j==11){
                        days=30;
                    }else{
                        days=31;
                    }

                }else {
                    if(j==2){
                        days=29;
                    }else if(j==4||j==6||j==9||j==11){
                        days=30;
                    }else{
                        days=31;
                    }
                }
                allorder.setSellSumsDayavg(DoubleFormatUtil.getFormatSums((allorder.getSellSums()/days)));
                allorder.setSellCountsDayavg(Double.parseDouble(new java.text.DecimalFormat("0.00").format(allorder.getSellCounts()/(double)days)));
                allorder.setPickSums(pickorderSumMapper.getSums(map)==null?0.0:DoubleFormatUtil.getFormatSums(pickorderSumMapper.getSums(map)));
                allorder.setRealGrossprofit(DoubleFormatUtil.getFormatSums(allorder.getSellSums()-allorder.getPickSums()));
                allorder.setPinOffItemoffset(taxMapper.selectByPrimaryKey(timeMonth)==null?0.0:taxMapper.selectByPrimaryKey(timeMonth).getInSellDifference());
                if(allorder.getSellSums()==0){
                    allorder.setGrossmargin("0%");
                }else{
                    allorder.setGrossmargin(DoubleFormatUtil.getFormatSums((allorder.getRealGrossprofit()+allorder.getPinOffItemoffset())/allorder.getSellSums()*100)+"%");
                }

                allorder.setFreightSupplier(pickorderSumMapper.getFreights(map)==null?0.0:DoubleFormatUtil.getFormatSums(pickorderSumMapper.getFreights(map)));
                allorder.setFreightJixi(pickorderSumMapper.selectJCCDSums(map)==null?0.0:DoubleFormatUtil.getFormatSums(pickorderSumMapper.selectJCCDSums(map)));
                allorder.setFreightCustomer(sellorderSumMapper.getFreights(map)==null?0.0:DoubleFormatUtil.getFormatSums(sellorderSumMapper.getFreights(map)));
                if(allorder.getSellSums()==0){
                    allorder.setFreightpro("0%");
                }else{
                    allorder.setFreightpro(DoubleFormatUtil.getFormatSums((allorder.getFreightSupplier()+allorder.getFreightJixi())/allorder.getSellSums()*100)+"%");
                }

                //判断第一个月不计算增长率，计算其它月增长率
                if (i == 2017 && j == 10) {
                    allorder.setSellSumsRategrowth("0%");
                    allorder.setSellCountsRategrowth("0%");
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
                    Map map1 = new HashMap();
                    map1.put("startDate", startDate1);
                    map1.put("endDate", endDate1);
                    Double sellSums = DoubleFormatUtil.getFormatSums(sellorderSumMapper.getSums(map1));
                    //因为要保留小数部分，故两个整数相除，其中一个转化为Double型
                    Double sellCounts = Double.parseDouble(sellorderSumMapper.getCount(map1) + "");

                    allorder.setSellSumsRategrowth(DoubleFormatUtil.getFormatSums((allorder.getSellSums() - sellSums) / sellSums*100) + "%");
                    allorder.setSellCountsRategrowth(new java.text.DecimalFormat("0.00").format((allorder.getSellCounts() - sellCounts) / sellCounts*100) + "%");
                }

                if (!isExist(timeMonth)) {
                    //不存在就添加
                    allorderMapper.insertSelective(allorder);
                } else {
                    //存在就更新
                    allorderMapper.updateByPrimaryKeySelective(allorder);
                }

                allorders.add(allorder);
            }
        }
        return allorders;
    }


    /**
     * 导出到excel
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
        headList.add("备注");
        headList.add("交易金额");
        headList.add("交易增长率");
        headList.add("订单数");
        headList.add("订单增长率");
        headList.add("订单平均");
        headList.add("日均交易额");
        headList.add("日均订单");
        headList.add("供应商金额");
        headList.add("实际毛利");
        headList.add("进销项抵扣");
        headList.add("毛利率");
        headList.add("运费比例");
        headList.add("供应商运费");
        headList.add("集兮配送费");
        headList.add("收客户运费");

        //获得表尾数据
        List<String> tails=new ArrayList<>();
        Double sellSums=0.0;
        int sellCounts=0;
        Double pickSums=0.0;
        Double realGrossprofits=0.0;
        Double pinOffItemoffsets=0.0;
        Double freightpros=0.0;
        Double freightSuppliers=0.0;
        Double freightJixis=0.0;
        Double freightCustomers=0.0;

        for(int i=0;i<timeMonthcodes.length;i++) {
            List<String> ss = new ArrayList<>();
            Allorder allorder=allorderMapper.selectByPrimaryKey(timeMonthcodes[i]);

            ss.add((i+1)+"");
            ss.add(allorder.getTimeMonth());
            ss.add(allorder.getRemark());
            ss.add(allorder.getSellSums().toString());
            ss.add(allorder.getSellSumsRategrowth());
            ss.add(allorder.getSellCounts().toString());
            ss.add(allorder.getSellCountsRategrowth());
            ss.add(allorder.getSellSumsAvg().toString());
            ss.add(allorder.getSellSumsDayavg().toString());
            ss.add(allorder.getSellCountsDayavg().toString());
            ss.add(allorder.getPickSums().toString());
            ss.add(allorder.getRealGrossprofit().toString());
            ss.add(allorder.getPinOffItemoffset().toString());
            ss.add(allorder.getGrossmargin());
            ss.add(allorder.getFreightpro());
            ss.add(allorder.getFreightSupplier().toString());
            ss.add(allorder.getFreightJixi().toString());
            ss.add(allorder.getFreightCustomer().toString());

            sellSums+=allorder.getSellSums();
            sellCounts+=allorder.getSellCounts();
            pickSums+=allorder.getPickSums();
            realGrossprofits+=allorder.getRealGrossprofit();
            pinOffItemoffsets+=allorder.getPinOffItemoffset();

            freightSuppliers+=allorder.getFreightSupplier();
            freightJixis+=allorder.getFreightJixi();
            freightCustomers+=allorder.getFreightCustomer();

            stringList.add(ss);
        }
        tails.add(DoubleFormatUtil.getFormatSums(sellSums).toString());
        tails.add("");
        tails.add(sellCounts+"");
        tails.add("");
        tails.add(DoubleFormatUtil.getFormatSums(sellSums/sellCounts).toString());
        tails.add("");
        tails.add("");
        tails.add(DoubleFormatUtil.getFormatSums(pickSums).toString());
        tails.add(DoubleFormatUtil.getFormatSums(realGrossprofits).toString());
        tails.add(DoubleFormatUtil.getFormatSums(pinOffItemoffsets).toString());
        tails.add(DoubleFormatUtil.getFormatSums((realGrossprofits+pinOffItemoffsets)/sellSums*100)+"%");
        if(sellSums==0){
            tails.add("0%") ;
        }else{
            tails.add(DoubleFormatUtil.getFormatSums((freightSuppliers+freightJixis)/sellSums*100)+"%");
        }

        tails.add(DoubleFormatUtil.getFormatSums(freightSuppliers).toString());
        tails.add(DoubleFormatUtil.getFormatSums(freightJixis).toString());
        tails.add(DoubleFormatUtil.getFormatSums(freightCustomers).toString());

        ExcelUtil.outputToExcel(stringList,headList,tails,"通用订单汇总",outputStream);
    }

}
