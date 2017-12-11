package com.jixi.controller;

import com.jixi.pojo.Sellman;
import com.jixi.pojo.SellorderSum;
import com.jixi.service.ISellmanService;
import com.jixi.service.ISellorderSumService;
import com.jixi.utils.DoubleFormatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by zhm on 2017/11/7
 */
@Controller
@RequestMapping("/sellorderSumByFinance")
public class SellorderSumByFinanceController {

    @Autowired
    private ISellorderSumService sellorderSumService;
    @Autowired
    private ISellmanService sellmanService;

    /**
     * 客户订单汇总信息列表（财务）及按条件搜索
     * @return
     */
    @RequestMapping("/listForFinance")
    public String likeByFinance(Model model,String sellordercode,String sellman,String ticketstatus,String allpaystatue,String projectName,String company,String customertype,String address,String customername,String selldateMin,String selldateMax) throws ParseException {
        Map<String,Object> map=new HashMap();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");

        //获得订单编号
        if(sellordercode==null||sellordercode.replace(" ","").equals("")){
            sellordercode=null;
        }
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
        //获得业务员姓名
        if(sellman==null||sellman.equals("0")){
            sellman=null;
        }
        //获得付款状态
        if(allpaystatue==null||allpaystatue.equals("0")){
            allpaystatue=null;
        }
        //获得开票状态
        if(ticketstatus==null||ticketstatus.equals("0")){
            ticketstatus=null;
        }

        map.put("sellordercode",sellordercode);
        map.put("projectName",projectName);
        map.put("company",company);
        map.put("customertype",customertype);
        map.put("address",address);
        map.put("customername",customername);
        map.put("allpaystatue",allpaystatue==null?null:(allpaystatue.equals("未结清")?"0":"1"));
        map.put("ticketstatus",ticketstatus==null?null:(ticketstatus.equals("未开票")?"0":"1"));
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

        List<SellorderSum> sellorderSums=sellorderSumService.like(map);

        //添加分类信息
        List<SellorderSum> projectNames=sellorderSumService.selectDistinctProjectname();
        List<SellorderSum> companys=sellorderSumService.selectDistinctCompany();
        List<SellorderSum> addresses=sellorderSumService.selectDistinctAddress();
        List<SellorderSum> customerNames=sellorderSumService.selectDistinctCustomerName();
        List<Sellman> sellmen=sellmanService.getSellmanList();
        List<SellorderSum> customerTypes=sellorderSumService.selectDistinctCustomerType();
        //获得价格汇总信息
        Double discountprices=0.0;
        Double receivedsums=0.0;
        Double noReceivedsums=0.0;
        if(sellorderSums.size()>0){
            discountprices=DoubleFormatUtil.getFormatSums(sellorderSumService.getDiscountPrices(map));
            receivedsums=DoubleFormatUtil.getFormatSums(sellorderSumService.getReceivedSums(map));
            noReceivedsums=DoubleFormatUtil.getFormatSums(sellorderSumService.getNoReceivedSums(map));
        }

        model.addAttribute("sellordercode",sellordercode);
        model.addAttribute("sellmen",sellmen);
        model.addAttribute("customerTypes",customerTypes);
        model.addAttribute("sellorderSums",sellorderSums);
        model.addAttribute("projectNames",projectNames);
        model.addAttribute("companys",companys);
        model.addAttribute("addresses",addresses);
        model.addAttribute("customerNames",customerNames);

        model.addAttribute("discountprices",discountprices);
        model.addAttribute("receivedsums",receivedsums);
        model.addAttribute("noReceivedsums",noReceivedsums);

        return "sellorderSumByFinance/listForFinance";
    }

    /**
     * 跳转财务修改页面
     * */
    @RequestMapping(value = "/updateByFinance",method = RequestMethod.GET)
    public String updateByFinance(String sellordercode,Model model){
        SellorderSum sellorderSum=sellorderSumService.selectOne(sellordercode);
        model.addAttribute("sellorderSum",sellorderSum);

        return "sellorderSumByFinance/updateByFinance";
    }

    /**
     * 财务修改信息
     * */
    @RequestMapping(value = "/updateByFinance",method = RequestMethod.POST)
    public String updateSellorderSumByFinance(SellorderSum sellorderSum) throws Exception {
        if(sellorderSum.getReceivedsum()==null){
            sellorderSum.setReceivedsum(0.0);
        }
        sellorderSum.setNoreceivedsum(sellorderSum.getDiscountprice()-sellorderSum.getReceivedsum());

        if(sellorderSum.getDiscountprice()-sellorderSum.getReceivedsum()==0){
            sellorderSum.setAllpaystatue("1");
        }else{
            sellorderSum.setAllpaystatue("0");
        }
        sellorderSumService.updateSellorderSum(sellorderSum);
        return "redirect:/sellorderSumByFinance/listForFinance";
    }

    /**
     * 财务修改已开票状态为未开票
     * */
    @RequestMapping(value = "/updateTicketStatusAsNo")
    public String updateTicketStatusAsNo(String sellordercode) throws Exception {
        SellorderSum sellorderSum=sellorderSumService.selectOne(sellordercode);
        sellorderSum.setTicketstatus("0");
        sellorderSum.setTicketno("");
        sellorderSumService.updateSellorderSum(sellorderSum);

        return "redirect:/sellorderSumByFinance/listForFinance";
    }

    /**
     * 财务修改未开票状态为已开票
     * */
    @RequestMapping(value = "/updateTicketStatusAsYes")
    public String updateTicketStatusAsYes(String sellordercode,String ticketno) throws Exception {

        SellorderSum sellorderSum=sellorderSumService.selectOne(sellordercode);
        sellorderSum.setTicketstatus("1");
        sellorderSum.setTicketno(ticketno);
        sellorderSumService.updateSellorderSum(sellorderSum);

        return "redirect:/sellorderSumByFinance/listForFinance";
    }

    /**
     * 导出数据到excel(财务导出)
     * @return
     */
    @RequestMapping(value = "/exportExcelAsFinance")
    public String exportExcelAsFinance(HttpServletResponse response, String sellordercodes) throws Exception {

        String[] codes=sellordercodes.split(",");
        //获取导出数据的时间区间
        String timeMax=codes[0].substring(0,8);
        String timeMin=codes[codes.length-1].substring(0,8);
        String time=timeMin+"-"+timeMax;

        response.reset();
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename="+ new String(("sellOrderSum"+time+".xlsx").getBytes(), "utf-8"));

        ServletOutputStream out=response.getOutputStream();
        sellorderSumService.exportExcelAsFinance(out,codes,"客户订单财务信息统计");

        return "";
    }

}
