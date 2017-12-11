package com.jixi.service;

import com.jixi.pojo.Commission;

/**
 * Created by zhm on 2017/10/23.
 */
public interface ICommissionService {
    void updateCommission(Commission commission);
    Commission selectOne(int id);
}
