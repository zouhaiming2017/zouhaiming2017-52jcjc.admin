package com.jixi.service.impl;

import com.jixi.mapper.SellorderSumMapper;
import com.jixi.service.IDataShowService;
import com.jixi.utils.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhm on 2017/11/9.
 */
@Service
public class DataShowService implements IDataShowService {

    @Autowired
    private SellorderSumMapper sellorderSumMapper;

    /**
     * 导出客户类型明细数据到excel
     * @param outputStream
     * @param customerTypes
     * @throws Exception
     */
    @Override
    public void exportExcel(OutputStream outputStream, String[] customerTypes,String[] counts,String[] sums) throws Exception {
        List<List<String>> stringList=new ArrayList<>();
        //创建表头内容
        List<String> headList = new ArrayList<>();
        headList.add("客户类型");
        headList.add("订单数量");
        headList.add("订单金额");

        //获得表尾数据
        List<String> tails=new ArrayList<>();


        for(int i=0;i<customerTypes.length;i++) {
            List<String> ss = new ArrayList<>();

            ss.add(customerTypes[i]);
            ss.add(counts[i]);
            ss.add(sums[i]);

            stringList.add(ss);
        }


        ExcelUtil.outputToExcel(stringList,headList,tails,"客户类型月度明细表",outputStream);
    }
}
