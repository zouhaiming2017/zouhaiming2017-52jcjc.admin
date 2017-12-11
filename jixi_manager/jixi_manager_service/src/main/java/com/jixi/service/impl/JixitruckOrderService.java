package com.jixi.service.impl;

import com.jixi.mapper.JixitruckOrderMapper;
import com.jixi.pojo.JixitruckOrder;
import com.jixi.pojo.JixitruckOrderExample;
import com.jixi.service.IJixitruckOrderService;
import com.jixi.utils.DoubleFormatUtil;
import com.jixi.utils.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by zhm on 2017/11/29.
 */
@Service
public class JixitruckOrderService implements IJixitruckOrderService {
    @Autowired
    private JixitruckOrderMapper jixitruckOrderMapper;

    /**
     * 获得列表
     * @return
     */
    @Override
    public List<JixitruckOrder> getJixitruckOrders() {
        JixitruckOrderExample example=new JixitruckOrderExample();
        return jixitruckOrderMapper.selectByExample(example);
    }

    /**
     * 模糊查询
     * @param map
     * @return
     */
    @Override
    public List<JixitruckOrder> like(Map map) {
        return jixitruckOrderMapper.like(map);
    }

    /**
     * 根据时间查运费合计
     * @param map
     * @return
     */
    @Override
    public Double getFreightsByDate(Map map) {
        return jixitruckOrderMapper.getFreightsByDate(map);
    }

    /**
     * 查询一个
     * @param sellordercode
     * @return
     */
    @Override
    public JixitruckOrder selectOne(String sellordercode) {
        return jixitruckOrderMapper.selectByPrimaryKey(sellordercode);
    }

    /**
     * 新增
     * @param jixitruckOrder
     * @throws Exception
     */
    @Override
    public void createJixitruckOrder(JixitruckOrder jixitruckOrder) throws Exception {
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat format1=new SimpleDateFormat("yyyyMMdd");
        Date senddate=format1.parse(jixitruckOrder.getSellordercode().substring(0,8));
        jixitruckOrder.setSenddate(format.parse(format.format(senddate)));
        jixitruckOrderMapper.insertSelective(jixitruckOrder);
    }

    /**
     * 更新
     * @param jixitruckOrder
     * @throws Exception
     */
    @Override
    public void updateJixitruckOrder(JixitruckOrder jixitruckOrder) throws Exception {
        jixitruckOrderMapper.updateByPrimaryKeySelective(jixitruckOrder);
    }

    /**
     * 批量删除
     * @param sellordercodes
     */
    @Override
    public void deleteJixitruckOrder(String[] sellordercodes) {
        for (String sellordercode:sellordercodes){
            jixitruckOrderMapper.deleteByPrimaryKey(sellordercode);
        }

    }

    /**
     * 删除一个
     * @param sellordercode
     */
    @Override
    public void deleteOne(String sellordercode) {
        jixitruckOrderMapper.deleteByPrimaryKey(sellordercode);
    }

    /**
     * 导出到excel
     * @param outputStream
     * @param sellordercodes
     * @throws Exception
     */
    @Override
    public void exportExcel(OutputStream outputStream, String[] sellordercodes) throws Exception {
        List<List<String>> stringList=new ArrayList<>();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        //创建表头内容
        List<String> headList = new ArrayList<>();
        headList.add("订单编号");
        headList.add("配送时间");
        headList.add("供应商");
        headList.add("运输路线");
        headList.add("运费");

        //获得表尾数据
        List<String> tails=new ArrayList<>();
        Double freights=0.0;

        for(String sellordercode:sellordercodes) {
            List<String> ss = new ArrayList<>();
            JixitruckOrder jixitruckOrder=jixitruckOrderMapper.selectByPrimaryKey(sellordercode);

            ss.add(jixitruckOrder.getSellordercode());
            ss.add(format.format(jixitruckOrder.getSenddate()));
            ss.add(jixitruckOrder.getSupplier());
            ss.add(jixitruckOrder.getAddress());
            ss.add(jixitruckOrder.getFreight().toString());

            freights+=jixitruckOrder.getFreight();

            stringList.add(ss);
        }
        tails.add("");
        tails.add(freights.toString());

        ExcelUtil.outputToExcel(stringList,headList,tails,"集兮车队订单表",outputStream);
    }
}
