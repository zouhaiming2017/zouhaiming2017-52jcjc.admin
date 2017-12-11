package com.jixi.controller;

import com.jixi.service.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.ParseException;

/**
 * Created by zhm on 2017/9/22.
 */
@Controller
@RequestMapping("welcomePage")
public class WelcomeController {
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private IItemService itemService;
    @Autowired
    private IUserService userService;
    @Autowired
    private IPickOrderSumService pickOrderSumService;
    @Autowired
    private ISellmanService sellmanService;
    @Autowired
    private ISellorderSumService sellorderSumService;
    @Autowired
    private ISupplierService supplierService;

    @RequestMapping("/welcome")
    public String toWelcome(Model model) throws ParseException {
        //获得登录信息(ip、上次退出时间)
        Subject subject = SecurityUtils.getSubject() ;
        Session session=subject.getSession();
        //获得总数
        long customerNum=customerService.countByExample();
        long itemNum=itemService.countByExample();
        long managerNum=userService.countByExample();
        long pickOrderSumNum=pickOrderSumService.countByExample();
        long sellManNum=sellmanService.countByExample();
        long sellOrderSumNum=sellorderSumService.countByExample();
        long supplierNum=supplierService.countByExample();
        //查看今天的数量
        long sellOrderSumTodayNum=sellorderSumService.getTodayCount();
        long pickOrderSumTodayNum=pickOrderSumService.getTodayCount();
        //查看昨天的数量
        long sellOrderSumYesterdayNum=sellorderSumService.getYesterdayCount();
        long pickOrderSumYesterdayNum=pickOrderSumService.getYesterdayCount();
        //查看本周数量
        long sellOrderSumWeekNum=sellorderSumService.getWeekCount();
        long pickOrderSumWeekNum=pickOrderSumService.getWeekCount();
        //查看本月数量
        long sellOrderSumMonthNum=sellorderSumService.getMonthCount();
        long pickOrderSumMonthNum=pickOrderSumService.getMonthCount();

        model.addAttribute("ip",session.getHost());
        model.addAttribute("lastTimeOut",session.getStartTimestamp());

        model.addAttribute("customerNum",customerNum);
        model.addAttribute("itemNum",itemNum);
        model.addAttribute("managerNum",managerNum);
        model.addAttribute("pickOrderSumNum",pickOrderSumNum);
        model.addAttribute("sellManNum",sellManNum);
        model.addAttribute("sellOrderSumNum",sellOrderSumNum);
        model.addAttribute("supplierNum",supplierNum);
        model.addAttribute("sellOrderSumTodayNum",sellOrderSumTodayNum);
        model.addAttribute("pickOrderSumTodayNum",pickOrderSumTodayNum);
        model.addAttribute("sellOrderSumYesterdayNum",sellOrderSumYesterdayNum);
        model.addAttribute("pickOrderSumYesterdayNum",pickOrderSumYesterdayNum);
        model.addAttribute("sellOrderSumWeekNum",sellOrderSumWeekNum);
        model.addAttribute("pickOrderSumWeekNum",pickOrderSumWeekNum);
        model.addAttribute("sellOrderSumMonthNum",sellOrderSumMonthNum);
        model.addAttribute("pickOrderSumMonthNum",pickOrderSumMonthNum);

        return "welcomePage/welcome";
    }

}
