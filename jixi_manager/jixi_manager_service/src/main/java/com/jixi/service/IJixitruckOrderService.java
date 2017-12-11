package com.jixi.service;

import com.jixi.pojo.JixitruckOrder;

import java.io.OutputStream;
import java.util.List;
import java.util.Map;

/**
 * Created by zhm on 2017/11/29.
 */
public interface IJixitruckOrderService {
    List<JixitruckOrder> getJixitruckOrders();

    List<JixitruckOrder> like(Map map);

    Double getFreightsByDate(Map map);

    JixitruckOrder selectOne(String sellordercode);

    void createJixitruckOrder(JixitruckOrder jixitruckOrder) throws Exception;

    void updateJixitruckOrder(JixitruckOrder jixitruckOrder) throws Exception;

    void deleteJixitruckOrder(String[] sellordercodes);

    void deleteOne(String sellordercode);

    void exportExcel(OutputStream outputStream, String[] sellordercodes)throws Exception;

}
