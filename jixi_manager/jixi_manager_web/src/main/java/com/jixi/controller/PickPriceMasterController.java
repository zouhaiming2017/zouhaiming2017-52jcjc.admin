package com.jixi.controller;

import com.jixi.pojo.PickpriceMaster;
import com.jixi.service.IPickPriceMasterService;
import com.jixi.utils.POIUtil;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhm on 2017/8/23.
 */
@Controller
@RequestMapping("/pickPriceMaster")
public class PickPriceMasterController {

    @Autowired
    private IPickPriceMasterService pickPriceMasterService;


    /**
     * 显示材料报价表列表
     * */
    @RequiresRoles("超级管理员")
    @RequestMapping("/list")
    public String getPickPriceMaster(Model model) {
        List<PickpriceMaster> pickpriceMasters= pickPriceMasterService.getPickPriceMasterList();
        List<PickpriceMaster> suppliers=pickPriceMasterService.selectDistinctSupplier();

        //传递分类（供应商数据）和所有数据
        model.addAttribute("suppliers",suppliers);
        model.addAttribute("pickpriceMasters",pickpriceMasters);
        return "pickPriceMaster/list";
    }


    /**
     * 将excel数据导入数据库
     * */
    @RequestMapping(value = "/importExcel",method = RequestMethod.POST)
    public String readExcelData(MultipartFile myFile) throws IOException {
        System.out.println(myFile.getOriginalFilename());
        List<String[]> list = POIUtil.readExcel(myFile,1,0,11); //这里得到的是一个集合，里面的每一个元素是String[]数组
        pickPriceMasterService.saveBath(list); //service实现方法
        return "redirect:/pickPriceMaster/list";
    }


    /**
     * 导出数据到excel
     * @return
     */
    @RequestMapping(value = "/exportExcel")
    @ResponseBody
    public String exportExcel(HttpServletResponse response) throws Exception {
        response.reset();

        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename="+ new String(("pickPrice.xlsx").getBytes(), "utf-8"));

        ServletOutputStream out=response.getOutputStream();
        pickPriceMasterService.exportExcel(out);

        return "redirect:/pickPriceMaster/list";
    }



    /**
     * 跳转新增页面
     * */
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String createPickpriceMaster(){
        return "pickPriceMaster/add";
    }

    /**
     * 新增数据
     * */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String createPickpriceMaster(PickpriceMaster pickpriceMaster) throws Exception {
        System.out.println(pickpriceMaster);
        pickPriceMasterService.createPickpriceMaster(pickpriceMaster);
        return "redirect:/pickPriceMaster/list";
    }

    /**
     * 跳转修改页面
     * */
    @RequestMapping(value = "/update",method = RequestMethod.GET)
    public String update(String itemCode,Model model){
        model.addAttribute("pickpriceMaster",pickPriceMasterService.selectOne(itemCode));
        return "pickPriceMaster/update";
    }

    /**
     * 修改数据
     * */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String update(PickpriceMaster pickpriceMaster){
        pickPriceMasterService.updatePickpriceMaster(pickpriceMaster);
        return "redirect:/pickPriceMaster/list";
    }


    /**
     * 删除多条数据
     * */
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public String deletePickpriceMaster(String itemcodes) {
        System.out.println(itemcodes);

        String[] codes=itemcodes.split(",");
        pickPriceMasterService.deletePickpriceMaster(codes);
        return "redirect:/pickPriceMaster/list";
    }


    /**
     * 删除单条数据
     * */
    @RequestMapping(value = "/deleteOne")
    public String deleteOne(String itemCode){
        pickPriceMasterService.deleteOne(itemCode);

        return "redirect:/pickPriceMaster/list";
    }


    /**
     * 根据商品名模糊查询
     * @param itemname
     * @return
     */
    @RequestMapping(value = "/like")
    public String like(String itemname,String supplier,Model model) {
        Map<String,Object> map=new HashMap();
        List<PickpriceMaster> pickpriceMasters=new ArrayList<PickpriceMaster>();


        //获得供应商名
        if(supplier==null||supplier.equals("0")){
            supplier=null;
        }
        map.put("supplier",supplier);

        //获得商品名
        String itemnameLike="";
        if(itemname==null||itemname.equals("")||itemname.equals(" ")) {
            itemnameLike = null;
            map.put("itemname",itemnameLike);
            List<PickpriceMaster> pickpriceMasters1=pickPriceMasterService.like(map);
            for(PickpriceMaster p:pickpriceMasters1){
                pickpriceMasters.add(p);
            }
        }else{
            char[] itemnames=itemname.toCharArray();
            for(int i=0;i<itemnames.length;i++){
                itemnameLike="%"+itemnames[i]+"%";
                map.put("itemname",itemnameLike);
                List<PickpriceMaster> pickpriceMasters1=pickPriceMasterService.like(map);
                for(PickpriceMaster p:pickpriceMasters1){
                    pickpriceMasters.add(p);
                }
            }

        }

        List<PickpriceMaster> suppliers=pickPriceMasterService.selectDistinctSupplier();

        model.addAttribute("pickpriceMasters",pickpriceMasters);
        model.addAttribute("suppliers",suppliers);
        model.addAttribute("itemname",itemname);

        return "pickPriceMaster/list";
    }
}
