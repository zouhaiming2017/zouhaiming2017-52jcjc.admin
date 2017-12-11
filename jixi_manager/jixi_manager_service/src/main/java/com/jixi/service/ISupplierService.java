package com.jixi.service;

import com.jixi.pojo.Supplier;

import java.util.List;
import java.util.Map;

/**
 * Created by zhm on 2017/8/29.
 */
public interface ISupplierService {
    List<Supplier> getSupplierList();
    List<Supplier> selectDistinctAddress();
    List<Supplier> selectDistinctVip();
    List<Supplier> selectDistinctSupplierIndex();
    List<Supplier> like(Map map);
    void updateByMasterTab();
    Supplier selectOne(String suppliercode);
    void createSupplier(Supplier supplier) throws Exception;
    void updateSupplier(Supplier supplier) throws Exception;
    void deleteSupplier(String[] supplierCodes);
    void deleteOne(String suppliercode);
    long countByExample();
}
