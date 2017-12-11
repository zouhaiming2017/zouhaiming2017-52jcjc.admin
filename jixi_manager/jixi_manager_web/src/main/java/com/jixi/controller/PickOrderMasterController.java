package com.jixi.controller;

import com.jixi.pojo.PickorderMaster;
import com.jixi.service.IPickOrderMasterService;
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
 * Created by zhm on 2017/8/23.
 */
@Controller
@RequestMapping("/pickOrderMaster")
public class PickOrderMasterController {

    @Autowired
    private IPickOrderMasterService pickOrderMasterService;

    /**
     * 显示配货单列表
     * */
    @RequestMapping("/list")
    public String getPickOrderMaster(Model model) {
        List<PickorderMaster> pickorderMasters=pickOrderMasterService.getPickOrderMasterList();
        model.addAttribute("pickorderMasters",pickorderMasters);
        return "pickOrderMaster/list";
    }


    /**
     * 将excel数据导入数据库
     * */
//    @RequestMapping(value = "/importExcel",method = RequestMethod.POST)
//    public String readExcelData(MultipartFile myFile) throws IOException, ParseException {
//        List<String[]> list = OrderPoiUtil.readExcel(myFile,5,11,3); //这里得到的是一个集合，里面的每一个元素是String[]数组
////        pickOrderMasterService.saveBath(list); //service实现方法
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
        response.setHeader("Content-Disposition", "attachment;filename="+ new String(("pickOrder.xlsx").getBytes(), "utf-8"));

        ServletOutputStream out=response.getOutputStream();
        pickOrderMasterService.exportExcel(out);

        return "";
    }


    /**
     * 新增数据
     * */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String createPickorderMaster(PickorderMaster pickorderMaster) throws Exception {
        pickOrderMasterService.createPickorderMaster(pickorderMaster);
        return "redirect:/pickOrderMaster/list";
    }


    /**
     * 从供货商报价表导入相应的商品进价
     * */
    @RequestMapping(value = "/addInprice",method = RequestMethod.POST)
    @ResponseBody
    public String addInpriceFromPickPriceMaster(){
        pickOrderMasterService.addInpriceFromPickPriceMaster();
        return "";
    }

    /**
     *  跳转到修改页面
     * */
    @RequestMapping(value = "/update",method = RequestMethod.GET)
    public String updatePickOrderMaster(String id,Model model){
        PickorderMaster pickorderMaster=pickOrderMasterService.selectOne(Integer.parseInt(id));
        model.addAttribute("pickorderMaster",pickorderMaster);
       return "pickOrderMaster/update";
    }

    /**
     * 修改数据
     * */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public String updatePickOrderMaster(PickorderMaster pickorderMaster){
        pickOrderMasterService.updatePickorderMaster(pickorderMaster);

        return "redirect:/pickOrderMaster/list";
    }


    /**
     * 批量删除配货单信息
     * */
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public String deletePickOrderMaster(String itemcodes){
        String[] codes=itemcodes.split(",");
        pickOrderMasterService.deletePickorderMaster(codes);
        return "redirect:/pickOrderMaster/list";
    }


    /**
     * 删除单个配货单信息
     * */
    @RequestMapping(value = "/deleteOne")
    public String deleteOne(String id){
        pickOrderMasterService.deleteOne(Integer.parseInt(id));
        return "redirect:/pickOrderMaster/list";
    }

    /**
     * 金额汇总
     * */
    @RequestMapping(value = "/getAllSum",method = RequestMethod.POST)
    @ResponseBody
    public String getSum(){
        pickOrderMasterService.getAllSum();

        return "";
    }
}
