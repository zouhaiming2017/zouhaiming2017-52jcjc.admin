package com.jixi.mapper;

import com.jixi.pojo.SellorderSum;
import com.jixi.pojo.SellorderSumExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SellorderSumMapper {
    long countByExample(SellorderSumExample example);

    long getDayCount(String selldate);

    long getWheekCount();

    long getMonthCount();

    long getCount(Map map);
    //根据时间进行价格汇总
    Double getOnlineSums(Map map);
    Double getUnderlineSums(Map map);
    Double getDiscountPrices(Map map);
    Double getTfreights(Map map);
    Double getCommissions(Map map);
    Double getReceivedSums(Map map);
    Double getNoReceivedSums(Map map);

    Long getCountByCustomerType(Map map);

    Integer getCustomerCounts(Map map);

    Double getSumByCustomerType(Map map);

    Double getSums(Map map);

    Double getFreights(Map map);

    Double getSumsBySellman(Map map);

    int deleteByExample(SellorderSumExample example);

    int deleteByPrimaryKey(String sellordercode);

    int insert(SellorderSum record);

    int insertSelective(SellorderSum record);

    List<SellorderSum> selectByExample(SellorderSumExample example);

    List<SellorderSum> selectBySellman(String sellman);

    List<SellorderSum> selectDistinctProjectname();

    List<SellorderSum> selectDistinctCustomerType();

    List<SellorderSum> selectDistinctProjectnameBySellman(String sellman);

    List<SellorderSum> selectDistinctCustomerTypeBySellman(String sellman);

    List<SellorderSum> selectDistinctCompany();

    List<SellorderSum> selectDistinctAddress();

    List<SellorderSum> selectDistinctSellman();

    List<SellorderSum> selectDistinctCustomerName();

    List<SellorderSum> selectDistinctCustomerPhone();

    List<SellorderSum> selectByCustomerName(Map map);

    List<SellorderSum> selectByCustomerPhone(Map map);

    List<SellorderSum> selectDetailBysellman(Map map);

    List<SellorderSum> like(Map map);

    SellorderSum selectByPrimaryKey(String sellordercode);

    int updateByExampleSelective(@Param("record") SellorderSum record, @Param("example") SellorderSumExample example);

    int updateByExample(@Param("record") SellorderSum record, @Param("example") SellorderSumExample example);

    int updateByPrimaryKeySelective(SellorderSum record);

    int updateByPrimaryKey(SellorderSum record);
}