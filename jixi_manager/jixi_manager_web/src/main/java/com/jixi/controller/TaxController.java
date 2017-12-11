package com.jixi.controller;

import com.jixi.pojo.Tax;
import com.jixi.service.ITaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by zhm on 2017/11/13.
 */
@Controller
@RequestMapping("/taxService")
public class TaxController {
    @Autowired
    private ITaxService taxService;

    /**
     * 获得所有数据
     * @param model
     * @return
     */
    @RequestMapping("/list")
    public String getTaxList(Model model){
        List<Tax> taxes=taxService.getTaxList();
        model.addAttribute("taxes",taxes);
        return "taxService/list";
    }

    /**
     * 跳转添加页面
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String addTaxList(Model model){
        //选择年月
        SimpleDateFormat yearFormat=new SimpleDateFormat("yyyy");
        int maxYear=Integer.parseInt(yearFormat.format(new Date()));
        List<String> timeMonths=new ArrayList<>();
        for(int i=2017;i<=maxYear;i++){
            for(int j=1;j<=12;j++){
                if(j<10){
                    timeMonths.add(i+"-0"+j);
                }else {
                    timeMonths.add(i+"-"+j);
                }
            }
        }

        model.addAttribute("timeMonths",timeMonths);

        return "taxService/add";
    }

    /**
     * 添加
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String addTaxList(Tax tax){
        taxService.addTax(tax);
        return "redirect:/taxService/list";
    }

    /**
     * 跳转修改页面
     */
    @RequestMapping(value = "/update",method = RequestMethod.GET)
    public String updateTax(Model model,String timeMonth){
        Tax tax=taxService.selectOne(timeMonth);
        model.addAttribute("tax",tax);
        return "taxService/update";
    }

    /**
     * 修改
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String updateTax(Tax tax){
        taxService.updateTax(tax);
        return "redirect:taxService/list";
    }
}
