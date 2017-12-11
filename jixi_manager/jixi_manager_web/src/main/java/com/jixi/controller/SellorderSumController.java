package com.jixi.controller;


import com.jixi.pojo.Commission;
import com.jixi.pojo.SellorderSum;
import com.jixi.service.ICommissionService;
import com.jixi.service.ICustomerService;
import com.jixi.service.ISellorderSumService;

import com.jixi.utils.DoubleFormatUtil;
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
 * Created by zhm on 2017/9/5.
 */
@Controller
@RequestMapping("/sellorderSum")
public class SellorderSumController {

    @Autowired
    private ISellorderSumService sellorderSumService;

    @Autowired
    private ICustomerService customerService;
    @Autowired
    private ICommissionService commissionService;

    /**
     * 客户订单列表及按条件搜索
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
        //查出数据
        List<SellorderSum> sellorderSums=sellorderSumService.like(map);

        //添加分类信息
        List<SellorderSum> projectNames=sellorderSumService.selectDistinctProjectname();
        List<SellorderSum> companys=sellorderSumService.selectDistinctCompany();
        List<SellorderSum> addresses=sellorderSumService.selectDistinctAddress();
        List<SellorderSum> customerNames=sellorderSumService.selectDistinctCustomerName();
        List<SellorderSum> sellmen=sellorderSumService.selectDistinctSellman();
        List<SellorderSum> customerTypes=sellorderSumService.selectDistinctCustomerType();
        List<SellorderSum> customerPhones=sellorderSumService.selectDistinctCustomerPhone();
        //获得价格汇总
        Double onlineSums=0.0;
        Double underlineSums=0.0;
        Double freights=0.0;
        Double discountprices=0.0;
        Double freightPro=0.0;
        if(sellorderSums.size()>0){
            onlineSums=DoubleFormatUtil.getFormatSums(sellorderSumService.getOnlineSums(map));
            underlineSums=DoubleFormatUtil.getFormatSums(sellorderSumService.getUnderlineSums(map));
            freights=DoubleFormatUtil.getFormatSums(sellorderSumService.getTfreights(map));
            discountprices=DoubleFormatUtil.getFormatSums(sellorderSumService.getDiscountPrices(map));
            freightPro=DoubleFormatUtil.getFormatSums(freights/discountprices*100);
        }

        model.addAttribute("customerPhones",customerPhones);
        model.addAttribute("sellmen",sellmen);
        model.addAttribute("customerTypes",customerTypes);
        model.addAttribute("sellorderSums",sellorderSums);
        model.addAttribute("projectNames",projectNames);
        model.addAttribute("companys",companys);
        model.addAttribute("addresses",addresses);
        model.addAttribute("customerNames",customerNames);

        model.addAttribute("onlineSums", onlineSums);
        model.addAttribute("underlineSums",underlineSums);
        model.addAttribute("freights",freights);
        model.addAttribute("discountprices",discountprices);
        model.addAttribute("freightPro",freightPro);//运费占比

        return "sellorderSum/list";
    }

    /**
     * 从客户表更新客户类型
     */
    @RequestMapping(value = "/importCustomerType")
    public String importCustomerType() throws Exception {
        List<SellorderSum> sellorderSums=sellorderSumService.getSellorderSumList();
        for(SellorderSum sellorderSum:sellorderSums){
            if(sellorderSum.getCustomerphone()==null||sellorderSum.getCustomerphone().equals("")){
                sellorderSum.setCustomertype("");
            }else{
                sellorderSum.setCustomertype(customerService.selectTypeByCustomerCode(sellorderSum.getCustomerphone()));
                //如果公司名和订货人为空，从客户表补充
                if(sellorderSum.getCompany()==null||"".equals(sellorderSum.getCompany())){
                    sellorderSum.setCompany(customerService.selectOne(sellorderSum.getCustomerphone()).getCompany());
                }
                if(sellorderSum.getCustomername()==null||"".equals(sellorderSum.getCustomername())){
                    sellorderSum.setCustomername(customerService.selectOne(sellorderSum.getCustomerphone()).getCustomername());
                }
                //根据客户类型更新销售提成
                Commission commission=commissionService.selectOne(1);
                switch(sellorderSum.getCustomertype()){
                    case "T1":
                        sellorderSum.setCommission(Double.parseDouble(new java.text.DecimalFormat("0.00").format(commission.getT1()*sellorderSum.getAllsum())));break;
                    case "T2":
                        sellorderSum.setCommission(Double.parseDouble(new java.text.DecimalFormat("0.00").format(commission.getT2()*sellorderSum.getAllsum())));break;
                    case "T3":
                        sellorderSum.setCommission(Double.parseDouble(new java.text.DecimalFormat("0.00").format(commission.getT3()*sellorderSum.getAllsum())));break;
                    case "T4":
                        sellorderSum.setCommission(Double.parseDouble(new java.text.DecimalFormat("0.00").format(commission.getT4()*sellorderSum.getAllsum())));break;
                    case "T5":
                        sellorderSum.setCommission(Double.parseDouble(new java.text.DecimalFormat("0.00").format(commission.getT5()*sellorderSum.getAllsum())));break;
                    default:
                        sellorderSum.setCommission(0.00);break;
                }
            }

            sellorderSumService.updateSellorderSum(sellorderSum);
        }

        return "redirect:/sellorderSum/list";
    }


    /**
     * 跳转新增页面
     * */
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String createSellorderSum(){
        return "sellorderSum/add";
    }

    /**
     * 提交新增信息
     * */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String createSellorderSum(SellorderSum sellorderSum) throws Exception {
        sellorderSumService.createSellorderSum(sellorderSum);
        return "redirect:/sellorderSum/list";
    }

    /**
     * 跳转修改页面
     * */
    @RequestMapping(value = "/update",method = RequestMethod.GET)
    public String update(String sellordercode,Model model){
        SellorderSum sellorderSum=sellorderSumService.selectOne(sellordercode);
        model.addAttribute("sellorderSum",sellorderSum);

        return "sellorderSum/update";
    }

    /**
     * 修改信息
     * */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String updateSellorderSum(SellorderSum sellorderSum) throws Exception {
        sellorderSumService.updateSellorderSum(sellorderSum);
        return "redirect:/sellorderSum/list";
    }


    /**
     * 批量删除信息
     * */
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    private String deleteSellorderSum(String sellordercodes){
        String[] codes=sellordercodes.split(",");
        sellorderSumService.deleteSellorderSum(codes);
        return "redirect:/sellorderSum/list";
    }


    /**
     * 删除单条数据
     * */
    @RequestMapping(value = "/deleteOne")
    public String deleteOne(String sellordercode){
        sellorderSumService.deleteOne(sellordercode);

        return "redirect:/sellorderSum/list";
    }

    /**
     * 跳转导入页面
     */
    @RequestMapping(value = "/excelUpload")
    public String excelUpload(){
        return "sellorderSum/excelUpload";
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
                sellorderSumService.saveBath(file,file.getOriginalFilename()); //service实现方法
            }

        }
        return "redirect:/sellorderSum/list";
    }

    /**
     * 导出数据到excel
     * @return
     */
    @RequestMapping(value = "/exportExcel")
    public String exportExcel(HttpServletResponse response,String sellordercodes) throws Exception {

        String[] codes=sellordercodes.split(",");
        //获取导出数据的时间区间
        String timeMax=codes[0].substring(0,8);
        String timeMin=codes[codes.length-1].substring(0,8);
        String time=timeMin+"-"+timeMax;

        response.reset();
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename="+ new String(("sellOrderSum"+time+".xlsx").getBytes(), "utf-8"));

        ServletOutputStream out=response.getOutputStream();
        sellorderSumService.exportExcel(out,codes);

        return "redirect:/sellorderSum/list";
    }

    /**
     * 将数据传到详情页面
     * @return
     */
    @RequestMapping(value = "/detail")
    public String getDetail(String sellordercode,Model model){
        SellorderSum sellorderSum=sellorderSumService.selectOne(sellordercode);
        model.addAttribute("sellorderSum",sellorderSum);
        return "sellorderSum/detail";
    }

}
