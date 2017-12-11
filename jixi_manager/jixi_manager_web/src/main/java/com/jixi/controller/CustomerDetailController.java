package com.jixi.controller;

import com.jixi.pojo.Customerdetail;
import com.jixi.service.ICustomerDetailService;

import com.jixi.utils.DoubleFormatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by zhm on 2017/11/9.
 */
@Controller
@RequestMapping("/customerDetail")
public class CustomerDetailController {

    @Autowired
    private ICustomerDetailService customerDetailService;

    /**
     * 从客户订单表添加数据并展示当月数据
     */
    @RequestMapping("/getCustomerDetail")
    public String addCustomerDetail(Model model,String year,String month) throws ParseException {
        List<Customerdetail> customerdetails=customerDetailService.updateCustomerDetailFromOrder(year,month);
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
        //获得统计数据
        Double discountPrices=0.0;
        Double freights=0.0;
        int counts=0;
        Double sellmanCommissions=0.0;
        for(Customerdetail customerdetail:customerdetails){
            discountPrices+=customerdetail.getDiscountprices();
            freights+=customerdetail.getFreight();
            counts+=customerdetail.getCount();
            sellmanCommissions+=customerdetail.getSellmancommission();
        }

        model.addAttribute("customerdetails",customerdetails);
        model.addAttribute("years",years);
        model.addAttribute("months",months);
        model.addAttribute("discountPrices", DoubleFormatUtil.getFormatSums(discountPrices));
        model.addAttribute("freights",DoubleFormatUtil.getFormatSums(freights));
        if(discountPrices==0){
            model.addAttribute("freightPros","0%");
        }else{
            model.addAttribute("freightPros",DoubleFormatUtil.getFormatSums(freights/discountPrices*100)+"%");
        }
        model.addAttribute("counts",counts);
        model.addAttribute("sellmanCommissions",DoubleFormatUtil.getFormatSums(sellmanCommissions));
        return "customerDetail/getCustomerDetail";
    }

    /**
     * 导出数据到excel
     * @return
     */
    @RequestMapping(value = "/exportExcel")
    public String exportExcel(HttpServletResponse response,String customermonthcodes) throws Exception {

        String[] codes=customermonthcodes.split(",");
        //获取导出数据的时间
        String time=codes[0].substring(0,6);

        response.reset();
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename="+ new String(("customerDetail"+time+".xlsx").getBytes(), "utf-8"));

        ServletOutputStream out=response.getOutputStream();
        customerDetailService.exportExcel(out,codes);

        return "redirect:/customerDetail/getCustomerDetail";
    }

}
