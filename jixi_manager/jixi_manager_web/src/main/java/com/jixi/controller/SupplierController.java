package com.jixi.controller;

import com.jixi.pojo.Supplier;
import com.jixi.service.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhm on 2017/8/29.
 */
@Controller
@RequestMapping("/supplier")
public class SupplierController {
    @Autowired
    private ISupplierService supplierService;

    /**
     * 客户信息列表及模糊查询
     */
    @RequestMapping("/list")
    public String like(Model model,String address,String vip,String supplierindex){
        Map<String,Object> map=new HashMap();

        //获得业务员
        if(address==null||address.equals("0")){
            address=null;
        }
        map.put("address",address);

        //获得客户类型
        if(supplierindex==null||supplierindex.equals("0")){
            supplierindex=null;
        }
        map.put("supplierindex",supplierindex);

        //获得客户vip等级
        if(vip==null||vip.equals("0")){
            vip=null;
        }
        map.put("vip",vip);

        List<Supplier> suppliers=supplierService.like(map);

        List<Supplier> addresses=supplierService.selectDistinctAddress();
        List<Supplier> vips=supplierService.selectDistinctVip();
        List<Supplier> supplierindexes=supplierService.selectDistinctSupplierIndex();

        model.addAttribute("addresses",addresses);
        model.addAttribute("vips",vips);
        model.addAttribute("supplierindexes",supplierindexes);
        model.addAttribute("suppliers",suppliers);
        return "supplier/list";
    }

    /**
     * 从报价表更新数据
     */
    @RequestMapping(value = "/updateByMasterTab")
    public String updateByMasterTab(){
        supplierService.updateByMasterTab();
        return "redirect:/supplier/list";
    }

    /**
     * 跳转新增页面
     * */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String createSupplier(){
        return "supplier/add";
    }

    /**
     * 提交新增客户信息
     * */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String createSupplier(Supplier supplier) throws Exception {
         supplierService.createSupplier(supplier);
        return "redirect:/supplier/list";
    }

    /**
     * 跳转修改页面
     * */
    @RequestMapping(value = "/update",method = RequestMethod.GET)
    public String updateSupplier(Model model,String suppliercode){
        Supplier supplier=supplierService.selectOne(suppliercode);
        model.addAttribute("supplier",supplier);
        return "supplier/update";
    }

    /**
     * 修改客户信息
     * */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String updateSupplier(Supplier supplier) throws Exception {
        supplierService.updateSupplier(supplier);
        return "redirect:/supplier/list";
    }


    /**
     * 批量删除客户信息
     * */
    @RequestMapping(value = "/delete")
    public String deleteSupplier(String suppliercodes){
        String[] codes=suppliercodes.split(",");
        supplierService.deleteSupplier(codes);
        return "redirect:/supplier/list";
    }

    /**
     * 删除一个
     */
    @RequestMapping(value = "/deleteOne")
    public String deleteOne(String suppliercode) {
        supplierService.deleteOne(suppliercode);
        return "redirect:/supplier/list";
    }
}
