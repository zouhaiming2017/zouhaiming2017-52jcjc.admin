package com.jixi.controller;

import com.jixi.pojo.JixitruckOrder;
import com.jixi.pojo.JixitruckOrderExample;
import com.jixi.service.IJixitruckOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by zhm on 2017/11/29.
 */
@Controller
@RequestMapping("/jixitruckOrder")
public class JixitruckOrderConroller {
    @Autowired
    private IJixitruckOrderService jixitruckOrderService;

    /**
     * 集兮车队订单列表及模糊查询
     * @param model
     * @return
     */
    @RequestMapping("/list")
    public String like(Model model,String pickdateMin,String pickdateMax) throws ParseException {
        Map map=new HashMap();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
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
        //查出数据
        List<JixitruckOrder> jixitruckOrders=jixitruckOrderService.like(map);
        //获得总运费
        Double freights=jixitruckOrderService.getFreightsByDate(map);

        model.addAttribute("jixitruckOrders",jixitruckOrders);
        model.addAttribute("freights",freights);
        return "jixitruckOrder/list";
    }

    /**
     * 查询一个
     * @param sellordercode
     * @return
     */
    @RequestMapping("/selectOne")
    public String selectOne(String sellordercode,Model model) {
        JixitruckOrder jixitruckOrder=jixitruckOrderService.selectOne(sellordercode);
        model.addAttribute("jixitruckOrder",jixitruckOrder);
        return "redirect:/jixitruckOrder/list";
    }

    /**
     * 跳转新增页面
     * @throws Exception
     */
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String createJixitruckOrder() throws Exception {
        return "jixitruckOrder/add";
    }


    /**
     * 新增
     * @param jixitruckOrder
     * @throws Exception
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String createJixitruckOrder(JixitruckOrder jixitruckOrder) throws Exception {
        jixitruckOrderService.createJixitruckOrder(jixitruckOrder);
        return "redirect:/jixitruckOrder/list";
    }

    /**
     * 跳转更新页面
     * @throws Exception
     */
    @RequestMapping(value = "/update",method = RequestMethod.GET)
    public String updateJixitruckOrder(String sellordercode,Model model) throws Exception {
        JixitruckOrder jixitruckOrder=jixitruckOrderService.selectOne(sellordercode);
        model.addAttribute("jixitruckOrder",jixitruckOrder);
        return "jixitruckOrder/update";
    }

    /**
     * 更新
     * @param jixitruckOrder
     * @throws Exception
     */
    @RequestMapping("/update")
    public String updateJixitruckOrder(JixitruckOrder jixitruckOrder) throws Exception {
        jixitruckOrderService.updateJixitruckOrder(jixitruckOrder);
        return "redirect:/jixitruckOrder/list";
    }

    /**
     * 批量删除
     * @param sellordercodes
     */
    @RequestMapping("/delete")
    public String deleteJixitruckOrder(String sellordercodes) {
        String[] codes=sellordercodes.split(",");
        jixitruckOrderService.deleteJixitruckOrder(codes);
        return "redirect:/jixitruckOrder/list";
    }

    /**
     * 删除一个
     * @param sellordercode
     */
    @RequestMapping("/deleteOne")
    public String deleteOne(String sellordercode) {
        jixitruckOrderService.deleteOne(sellordercode);
        return "redirect:/jixitruckOrder/list";
    }

    /**
     * 导出到excel
     * @param sellordercodes
     * @throws Exception
     */
    @RequestMapping("/exportExcel")
    public String exportExcel(HttpServletResponse response, String sellordercodes) throws Exception {
        String[] codes=sellordercodes.split(",");

        response.reset();
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename="+ new String(("jixiTructOrder"+".xlsx").getBytes(), "utf-8"));

        ServletOutputStream out=response.getOutputStream();
        jixitruckOrderService.exportExcel(out,codes);

        return "redirect:/jixitruckOrder/list";
    }
}
