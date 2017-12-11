package com.jixi.mapper;

import com.jixi.pojo.SellorderJc;
import com.jixi.pojo.SellorderJcExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SellorderJcMapper {
    long countByExample(SellorderJcExample example);

    int deleteByExample(SellorderJcExample example);

    int deleteByPrimaryKey(String sellordercode);

    int insert(SellorderJc record);

    int insertSelective(SellorderJc record);

    List<SellorderJc> selectByExample(SellorderJcExample example);

    List<SellorderJc> selectDistinctProjectname();

    List<SellorderJc> selectDistinctCustomerType();

    List<SellorderJc> selectDistinctCompany();

    List<SellorderJc> selectDistinctAddress();

    List<SellorderJc> selectDistinctSellman();

    List<SellorderJc> selectDistinctCustomerName();

    List<SellorderJc> selectDistinctCustomerPhone();

    List<SellorderJc> like(Map map);

    SellorderJc selectByPrimaryKey(String sellordercode);

    int updateByExampleSelective(@Param("record") SellorderJc record, @Param("example") SellorderJcExample example);

    int updateByExample(@Param("record") SellorderJc record, @Param("example") SellorderJcExample example);

    int updateByPrimaryKeySelective(SellorderJc record);

    int updateByPrimaryKey(SellorderJc record);
}