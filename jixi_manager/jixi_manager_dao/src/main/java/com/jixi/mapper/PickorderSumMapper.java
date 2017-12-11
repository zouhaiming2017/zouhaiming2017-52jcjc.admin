package com.jixi.mapper;

import com.jixi.pojo.PickorderSum;
import com.jixi.pojo.PickorderSumExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface PickorderSumMapper {
    long countByExample(PickorderSumExample example);

    long getDayCount(String pickdate);

    long getWheekCount();

    long getMonthCount();

    long getCount(Map map);

    Double getSums(Map map);

    Double selectJCCDSums(Map map);

    Double getFreights(Map map);

    int deleteByExample(PickorderSumExample example);

    int deleteByPrimaryKey(String pickordercode);

    int insert(PickorderSum record);

    int insertSelective(PickorderSum record);

    List<PickorderSum> selectByExample(PickorderSumExample example);

    List<PickorderSum> selectDetailBySupplier(Map map);

    List<PickorderSum> selectDistinctSupplier();

    List<PickorderSum> selectDistinctLinkman();

    List<PickorderSum> selectDistinctAddress();

    List<PickorderSum> like(Map map);

    //价格汇总
    Double getPsums(Map map);
    Double getPfreights(Map map);
    Double getPallSums(Map map);
    Double getPreceivedsums(Map map);
    Double getPnoreceivedsum(Map map);

    PickorderSum selectByPrimaryKey(String pickordercode);

    int updateByExampleSelective(@Param("record") PickorderSum record, @Param("example") PickorderSumExample example);

    int updateByExample(@Param("record") PickorderSum record, @Param("example") PickorderSumExample example);

    int updateByPrimaryKeySelective(PickorderSum record);

    int updateByPrimaryKey(PickorderSum record);
}