package com.jixi.controller;


import com.jixi.pojo.SellorderMaster;
import com.jixi.service.ISellOrderMasterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

/**
 * Created by zhm on 2017/8/24.
 */
@Controller
@RequestMapping("/sellOrderMaster")
public class SellOrderMasterController {

    @Autowired
    private ISellOrderMasterService sellOrderMasterService;


    /**
     * 显示商城订单列表
     * */
    @RequestMapping("/list")
    public String getSellOrderMaster(Model model) {
        List<SellorderMaster> sellorderMasters= sellOrderMasterService.getSellOrderMasterList();
        model.addAttribute("sellorderMasters",sellorderMasters);
        return "sellOrderMaster/list";
    }

    /**
     * 将excel数据导入数据库
     * */
//    @RequestMapping(value = "/importExcel",method = RequestMethod.POST)
//    @ResponseBody
//    public String readExcelData(MultipartFile myFile) throws IOException, ParseException {
//        List<String[]> list = OrderPoiUtil.readExcel(myFile,7,11,5); //这里得到的是一个集合，里面的每一个元素是String[]数组
//        sellOrderMasterService.saveBath(list); //service实现方法
//
//        return "";
//    }

    /**
     * 导出数据到excel
     * @return
     */
    @RequestMapping(value = "/exportExcel")
    @ResponseBody
    public String exportExcel(HttpServletResponse response) throws Exception {
        response.reset();

        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename="+ new String(("sellOrder.xlsx").getBytes(), "utf-8"));

        ServletOutputStream out=response.getOutputStream();
        sellOrderMasterService.exportExcel(out);

        return "";
    }


    /**
     * 新增数据
     * */
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @ResponseBody
    public String createSellorderMaster(SellorderMaster sellorderMaster) throws Exception {
         sellOrderMasterService.createSellorderMaster(sellorderMaster);
        return "";
    }

    /**
     * 修改数据
     * */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public String updateSellorderMaster(SellorderMaster sellorderMaster){
        sellOrderMasterService.updateSellorderMaster(sellorderMaster);
        return "";
    }

    /**
     * 批量删除客户订单信息
     * */
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    private String deleteSellorderMaster(String itemcodes){
        String[] codes=itemcodes.split(",");
        sellOrderMasterService.deleteSellorderMaster(codes);
        return "";
    }

    /**
     * 金额汇总
     * */
    @RequestMapping(value = "/getAllSum",method = RequestMethod.POST)
    @ResponseBody
    public String getAllSum(){
        sellOrderMasterService.getAllSum();
        return "";
    }
}
