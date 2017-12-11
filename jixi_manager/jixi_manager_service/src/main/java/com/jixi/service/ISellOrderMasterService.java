package com.jixi.service;


import com.jixi.pojo.SellorderMaster;
import java.io.OutputStream;
import java.text.ParseException;
import java.util.List;

/**
 * Created by zhm on 2017/8/24.
 */
public interface ISellOrderMasterService {
    List<SellorderMaster> getSellOrderMasterList();
    SellorderMaster selectOne(Integer id);
    void saveBath(List<String[]> list) throws ParseException;
    void exportExcel(OutputStream outputStream) throws Exception;
    void createSellorderMaster(SellorderMaster sellorderMaster) throws Exception;
    void updateSellorderMaster(SellorderMaster sellorderMaster);
    void deleteSellorderMaster(String[] ids);
    void deleteOne(Integer id);
    void getAllSum();
    long countByExample();
}
