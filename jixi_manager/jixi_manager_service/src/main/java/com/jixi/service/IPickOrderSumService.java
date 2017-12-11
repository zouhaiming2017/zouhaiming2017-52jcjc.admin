package com.jixi.service;

import com.jixi.pojo.PickorderSum;
import org.springframework.web.multipart.MultipartFile;

import java.io.OutputStream;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

/**
 * Created by zhm on 2017/9/13.
 */
public interface IPickOrderSumService {
    List<PickorderSum> getPickorderSumList();

    List<PickorderSum> selectDistinctSupplier();

    List<PickorderSum> selectDistinctLinkman();

    List<PickorderSum> selectDistinctAddress();

    List<PickorderSum> like(Map map);

    PickorderSum selectOne(String pickordercode);

    void createPickorderSum(PickorderSum pickorderSum) throws Exception;

    void updatePickorderSum(PickorderSum pickorderSum) throws Exception;

    void deletePickorderSum(String[] pickordercodes);

    void deleteOne(String pickordercode);

    void saveBath(MultipartFile myFile,String path) throws Exception;

    void exportExcel(OutputStream outputStream, String[] pickordercodes)throws Exception;

    void exportExcelAsFinance(OutputStream outputStream,String[] pickordercodes,String sheetName)throws Exception;

    long countByExample();

    long getTodayCount() throws ParseException;

    long getYesterdayCount();

    long getWeekCount();

    long getMonthCount();

    long getCount(Map map);

    Double getSums(Map map);

    //价格汇总
    Double getPsums(Map map);
    Double getPfreights(Map map);
    Double getPallSums(Map map);
    Double getPreceivedsums(Map map);
    Double getPnoreceivedsum(Map map);
}


