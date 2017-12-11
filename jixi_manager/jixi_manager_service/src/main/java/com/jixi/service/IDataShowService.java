package com.jixi.service;

import java.io.OutputStream;

/**
 * Created by zhm on 2017/11/9.
 */
public interface IDataShowService {
    void exportExcel(OutputStream outputStream, String[] customerTypes,String[] counts,String[] sums)throws Exception;
}
