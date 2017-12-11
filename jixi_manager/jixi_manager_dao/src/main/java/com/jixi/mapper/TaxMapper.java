package com.jixi.mapper;

import com.jixi.pojo.Tax;
import com.jixi.pojo.TaxExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TaxMapper {
    long countByExample(TaxExample example);

    int deleteByExample(TaxExample example);

    int deleteByPrimaryKey(String timeMonth);

    int insert(Tax record);

    int insertSelective(Tax record);

    List<Tax> selectByExample(TaxExample example);

    Tax selectByPrimaryKey(String timeMonth);

    int updateByExampleSelective(@Param("record") Tax record, @Param("example") TaxExample example);

    int updateByExample(@Param("record") Tax record, @Param("example") TaxExample example);

    int updateByPrimaryKeySelective(Tax record);

    int updateByPrimaryKey(Tax record);
}