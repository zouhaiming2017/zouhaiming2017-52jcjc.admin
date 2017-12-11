package com.jixi.mapper;

import com.jixi.pojo.Supplierdetail;
import com.jixi.pojo.SupplierdetailExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SupplierdetailMapper {
    long countByExample(SupplierdetailExample example);

    int deleteByExample(SupplierdetailExample example);

    int deleteByPrimaryKey(String suppliermonthcode);

    int insert(Supplierdetail record);

    int insertSelective(Supplierdetail record);

    List<Supplierdetail> selectByExample(SupplierdetailExample example);

    Supplierdetail selectByPrimaryKey(String suppliermonthcode);

    int updateByExampleSelective(@Param("record") Supplierdetail record, @Param("example") SupplierdetailExample example);

    int updateByExample(@Param("record") Supplierdetail record, @Param("example") SupplierdetailExample example);

    int updateByPrimaryKeySelective(Supplierdetail record);

    int updateByPrimaryKey(Supplierdetail record);
}