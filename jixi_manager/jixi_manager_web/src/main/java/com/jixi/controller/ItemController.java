package com.jixi.controller;

import com.jixi.pojo.Item;
import com.jixi.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhm on 2017/8/21.
 */
@Controller
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private IItemService itemService;

    /**
     * 详情页面
     */
    @RequestMapping("/detail")
    public String detail(String itemcode,Model model){
        Item item=itemService.selectOne(itemcode);
        model.addAttribute("item",item);
        return "item/detail";
    }

    /**
     * 商品列表及模糊查询
     */
    @RequestMapping("/list")
    public String like(Model model,String supplier,String brandname,String itemname){
        Map<String,Object> map=new HashMap();

        //获得供应商名
        if(supplier==null||supplier.equals("0")){
            supplier=null;
        }
        map.put("supplier",supplier);

        //获得品牌名
        if(brandname==null||brandname.equals("0")){
            brandname=null;
        }
        map.put("brandname",brandname);

        //获得商品名
        String itemnameLike="";
        if(itemname==null||itemname.equals("")||itemname.equals(" ")) {
            itemnameLike = null;
        }else{
            itemnameLike="%"+itemname+"%";
        }

        map.put("itemname",itemnameLike);
        List<Item> items=itemService.like(map);

        List<Item> suppliers=itemService.selectDistinctSupplier();
        List<Item> brandnames=itemService.selectDistinctBrandName();

        model.addAttribute("items",items);
        model.addAttribute("suppliers",suppliers);
        model.addAttribute("brandnames",brandnames);
        model.addAttribute("itemname",itemname);

        return "item/list";
    }

    /**
     * 跳转新增页面
     * */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String createItem(){
        return "item/add";
    }


    /**
     * 提交新增商品信息
     * */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String createItem(Item item) throws Exception {
        item.setCount(item.getCounts()-item.getOutcount());
        itemService.createItem(item);
        return "redirect:/item/list";
    }

    /**
     * 跳转修改页面
     * */
    @RequestMapping(value = "/update",method = RequestMethod.GET)

    public String updateItem(String itemcode,Model model) throws Exception {
         Item item=itemService.selectOne(itemcode);
         model.addAttribute("item",item);
        return "item/update";
    }

    /**
     * 修改商品信息
     * */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String updateItem(Item item) throws Exception {
        item.setCount(item.getCounts()-item.getOutcount());
        itemService.updateItem(item);
        return "redirect:/item/list";
    }

    /**
     * 批量删除商品信息
     * */
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public String deleteItem(String itemcodes) {
        String[] codes = itemcodes.split(",");
        itemService.deleteItem(codes);
        return "redirect:/item/list";
    }

    /**
     * 删除一个商品
     * */
    @RequestMapping(value = "/deleteOne")
    public String deleteOne(String itemcode) {
        itemService.deleteOne(itemcode);
        return "redirect:/item/list";
    }

    /**
     * 导出数据到excel
     * @return
     */
    @RequestMapping(value = "/exportExcel")
    public String exportExcel(HttpServletResponse response, String itemcodes) throws Exception {
        String[] codes=itemcodes.split(",");

        response.reset();
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename="+ new String(("item"+".xlsx").getBytes(), "utf-8"));

        ServletOutputStream out=response.getOutputStream();
        itemService.exportExcel(out,codes);

        return "redirect:/pickorderItem/list";
    }




}
