package com.jixi.mapper;

import com.jixi.pojo.JixitruckOrder;
import com.jixi.pojo.JixitruckOrderExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface JixitruckOrderMapper {
    long countByExample(JixitruckOrderExample example);

    int deleteByExample(JixitruckOrderExample example);

    int deleteByPrimaryKey(String sellordercode);

    int insert(JixitruckOrder record);

    int insertSelective(JixitruckOrder record);

    List<JixitruckOrder> selectByExample(JixitruckOrderExample example);

    List<JixitruckOrder> like(Map map);

    Double getFreightsByDate(Map map);

    JixitruckOrder selectByPrimaryKey(String sellordercode);

    int updateByExampleSelective(@Param("record") JixitruckOrder record, @Param("example") JixitruckOrderExample example);

    int updateByExample(@Param("record") JixitruckOrder record, @Param("example") JixitruckOrderExample example);

    int updateByPrimaryKeySelective(JixitruckOrder record);

    int updateByPrimaryKey(JixitruckOrder record);
}