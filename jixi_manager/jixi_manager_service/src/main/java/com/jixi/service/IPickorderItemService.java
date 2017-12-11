package com.jixi.service;

import com.jixi.pojo.PickorderItem;
import org.springframework.web.multipart.MultipartFile;

import java.io.OutputStream;
import java.util.List;
import java.util.Map;

/**
 * Created by zhm on 2017/11/22.
 */
public interface IPickorderItemService {
    void saveBath(MultipartFile myFile, String path) throws Exception;
    List<PickorderItem> getPickorderItrems();
    void deleteOne(String id);
    void deletePickorderItem(String[] ids);
    void add(PickorderItem pickorderItem);
    void update(PickorderItem pickorderItem);
    PickorderItem selectOne(String id);
    List<PickorderItem> selectDistinctSupplier();
    List<PickorderItem> selectDistinctBrandName();
    List<PickorderItem> selectDistinctItemCode();
    List<PickorderItem> like(Map map);
    void exportExcel(OutputStream outputStream, String[] ids)throws Exception;
    void exportRankExcel(OutputStream outputStream, String[] itemcodes)throws Exception;
}
