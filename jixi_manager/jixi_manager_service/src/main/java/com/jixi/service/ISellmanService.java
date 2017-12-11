package com.jixi.service;

import com.jixi.pojo.Sellman;

import java.util.List;
import java.util.Map;

/**
 * Created by zhm on 2017/8/29.
 */
public interface ISellmanService {
    List<Sellman> getSellmanList();
    List<Sellman> selectDistinctSellmanAddress();
    List<Sellman> selectDistinctLeader();
    List<Sellman> selectDistinctSellmanNature();
    Sellman selectOne(String sellmancode);
    List<Sellman> like(Map map);
    void createSellman(Sellman sellman) throws Exception;
    void updateSellman(Sellman sellman) throws Exception;
    void deleteSellman(String[] sellmanCodes);
    void deleteOne(String sellmancode);
    long countByExample();
}
