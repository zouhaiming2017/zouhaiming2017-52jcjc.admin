package com.jixi.service;

import com.jixi.pojo.Allorder;

import java.io.OutputStream;
import java.text.ParseException;
import java.util.List;

/**
 * Created by zhm on 2017/11/13.
 */
public interface IAllorderService {
    List<Allorder> getAllorder() throws ParseException;

    void exportExcel(OutputStream outputStream, String[] timeMonthcodes)throws Exception;
}
