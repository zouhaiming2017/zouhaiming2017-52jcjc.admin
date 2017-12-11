package com.jixi.controller;

import com.jixi.pojo.PickorderSum;
import com.jixi.service.IPickOrderSumService;
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
 * Created by zhm on 2017/11/27.
 */
@Controller
@RequestMapping("/pickorderSumByFinance")
public class PickorderSumByFinanceController {
    @Autowired
    private IPickOrderSumService pickOrderSumService;

    /**
     * 配货单汇总列表及模糊查询（财务）
     */
    @RequestMapping(value = "/listForFinance")
    public String like(Model model,String pickordercode,String ticketstatus,String allpaystatue,String supplier,String address,String pickdateMin,String pickdateMax) throws ParseException {
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
        //获得付款状态
        if(allpaystatue==null||allpaystatue.equals("0")){
            allpaystatue=null;
        }
        //获得开票状态
        if(ticketstatus==null||ticketstatus.equals("0")){
            ticketstatus=null;
        }

        map.put("pickordercode",pickordercode);
        map.put("supplier",supplier);
        map.put("address",address);
        map.put("allpaystatue",allpaystatue==null?null:(allpaystatue.equals("未结清")?"0":"1"));
        map.put("ticketstatus",ticketstatus==null?null:(ticketstatus.equals("未开票")?"0":"1"));


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
        Double allsums=0.0;
        Double receivedsums=0.0;
        Double noreceivedsums=0.0;
        if(pickorderSums.size()>0){
            allsums=DoubleFormatUtil.getFormatSums(pickOrderSumService.getPallSums(map));
            receivedsums=DoubleFormatUtil.getFormatSums(pickOrderSumService.getPreceivedsums(map));
            noreceivedsums=DoubleFormatUtil.getFormatSums(pickOrderSumService.getPnoreceivedsum(map));

        }
        model.addAttribute("pickordercode",pickordercode);
        model.addAttribute("suppliers",suppliers);
        model.addAttribute("linkmans",linkmans);
        model.addAttribute("addresses",addresses);

        model.addAttribute("allsums",allsums);
        model.addAttribute("receivedsums",receivedsums);
        model.addAttribute("noreceivedsums",noreceivedsums);

        model.addAttribute("pickorderSums",pickorderSums);

        return "pickorderSumByFinance/listForFinance";
    }

    /**
     * 跳转财务修改页面
     * */
    @RequestMapping(value = "/updateByFinance",method = RequestMethod.GET)
    public String updateByFinance(String pickordercode,Model model){
        PickorderSum pickorderSum=pickOrderSumService.selectOne(pickordercode);
        model.addAttribute("pickorderSum",pickorderSum);

        return "pickorderSumByFinance/updateByFinance";
    }

    /**
     * 财务修改信息
     * */
    @RequestMapping(value = "/updateByFinance",method = RequestMethod.POST)
    public String updateSellorderSumByFinance(PickorderSum pickorderSum) throws Exception {

        if(pickorderSum.getReceivedsum()==null){
            pickorderSum.setReceivedsum(0.0);
        }
        pickorderSum.setNoreceivedsum(pickorderSum.getAllsum()-pickorderSum.getReceivedsum());

        if(pickorderSum.getAllsum()-pickorderSum.getReceivedsum()==0){
            pickorderSum.setAllpaystatue("1");
        }else{
            pickorderSum.setAllpaystatue("0");
        }
        pickOrderSumService.updatePickorderSum(pickorderSum);

        return "redirect:/pickorderSumByFinance/listForFinance";
    }


    /**
     * 财务修改已开票状态为未开票
     * */
    @RequestMapping(value = "/updateTicketStatusAsNo")
    public String updateTicketStatusAsNo(String pickordercode) throws Exception {
        PickorderSum pickorderSum=pickOrderSumService.selectOne(pickordercode);
        pickorderSum.setTicketstatus("0");
        pickorderSum.setTicketno("");
        pickOrderSumService.updatePickorderSum(pickorderSum);

        return "redirect:/pickorderSumByFinance/listForFinance";
    }

    /**
     * 财务修改未开票状态为已开票
     * */
    @RequestMapping(value = "/updateTicketStatusAsYes")
    public String updateTicketStatusAsYes(String pickordercode,String ticketno) throws Exception {

        PickorderSum pickorderSum=pickOrderSumService.selectOne(pickordercode);
        pickorderSum.setTicketstatus("1");
        pickorderSum.setTicketno(ticketno);
        pickOrderSumService.updatePickorderSum(pickorderSum);

        return "redirect:/pickorderSumByFinance/listForFinance";
    }

    /**
     * 导出数据到excel(财务导出)
     * @return
     */
    @RequestMapping(value = "/exportExcelAsFinance")
    public String exportExcelAsFinance(HttpServletResponse response, String pickordercodes) throws Exception {

        String[] codes=pickordercodes.split(",");
        //获取导出数据的时间区间
        String timeMax=codes[0].substring(0,8);
        String timeMin=codes[codes.length-1].substring(0,8);
        String time=timeMin+"-"+timeMax;

        response.reset();
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename="+ new String(("pickOrderSumByFinanace"+time+".xlsx").getBytes(), "utf-8"));

        ServletOutputStream out=response.getOutputStream();
        pickOrderSumService.exportExcelAsFinance(out,codes,"配货订单财务信息统计");

        return "";
    }


}
