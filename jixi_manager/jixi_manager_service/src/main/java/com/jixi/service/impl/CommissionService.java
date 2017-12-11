package com.jixi.service.impl;

import com.jixi.mapper.CommissionMapper;
import com.jixi.pojo.Commission;
import com.jixi.service.ICommissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhm on 2017/10/23.
 */
@Service
public class CommissionService implements ICommissionService {

    @Autowired
    private CommissionMapper commissionMapper;

    /**
     * 更新业务员提成（永远只有一条信息）
     */
    @Override
    public void updateCommission(Commission commission) {
        commissionMapper.updateByPrimaryKeySelective(commission);
    }

    /**
     * 查询一条提成信息
     * @param id
     * @return
     */
    @Override
    public Commission selectOne(int id) {
        return commissionMapper.selectByPrimaryKey(id);
    }
}
