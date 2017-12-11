package com.jixi.mapper;

import com.jixi.pojo.Commission;
import com.jixi.pojo.CommissionExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommissionMapper {
    long countByExample(CommissionExample example);

    int deleteByExample(CommissionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Commission record);

    int insertSelective(Commission record);

    List<Commission> selectByExample(CommissionExample example);

    Commission selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Commission record, @Param("example") CommissionExample example);

    int updateByExample(@Param("record") Commission record, @Param("example") CommissionExample example);

    int updateByPrimaryKeySelective(Commission record);

    int updateByPrimaryKey(Commission record);
}