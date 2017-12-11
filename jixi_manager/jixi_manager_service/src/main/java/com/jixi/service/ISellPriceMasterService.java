package com.jixi.service;

import com.jixi.pojo.SellpriceMaster;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

/**
 * Created by zhm on 2017/8/24.
 */
public interface ISellPriceMasterService {
    List<SellpriceMaster> getSellPriceMasterList();
    List<SellpriceMaster> selectDistinctSupplierCode();
    SellpriceMaster selectOne(String itemcode);
    List<SellpriceMaster> like(Map map);
    void saveBath(List<String[]> list);
    void exportExcel(OutputStream outputStream) throws Exception;
    void createSellpriceMaster(SellpriceMaster sellpriceMaster) throws Exception;
    void updateSellpriceMaster(SellpriceMaster sellpriceMaster);
    void deleteSellpriceMaster(String[] itemCodes);
    void deleteOne(String itemcode);
    long countByExample();
}
