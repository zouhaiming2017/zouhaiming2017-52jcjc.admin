package com.jixi.service;

import com.jixi.pojo.SellorderAll;

import java.io.OutputStream;
import java.text.ParseException;
import java.util.List;

/**
 * Created by zhm on 2017/11/13.
 */
public interface ISellorderAllService {
    List<SellorderAll> getSellorderAll() throws ParseException;
    void exportExcel(OutputStream outputStream, String[] timeMonthcodes)throws Exception;
}
