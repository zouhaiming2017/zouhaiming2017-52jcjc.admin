package com.jixi.service;

import com.jixi.pojo.Sellmandetail;

import java.io.OutputStream;
import java.text.ParseException;
import java.util.List;

/**
 * Created by zhm on 2017/11/10.
 */
public interface ISellmanDetailService {
    List<Sellmandetail> updateSellmanDetailFromOrder(String year, String month) throws ParseException;

    void exportExcel(OutputStream outputStream, String[] sellmanmonthcodes)throws Exception;
}
