package com.jixi.service;

import com.jixi.pojo.SellorderJc;
import org.springframework.web.multipart.MultipartFile;

import java.io.OutputStream;
import java.util.List;
import java.util.Map;

/**
 * Created by zhm on 2017/11/20.
 */
public interface ISellorderJcService {
    List<SellorderJc> getSellorderJcList();

    void addSellorderJc(SellorderJc sellorderJc);

    SellorderJc selectOne(String sellordercode);

    void updateSellorderJc(SellorderJc sellorderJc);

    void delectOne(String sellordercode);

    void deleteSellorderJc(String[] sellordercode);

    void saveBath(MultipartFile myFile, String path) throws Exception;

    void exportExcel(OutputStream outputStream, String[] sellordercodes)throws Exception;

    List <SellorderJc> selectDistinctProjectname();

    List <SellorderJc> selectDistinctCompany();

    List <SellorderJc> selectDistinctAddress();

    List<SellorderJc> selectDistinctCustomerName();

    List<SellorderJc> selectDistinctSellman();

    List<SellorderJc> selectDistinctCustomerType();

    List<SellorderJc> selectDistinctCustomerPhone();

    List<SellorderJc> like(Map map);

    Map<String,Double> countSums(List<SellorderJc> list);
}
