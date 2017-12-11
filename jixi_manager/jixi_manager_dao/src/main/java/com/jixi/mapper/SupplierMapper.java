package com.jixi.mapper;

import com.jixi.pojo.Supplier;
import com.jixi.pojo.SupplierExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SupplierMapper {
    long countByExample(SupplierExample example);

    int deleteByExample(SupplierExample example);

    int deleteByPrimaryKey(String suppliercode);

    int insert(Supplier record);

    int insertSelective(Supplier record);

    List<Supplier> selectByExample(SupplierExample example);

    List<Supplier> selectDistinctAddress();

    List<Supplier> selectDistinctVip();

    List<Supplier> selectDistinctSupplierIndex();

    List<Supplier> like(Map map);

    Supplier selectByPrimaryKey(String suppliercode);

    int updateByExampleSelective(@Param("record") Supplier record, @Param("example") SupplierExample example);

    int updateByExample(@Param("record") Supplier record, @Param("example") SupplierExample example);

    int updateByPrimaryKeySelective(Supplier record);

    int updateByPrimaryKey(Supplier record);
}