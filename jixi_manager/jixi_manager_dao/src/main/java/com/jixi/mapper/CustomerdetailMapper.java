package com.jixi.mapper;

import com.jixi.pojo.Customerdetail;
import com.jixi.pojo.CustomerdetailExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomerdetailMapper {
    long countByExample(CustomerdetailExample example);

    int deleteByExample(CustomerdetailExample example);

    int deleteByPrimaryKey(String customermonthcode);

    int insert(Customerdetail record);

    int insertSelective(Customerdetail record);

    List<Customerdetail> selectByExample(CustomerdetailExample example);

    Customerdetail selectByPrimaryKey(String customermonthcode);

    int updateByExampleSelective(@Param("record") Customerdetail record, @Param("example") CustomerdetailExample example);

    int updateByExample(@Param("record") Customerdetail record, @Param("example") CustomerdetailExample example);

    int updateByPrimaryKeySelective(Customerdetail record);

    int updateByPrimaryKey(Customerdetail record);
}