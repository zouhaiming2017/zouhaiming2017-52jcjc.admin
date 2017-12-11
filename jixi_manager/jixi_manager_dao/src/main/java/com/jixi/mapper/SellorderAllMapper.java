package com.jixi.mapper;

import com.jixi.pojo.SellorderAll;
import com.jixi.pojo.SellorderAllExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SellorderAllMapper {
    long countByExample(SellorderAllExample example);

    int deleteByExample(SellorderAllExample example);

    int deleteByPrimaryKey(String timeMonth);

    int insert(SellorderAll record);

    int insertSelective(SellorderAll record);

    List<SellorderAll> selectByExample(SellorderAllExample example);

    SellorderAll selectByPrimaryKey(String timeMonth);

    int updateByExampleSelective(@Param("record") SellorderAll record, @Param("example") SellorderAllExample example);

    int updateByExample(@Param("record") SellorderAll record, @Param("example") SellorderAllExample example);

    int updateByPrimaryKeySelective(SellorderAll record);

    int updateByPrimaryKey(SellorderAll record);
}