package com.jixi.service.impl;

import com.jixi.mapper.TaxMapper;
import com.jixi.pojo.Tax;
import com.jixi.pojo.TaxExample;
import com.jixi.service.ITaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhm on 2017/11/13.
 */
@Service
public class TaxService implements ITaxService {

    @Autowired
    private TaxMapper taxMapper;

    /**
     * 查询所有
     * @return
     */
    @Override
    public List<Tax> getTaxList() {
        TaxExample example=new TaxExample();
        return taxMapper.selectByExample(example);
    }

    /**
     * 添加一个
     */
    @Override
    public void addTax(Tax tax) {
        taxMapper.insertSelective(tax);
    }


    /**
     * 更新一个
     */
    @Override
    public void updateTax(Tax tax) {
        taxMapper.updateByPrimaryKeySelective(tax);
    }


    /**
     * 查找一个
     * @return
     */
    @Override
    public Tax selectOne(String timeMonth) {
        return taxMapper.selectByPrimaryKey(timeMonth);
    }

    /**
     * 删除一个
     */
    @Override
    public void deleteOne(String timeMonth) {
        taxMapper.deleteByPrimaryKey(timeMonth);
    }

    /**
     * 删除多个
     */
    @Override
    public void deleteTax() {

    }
}
