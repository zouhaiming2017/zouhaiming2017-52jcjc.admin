package com.jixi.mapper;

import com.jixi.pojo.Allorder;
import com.jixi.pojo.AllorderExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AllorderMapper {
    long countByExample(AllorderExample example);

    int deleteByExample(AllorderExample example);

    int deleteByPrimaryKey(String timeMonth);

    int insert(Allorder record);

    int insertSelective(Allorder record);

    List<Allorder> selectByExample(AllorderExample example);

    Allorder selectByPrimaryKey(String timeMonth);

    int updateByExampleSelective(@Param("record") Allorder record, @Param("example") AllorderExample example);

    int updateByExample(@Param("record") Allorder record, @Param("example") AllorderExample example);

    int updateByPrimaryKeySelective(Allorder record);

    int updateByPrimaryKey(Allorder record);
}