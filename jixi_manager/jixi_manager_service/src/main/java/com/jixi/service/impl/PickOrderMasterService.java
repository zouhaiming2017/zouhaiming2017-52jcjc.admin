package com.jixi.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jixi.mapper.PickorderMasterMapper;
import com.jixi.mapper.PickpriceMasterMapper;
import com.jixi.pojo.*;
import com.jixi.service.IPickOrderMasterService;
import com.jixi.utils.ExportExcelUtil;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by zhm on 2017/8/23.
 */
@Service
public class PickOrderMasterService implements IPickOrderMasterService{

    @Autowired
    private PickorderMasterMapper pickorderMasterMapper;

    @Autowired
    private PickpriceMasterMapper pickpriceMasterMapper;

    /**
     * 判断id是否存在
     *
     * @param id
     * @return
     */
    public boolean isExist(Integer id) {
        try {
            PickorderMaster pickorderMaster = pickorderMasterMapper.selectByPrimaryKey(id);
            if (pickorderMaster== null) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    /**
     * 判断id是否为空
     * */
    public boolean isNull(Integer id){
        if(id==null||"".equals(id)){
            return false;
        }
        return true;
    }

    /**
     * 数据列表查询
     * @return
     */
    @Override
    public List<PickorderMaster> getPickOrderMasterList() {

        //执行查询
        PickorderMasterExample example = new PickorderMasterExample();
        List<PickorderMaster> list = pickorderMasterMapper.selectByExample(example);
        return list;
    }

    /**
     * 查询一个
     * @param id
     * @return
     */
    @Override
    public PickorderMaster selectOne(Integer id) {
        PickorderMaster pickorderMaster=pickorderMasterMapper.selectByPrimaryKey(id);
        return pickorderMaster;
    }

    @Override
    public void saveBathBath(List<String[]> list) throws ParseException {

    }


    /**
     * 从excel读取数据导入PickorderMaster表中
     * @param list
     */
//    @Override
//    public JixiResult saveBath(List<String[]> list) throws ParseException {
//        PickorderMaster pickorderMaster=new PickorderMaster();
//
//        for (String[] strings : list) {
//            //获得订单编号
//            String orderCodeStr="";
//            //定义收货时间
//            Date pickDateDate=new Date();
//            //获得订单编号和时间
//            if(strings[0]!=null&&!"".equals(strings[0])&&(strings[0].startsWith("配货单"))){
//                orderCodeStr =strings[0].replace(" ","").substring(4);
//
//                String pickDate=orderCodeStr.substring(0,12);
//                SimpleDateFormat format=new SimpleDateFormat("yyyyMMddHHmm");
//                pickDateDate=format.parse(pickDate);
//            }
//
//            //获得收货地址
//            String addessStr="";
//            if(strings[13]!=null&&!"".equals(strings[13])&&(strings[13].startsWith("收货地址"))){
//                addessStr=strings[13].replace(" ","").substring(5);
//            }
//
//            String itemCode = strings[1];
//            if(isNull(itemCode)) {
//                pickorderMaster.setPickordercode(orderCodeStr);
//                pickorderMaster.setItemcode(strings[1].replace(" ",""));
//                pickorderMaster.setItemname(strings[2].replace(" ",""));
//                pickorderMaster.setStandard(strings[3].replace(" ",""));
//                pickorderMaster.setModel(strings[4].replace(" ",""));
//                pickorderMaster.setBrandname(strings[5].replace(" ",""));
//                pickorderMaster.setPackingsize(strings[6].replace(" ",""));
//                pickorderMaster.setChargeunit(strings[7].replace(" ",""));
//                pickorderMaster.setCount(Long.valueOf("".equals(strings[8].replace(" ",""))?"0":strings[8].replace(" ","")));
//                pickorderMaster.setInprice(Double.valueOf("".equals(strings[9].replace(" ",""))?"0.00":strings[9].replace(" ","")));
//                pickorderMaster.setSum(0.00);
//                pickorderMaster.setRemarks(strings[11].replace(" ",""));
//                pickorderMaster.setPickdate(pickDateDate);
//                pickorderMaster.setPickaddress(addessStr);
//
//                if (!isExist(itemCode)) {
//                    //不存在就添加
//                    pickorderMasterMapper.insertSelective(pickorderMaster);
//                } else {
//                    //存在就更新
//                    pickorderMasterMapper.updateByPrimaryKeySelective(pickorderMaster);
//                }
//            }
//
//        }
//        return JixiResult.ok();
//    }
//

    /**
     * 导出表数据到excel
     * @return
     */
    public void exportExcel(OutputStream outputStream) throws Exception {
        //获得配货表中所有数据
        PickorderMasterExample example = new PickorderMasterExample();
        List<PickorderMaster> list = pickorderMasterMapper.selectByExample(example);

        //实例化工具类
        ExportExcelUtil<PickorderMaster> exportExcelUtil=new ExportExcelUtil();
        exportExcelUtil.setClassName(PickorderMaster.class.getName());
        //获得表头数据
        List<String> headList = new ArrayList<>();
        headList.add("配货订单号");
        headList.add("商品编码");
        headList.add("商品名称");
        headList.add("规格");
        headList.add("型号");
        headList.add("品牌");
        headList.add("包装规格");
        headList.add("计价单位");
        headList.add("数量");
        headList.add("进价");
        headList.add("合计");
        headList.add("下单时间");
        headList.add("收货地址");
        headList.add("备注");
        exportExcelUtil.setHeadList(headList);


        exportExcelUtil.exportExcel(list,outputStream,"配货订单表");
    }

    /**
     * 新增数据
     * */
    @Override
    public void createPickorderMaster(PickorderMaster pickorderMaster) throws Exception {
        pickorderMasterMapper.insertSelective(pickorderMaster);
    }

    /**
     * 从供货商报价表导入相应的商品进价
     * */
//    @Override
//    public JixiResult addInpriceFromPickPriceMaster() {
//        //查询供货商报价表所有数据
//        PickpriceMasterExample example = new PickpriceMasterExample();
//        List<PickpriceMaster> priceList = pickpriceMasterMapper.selectByExample(example);
//        //将商品进价插入配货订单表
//        int isSuccess=0;
//        for(PickpriceMaster pickpriceMaster:priceList){
//            String itemCode=pickpriceMaster.getItemcode();
//            if(isExist(itemCode)){
//                //存在就插入
//                PickorderMaster pickorderMaster=pickorderMasterMapper.selectByPrimaryKey(itemCode);
//                pickorderMaster.setInprice(pickpriceMaster.getInprice());
//
//                //更新表
//                pickorderMasterMapper.updateByPrimaryKeySelective(pickorderMaster);
//            }
//        }
//        return JixiResult.ok();
//    }


    /**
     * 修改配货单数据
     * */
    @Override
    public void updatePickorderMaster(PickorderMaster pickorderMaster) {
        pickorderMasterMapper.updateByPrimaryKeySelective(pickorderMaster);

    }


    /**
     * 删除多个配货单数据
     * */
    @Override
    public void deletePickorderMaster(String[] ids) {
        for (int i=0;i<ids.length;i++){
            pickorderMasterMapper.deleteByPrimaryKey(Integer.parseInt(ids[i]));
        }

    }

    /**
     * 删除单个
     * @param id
     */
    @Override
    public void deleteOne(Integer id) {
        pickorderMasterMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void addInpriceFromPickPriceMaster() {

    }

    /**
     * 金额汇总
     * */
    @Override
    public void getAllSum() {
        //查询所有数据
        PickorderMasterExample example = new PickorderMasterExample();
        List<PickorderMaster> list = pickorderMasterMapper.selectByExample(example);
        int allSum=0;
        for(PickorderMaster pickorderMaster:list){
            //获得每个订单总价并将值赋给sum
            if(pickorderMaster.getCount()==null||"".equals(pickorderMaster.getCount())){
                pickorderMaster.setCount((long)0);
            }
            if(pickorderMaster.getInprice()==null||"".equals(pickorderMaster.getInprice())){
                pickorderMaster.setInprice(0.00);
            }
            pickorderMaster.setSum(pickorderMaster.getInprice()*pickorderMaster.getCount());
            pickorderMasterMapper.updateByPrimaryKeySelective(pickorderMaster);

            //累计汇总
            allSum+=pickorderMaster.getSum();
        }
    }

    /**
     * 统计总数
     * @return
     */
    @Override
    public long countByExample() {
        PickorderMasterExample example = new PickorderMasterExample();
        return pickorderMasterMapper.countByExample(example);
    }
}

