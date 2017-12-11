package com.jixi.service;

import com.jixi.pojo.Supplierdetail;

import java.io.OutputStream;
import java.text.ParseException;
import java.util.List;

/**
 * Created by zhm on 2017/11/10.
 */
public interface ISupplierDetailService {
    List<Supplierdetail> updateSupplierDetailFromOrder(String year, String month) throws ParseException;

    void exportExcel(OutputStream outputStream, String[] suppliermonthcodes)throws Exception;
}
