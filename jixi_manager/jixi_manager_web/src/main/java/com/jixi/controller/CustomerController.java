package com.jixi.controller;

import com.jixi.pojo.Customer;
import com.jixi.service.ICustomerService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhm on 2017/8/29.
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;


    /**
     * 客户信息列表及模糊查询
     */
    @RequestMapping("/list")
    public String like(Model model,String sellman,String customertype,String vip){
        Map<String,Object> map=new HashMap();

        //获得业务员
        if(sellman==null||sellman.equals("0")){
            sellman=null;
        }
        map.put("sellman",sellman);

        //获得客户类型
        if(customertype==null||customertype.equals("0")){
            customertype=null;
        }
        map.put("customertype",customertype);

        //获得客户vip等级
        if(vip==null||vip.equals("0")){
            vip=null;
        }
        map.put("vip",vip);


        List<Customer> customers=customerService.like(map);

        List<Customer> sellmans=customerService.selectDistinctSellman();
        List<Customer> customertypes=customerService.selectDistinctCustomerType();
        List<Customer> vips=customerService.selectDistinctVip();

        model.addAttribute("customers",customers);
        model.addAttribute("sellmans",sellmans);
        model.addAttribute("customertypes",customertypes);
        model.addAttribute("vips",vips);

        return "customer/list";
    }

    /**
     * 跳转新增页面
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String createItem() {
        return "customer/add";
    }

    /**
     * 提交新增客户信息
     * */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String createItem(Customer customer) throws Exception {
        customerService.createCustomer(customer);
        return "redirect:/customer/list";
    }

    /**
     * 跳转修改页面
     * */
    @RequestMapping(value = "/update",method = RequestMethod.GET)
    public String updateItem(Model model,String customercode){
        Customer customer=customerService.selectOne(customercode);
        model.addAttribute("customer",customer);

        return "customer/update";
    }

    /**
     * 修改客户信息
     * */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String updateItem(Customer customer) throws Exception {
        customerService.updateCustomer(customer);
        return "redirect:/customer/list";
    }


    /**
     * 批量删除客户信息
     * */
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public String deleteCustomer(String customercodes){
          String[] codes=customercodes.split(",");
          customerService.deleteCustomer(codes);
        return "redirect:/customer/list";
    }

    /**
     * 删除一个
     */
    @RequestMapping(value = "/deleteOne")
    public String deleteOne(String customercode){
        customerService.deleteOne(customercode);
        return "redirect:/customer/list";
    }


    /**
     * 从客户订单表查询数据并导入
     * @return
     */
    @RequestMapping(value = "/importBySellorder")
    public String importBySellorderMaster(){
        customerService.importBySellorderSum();
        return "redirect:/customer/list";
    }


    /**
     * 导出数据到excel
     * @return
     */
    @RequestMapping(value = "/exportExcel")
    public String exportExcel(HttpServletResponse response, String customercodes) throws Exception {
        String[] codes=customercodes.split(",");

        response.reset();
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename="+ new String(("customer"+".xlsx").getBytes(), "utf-8"));

        ServletOutputStream out=response.getOutputStream();
        customerService.exportExcel(out,codes);

        return "redirect:/customer/list";
    }

    /**
     * 根据客户编码分页查询订单
     * @param page
     * @param rows
     * @param customercode
     * @return
     */
//    @RequestMapping("/listByCustomercode")
//    @ResponseBody
//    public EasyUIDataGridResult getListByCustomercode(Integer page, Integer rows,@PathVariable String customercode) {
//        EasyUIDataGridResult result = customerService.getListByCustomercode(page,rows,"15156568155null");
//        return result;
//    }

}
