package com.jixi.service;

import com.jixi.pojo.SellorderSum;
import com.jixi.utils.ComplexExcelUtil;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by zhm on 2017/9/5.
 */
public interface ISellorderSumService {
    List<SellorderSum> getSellorderSumList();

    List<SellorderSum> selectBySellman(String sellman);

    List<SellorderSum> like(Map map);

    SellorderSum selectOne(String sellordercode);

    void createSellorderSum(SellorderSum sellorderSum) throws Exception;

    void updateSellorderSum(SellorderSum sellorderSum) throws Exception;

    void deleteSellorderSum(String[] sellordercode);

    void deleteOne(String sellordercode);

    void saveBath(MultipartFile myFile,String path) throws Exception;

    void exportExcel(OutputStream outputStream,String[] sellordercodes)throws Exception;

    void exportExcelAsSellman(OutputStream outputStream,String[] sellordercodes,String sheetName)throws Exception;

    void exportExcelAsFinance(OutputStream outputStream,String[] sellordercodes,String sheetName)throws Exception;

    List <SellorderSum> selectDistinctProjectname();

    List<SellorderSum> selectDistinctProjectnameBySellman(String sellman);

    List<SellorderSum> selectDistinctCustomerTypeBySellman(String sellman);

    List <SellorderSum> selectDistinctCompany();

    List <SellorderSum> selectDistinctAddress();

    List<SellorderSum> selectDistinctCustomerName();

    List<SellorderSum> selectDistinctSellman();

    List<SellorderSum> selectDistinctCustomerType();

    List<SellorderSum> selectDistinctCustomerPhone();

    long countByExample();

    long getTodayCount() throws ParseException;

    long getYesterdayCount();

    long getWeekCount();

    long getMonthCount();

    long getCount(Map map);

    Long getCountByCustomerType(Map map);

    Double getSumByCustomerType(Map map);

    Double getSums(Map map);

    Double getSumsBySellman(Map map);
    //根据时间价格汇总
    Double getOnlineSums(Map map);
    Double getUnderlineSums(Map map);
    Double getDiscountPrices(Map map);
    Double getTfreights(Map map);
    Double getCommissions(Map map);
    Double getReceivedSums(Map map);
    Double getNoReceivedSums(Map map);

}


