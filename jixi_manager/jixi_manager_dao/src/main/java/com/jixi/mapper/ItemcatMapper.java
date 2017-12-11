package com.jixi.mapper;

import com.jixi.pojo.Itemcat;
import com.jixi.pojo.ItemcatExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ItemcatMapper {
    long countByExample(ItemcatExample example);

    int deleteByExample(ItemcatExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Itemcat record);

    int insertSelective(Itemcat record);

    List<Itemcat> selectByExample(ItemcatExample example);

    Itemcat selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Itemcat record, @Param("example") ItemcatExample example);

    int updateByExample(@Param("record") Itemcat record, @Param("example") ItemcatExample example);

    int updateByPrimaryKeySelective(Itemcat record);

    int updateByPrimaryKey(Itemcat record);
}