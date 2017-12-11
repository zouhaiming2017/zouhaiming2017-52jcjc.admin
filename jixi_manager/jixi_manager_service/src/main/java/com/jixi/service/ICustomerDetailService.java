package com.jixi.service;

import com.jixi.pojo.Customerdetail;
import com.jixi.pojo.CustomerdetailExample;

import java.io.OutputStream;
import java.text.ParseException;
import java.util.List;

/**
 * Created by zhm on 2017/11/9.
 */
public interface ICustomerDetailService {
    List<Customerdetail> selectByExample();

    Customerdetail selectByPrimaryKey(String customermonthcode);

    List<Customerdetail> updateCustomerDetailFromOrder(String year,String month) throws ParseException;

    void exportExcel(OutputStream outputStream, String[] customermonthcodes)throws Exception;

}
