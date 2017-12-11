package com.jixi.service;

import com.jixi.pojo.Item;


import java.io.OutputStream;
import java.util.List;
import java.util.Map;

/**
 * Created by zhm on 2017/8/21.
 */
public interface IItemService {
    Item getItemByItemCode(String itemCode);
    List<Item> getItemList();
    Item selectOne(String itemcode);
    List<Item> selectDistinctSupplier();
    List<Item> selectDistinctBrandName();
    List<Item> like(Map map);
    void createItem(Item item) throws Exception;
    void updateItem(Item item) throws Exception;
    void deleteItem(String[] itemCodes);
    void deleteOne(String itemcode);
    void exportExcel(OutputStream outputStream, String[] itemcodes)throws Exception;
    long countByExample();
}
