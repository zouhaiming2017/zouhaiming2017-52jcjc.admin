package com.jixi.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jixi.mapper.SellorderMasterMapper;
import com.jixi.pojo.SellorderMaster;
import com.jixi.pojo.SellorderMasterExample;
import com.jixi.service.ISellOrderMasterService;
import com.jixi.utils.ExportExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by zhm on 2017/8/24.
 */
@Service
public class SellOrderMasterService implements ISellOrderMasterService {

    @Autowired
    private SellorderMasterMapper sellorderMasterMapper;


    /**
     * 判断id是否存在
     *
     * @param id
     * @return
     */
    public boolean isExist(Integer id) {
        try {
            SellorderMaster sellorderMaster = sellorderMasterMapper.selectByPrimaryKey(id);
            if (sellorderMaster== null){
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
        if(id!=null&&!"".equals(id)){
            return true;
        }
        return false;
    }

    /**
     * 数据列表查询
     * @return
     */
    @Override
    public List<SellorderMaster>  getSellOrderMasterList() {
        //执行查询
        SellorderMasterExample example = new SellorderMasterExample();
        List<SellorderMaster> list = sellorderMasterMapper.selectByExample(example);

        return list;
    }

    /**
     * 查询一个
     */
    @Override
    public SellorderMaster selectOne(Integer id) {
        return sellorderMasterMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveBath(List<String[]> list) throws ParseException {

    }

    /**
     * 从excel导入数据到客户订单表
     * @param list
     * @return
     */
//    @Override
//    public JixiResult saveBath(List<String[]> list) throws ParseException {
//        SellorderMaster sellorderMaster=new SellorderMaster();
//        for (String[] strings : list) {
//
//            //定义订单编号
//            String orderCodeStr="";
//            //定义收货时间
//            Date sellDateDate=new Date();
//            //获得订单编号和时间
//            if(strings[0]!=null&&!"".equals(strings[0])&&(strings[0].startsWith("订单编号"))){
//                orderCodeStr =strings[0].replace(" ","").substring(5);
//
//                String pickDate=orderCodeStr.substring(0,12);
//                SimpleDateFormat format=new SimpleDateFormat("yyyyMMddHHmm");
//                sellDateDate=format.parse(pickDate);
//            }
//
//            //获得收货地址
//            String addessStr="";
//            if(strings[13]!=null&&!"".equals(strings[13])&&(strings[13].startsWith("送货地址"))){
//                addessStr=strings[13].replace(" ","").substring(5);
//            }
//            //获得联系人
//            String linkmanStr="";
//            if(strings[14]!=null&&!"".equals(strings[14])&&(strings[14].startsWith("联系人"))){
//                linkmanStr=strings[14].replace(" ","").substring(4);
//            }
//
//            //获得订货单位
//            String companyStr="";
//            if(strings[15]!=null&&!"".equals(strings[15])&&(strings[15].startsWith("订货单位"))){
//                companyStr=strings[15].replace(" ","").substring(5);
//            }
//
//            String itemCode = strings[1];
//            if(isNull(itemCode)) {
//                sellorderMaster.setSellordercode(orderCodeStr);
//                sellorderMaster.setItemcode(strings[1].replace(" ",""));
//                sellorderMaster.setItemname(strings[2].replace(" ",""));
//                sellorderMaster.setStandard(strings[3].replace(" ",""));
//                sellorderMaster.setModel(strings[4].replace(" ",""));
//                sellorderMaster.setBrandname(strings[5].replace(" ",""));
//                sellorderMaster.setPackingsize(strings[6].replace(" ",""));
//                sellorderMaster.setChargeunit(strings[7].replace(" ",""));
//                sellorderMaster.setOutprice(Double.valueOf("".equals(strings[8].replace(" ",""))?"0.00":strings[8].replace(" ","")));
//                sellorderMaster.setCount(Long.valueOf("".equals(strings[9].replace(" ",""))?"0":strings[9].replace(" ","")));
//                sellorderMaster.setSum(0.00);
//                sellorderMaster.setCompany(companyStr);
//                sellorderMaster.setLinkman(linkmanStr);
//                sellorderMaster.setSelldate(sellDateDate);
//                sellorderMaster.setSelladdress(addessStr);
//                sellorderMaster.setRemarks(strings[11].replace(" ",""));
//
//                if (!isExist(itemCode)) {
//                    //不存在就添加
//                    sellorderMasterMapper.insertSelective(sellorderMaster);
//                } else {
//                    //存在就更新
//                    sellorderMasterMapper.updateByPrimaryKeySelective(sellorderMaster);
//                }
//            }
//
//        }
//        return JixiResult.ok();
//    }

    /**
     * 导出数据到excel
     * @param outputStream
     * @return
     * @throws Exception
     */
    @Override
    public void exportExcel(OutputStream outputStream) throws Exception {
        //获得SellorderMaster所有数据
        SellorderMasterExample example = new SellorderMasterExample();
        List<SellorderMaster> list = sellorderMasterMapper.selectByExample(example);
        //实例化工具类
        ExportExcelUtil<SellorderMaster> exportExcelUtil=new ExportExcelUtil();
        exportExcelUtil.setClassName(SellorderMaster.class.getName());

        //获得表头数据
        List<String> headList = new ArrayList<>();
        headList.add("客户订单号");
        headList.add("商品编码");
        headList.add("商品名称");
        headList.add("规格");
        headList.add("型号");
        headList.add("品牌");
        headList.add("包装规格");
        headList.add("计价单位");
        headList.add("售价");
        headList.add("数量");
        headList.add("合计");
        headList.add("收货公司");
        headList.add("联系人");
        headList.add("下单时间");
        headList.add("收货地址");
        headList.add("备注");
        exportExcelUtil.setHeadList(headList);

        exportExcelUtil.exportExcel(list,outputStream,"客户订单数据");
    }


    /**
     * 新增客户订单
     * */
    @Override
    public void createSellorderMaster(SellorderMaster sellorderMaster) throws Exception {
        sellorderMasterMapper.insertSelective(sellorderMaster);
    }

    /**
     * 修改客户订单
     * */
    @Override
    public void updateSellorderMaster(SellorderMaster sellorderMaster) {
        sellorderMasterMapper.updateByPrimaryKeySelective(sellorderMaster);
    }


    /**
     * 批量删除客户订单
     * */
    @Override
    public void deleteSellorderMaster(String[] ids) {
        for (int i=0;i<ids.length;i++){
            sellorderMasterMapper.deleteByPrimaryKey(Integer.parseInt(ids[i]));
        }
    }

    /**
     * 删除一个
     * @param id
     */
    @Override
    public void deleteOne(Integer id) {
        sellorderMasterMapper.deleteByPrimaryKey(id);
    }


    /**
     * 金额汇总
     * */
    @Override
    public void getAllSum() {
        //查询所有数据
        SellorderMasterExample example = new SellorderMasterExample();
        List<SellorderMaster> list = sellorderMasterMapper.selectByExample(example);
        int allSum = 0;
        for (SellorderMaster sellorderMaster : list) {
            //获得每个订单总价并将值赋给sum
            if(sellorderMaster.getCount()==null||"".equals(sellorderMaster.getCount())){
                sellorderMaster.setCount((long)0);
            }
            if(sellorderMaster.getOutprice()==null||"".equals(sellorderMaster.getOutprice())){
                sellorderMaster.setOutprice(0.00);
            }
            sellorderMaster.setSum(sellorderMaster.getOutprice() * sellorderMaster.getCount());
            sellorderMasterMapper.updateByPrimaryKeySelective(sellorderMaster);

            allSum += sellorderMaster.getSum();
        }
    }

    /**
     * 统计总数
     * @return
     */
    @Override
    public long countByExample() {
        SellorderMasterExample example = new SellorderMasterExample();
        return sellorderMasterMapper.countByExample(example);
    }
}
