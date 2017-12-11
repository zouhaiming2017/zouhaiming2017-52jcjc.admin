package com.jixi.service;

import com.jixi.pojo.Customer;
import com.jixi.pojo.CustomerExample;

import java.io.OutputStream;
import java.util.List;
import java.util.Map;

/**
 * Created by zhm on 2017/8/29.
 */
public interface ICustomerService {
    List<Customer> getCustomerList();
    List<Customer> selectDistinctSellman();
    List<Customer> selectDistinctCustomerType();
    List<Customer> selectDistinctVip();
    List<Customer> like(Map map);
    Customer selectOne(String customercode);
    void createCustomer(Customer customer) throws Exception;
    void updateCustomer(Customer customer) throws Exception;
    void deleteCustomer(String[] customerCodes);
    void deleteOne(String customercode);
    void importBySellorderSum();
    long countByExample();
    String selectTypeByCustomerCode(String customerCode);
    void exportExcel(OutputStream outputStream, String[] customerCodes)throws Exception;

}
