package com.jixi.mapper;

import com.jixi.pojo.PickorderMaster;
import com.jixi.pojo.PickorderMasterExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PickorderMasterMapper {
    long countByExample(PickorderMasterExample example);

    int deleteByExample(PickorderMasterExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PickorderMaster record);

    int insertSelective(PickorderMaster record);

    List<PickorderMaster> selectByExample(PickorderMasterExample example);

    PickorderMaster selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PickorderMaster record, @Param("example") PickorderMasterExample example);

    int updateByExample(@Param("record") PickorderMaster record, @Param("example") PickorderMasterExample example);

    int updateByPrimaryKeySelective(PickorderMaster record);

    int updateByPrimaryKey(PickorderMaster record);
}