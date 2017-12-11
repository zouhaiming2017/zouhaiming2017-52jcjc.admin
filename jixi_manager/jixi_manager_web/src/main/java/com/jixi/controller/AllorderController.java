package com.jixi.controller;

import com.jixi.pojo.Allorder;
import com.jixi.service.IAllorderService;
import com.jixi.utils.DoubleFormatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.util.List;

/**
 * Created by zhm on 2017/11/13.
 */
@Controller
@RequestMapping("/allOrder")
public class AllorderController {

    @Autowired
    private IAllorderService allorderService;

    @RequestMapping("/getAllorderList")
    public String getAllorderList(Model model) throws ParseException {
        List<Allorder> allorders=allorderService.getAllorder();
        //获得汇总信息
        Double sellSums=0.0;
        int sellCounts=0;
        Double pickSums=0.0;
        Double realGrossprofits=0.0;
        Double pinOffItemoffsets=0.0;
        Double freightpros=0.0;
        Double freightSuppliers=0.0;
        Double freightJixis=0.0;
        Double freightCustomers=0.0;
        for(Allorder allorder:allorders){
            sellSums+=allorder.getSellSums();
            sellCounts+=allorder.getSellCounts();
            pickSums+=allorder.getPickSums();
            realGrossprofits+=allorder.getRealGrossprofit();
            pinOffItemoffsets+=allorder.getPinOffItemoffset();

            freightSuppliers+=allorder.getFreightSupplier();
            freightJixis+=allorder.getFreightJixi();
            freightCustomers+=allorder.getFreightCustomer();

        }
        model.addAttribute("allorders",allorders);

        model.addAttribute("sellSums", DoubleFormatUtil.getFormatSums(sellSums));
        model.addAttribute("sellCounts",sellCounts);
        model.addAttribute("sellSumsAvgs",DoubleFormatUtil.getFormatSums(sellSums/sellCounts));
        model.addAttribute("pickSums",DoubleFormatUtil.getFormatSums(pickSums));
        model.addAttribute("realGrossprofits",DoubleFormatUtil.getFormatSums(realGrossprofits));
        model.addAttribute("pinOffItemoffsets",pinOffItemoffsets);
        model.addAttribute("grossmargins",DoubleFormatUtil.getFormatSums((realGrossprofits+pinOffItemoffsets)/sellSums*100)+"%");
        if(sellSums==0){
            model.addAttribute("freightpros","0%") ;
        }else{
            model.addAttribute("freightpros",DoubleFormatUtil.getFormatSums((freightSuppliers+freightJixis)/sellSums*100)+"%");
        }
        model.addAttribute("freightSuppliers",freightSuppliers);
        model.addAttribute("freightJixis",freightJixis);
        model.addAttribute("freightCustomers",freightCustomers);

        return "allOrder/getAllorderList";
    }

    /**
     * 导出数据到excel
     * @return
     */
    @RequestMapping(value = "/exportExcel")
    public String exportExcel(HttpServletResponse response, String timeMonthcodes) throws Exception {

        String[] codes=timeMonthcodes.split(",");


        response.reset();
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename="+ new String(("allorders.xlsx").getBytes(), "utf-8"));

        ServletOutputStream out=response.getOutputStream();
        allorderService.exportExcel(out,codes);

        return "redirect:/allOrder/getAllorderList";
    }
}
