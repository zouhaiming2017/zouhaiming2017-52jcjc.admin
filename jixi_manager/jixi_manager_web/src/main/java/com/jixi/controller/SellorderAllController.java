package com.jixi.controller;

import com.jixi.pojo.SellorderAll;
import com.jixi.service.ISellorderAllService;
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
@RequestMapping("/sellorderAll")
public class SellorderAllController {

    @Autowired
    private ISellorderAllService sellorderAllService;

    @RequestMapping("/getSellorderList")
    public String getSellorderList(Model model) throws ParseException {
        List<SellorderAll> sellorderAlls= sellorderAllService.getSellorderAll();
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

        for(SellorderAll sellorderAll:sellorderAlls){
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
        }

        model.addAttribute("sellorderAlls",sellorderAlls);
        model.addAttribute("allsums", DoubleFormatUtil.getFormatSums(allsums));
        model.addAttribute("allcounts",allcounts);
        model.addAttribute("dCounts",dCounts);
        model.addAttribute("cCounts",cCounts);
        model.addAttribute("bCounts",bCounts);
        model.addAttribute("aCounts",aCounts);
        model.addAttribute("dSums",DoubleFormatUtil.getFormatSums(dSums));
        model.addAttribute("cSums",DoubleFormatUtil.getFormatSums(cSums));
        model.addAttribute("bSums",DoubleFormatUtil.getFormatSums(bSums));
        model.addAttribute("aSums",DoubleFormatUtil.getFormatSums(aSums));

        return "sellorderAll/getSellorderList";
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
        response.setHeader("Content-Disposition", "attachment;filename="+ new String(("sellorderAll.xlsx").getBytes(), "utf-8"));

        ServletOutputStream out=response.getOutputStream();
        sellorderAllService.exportExcel(out,codes);

        return "redirect:/sellorderAll/getSellorderList";
    }
}
