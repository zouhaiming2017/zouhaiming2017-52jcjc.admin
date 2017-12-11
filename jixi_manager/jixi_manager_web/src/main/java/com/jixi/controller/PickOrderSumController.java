package com.jixi.controller;

import com.jixi.pojo.PickorderSum;
import com.jixi.service.IPickOrderSumService;
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
 * Created by zhm on 2017/9/13.
 */
@Controller
@RequestMapping("/pickOrderSum")
public class PickOrderSumController {

    @Autowired
    private IPickOrderSumService pickOrderSumService;


    /**
     * 配货单汇总及模糊查询
     */
    @RequestMapping("/list")
    public String like(Model model,String pickordercode,String supplier,String address,String pickdateMin,String pickdateMax) throws ParseException {
        Map<String,Object> map=new HashMap();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");

        //获得配货单号
        if(pickordercode==null||pickordercode.replace(" ","").equals("")){
            pickordercode=null;
        }
        //获得供应商
        if(supplier==null||supplier.equals("0")){
            supplier=null;
        }
        //获得地址
        if(address==null||address.equals("0")){
            address=null;
        }

        map.put("pickordercode",pickordercode);
        map.put("supplier",supplier);
        map.put("address",address);


        /*获得开始时间*/
        Date pickdateMin1=new Date();
        if(pickdateMin==null||"".equals(pickdateMin.replace(" ",""))){
            //若开始时间为空，则赋予时间2017-01-01
            pickdateMin="2017-01-01";
            pickdateMin1=format.parse(pickdateMin);
        }else {
            pickdateMin1=format.parse(pickdateMin);
        }
        map.put("pickdateMin",pickdateMin1);
        model.addAttribute("pickdateMin",pickdateMin1);


        /*获得结束时间*/
        Date pickdateMax2=new Date();
        if(pickdateMax==null||"".equals(pickdateMax.replace(" ",""))){
            //若结束时间为空，则赋予当前时间
            pickdateMax2=format.parse(format.format(pickdateMax2));
        }else {
            pickdateMax2=format.parse(pickdateMax);
        }
        map.put("pickdateMax",pickdateMax2);
        model.addAttribute("pickdateMax",pickdateMax2);

        List<PickorderSum> pickorderSums=pickOrderSumService.like(map);
        //分类信息
        List<PickorderSum> suppliers=pickOrderSumService.selectDistinctSupplier();
        List<PickorderSum> linkmans=pickOrderSumService.selectDistinctLinkman();
        List<PickorderSum> addresses=pickOrderSumService.selectDistinctAddress();
       //价格统计
        Double sums=0.0;
        Double freights=0.0;
        Double allsums=0.0;
        Double freightPro=0.0;
        if(pickorderSums.size()>0){
            sums=DoubleFormatUtil.getFormatSums(pickOrderSumService.getPsums(map));
            freights=DoubleFormatUtil.getFormatSums(pickOrderSumService.getPfreights(map));
            allsums=DoubleFormatUtil.getFormatSums(pickOrderSumService.getPallSums(map));
            freightPro=DoubleFormatUtil.getFormatSums(freights/allsums*100);
        }

        model.addAttribute("pickordercode",pickordercode);
        model.addAttribute("suppliers",suppliers);
        model.addAttribute("linkmans",linkmans);
        model.addAttribute("addresses",addresses);

        model.addAttribute("sums",sums);
        model.addAttribute("freights",freights);
        model.addAttribute("allsums",allsums);
        model.addAttribute("freightPro",freightPro);
        model.addAttribute("pickorderSums",pickorderSums);

        return "pickOrderSum/list";
    }

    /**
     * 跳转导入页面
     */
    @RequestMapping(value = "/excelUpload")
    public String excelUpload(){
        return "pickOrderSum/excelUpload";
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
                pickOrderSumService.saveBath(file,file.getOriginalFilename()); //service实现方法
            }

        }
        return "redirect:/pickOrderSum/list";
    }

    /**
     * 导出数据到excel
     * @return
     */
    @RequestMapping(value = "/exportExcel")
    public String exportExcel(HttpServletResponse response, String pickordercodes) throws Exception {
        String[] codes=pickordercodes.split(",");
        //获取导出数据的时间区间
        String timeMax=codes[0].substring(0,8);
        String timeMin=codes[codes.length-1].substring(0,8);
        String time=timeMin+"-"+timeMax;

        response.reset();
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename="+ new String(("pickOrderSum"+time+".xlsx").getBytes(), "utf-8"));

        ServletOutputStream out=response.getOutputStream();
        pickOrderSumService.exportExcel(out,codes);

        return "redirect:/pickOrderSum/list";
    }


    /**
     * 跳转新增页面
     * */
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String createSellorderSum(){
        return "pickOrderSum/add";
    }

    /**
     * 提交新增信息
     * */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String createSellorderSum(PickorderSum pickorderSum) throws Exception {
        System.out.println(pickorderSum);
        //获得时间
        String pickdateStr = pickorderSum.getPickordercode().substring(0, 8);
        SimpleDateFormat format1 = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date pickdateDate = format1.parse(pickdateStr);
        String pickdate = format.format(pickdateDate);
        pickorderSum.setPickdata(format.parse(pickdate));

        pickOrderSumService.createPickorderSum(pickorderSum);
        System.out.println("后："+pickorderSum);
        return "redirect:/pickOrderSum/list";
    }

    /**
     * 跳转修改页面
     * */
    @RequestMapping(value = "/update",method = RequestMethod.GET)
    public String update(String pickordercode,Model model){
        PickorderSum pickorderSum=pickOrderSumService.selectOne(pickordercode);
        model.addAttribute("pickorderSum",pickorderSum);

        return "pickOrderSum/update";
    }

    /**
     * 修改信息
     * */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String updateSellorderSum(PickorderSum pickorderSum) throws Exception {
        pickOrderSumService.updatePickorderSum(pickorderSum);
        return "redirect:/pickOrderSum/list";
    }


    /**
     * 批量删除信息
     * */
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    private String deleteSellorderSum(String pickordercodes){
        String[] codes=pickordercodes.split(",");
        pickOrderSumService.deletePickorderSum(codes);
        return "redirect:/pickOrderSum/list";
    }


    /**
     * 删除单条数据
     * */
    @RequestMapping(value = "/deleteOne")
    public String deleteOne(String pickordercode){
        pickOrderSumService.deleteOne(pickordercode);

        return "redirect:/pickOrderSum/list";
    }


    /**
     * 将数据传到详情页面
     * @return
     */
    @RequestMapping(value = "/detail")
    public String getDetail(String pickordercode,Model model){
        PickorderSum pickorderSum=pickOrderSumService.selectOne(pickordercode);
        model.addAttribute("pickorderSum",pickorderSum);
        return "pickOrderSum/detail";
    }


}
