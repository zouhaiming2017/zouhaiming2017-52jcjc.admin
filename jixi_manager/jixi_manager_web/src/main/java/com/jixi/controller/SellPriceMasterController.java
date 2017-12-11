package com.jixi.controller;

import com.jixi.pojo.PickpriceMaster;
import com.jixi.pojo.SellpriceMaster;
import com.jixi.service.IPickPriceMasterService;
import com.jixi.service.ISellPriceMasterService;
import com.jixi.utils.POIUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhm on 2017/8/24.
 */
@Controller
@RequestMapping("/sellPriceMaster")
public class SellPriceMasterController {

    @Autowired
    private ISellPriceMasterService sellPriceMasterService;

    @Autowired
    private IPickPriceMasterService pickPriceMasterService;


    /**
     * 显示商城材料价目列表
     * */
    @RequestMapping("/list")
    public String getSellPriceMaster(Model model) {
        List<SellpriceMaster> sellpriceMasters = sellPriceMasterService.getSellPriceMasterList();
        //获得供应商分类
//        List<SellpriceMaster> supplierCodes=sellPriceMasterService.selectDistinctSupplierCode();
        List<PickpriceMaster> suppliers=pickPriceMasterService.selectDistinctSupplier();


        model.addAttribute("suppliers",suppliers);
        model.addAttribute("sellpriceMasters",sellpriceMasters);
        return "sellPriceMaster/list";
    }

    /**
     * 模糊查询
     */
    @RequestMapping("/like")
    public String like(Model model,String supplier,String itemname){
        Map<String,Object> map=new HashMap();
        List<SellpriceMaster> sellpriceMasters=new ArrayList<>();

        //获得供应商名
        if(supplier==null||supplier.equals("0")){
            supplier=null;
        }
        map.put("suppliercode",supplier);

        //获得商品名
        String itemnameLike="";
        if(itemname==null||itemname.equals("")||itemname.equals(" ")) {
            itemnameLike = null;
            map.put("itemname",itemnameLike);
            List<SellpriceMaster> sellpriceMasters1=sellPriceMasterService.like(map);
            for(SellpriceMaster s:sellpriceMasters1){
                sellpriceMasters.add(s);
            }
        }else{
            char[] itemnames=itemname.toCharArray();
            for(int i=0;i<itemnames.length;i++){
                itemnameLike="%"+itemnames[i]+"%";
                map.put("itemname",itemnameLike);
                List<SellpriceMaster> sellpriceMasters1=sellPriceMasterService.like(map);
                for(SellpriceMaster s:sellpriceMasters1){
                    sellpriceMasters.add(s);
                }
            }

        }

        List<PickpriceMaster> suppliers=pickPriceMasterService.selectDistinctSupplier();

        model.addAttribute("sellpriceMasters",sellpriceMasters);
        model.addAttribute("suppliers",suppliers);
        model.addAttribute("itemname",itemname);
        return "sellPriceMaster/list";
    }


    /**
     * 将excel数据导入数据库
     * */
    @RequestMapping(value = "/importExcel",method = RequestMethod.POST)
    public String readExcelData(MultipartFile myFile) throws IOException {
        List<String[]> list = POIUtil.readExcel(myFile,1,0,12); //这里得到的是一个集合，里面的每一个元素是String[]数组
        sellPriceMasterService.saveBath(list); //service实现方法

        return "redirect:/sellPriceMaster/list";
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
        response.setHeader("Content-Disposition", "attachment;filename="+ new String(("sellPrice.xlsx").getBytes(), "utf-8"));

        ServletOutputStream out=response.getOutputStream();
        sellPriceMasterService.exportExcel(out);

        return "";
    }

    /**
     * 跳转到新增页面
     */
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String createSellpriceMaster(){
        return "sellPriceMaster/add";
    }

    /**
     * 新增商城上线材料价目
     * */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String createSellpriceMaster(SellpriceMaster sellpriceMaster) throws Exception {
        sellPriceMasterService.createSellpriceMaster(sellpriceMaster);
        return "redirect:/sellPriceMaster/list";
    }

    /**
     * 跳转修改页面
     * */
    @RequestMapping(value = "/update",method = RequestMethod.GET)
    public String update(String itemcode,Model model){
        SellpriceMaster sellpriceMaster=sellPriceMasterService.selectOne(itemcode);

        model.addAttribute("sellpriceMaster",sellpriceMaster);
        return "sellPriceMaster/update";
    }

    /**
     * 修改商城上线材料价目
     * */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public String update(SellpriceMaster sellpriceMaster){
        sellPriceMasterService.updateSellpriceMaster(sellpriceMaster);
        return "redirect:/sellPriceMaster/list";
    }

    /**
     * 批量删除客户订单信息
     * */
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    private String deleteSellpriceMaster(String itemcodes){
        String[] codes=itemcodes.split(",");
        sellPriceMasterService.deleteSellpriceMaster(codes);
        return "redirect:/sellPriceMaster/list";
    }

    /**
     * 单个删除客户订单信息
     * */
    @RequestMapping(value = "/deleteOne",method = RequestMethod.POST)
    @ResponseBody
    private String deleteOne(String itemcode){
        sellPriceMasterService.deleteOne(itemcode);
        return "redirect:/sellPriceMaster/list";
    }
}
