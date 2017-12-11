package com.jixi.mapper;

import com.jixi.pojo.Customer;
import com.jixi.pojo.CustomerExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CustomerMapper {
    long countByExample(CustomerExample example);

    int deleteByExample(CustomerExample example);

    int deleteByPrimaryKey(String customercode);

    int insert(Customer record);

    int insertSelective(Customer record);

    List<Customer> selectByExample(CustomerExample example);

    String selectTypeByCustomerCode(String customerCode);

    List<Customer> selectDistinctSellman();

    List<Customer> selectDistinctCustomerType();

    List<Customer> selectDistinctVip();

    List<Customer> like(Map map);

    Customer selectByPrimaryKey(String customercode);

    int updateByExampleSelective(@Param("record") Customer record, @Param("example") CustomerExample example);

    int updateByExample(@Param("record") Customer record, @Param("example") CustomerExample example);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);
}