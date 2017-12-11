package com.jixi.controller;

import com.jixi.pojo.SellorderSum;
import com.jixi.service.IPickOrderSumService;
import com.jixi.service.ISellorderSumService;
import com.jixi.utils.DateUtil;
import com.jixi.utils.DoubleFormatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by zhm on 2017/9/22.
 */
@Controller
@RequestMapping("/charts")
public class ChartsController {
    @Autowired
    private IPickOrderSumService pickOrderSumService;
    @Autowired
    private ISellorderSumService sellorderSumService;

    /**
     * 年统计数量图
     * @param model
     * @return
     * @throws ParseException
     */
    @RequestMapping("/charts-year")
    public String toCharts1(Model model,String year) throws ParseException {
        Map map=new HashMap();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat yearFormat=new SimpleDateFormat("yyyy");
        if(year==null||"0".equals(year)){
            year=yearFormat.format(new Date());
        }else {
            year=year.substring(0,4);
        }

        String pickOrderSumCounts="";
        String sellorderSumCounts="";

        Long maxCount=Long.parseLong("0");
        Long minCount=Long.parseLong("0");

        int maxMonth=1;
        int minMonth=1;
        for(int i=1;i<=12;i++){
            String startDate=year+"-0"+i+"-01";
            String endDate="";
            if(i<12){
                 endDate=year+"-0"+(i+1)+"-01";
            }else {
                Calendar calendar=new GregorianCalendar();
                calendar.setTime(yearFormat.parse(year));
                calendar.add(calendar.YEAR, 1);

                endDate=yearFormat.format(calendar.getTime())+"-01-01";
            }

            map.put("startDate",format.parse(startDate));
            map.put("endDate",format.parse(endDate));

            Long pickOrderSumCount=pickOrderSumService.getCount(map);
            Long sellorderSumCount=sellorderSumService.getCount(map);

            if(i==1){
                pickOrderSumCounts+=pickOrderSumCount;
                sellorderSumCounts+=sellorderSumCount;

                maxCount=sellorderSumCount;
                minCount=sellorderSumCount;
            }else {
                pickOrderSumCounts+=","+pickOrderSumCount;
                sellorderSumCounts+=","+sellorderSumCount;
            }

            if(maxCount<sellorderSumCount){
                maxCount=sellorderSumCount;
                maxMonth=i-1;
            }
            if(minCount>sellorderSumCount){
                minCount=sellorderSumCount;
                minMonth=i;
            }
        }

        //选择年份
        int maxYear=Integer.parseInt(yearFormat.format(new Date()));
        List<String> years=new ArrayList<>();
        for(int i=2017;i<=maxYear;i++){
            years.add(i+"年");
        }

        model.addAttribute("pickOrderSumCounts",pickOrderSumCounts);
        model.addAttribute("sellorderSumCounts",sellorderSumCounts);
        model.addAttribute("maxCount",maxCount);
        model.addAttribute("minCount",minCount);
        model.addAttribute("maxMonth",maxMonth);
        model.addAttribute("minMonth",minMonth);
        model.addAttribute("year",year);
        model.addAttribute("years",years);

        return "charts/charts-year";
    }


    /**
     * 月统计数量图
     * @param model
     * @return
     * @throws ParseException
     */
    @RequestMapping("/charts-month")
    public String toCharts2(Model model,String year,String month) throws ParseException {
        Map map=new HashMap();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat monthFormat=new SimpleDateFormat("yyyy-MM");
        if(year==null||month==null||"0".equals(year)||"0".equals(month)){
            month=monthFormat.format(new Date());
        }else {
            month=year.substring(0,4)+"-"+month.substring(0,2);
        }

        String pickOrderSumCounts="";
        String sellorderSumCounts="";

        Long maxCount=Long.parseLong("0");
        Long minCount=Long.parseLong("0");

        int maxDay=1;
        int minDay=1;
        String days="'1号'";

        for(int i=1;i<=31;i++){
            String startDate="";
            if(i<10){
                 startDate=month+"-0"+i;
            }else {
                 startDate=month+"-"+i;
            }

            String endDate="";

            String monthStr=month.substring(5);
            if(monthStr.equals("02")||monthStr.equals("04")||monthStr.equals("06")||monthStr.equals("09")||monthStr.equals("11")){
                if(i==30){
                    Calendar calendar=new GregorianCalendar();
                    calendar.setTime(monthFormat.parse(month));
                    calendar.add(calendar.MONTH, 1);
                    endDate=monthFormat.format(calendar.getTime())+"-01";
                }else if(i==31){
                    break;
                }else {
                    if(i<10){
                        endDate=month+"-0"+(i+1);
                    }else {
                        endDate=month+"-"+(i+1);
                    }
                }

            }else {
                if(i==31){
                    Calendar calendar=new GregorianCalendar();
                    calendar.setTime(monthFormat.parse(month));
                    calendar.add(calendar.MONTH, 1);

                    endDate=monthFormat.format(calendar.getTime())+"-01";
                }else{
                    if(i<10){
                        endDate=month+"-0"+(i+1);
                    }else {
                        endDate=month+"-"+(i+1);
                    }
                }
            }

            map.put("startDate",format.parse(startDate));
            map.put("endDate",format.parse(endDate));

            Long pickOrderSumCount=pickOrderSumService.getCount(map);
            Long sellorderSumCount=sellorderSumService.getCount(map);

            if(i==1){
                pickOrderSumCounts+=pickOrderSumCount;
                sellorderSumCounts+=sellorderSumCount;

                maxCount=sellorderSumCount;
                minCount=sellorderSumCount;
            }else {
                pickOrderSumCounts+=","+pickOrderSumCount;
                sellorderSumCounts+=","+sellorderSumCount;
            }

            if(maxCount<sellorderSumCount){
                maxCount=sellorderSumCount;
                maxDay=i-1;
            }
            if(minCount>sellorderSumCount){
                minCount=sellorderSumCount;
                minDay=i;
            }

            if(i!=1){
                days+=",'"+i+"号'";
            }
        }

        //选择年月
        SimpleDateFormat yearFormat=new SimpleDateFormat("yyyy");
        int maxYear=Integer.parseInt(yearFormat.format(new Date()));
        List<String> years=new ArrayList<>();
        for(int i=2017;i<=maxYear;i++){
            years.add(i+"年");
        }

        List<String> months=new ArrayList<>();
        for(int i=1;i<=12;i++){
            if(i<10){
                months.add("0"+i+"月");
            }else {
                months.add(i+"月");
            }
        }

        model.addAttribute("pickOrderSumCounts",pickOrderSumCounts);
        model.addAttribute("sellorderSumCounts",sellorderSumCounts);
        model.addAttribute("maxCount",maxCount);
        model.addAttribute("minCount",minCount);
        model.addAttribute("maxDay",maxDay);
        model.addAttribute("minDay",minDay);
        model.addAttribute("days",days);
        model.addAttribute("month",month);
        model.addAttribute("years",years);
        model.addAttribute("months",months);

        return "charts/charts-month";
    }


    /**
     * 年统计收支图
     * @param model
     * @return
     * @throws ParseException
     */
    @RequestMapping("/sum-year")
    public String getYearSums(Model model,String year) throws ParseException {
        Map map=new HashMap();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat yearFormat=new SimpleDateFormat("yyyy");
        if(year==null||"0".equals(year)){
            year=yearFormat.format(new Date());
        }else {
            year=year.substring(0,4);
        }

        String pickOrderSums="";
        String sellorderSums="";

        Double maxSum=Double.parseDouble("0.0");
        Double minSum=Double.parseDouble("0.0");

        int maxMonth=1;
        int minMonth=1;
        for(int i=1;i<=12;i++){
            String startDate=year+"-0"+i+"-01";
            String endDate="";
            if(i<12){
                endDate=year+"-0"+(i+1)+"-01";
            }else {
                Calendar calendar=new GregorianCalendar();
                calendar.setTime(yearFormat.parse(year));
                calendar.add(calendar.YEAR, 1);

                endDate=yearFormat.format(calendar.getTime())+"-01-01";
            }

            map.put("startDate",format.parse(startDate));
            map.put("endDate",format.parse(endDate));

            Double pickOrderSum=(pickOrderSumService.getSums(map)==null?0.0:DoubleFormatUtil.getFormatSums(pickOrderSumService.getSums(map)));
            Double sellorderSum=(sellorderSumService.getSums(map)==null?0.0:DoubleFormatUtil.getFormatSums(sellorderSumService.getSums(map)));

            if(i==1){
                pickOrderSums+=pickOrderSum;
                sellorderSums+=sellorderSum;

                maxSum=sellorderSum;
                minSum=sellorderSum;
            }else {
                pickOrderSums+=","+pickOrderSum;
                sellorderSums+=","+sellorderSum;
            }

            if(maxSum<sellorderSum){
                maxSum=sellorderSum;
                maxMonth=i-1;
            }
            if(minSum>sellorderSum){
                minSum=sellorderSum;
                minMonth=i;
            }
        }

        //选择年份
        int maxYear=Integer.parseInt(yearFormat.format(new Date()));
        List<String> years=new ArrayList<>();
        for(int i=2017;i<=maxYear;i++){
            years.add(i+"年");
        }

        model.addAttribute("pickOrderSums",pickOrderSums);
        model.addAttribute("sellorderSums",sellorderSums);
        model.addAttribute("maxSum", maxSum);
        model.addAttribute("minSum",minSum);
        model.addAttribute("maxMonth",maxMonth);
        model.addAttribute("minMonth",minMonth);
        model.addAttribute("year",year);
        model.addAttribute("years",years);

        return "charts/sum-year";
    }


    /**
     * 月统计收支图
     * @param model
     * @return
     * @throws ParseException
     */
    @RequestMapping("/sum-month")
    public String getMonthSums(Model model,String year,String month) throws ParseException {
        Map map=new HashMap();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat monthFormat=new SimpleDateFormat("yyyy-MM");
        if(year==null||month==null||"0".equals(year)||"0".equals(month)){
            month=monthFormat.format(new Date());
        }else {
            month=year.substring(0,4)+"-"+month.substring(0,2);
        }

        String pickOrderSums="";
        String sellorderSums="";

        Double maxSum=Double.parseDouble("0.0");
        Double minSum=Double.parseDouble("0.0");

        int maxDay=1;
        int minDay=1;
        String days="'1号'";

        for(int i=1;i<=31;i++){
            String startDate="";
            if(i<10){
                startDate=month+"-0"+i;
            }else {
                startDate=month+"-"+i;
            }

            String endDate="";

            String monthStr=month.substring(5);
            if(monthStr.equals("02")||monthStr.equals("04")||monthStr.equals("06")||monthStr.equals("09")||monthStr.equals("11")){
                if(i==30){
                    Calendar calendar=new GregorianCalendar();
                    calendar.setTime(monthFormat.parse(month));
                    calendar.add(calendar.MONTH, 1);
                    endDate=monthFormat.format(calendar.getTime())+"-01";
                }else if(i==31){
                    break;
                }else {
                    if(i<10){
                        endDate=month+"-0"+(i+1);
                    }else {
                        endDate=month+"-"+(i+1);
                    }
                }

            }else {
                if(i==31){
                    Calendar calendar=new GregorianCalendar();
                    calendar.setTime(monthFormat.parse(month));
                    calendar.add(calendar.MONTH, 1);

                    endDate=monthFormat.format(calendar.getTime())+"-01";
                }else{
                    if(i<10){
                        endDate=month+"-0"+(i+1);
                    }else {
                        endDate=month+"-"+(i+1);
                    }
                }
            }

            map.put("startDate",format.parse(startDate));
            map.put("endDate",format.parse(endDate));

            Double pickOrderSum=(pickOrderSumService.getSums(map)==null?0.0:DoubleFormatUtil.getFormatSums(pickOrderSumService.getSums(map)));
            Double sellorderSum=(sellorderSumService.getSums(map)==null?0.0:DoubleFormatUtil.getFormatSums(sellorderSumService.getSums(map)));

            if(i==1){
                pickOrderSums+=pickOrderSum;
                sellorderSums+=sellorderSum;

                maxSum=sellorderSum;
                minSum=sellorderSum;
            }else {
                pickOrderSums+=","+pickOrderSum;
                sellorderSums+=","+sellorderSum;
            }

            if(maxSum<sellorderSum){
                maxSum=sellorderSum;
                maxDay=i-1;
            }
            if(minSum>sellorderSum){
                minSum=sellorderSum;
                minDay=i;
            }

            if(i!=1){
                days+=",'"+i+"号'";
            }
        }

        //选择年月
        SimpleDateFormat yearFormat=new SimpleDateFormat("yyyy");
        int maxYear=Integer.parseInt(yearFormat.format(new Date()));
        List<String> years=new ArrayList<>();
        for(int i=2017;i<=maxYear;i++){
            years.add(i+"年");
        }

        List<String> months=new ArrayList<>();
        for(int i=1;i<=12;i++){
            if(i<10){
                months.add("0"+i+"月");
            }else {
                months.add(i+"月");
            }
        }

        model.addAttribute("pickOrderSums",pickOrderSums);
        model.addAttribute("sellorderSums",sellorderSums);
        model.addAttribute("maxSum",maxSum);
        model.addAttribute("minSum",minSum);
        model.addAttribute("maxDay",maxDay);
        model.addAttribute("minDay",minDay);
        model.addAttribute("days",days);
        model.addAttribute("month",month);
        model.addAttribute("years",years);
        model.addAttribute("months",months);

        return "charts/sum-month";
    }


    /**
     * 按客户类型获得总收入图
     */
    @RequestMapping("/pie-chart")
    public String getSumByCustomerType(Model model,String year,String month) throws ParseException {
        //获得时间
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM");
        Map dates= DateUtil.getDates(year,month);
        String startDate=format.format(dates.get("startDate"));
        String endDate=format.format(dates.get("endDate"));
        //获得客户类型
        List<String> customerTypes=new ArrayList<>();
        customerTypes.add("T1");
        customerTypes.add("T2");
        customerTypes.add("T3");
        customerTypes.add("T4");
        customerTypes.add("T5");
        for(int i=0;i<customerTypes.size();i++){
            Map map=new HashMap();
            map.put("customertype",customerTypes.get(i));
            map.put("startDate",format.parse(startDate));
            map.put("endDate",format.parse(endDate));
            if(sellorderSumService.getSumByCustomerType(map)==null){
                model.addAttribute(customerTypes.get(i),0);
            }else{
                model.addAttribute(customerTypes.get(i),DoubleFormatUtil.getFormatSums(sellorderSumService.getSumByCustomerType(map)));
            }
        }
        //选择年月
        SimpleDateFormat yearFormat=new SimpleDateFormat("yyyy");
        int maxYear=Integer.parseInt(yearFormat.format(new Date()));
        List<String> years=new ArrayList<>();
        for(int i=2017;i<=maxYear;i++){
            years.add(i+"年");
        }

        List<String> months=new ArrayList<>();
        for(int i=1;i<=12;i++){
            if(i<10){
                months.add("0"+i+"月");
            }else {
                months.add(i+"月");
            }
        }
        model.addAttribute("years",years);
        model.addAttribute("months",months);
        SimpleDateFormat format1=new SimpleDateFormat("yyyy年MM月");
        if(year==null||month==null){
            model.addAttribute("month",format1.format(new Date()));
        }else{
            model.addAttribute("month",year+month);
        }

        return "charts/pie-chart";
    }

    /**
     * 地图分布
     */
    @RequestMapping("/map-chart")
    public String getSumByAddress(Model model){

        return "charts/map-chart";
    }

    /**
     * 查业务员客户年销售统计
     */
    @RequestMapping("/sellman-year")
    public String getSumsBySellman(Model model,String year,String sellman) throws ParseException {
        Map map=new HashMap();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat yearFormat=new SimpleDateFormat("yyyy");
        if(year==null||"0".equals(year)){
            year=yearFormat.format(new Date());
        }else {
            year=year.substring(0,4);
        }

        String sellorderSums="";

        Double maxSum=Double.parseDouble("0.0");
        Double minSum=Double.parseDouble("0.0");

        int maxMonth=1;
        int minMonth=1;
        for(int i=1;i<=12;i++){
            String startDate=year+"-0"+i+"-01";
            String endDate="";
            if(i<12){
                endDate=year+"-0"+(i+1)+"-01";
            }else {
                Calendar calendar=new GregorianCalendar();
                calendar.setTime(yearFormat.parse(year));
                calendar.add(calendar.YEAR, 1);

                endDate=yearFormat.format(calendar.getTime())+"-01-01";
            }

            map.put("startDate",format.parse(startDate));
            map.put("endDate",format.parse(endDate));
            map.put("sellman",sellman);

            Double sellorderSum=(sellorderSumService.getSumsBySellman(map)==null?0.0:DoubleFormatUtil.getFormatSums(sellorderSumService.getSumsBySellman(map)));

            if(i==1){
                sellorderSums+=sellorderSum;

                maxSum=sellorderSum;
                minSum=sellorderSum;
            }else {
                sellorderSums+=","+sellorderSum;
            }

            if(maxSum<sellorderSum){
                maxSum=sellorderSum;
                maxMonth=i-1;
            }
            if(minSum>sellorderSum){
                minSum=sellorderSum;
                minMonth=i;
            }
        }

        //选择年份
        int maxYear=Integer.parseInt(yearFormat.format(new Date()));
        List<String> years=new ArrayList<>();
        for(int i=2017;i<=maxYear;i++){
            years.add(i+"年");
        }

        model.addAttribute("sellorderSums",sellorderSums);
        model.addAttribute("maxSum",maxSum);
        model.addAttribute("minSum",minSum);
        model.addAttribute("maxMonth",maxMonth);
        model.addAttribute("minMonth",minMonth);
        model.addAttribute("year",year);
        model.addAttribute("years",years);
        model.addAttribute("sellman",sellman);

        return "charts/sellman-year";
    }

}
