package com.jixi.service;

import com.jixi.pojo.PickorderMaster;
import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.util.List;

/**
 * Created by zhm on 2017/8/23.
 */
public interface IPickOrderMasterService {
    List<PickorderMaster> getPickOrderMasterList();
    PickorderMaster selectOne(Integer id);
    void saveBathBath(List<String[]> list) throws ParseException;
    void exportExcel(OutputStream outputStream) throws Exception;
    void createPickorderMaster(PickorderMaster pickorderMaster) throws Exception;
    void updatePickorderMaster(PickorderMaster pickorderMaster);
    void deletePickorderMaster(String[] ids);
    void deleteOne(Integer id);
    void addInpriceFromPickPriceMaster();
    void getAllSum();
    long countByExample();
    
}
