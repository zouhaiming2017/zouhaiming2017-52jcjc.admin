package com.jixi.controller;


import com.jixi.pojo.Commission;
import com.jixi.pojo.Sellman;
import com.jixi.pojo.SellorderSum;
import com.jixi.service.ICommissionService;
import com.jixi.service.ICustomerService;
import com.jixi.service.ISellmanService;
import com.jixi.service.ISellorderSumService;
import com.jixi.utils.DoubleFormatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by zhm on 2017/8/29.
 */
@Controller
@RequestMapping("/sellman")
public class SellmanController {

    @Autowired
    private ISellmanService sellmanService;

    @Autowired
    private ISellorderSumService sellorderSumService;

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private ICommissionService commissionService;


    /**
     * 分页显示业务员信息列表及模糊查询
     */
    @RequestMapping("/list")
    public String like(Model model,String sellmanaddress,String leader,String sellmannature) {
        Map<String,Object> map=new HashMap();

        //获得业务员所属区域
        if(sellmanaddress==null||sellmanaddress.equals("0")){
            sellmanaddress=null;
        }
        map.put("sellmanaddress",sellmanaddress);

        //获得业务员上级领导
        if(leader==null||leader.equals("0")){
            leader=null;
        }
        map.put("leader",leader);

        //获得业务员性质
        if(sellmannature==null||sellmannature.equals("0")){
            sellmannature=null;
        }
        map.put("sellmannature",sellmannature);

        List<Sellman> sellmen=sellmanService.like(map);

        List<Sellman> sellmanaddresses=sellmanService.selectDistinctSellmanAddress();
        List<Sellman> leaders=sellmanService.selectDistinctLeader();
        List<Sellman> sellmannatures=sellmanService.selectDistinctSellmanNature();

        model.addAttribute("sellmanaddresses",sellmanaddresses);
        model.addAttribute("leaders",leaders);
        model.addAttribute("sellmannatures",sellmannatures);
        model.addAttribute("sellmen",sellmen);

        return "sellman/list";
    }

    /**
     * 查询业务员全部订单及搜索
     */
    @RequestMapping(value = "/selectorder")
    public String selectorder(Model model,String sellmanname,String projectName,String customertype,String allpaystatue,String selldateMin,String selldateMax) throws ParseException {

        Map<String,Object> map=new HashMap();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");

        //获得项目名称
        if(projectName==null||projectName.equals("0")){
            projectName=null;
        }

        //获得客户类型
        if(customertype==null||customertype.equals("0")){
            customertype=null;
        }

        //获得付款状态
        if(allpaystatue==null||allpaystatue.equals("0")){
            allpaystatue=null;
        }

        map.put("projectName",projectName);
        map.put("customertype",customertype);
        map.put("allpaystatue",allpaystatue==null?null:(allpaystatue.equals("未结清")?"0":"1"));
        map.put("sellman",sellmanname);

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
        List<SellorderSum> projectNames=sellorderSumService.selectDistinctProjectnameBySellman(sellmanname);
        List<SellorderSum> customerTypes=sellorderSumService.selectDistinctCustomerTypeBySellman(sellmanname);

        //获得价格汇总信息
        Double discountprices=0.0;
        Double receivedsums=0.0;
        Double noReceivedsums=0.0;
        Double commissions=0.0;
        if(sellorderSums.size()>0){
            discountprices=DoubleFormatUtil.getFormatSums(sellorderSumService.getDiscountPrices(map));
            receivedsums=  DoubleFormatUtil.getFormatSums(sellorderSumService.getReceivedSums(map));
            noReceivedsums=DoubleFormatUtil.getFormatSums(sellorderSumService.getNoReceivedSums(map));
            commissions=    DoubleFormatUtil.getFormatSums(sellorderSumService.getCommissions(map));
        }

        model.addAttribute("sellmanname",sellmanname);
        model.addAttribute("projectNames",projectNames);
        model.addAttribute("customerTypes",customerTypes);
        model.addAttribute("sellorderSums",sellorderSums);

        model.addAttribute("discountprices",discountprices);
        model.addAttribute("receivedsums",receivedsums);
        model.addAttribute("noReceivedsums",noReceivedsums);
        model.addAttribute("commissions",commissions);

        return "sellman/selectorder";
    }


    /**
     * 导出数据到excel(按销售提成导出)
     * @return
     */
    @RequestMapping(value = "/exportExcelAsSellman")
    public String exportExcelAsSellman(HttpServletResponse response, String sellordercodes) throws Exception {

        String[] codes=sellordercodes.split(",");
        //获取导出数据的时间区间
        String timeMax=codes[0].substring(0,8);
        String timeMin=codes[codes.length-1].substring(0,8);
        String time=timeMin+"-"+timeMax;

        response.reset();
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename="+ new String(("sellOrderSum"+time+".xlsx").getBytes(), "utf-8"));

        ServletOutputStream out=response.getOutputStream();
        sellorderSumService.exportExcelAsSellman(out,codes,"业务员所有客户订单");

        return "";
    }

    /**
     * 跳转设置提成页面
     */
    @RequestMapping(value = "/setCommission",method = RequestMethod.GET)
    public String setCommissions(Model model){
        Commission commission=commissionService.selectOne(1);
        model.addAttribute("commission",commission);
        return "sellman/setCommission";
    }

    /**
     * 设置提成页面
     */
    @RequestMapping(value = "/setCommission",method = RequestMethod.POST)
    public String setCommissions(Commission commission) throws Exception {
        //更新提成
        commissionService.updateCommission(commission);

        List<SellorderSum> sellorderSums=sellorderSumService.getSellorderSumList();
        for(SellorderSum sellorderSum:sellorderSums){
            //获得业务员提成
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
            sellorderSumService.updateSellorderSum(sellorderSum);
        }

        return "redirect:/sellman/list";
    }

    /**
     * 跳转新增页面
     * */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String createSellman(){
        return "sellman/add";
    }

    /**
     * 提交新增业务员信息
     * */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String createSellman(Sellman sellman) throws Exception {
        sellmanService.createSellman(sellman);
        return "redirect:/sellman/list";
    }

    /**
     * 跳转修改页面
     * */
    @RequestMapping(value = "/update",method = RequestMethod.GET)
    public String updateSellman(Model model,String sellmancode) {
        Sellman sellman=sellmanService.selectOne(sellmancode);
        model.addAttribute("sellman",sellman);
        return "sellman/update";
    }

    /**
     * 修改业务员信息
     * */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String updateSellman(Sellman sellman) throws Exception {
        sellmanService.updateSellman(sellman);
        return "redirect:/sellman/list";
    }


    /**
     * 批量删除业务员信息
     * */
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public String deleteSellman(String sellmancodes){
        String[] codes=sellmancodes.split(",");
        sellmanService.deleteSellman(codes);
        return "redirect:/sellman/list";
    }

    /**
     * 删除一个
     */
    @RequestMapping(value = "/deleteOne")
    public String seleteOne(String sellmancode){
        sellmanService.deleteOne(sellmancode);
        return "redirect:/sellman/list";
    }


}
