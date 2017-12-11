package com.jixi.service.impl;

import com.jixi.mapper.PickorderSumMapper;
import com.jixi.pojo.PickorderSum;
import com.jixi.pojo.PickorderSumExample;
import com.jixi.pojo.PickorderSumExport;
import com.jixi.service.IPickOrderSumService;
import com.jixi.utils.ComplexExcelUtil;
import com.jixi.utils.DoubleFormatUtil;
import com.jixi.utils.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by zhm on 2017/9/13.
 */
@Service
public class PickOrderSumService implements IPickOrderSumService {

    @Autowired
    private PickorderSumMapper pickorderSumMapper;


    /**
     * 判断pickordercode是否存在
     *
     * @param pickordercode
     * @return
     */
    public boolean isExist(String pickordercode) {
        try {
            PickorderSum pickorderSum = pickorderSumMapper.selectByPrimaryKey(pickordercode);
            if (pickorderSum == null) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    /**
     * 判断pickordercode是否为空
     */
    public boolean isNull(String pickordercode) {
        if (pickordercode != null && !"".equals(pickordercode)) {
            return true;
        }
        return false;
    }


    /**
     * 查询列表
     * @return
     */
    @Override
    public List<PickorderSum> getPickorderSumList() {
        PickorderSumExample example = new PickorderSumExample();
        List<PickorderSum> list = pickorderSumMapper.selectByExample(example);
        return list;
    }

    /**
     * 去重复查询供应商
     * @return
     */
    @Override
    public List<PickorderSum> selectDistinctSupplier() {
        return pickorderSumMapper.selectDistinctSupplier();
    }

    /**
     * 去重复查询联系人
     * @return
     */
    @Override
    public List<PickorderSum> selectDistinctLinkman() {
        return pickorderSumMapper.selectDistinctLinkman();
    }

    /**
     * 去重复查询收货地
     * @return
     */
    @Override
    public List<PickorderSum> selectDistinctAddress() {
        return pickorderSumMapper.selectDistinctAddress();
    }


    /**
     * 模糊查询
     * @param map
     * @return
     */
    @Override
    public List<PickorderSum> like(Map map) {
        return pickorderSumMapper.like(map);
    }

    /**
     * 查询一个
     * @param pickordercode
     * @return
     */
    @Override
    public PickorderSum selectOne(String pickordercode) {
        PickorderSum pickorderSum=pickorderSumMapper.selectByPrimaryKey(pickordercode);
        return pickorderSum;
    }

    /**
     * 新增
     * @param pickorderSum
     * @return
     * @throws Exception
     */
    @Override
    public void createPickorderSum(PickorderSum pickorderSum) throws Exception {
        pickorderSum.setAllsum(pickorderSum.getSum()+pickorderSum.getFreight());
        pickorderSum.setReceivedsum(0.0);
        pickorderSum.setNoreceivedsum(pickorderSum.getAllsum());
        pickorderSumMapper.insertSelective(pickorderSum);
    }

    /**
     * 修改
     * @param pickorderSum
     * @return
     * @throws Exception
     */
    @Override
    public void updatePickorderSum(PickorderSum pickorderSum) throws Exception {
        if(pickorderSum.getSum()!=null&&pickorderSum.getFreight()!=null){
            pickorderSum.setAllsum(pickorderSum.getSum()+pickorderSum.getFreight());
        }

        pickorderSumMapper.updateByPrimaryKeySelective(pickorderSum);
    }

    /**
     * 批量删除
     * @param pickordercodes
     * @return
     */
    @Override
    public void deletePickorderSum(String[] pickordercodes) {
        for(int i=0;i<pickordercodes.length;i++){
            pickorderSumMapper.deleteByPrimaryKey(pickordercodes[i]);
        }
    }

    /**
     * 删除一个
     * @param pickordercode
     */
    @Override
    public void deleteOne(String pickordercode) {
        pickorderSumMapper.deleteByPrimaryKey(pickordercode);

    }

    /**
     * 从excel导入数据
     * @param myFile
     * @return
     * @throws Exception
     */
    @Override
    public void saveBath(MultipartFile myFile,String path) throws Exception {
        List<List<List<String>>> ss= ExcelUtil.readExcel(myFile.getInputStream(),path,false);
        for(List<String> list:ss.get(0)){
            PickorderSum pickorderSum=new PickorderSum();
            //获得配货单号
            String pickordercode=list.get(0);
            if (isNull(pickordercode)) {
                pickorderSum.setPickordercode(list.get(0));
                pickorderSum.setSupplier(list.get(1));
                pickorderSum.setAddress(list.get(2));
                pickorderSum.setLinkman(list.get(3));
                pickorderSum.setSum(DoubleFormatUtil.getFormatDouble(list.get(5)));
                pickorderSum.setFreight(DoubleFormatUtil.getFormatDouble(list.get(7)));
                pickorderSum.setAllsum(DoubleFormatUtil.getFormatDouble(list.get(9)));
                pickorderSum.setPickman(list.get(11));
                pickorderSum.setRemark(list.get(12));
                //获得时间
                String pickdateStr = pickorderSum.getPickordercode().substring(0, 8);
                SimpleDateFormat format1 = new SimpleDateFormat("yyyyMMdd");
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                Date pickdateDate = format1.parse(pickdateStr);
                String pickdate = format.format(pickdateDate);

                pickorderSum.setPickdata(format.parse(pickdate));
                //补充其它数据
                pickorderSum.setReceivedsum(0.0);
                pickorderSum.setNoreceivedsum(pickorderSum.getAllsum());
                pickorderSum.setTicketstatus("0");
                pickorderSum.setAllpaystatue("0");

                if (!isExist(pickordercode)) {
                    //不存在就添加
                    pickorderSumMapper.insertSelective(pickorderSum);
                } else {
                    //存在就跳过
                    continue;
                }
            }

        }

    }

    /**
     * 导出数据到excel
     * @param outputStream
     * @param pickordercodes
     * @return
     * @throws Exception
     */
    @Override
    public void exportExcel(OutputStream outputStream, String[] pickordercodes) throws Exception {
        List<List<String>> stringList=new ArrayList<>();
        //创建表头内容
        List<String> headList = new ArrayList<>();
        headList.add("配货单号");
//        headList.add("订单时间");
        headList.add("供应商");
        headList.add("联系人");
        headList.add("合计");
        headList.add("运费");
        headList.add("总计");
        //获得表尾数据
        List<String> tails=new ArrayList<>();
        Double sums=0.0;
        Double freights=0.0;
        Double allSums=0.0;

        for(int i=0;i<pickordercodes.length;i++){
            List<String> ss=new ArrayList<>();
            PickorderSum pickorderSum=pickorderSumMapper.selectByPrimaryKey(pickordercodes[i]);

            SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
            ss.add(pickorderSum.getPickordercode());
//            ss.add(format.format(pickorderSum.getPickdata()));
            ss.add(pickorderSum.getSupplier());
            ss.add(pickorderSum.getLinkman());
            ss.add(pickorderSum.getSum().toString());
            ss.add(pickorderSum.getFreight().toString());
            ss.add(pickorderSum.getAllsum().toString());

            sums+=pickorderSum.getSum();
            freights+=pickorderSum.getFreight();
            allSums+=pickorderSum.getAllsum();

            stringList.add(ss);
        }
        tails.add(DoubleFormatUtil.getFormatSums(sums).toString());
        tails.add(DoubleFormatUtil.getFormatSums(freights).toString());
        tails.add(DoubleFormatUtil.getFormatSums(allSums).toString());

        ExcelUtil.outputToExcel(stringList,headList,tails,"配货表",outputStream);
    }

    /**
     * 导出到excel（财务）
     * @param outputStream
     * @param pickordercodes
     * @param sheetName
     * @throws Exception
     */
    @Override
    public void exportExcelAsFinance(OutputStream outputStream, String[] pickordercodes, String sheetName) throws Exception {
        List<List<String>> stringList=new ArrayList<>();
        //创建表头内容
        List<String> headList = new ArrayList<>();
        headList.add("配货号");
        headList.add("供应商");
        headList.add("收货地址");
        headList.add("总计");
        headList.add("已付款");
        headList.add("未付款");
        headList.add("付款状态");
        headList.add("开票状态");
        headList.add("发票单号");

        //获得表尾数据
        List<String> tails=new ArrayList<>();
        Double allSums=0.0;
        Double receivedsums=0.0;
        Double noReceivedsums=0.0;

        for(int i=0;i<pickordercodes.length;i++) {
            List<String> ss = new ArrayList<>();
            PickorderSum pickorderSum=pickorderSumMapper.selectByPrimaryKey(pickordercodes[i]);

            ss.add(pickorderSum.getPickordercode());
            ss.add(pickorderSum.getSupplier());
            ss.add(pickorderSum.getAddress());
            ss.add(pickorderSum.getAllsum().toString());
            ss.add(pickorderSum.getReceivedsum().toString()==null?"0.0":pickorderSum.getReceivedsum().toString());
            ss.add(pickorderSum.getNoreceivedsum().toString()==null?"0.0":pickorderSum.getNoreceivedsum().toString());
            ss.add(pickorderSum.getAllpaystatue()==null ||pickorderSum.getAllpaystatue().equals("0")?"未结清":"已结清");
            ss.add(pickorderSum.getTicketstatus()==null ||pickorderSum.getTicketstatus().equals("0")?"未开票":"已开票");
            ss.add(pickorderSum.getTicketno());

            allSums+=pickorderSum.getAllsum();
            receivedsums+=pickorderSum.getReceivedsum();
            noReceivedsums+=pickorderSum.getNoreceivedsum();

            stringList.add(ss);
        }
        tails.add(DoubleFormatUtil.getFormatSums(allSums).toString());
        tails.add(DoubleFormatUtil.getFormatSums(receivedsums).toString());
        tails.add(DoubleFormatUtil.getFormatSums(noReceivedsums).toString());
        tails.add("");
        tails.add("");
        tails.add("");

        ExcelUtil.outputToExcel(stringList,headList,tails,sheetName,outputStream);
    }


    /**
     * 统计总数
     * @return
     */
    @Override
    public long countByExample() {
        PickorderSumExample example = new PickorderSumExample();
        return pickorderSumMapper.countByExample(example);
    }

    /**
     * 统计当天数量
     * @return
     * @throws ParseException
     */
    @Override
    public long getTodayCount() throws ParseException {
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        String today=format.format(new Date());
        return pickorderSumMapper.getDayCount(today);
    }

    /**
     * 获得前一天的数量
     * @return
     */
    @Override
    public long getYesterdayCount() {
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        Calendar  calendar=new GregorianCalendar();
        calendar.setTime(new Date());//设置起时间
        calendar.add(calendar.DATE,-1);//把日期往后增加一天.整数往后推,负数往前移动

        return pickorderSumMapper.getDayCount(format.format(calendar.getTime()));
    }

    /**
     * 获得本周数量
     * @return
     */
    @Override
    public long getWeekCount() {
        return pickorderSumMapper.getWheekCount();
    }

    /**
     * 获得本月数量
     * @return
     */
    @Override
    public long getMonthCount() {
        return pickorderSumMapper.getMonthCount();
    }

    /**
     * 获得规定时间段的数据量
     * @return
     */
    @Override
    public long getCount(Map map) {
        return pickorderSumMapper.getCount(map);
    }

    /**
     * 获得规定时间段的总支出
     * @param map
     * @return
     */
    @Override
    public Double getSums(Map map) {
        return pickorderSumMapper.getSums(map);
    }

    /**
     * 根据条件筛选获得总合价
     * @param map
     * @return
     */
    @Override
    public Double getPsums(Map map) {
        return pickorderSumMapper.getPsums(map);
    }


    /**
     * 根据条件筛选获得总运费
     * @param map
     * @return
     */
    @Override
    public Double getPfreights(Map map) {
        return pickorderSumMapper.getPfreights(map);
    }

    /**
     * 根据条件筛选获得总价
     * @param map
     * @return
     */
    @Override
    public Double getPallSums(Map map) {
        return pickorderSumMapper.getPallSums(map);
    }

    /**
     * 根据条件筛选获得已收款总计
     * @param map
     * @return
     */
    @Override
    public Double getPreceivedsums(Map map) {
        return pickorderSumMapper.getPreceivedsums(map);
    }


    /**
     * 根据条件筛选获得未收款总计
     * @param map
     * @return
     */
    @Override
    public Double getPnoreceivedsum(Map map) {
        return pickorderSumMapper.getPnoreceivedsum(map);
    }

}
