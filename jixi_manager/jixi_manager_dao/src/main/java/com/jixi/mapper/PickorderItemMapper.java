package com.jixi.mapper;

import com.jixi.pojo.PickorderItem;
import com.jixi.pojo.PickorderItemExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface PickorderItemMapper {
    long countByExample(PickorderItemExample example);

    int deleteByExample(PickorderItemExample example);

    int deleteByPrimaryKey(String id);

    int insert(PickorderItem record);

    int insertSelective(PickorderItem record);

    List<PickorderItem> selectByExample(PickorderItemExample example);

    List<PickorderItem> selectDistinctSupplier();

    List<PickorderItem> selectDistinctBrandName();

    List<PickorderItem> selectDistinctItemCode();

    List<PickorderItem> like(Map map);

    List<PickorderItem> selectByItemcode(String itemcode);

    PickorderItem selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PickorderItem record, @Param("example") PickorderItemExample example);

    int updateByExample(@Param("record") PickorderItem record, @Param("example") PickorderItemExample example);

    int updateByPrimaryKeySelective(PickorderItem record);

    int updateByPrimaryKey(PickorderItem record);
}