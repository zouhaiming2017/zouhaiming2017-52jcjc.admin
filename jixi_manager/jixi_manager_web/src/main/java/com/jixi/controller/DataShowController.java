package com.jixi.controller;

import com.jixi.pojo.CustomerTypeShow;
import com.jixi.service.IDataShowService;
import com.jixi.service.ISellorderSumService;
import com.jixi.utils.DateUtil;
import com.jixi.utils.DoubleFormatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by zhm on 2017/11/8.
 */
@Controller
@RequestMapping("/dataShow")
public class DataShowController {

    @Autowired
    private ISellorderSumService sellorderSumService;
    @Autowired
    private IDataShowService dataShowService;

    /**
     * 客户类型明细
     */
    @RequestMapping("/customerTypeDetail")
    public String customerTypeDetail(Model model, String year, String month) throws ParseException {
        List<CustomerTypeShow> customerTypeShows=new ArrayList<>();

        //获得起止时间
        Map<String,Date> dates=DateUtil.getDates(year,month);
        Date startDate=dates.get("startDate");
        Date endDate=dates.get("endDate");

        //添加分类信息
        List<String> customerTypes=new ArrayList<>();
        customerTypes.add("T1");
        customerTypes.add("T2");
        customerTypes.add("T3");
        customerTypes.add("T4");
        customerTypes.add("T5");
        //定义汇总数据
        int counts=0;
        double sums=0.0;
        //查出并添加数据
        for(String s:customerTypes){
           Map map=new HashMap();
           map.put("startDate",startDate);
           map.put("endDate",endDate);
           map.put("customertype",s);

           Double sum=sellorderSumService.getSumByCustomerType(map);
           Long count=sellorderSumService.getCountByCustomerType(map);

           if(sum==null){
               sum=0.0;
           }

           CustomerTypeShow customerTypeShow=new CustomerTypeShow();
           customerTypeShow.setCustomerType(s);
           customerTypeShow.setSum(DoubleFormatUtil.getFormatSums(sum));
           customerTypeShow.setCount(count);

           counts+=count;
           sums+=sum;

           customerTypeShows.add(customerTypeShow);
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

        model.addAttribute("customerTypeShows",customerTypeShows);
        model.addAttribute("sums", DoubleFormatUtil.getFormatSums(sums));
        model.addAttribute("counts",counts);
        model.addAttribute("years",years);
        model.addAttribute("months",months);

        return "dataShow/customerTypeDetail";
    }

    /**
     * 导出客户类型明细数据到excel
     * @return
     */
    @RequestMapping(value = "/exportExcel")
    public String exportExcel(HttpServletResponse response, String customerTypes,String counts,String sums) throws Exception {

        String[] customerTypes1=customerTypes.split(",");
        String[] counts1=counts.split(",");
        String[] sums1=sums.split(",");

        response.reset();
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename="+ new String(("customerTypeShow"+".xlsx").getBytes(), "utf-8"));

        ServletOutputStream out=response.getOutputStream();
        dataShowService.exportExcel(out,customerTypes1,counts1,sums1);

        return "redirect:/dataShow/customerTypeDetail";
    }

}
