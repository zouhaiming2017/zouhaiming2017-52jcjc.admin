package com.jixi.mapper;

import com.jixi.pojo.SellorderMaster;
import com.jixi.pojo.SellorderMasterExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SellorderMasterMapper {
    long countByExample(SellorderMasterExample example);

    int deleteByExample(SellorderMasterExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SellorderMaster record);

    int insertSelective(SellorderMaster record);

    List<SellorderMaster> selectByExample(SellorderMasterExample example);

    SellorderMaster selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SellorderMaster record, @Param("example") SellorderMasterExample example);

    int updateByExample(@Param("record") SellorderMaster record, @Param("example") SellorderMasterExample example);

    int updateByPrimaryKeySelective(SellorderMaster record);

    int updateByPrimaryKey(SellorderMaster record);
}