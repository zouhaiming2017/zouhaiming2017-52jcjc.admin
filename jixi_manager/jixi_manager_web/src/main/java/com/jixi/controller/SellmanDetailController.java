package com.jixi.controller;

import com.jixi.pojo.Sellmandetail;
import com.jixi.service.ISellmanDetailService;
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
 * Created by zhm on 2017/11/10.
 */
@Controller
@RequestMapping("/sellmanDetail")
public class SellmanDetailController {
    @Autowired
    private ISellmanDetailService sellmanDetailService;

    @RequestMapping("/getSellmanDetail")
    public String getSellmanDetail(Model model, String year, String month) throws ParseException {
        List<Sellmandetail> sellmandetails=sellmanDetailService.updateSellmanDetailFromOrder(year,month);
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
        Double recieveprices=0.0;
        Double noRecieveprices=0.0;
        Double sellmanCommissions=0.0;
        for(Sellmandetail sellmandetail:sellmandetails){
            discountPrices+=sellmandetail.getDiscountprices();
            recieveprices+=sellmandetail.getRecieveprices();
            noRecieveprices+=sellmandetail.getNorecieveprices();
            sellmanCommissions+=sellmandetail.getCommissions();
        }

        model.addAttribute("sellmandetails",sellmandetails);
        model.addAttribute("years",years);
        model.addAttribute("months",months);
        model.addAttribute("discountPrices", DoubleFormatUtil.getFormatSums(discountPrices));
        model.addAttribute("recieveprices",DoubleFormatUtil.getFormatSums(recieveprices));
        model.addAttribute("noRecieveprices",DoubleFormatUtil.getFormatSums(noRecieveprices));
        model.addAttribute("sellmanCommissions",DoubleFormatUtil.getFormatSums(sellmanCommissions));

        return "sellmanDetail/getSellmanDetail";
    }

    /**
     * 导出数据到excel
     * @return
     */
    @RequestMapping(value = "/exportExcel")
    public String exportExcel(HttpServletResponse response, String sellmanmonthcodes) throws Exception {

        String[] codes=sellmanmonthcodes.split(",");
        //获取导出数据的时间
        String time=codes[0].substring(0,6);

        response.reset();
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename="+ new String(("sellmanDetail"+time+".xlsx").getBytes(), "utf-8"));

        ServletOutputStream out=response.getOutputStream();
        sellmanDetailService.exportExcel(out,codes);

        return "redirect:/sellmanDetail/getSellmanDetail";
    }

}
