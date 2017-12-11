package com.jixi.controller;

import com.jixi.pojo.SellorderJc;
import com.jixi.service.ISellorderJcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by zhm on 2017/11/20.
 */
@Controller
@RequestMapping("sellorderJc")
public class SellorderJcController {

    @Autowired
    private ISellorderJcService sellorderJcService;

    /**
     *  获得列表及按条件搜索
     * @return
     */
    @RequestMapping("/list")
    public String like(Model model,String customerphone,String sellman,String projectName,String company,String customertype,String address,String customername,String selldateMin,String selldateMax) throws ParseException {
        Map<String,Object> map=new HashMap();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");

        //获得项目名称
        if(projectName==null||projectName.equals("0")){
            projectName=null;
        }
        //获得公司名称
        if(company==null||company.equals("0")){
            company=null;
        }
        //获得工地名称
        if(address==null||address.equals("0")){
            address=null;
        }
        //获得客户名称
        if(customername==null||customername.equals("0")){
            customername=null;
        }
        //获得客户类型
        if(customertype==null||customertype.equals("0")){
            customertype=null;
        }
        //获得客户手机号
        if(customerphone==null||customerphone.equals("0")){
            customerphone=null;
        }
        //获得业务员
        if(sellman==null||sellman.equals("0")){
            sellman=null;
        }

        map.put("projectName",projectName);
        map.put("company",company);
        map.put("customertype",customertype);
        map.put("address",address);
        map.put("customername",customername);
        map.put("customerphone",customerphone);
        map.put("sellman",sellman);
        map.put("ticketstatus",null);
        map.put("allpaystatue",null);


         /*获得开始时间*/
        Date selldateMin1=new Date();
        if(selldateMin==null||"".equals(selldateMin.replace(" ",""))){
            //若开始时间为空，则赋予时间2017-01-01
            selldateMin="2017-01-01";
            selldateMin1=format.parse(selldateMin);
        }else {
            selldateMin1=format.parse(selldateMin);
        }
        map.put("selldateMin",selldateMin1);
        model.addAttribute("selldateMin",selldateMin1);


        /*获得结束时间*/
        Date selldateMax2=new Date();
        if(selldateMax==null||"".equals(selldateMax.replace(" ",""))){
            //若结束时间为空，则赋予当前时间
            selldateMax2=format.parse(format.format(selldateMax2));
        }else {
            selldateMax2=format.parse(selldateMax);
        }
        map.put("selldateMax",selldateMax2);
        model.addAttribute("selldateMax",selldateMax2);

        List<SellorderJc> sellorderJcs=sellorderJcService.like(map);

        //添加分类信息
        List<SellorderJc> projectNames=sellorderJcService.selectDistinctProjectname();
        List<SellorderJc> companys=sellorderJcService.selectDistinctCompany();
        List<SellorderJc> addresses=sellorderJcService.selectDistinctAddress();
        List<SellorderJc> customerNames=sellorderJcService.selectDistinctCustomerName();
        List<SellorderJc> sellmen=sellorderJcService.selectDistinctSellman();
        List<SellorderJc> customerTypes=sellorderJcService.selectDistinctCustomerType();
        List<SellorderJc> customerPhones=sellorderJcService.selectDistinctCustomerPhone();

        //获得价格汇总信息
        Map<String,Double> map2=sellorderJcService.countSums(sellorderJcs);

        model.addAttribute("sellorderJcs",sellorderJcs);

        model.addAttribute("customerPhones",customerPhones);
        model.addAttribute("sellmen",sellmen);
        model.addAttribute("customerTypes",customerTypes);
        model.addAttribute("projectNames",projectNames);
        model.addAttribute("companys",companys);
        model.addAttribute("addresses",addresses);
        model.addAttribute("customerNames",customerNames);

        model.addAttribute("onlineSums",new java.text.DecimalFormat("0.00").format(map2.get("onlineSums")));
        model.addAttribute("underlineSums",new java.text.DecimalFormat("0.00").format(map2.get("underlineSums")));
        model.addAttribute("freights",new java.text.DecimalFormat("0.00").format(map2.get("freights")));
        model.addAttribute("allSums",new java.text.DecimalFormat("0.00").format(map2.get("allSums")));
        model.addAttribute("commissions",new java.text.DecimalFormat("0.00").format(map2.get("commissions")));
        model.addAttribute("discountprices",new java.text.DecimalFormat("0.00").format(map2.get("discountprices")));
        model.addAttribute("freightPro",new java.text.DecimalFormat("0.00").format(map2.get("freights")/map2.get("discountprices")*100));//运费占比
        return "sellorderJc/list";
    }



    /**
     * 跳转导入页面
     */
    @RequestMapping(value = "/excelUpload")
    public String excelUpload(){
        return "sellorderJc/excelUpload";
    }


    /**
     * 将excel数据导入数据库
     * */
    @RequestMapping(value = "/importExcel")
    public String uploadExcel(@RequestParam("file")MultipartFile file) throws Exception {
        String fileName = "";//文件名
        if (file != null)
        {
            fileName = file.getOriginalFilename();
            if (fileName.endsWith(".xls") || fileName.endsWith(".xlsx"))
            {
                sellorderJcService.saveBath(file,file.getOriginalFilename()); //service实现方法
            }

        }
        return "redirect:/sellorderJc/list";
    }

    /**
     * 导出数据到excel
     * @return
     */
    @RequestMapping(value = "/exportExcel")
    public String exportExcel(HttpServletResponse response, String sellordercodes) throws Exception {

        String[] codes=sellordercodes.split(",");
        //获取导出数据的时间区间
        String timeMax=codes[0].substring(0,8);
        String timeMin=codes[codes.length-1].substring(0,8);
        String time=timeMin+"-"+timeMax;

        response.reset();
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename="+ new String(("sellOrderJc"+time+".xlsx").getBytes(), "utf-8"));

        ServletOutputStream out=response.getOutputStream();
        sellorderJcService.exportExcel(out,codes);

        return "redirect:/sellorderJc/list";
    }

    /**
     * 跳转新增页面
     * */
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String createSellorderSum(){
        return "sellorderJc/add";
    }

    /**
     * 提交新增信息
     * */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String createSellorderSum(SellorderJc sellorderJc) throws Exception {
        sellorderJcService.addSellorderJc(sellorderJc);
        return "redirect:/sellorderJc/list";
    }

    /**
     * 跳转修改页面
     * */
    @RequestMapping(value = "/update",method = RequestMethod.GET)
    public String update(String sellordercode,Model model){
        SellorderJc sellorderJc=sellorderJcService.selectOne(sellordercode);
        model.addAttribute("sellorderJc",sellorderJc);

        return "sellorderJc/update";
    }

    /**
     * 修改信息
     * */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String updateSellorderSum(SellorderJc sellorderJc) throws Exception {
        sellorderJcService.updateSellorderJc(sellorderJc);
        return "redirect:/sellorderJc/list";
    }


    /**
     * 批量删除信息
     * */
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    private String deleteSellorderSum(String sellordercodes){
        String[] codes=sellordercodes.split(",");
        sellorderJcService.deleteSellorderJc(codes);
        return "redirect:/sellorderJc/list";
    }


    /**
     * 删除单条数据
     * */
    @RequestMapping(value = "/deleteOne")
    public String deleteOne(String sellordercode){
        sellorderJcService.delectOne(sellordercode);

        return "redirect:/sellorderJc/list";
    }

    /**
     * 将数据传到详情页面
     * @return
     */
    @RequestMapping(value = "/detail")
    public String getDetail(String sellordercode,Model model){
        SellorderJc sellorderJc=sellorderJcService.selectOne(sellordercode);
        model.addAttribute("sellorderJc",sellorderJc);
        return "sellorderJc/detail";
    }

}
