package com.jixi.mapper;

import com.jixi.pojo.Sellman;
import com.jixi.pojo.SellmanExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SellmanMapper {
    long countByExample(SellmanExample example);

    int deleteByExample(SellmanExample example);

    int deleteByPrimaryKey(String sellmancode);

    int insert(Sellman record);

    int insertSelective(Sellman record);

    List<Sellman> selectByExample(SellmanExample example);

    List<Sellman> selectDistinctSellmanAddress();

    List<Sellman> selectDistinctLeader();

    List<Sellman> selectDistinctSellmanNature();

    List<Sellman> like(Map map);

    Sellman selectByPrimaryKey(String sellmancode);

    int updateByExampleSelective(@Param("record") Sellman record, @Param("example") SellmanExample example);

    int updateByExample(@Param("record") Sellman record, @Param("example") SellmanExample example);

    int updateByPrimaryKeySelective(Sellman record);

    int updateByPrimaryKey(Sellman record);
}