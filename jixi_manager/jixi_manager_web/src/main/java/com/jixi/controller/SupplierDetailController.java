package com.jixi.controller;

import com.jixi.pojo.Supplierdetail;
import com.jixi.service.ISupplierDetailService;
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
@RequestMapping("/supplierDetail")
public class SupplierDetailController {
    @Autowired
    private ISupplierDetailService supplierDetailService;

    /**
     * 获得所有供应商月度明细
     * @return
     */
    @RequestMapping("/getSupplierDetail")
    public String getSupplierDetail(Model model, String year, String month) throws ParseException {
        List<Supplierdetail> supplierdetails=supplierDetailService.updateSupplierDetailFromOrder(year,month);
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
        Double supplierSums=0.0;
        Double supplierFreights=0.0;

        for(Supplierdetail supplierdetail:supplierdetails){
            supplierSums+=supplierdetail.getSuppliersums();
            supplierFreights+=supplierdetail.getSupplierfreights();
        }

        model.addAttribute("supplierdetails",supplierdetails);
        model.addAttribute("years",years);
        model.addAttribute("months",months);
        model.addAttribute("supplierSums", DoubleFormatUtil.getFormatSums(supplierSums));
        model.addAttribute("supplierFreights",DoubleFormatUtil.getFormatSums(supplierFreights));
        if(supplierSums==0){
            model.addAttribute("freightPro","0%");
        }else {
            model.addAttribute("freightPro",DoubleFormatUtil.getFormatSums(supplierFreights/supplierSums*100)+"%");
        }

        return "supplierDetail/getSupplierDetail";
    }

    /**
     * 导出数据到excel
     * @return
     */
    @RequestMapping(value = "/exportExcel")
    public String exportExcel(HttpServletResponse response, String suppliermonthcodes) throws Exception {

        String[] codes=suppliermonthcodes.split(",");
        //获取导出数据的时间
        String time=codes[0].substring(0,6);

        response.reset();
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename="+ new String(("supplierDetail"+time+".xlsx").getBytes(), "utf-8"));

        ServletOutputStream out=response.getOutputStream();
        supplierDetailService.exportExcel(out,codes);

        return "redirect:/supplierDetail/getSupplierDetail";
    }
}
