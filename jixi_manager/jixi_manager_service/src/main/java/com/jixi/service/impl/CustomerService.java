package com.jixi.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jixi.mapper.CustomerMapper;
import com.jixi.mapper.SellorderMasterMapper;
import com.jixi.mapper.SellorderSumMapper;
import com.jixi.pojo.*;
import com.jixi.service.ICustomerService;

import com.jixi.utils.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by zhm on 2017/8/29.
 */
@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private SellorderSumMapper sellorderSumMapper;


    /**
     * customercode
     *
     * @param customercode
     * @return
     */
    public boolean isExist(String customercode) {
        try {
            Customer customer=customerMapper.selectByPrimaryKey(customercode);
            if (customer== null){
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }


    /**
     * customercode
     * */
    public boolean isNull(String customercode){
        if(customercode==null||"".equals(customercode)){
            return false;
        }
        return true;
    }


    /**
     * 客户列表查询
     * @return
     */
    @Override
    public List<Customer> getCustomerList() {
        //执行查询
        CustomerExample example = new CustomerExample();
        List<Customer> list = customerMapper.selectByExample(example);

        return list;
    }

    /**
     * 去重复查询业务员
     * @return
     */
    @Override
    public List<Customer> selectDistinctSellman() {
        return customerMapper.selectDistinctSellman();
    }

    /**
     * 去重复查询客户类型
     * @return
     */
    @Override
    public List<Customer> selectDistinctCustomerType() {
        return customerMapper.selectDistinctCustomerType();
    }

    /**
     * 去重复查询客户vip等级
     * @return
     */
    @Override
    public List<Customer> selectDistinctVip() {
        return customerMapper.selectDistinctVip();
    }

    /**
     *模糊查询
     * @return
     */
    @Override
    public List<Customer> like(Map map) {
        return customerMapper.like(map);
    }

    /**
     * 查找一个
     * @param customercode
     * @return
     */
    @Override
    public Customer selectOne(String customercode) {
        return customerMapper.selectByPrimaryKey(customercode);
    }

    /**
     * 新增客户
     * */
    @Override
    public void createCustomer(Customer customer) throws Exception {
        customerMapper.insertSelective(customer);

    }

    /**
     * 修改客户信息
     * */
    @Override
    public void updateCustomer(Customer customer) throws Exception {
        customerMapper.updateByPrimaryKeySelective(customer);
    }

    /**
     * 批量删除客户
     * */
    @Override
    public void deleteCustomer(String[] customerCodes) {
        for (int i=0;i<customerCodes.length;i++){
            customerMapper.deleteByPrimaryKey(customerCodes[i]);
        }
    }

    /**
     * 删除一个
     * @param customercode
     */
    @Override
    public void deleteOne(String customercode) {
        customerMapper.deleteByPrimaryKey(customercode);

    }

    /**
     * 从客户订单表查询数据并导入
     * @return
     */
    @Override
    public void importBySellorderSum(){
        Customer customer=new Customer();
        //查询客户订单表所有数据
        SellorderSumExample example=new SellorderSumExample();
        List<SellorderSum> list=sellorderSumMapper.selectByExample(example);

        for(SellorderSum sellorderSum:list) {
            String customercode = sellorderSum.getCustomerphone();
            if (isNull(customercode)) {
                customer.setCustomercode(customercode);
                customer.setCustomername(sellorderSum.getCustomername());
                customer.setCompany(sellorderSum.getCompany());
                customer.setSellman(sellorderSum.getSellman());
                if (!isExist(customercode)) {
                    //不存在就添加
                    customerMapper.insertSelective(customer);
                } else {
                    //存在就跳过
                    continue;
                }
            }
        }
    }

    /**
     * 统计总数
     * @return
     */
    @Override
    public long countByExample() {
        CustomerExample example = new CustomerExample();
        return customerMapper.countByExample(example);
    }

    /**
     * 根据公司名获得客户类型
     * @param customerCode
     * @return
     */
    @Override
    public String selectTypeByCustomerCode(String customerCode){
        return customerMapper.selectTypeByCustomerCode(customerCode);
    }

    /**
     * 导出到excel
     * @param outputStream
     * @param customerCodes
     * @throws Exception
     */
    @Override
    public void exportExcel(OutputStream outputStream, String[] customerCodes) throws Exception {
        List<List<String>> stringList=new ArrayList<>();
        //创建表头内容
        List<String> headList = new ArrayList<>();
        headList.add("手机号");
        headList.add("姓名");
        headList.add("所在公司");
        headList.add("客户类型");
        headList.add("业务员");
        headList.add("Vip等级");
        headList.add("其它1");
        headList.add("其它2");
        headList.add("其它3");
        headList.add("其它4");
        //获得表尾数据
        List<String> tails=new ArrayList<>();

        for(int i=0;i<customerCodes.length;i++) {
            List<String> ss = new ArrayList<>();
            Customer customer=customerMapper.selectByPrimaryKey(customerCodes[i]);

            ss.add(customer.getCustomercode());
            ss.add(customer.getCustomername());
            ss.add(customer.getCompany());
            ss.add(customer.getCustomertype());
            ss.add(customer.getSellman());
            ss.add(customer.getVip());
            ss.add("");
            ss.add("");
            ss.add("");
            ss.add("");

            stringList.add(ss);
        }
        tails.add("");
        tails.add("");
        tails.add("");
        tails.add("");
        tails.add("");
        tails.add("");
        tails.add("");

        ExcelUtil.outputToExcel(stringList,headList,tails,"客户表",outputStream);
    }

}
