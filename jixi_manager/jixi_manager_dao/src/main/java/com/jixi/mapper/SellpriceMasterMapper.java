package com.jixi.mapper;

import com.jixi.pojo.SellpriceMaster;
import com.jixi.pojo.SellpriceMasterExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SellpriceMasterMapper {
    long countByExample(SellpriceMasterExample example);

    int deleteByExample(SellpriceMasterExample example);

    int deleteByPrimaryKey(String itemcode);

    int insert(SellpriceMaster record);

    int insertSelective(SellpriceMaster record);

    List<SellpriceMaster> selectByExample(SellpriceMasterExample example);

    List<SellpriceMaster> selectDistinctSupplierCode();

    List<SellpriceMaster> like(Map map);

    SellpriceMaster selectByPrimaryKey(String itemcode);

    int updateByExampleSelective(@Param("record") SellpriceMaster record, @Param("example") SellpriceMasterExample example);

    int updateByExample(@Param("record") SellpriceMaster record, @Param("example") SellpriceMasterExample example);

    int updateByPrimaryKeySelective(SellpriceMaster record);

    int updateByPrimaryKey(SellpriceMaster record);
}