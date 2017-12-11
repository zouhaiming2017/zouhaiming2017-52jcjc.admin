package com.jixi.service;

import com.jixi.pojo.PickpriceMaster;

import java.io.OutputStream;
import java.util.List;
import java.util.Map;

/**
 * Created by zhm on 2017/8/23.
 */
public interface IPickPriceMasterService {
       List<PickpriceMaster> getPickPriceMasterList();
       void saveBath(List<String[]> list);
       void exportExcel(OutputStream outputStream) throws Exception;
       void createPickpriceMaster(PickpriceMaster pickpriceMaster) throws Exception;
       void updatePickpriceMaster(PickpriceMaster pickpriceMaster);
       PickpriceMaster selectOne(String itemCode);
       void deletePickpriceMaster(String[] itemCodes);
       void deleteOne(String itemCode);
       List<PickpriceMaster> like(Map map);
       List<PickpriceMaster> selectDistinctSupplier();
       long countByExample();
}
