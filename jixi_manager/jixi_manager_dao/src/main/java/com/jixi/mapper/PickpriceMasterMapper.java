package com.jixi.mapper;

import com.jixi.pojo.PickpriceMaster;
import com.jixi.pojo.PickpriceMasterExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface PickpriceMasterMapper {
    long countByExample(PickpriceMasterExample example);

    int deleteByExample(PickpriceMasterExample example);

    int deleteByPrimaryKey(String itemcode);

    int insert(PickpriceMaster record);

    int insertSelective(PickpriceMaster record);

    List<PickpriceMaster> selectByExample(PickpriceMasterExample example);

    List<PickpriceMaster> selectDistinctSupplier();

    PickpriceMaster selectByPrimaryKey(String itemcode);

    List<PickpriceMaster> like(Map map);

    int updateByExampleSelective(@Param("record") PickpriceMaster record, @Param("example") PickpriceMasterExample example);

    int updateByExample(@Param("record") PickpriceMaster record, @Param("example") PickpriceMasterExample example);

    int updateByPrimaryKeySelective(PickpriceMaster record);

    int updateByPrimaryKey(PickpriceMaster record);
}