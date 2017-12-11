package com.jixi.service;

import com.jixi.pojo.Tax;

import java.util.List;

/**
 * Created by zhm on 2017/11/13.
 */
public interface ITaxService {
    List<Tax> getTaxList();
    void addTax(Tax tax);
    void updateTax(Tax tax);
    Tax selectOne(String timeMonth);
    void deleteOne(String timeMonth);
    void deleteTax();
}
