package com.jixi.service.impl;

import com.jixi.mapper.SellmanMapper;
import com.jixi.pojo.Sellman;
import com.jixi.pojo.SellmanExample;
import com.jixi.service.ISellmanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by zhm on 2017/8/29.
 */
@Service
public class SellmanService implements ISellmanService {

    @Autowired
    private SellmanMapper sellmanMapper;


    /**
     * 业务员列表查询
     * @return
     */
    @Override
    public List<Sellman> getSellmanList() {
        //执行查询
        SellmanExample example = new SellmanExample();
        List<Sellman> list = sellmanMapper.selectByExample(example);


        return list;
    }

    /**
     * 去重复查询业务员所属区域
     * @return
     */
    @Override
    public List<Sellman> selectDistinctSellmanAddress() {
        return sellmanMapper.selectDistinctSellmanAddress();
    }

    /**
     * 去重复查询业务员上级领导
     */
    @Override
    public List<Sellman> selectDistinctLeader() {
        return sellmanMapper.selectDistinctLeader();
    }

    /**
     * 去重复查询业务员性质
     * @return
     */
    @Override
    public List<Sellman> selectDistinctSellmanNature() {
        return sellmanMapper.selectDistinctSellmanNature();
    }

    /**
     * 查询一个
     * @param sellmancode
     * @return
     */
    @Override
    public Sellman selectOne(String sellmancode) {
        return sellmanMapper.selectByPrimaryKey(sellmancode);
    }

    /**
     * 模糊查询
     * @param map
     * @return
     */
    @Override
    public List<Sellman> like(Map map) {
        return sellmanMapper.like(map);
    }


    /**
     * 新增业务员
     * */
    @Override
    public void createSellman(Sellman sellman) throws Exception {
        sellmanMapper.insertSelective(sellman);
    }

    /**
     * 修改业务员信息
     * */
    @Override
    public void updateSellman(Sellman sellman) throws Exception {
        sellmanMapper.updateByPrimaryKeySelective(sellman);
    }


    /**
     * 批量删除业务员信息
     * */
    @Override
    public void deleteSellman(String[] sellmanCodes) {
        for (int i=0;i<sellmanCodes.length;i++){
            sellmanMapper.deleteByPrimaryKey(sellmanCodes[i]);
        }
    }

    /**
     * 删除一个
     * @param sellmancode
     */
    @Override
    public void deleteOne(String sellmancode) {
        sellmanMapper.deleteByPrimaryKey(sellmancode);
    }

    /**
     * 统计总数
     * @return
     */
    @Override
    public long countByExample() {
        SellmanExample example = new SellmanExample();
        return sellmanMapper.countByExample(example);
    }
}
