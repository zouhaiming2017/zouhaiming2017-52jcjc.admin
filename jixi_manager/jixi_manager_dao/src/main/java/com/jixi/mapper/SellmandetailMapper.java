package com.jixi.mapper;

import com.jixi.pojo.Sellmandetail;
import com.jixi.pojo.SellmandetailExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SellmandetailMapper {
    long countByExample(SellmandetailExample example);

    int deleteByExample(SellmandetailExample example);

    int deleteByPrimaryKey(String sellmanmonthcode);

    int insert(Sellmandetail record);

    int insertSelective(Sellmandetail record);

    List<Sellmandetail> selectByExample(SellmandetailExample example);

    Sellmandetail selectByPrimaryKey(String sellmanmonthcode);

    int updateByExampleSelective(@Param("record") Sellmandetail record, @Param("example") SellmandetailExample example);

    int updateByExample(@Param("record") Sellmandetail record, @Param("example") SellmandetailExample example);

    int updateByPrimaryKeySelective(Sellmandetail record);

    int updateByPrimaryKey(Sellmandetail record);
}