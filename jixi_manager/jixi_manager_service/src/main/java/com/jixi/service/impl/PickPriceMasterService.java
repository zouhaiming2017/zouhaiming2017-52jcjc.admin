package com.jixi.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jixi.mapper.PickpriceMasterMapper;

import com.jixi.pojo.PickpriceMaster;
import com.jixi.pojo.PickpriceMasterExample;
import com.jixi.service.IPickPriceMasterService;
import com.jixi.utils.ExportExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * Created by zhm on 2017/8/23.
 */
@Service
public class PickPriceMasterService implements IPickPriceMasterService {

    @Autowired
    private PickpriceMasterMapper pickpriceMasterMapper;

    /**
     * 判断itemCode是否存在
     * @param itemCode
     * @return
     */
    public boolean isExist(String itemCode) {
        try {
            PickpriceMaster pickpriceMaster = pickpriceMasterMapper.selectByPrimaryKey(itemCode);
            if (pickpriceMaster==null) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    /**
     * 判断itemCode是否为空
     * */
    public boolean isNull(String itemCode){
        if(itemCode!=null&&!"".equals(itemCode)){
            return true;
        }
        return false;
    }



    /**
     * 数据列表查询
     * @return
     */
    @Override
    public List<PickpriceMaster> getPickPriceMasterList() {
        //执行查询
        PickpriceMasterExample example = new PickpriceMasterExample();
        List<PickpriceMaster> list = pickpriceMasterMapper.selectByExample(example);
        return list;
    }

    /**
     * 从excel中导入数据到供应商报价表
     * @param list
     * @return
     */
    @Override
    public void saveBath(List<String[]> list) {
        PickpriceMaster pickpriceMaster=new PickpriceMaster();
        for (String[] strings : list) {
            String itemCode = strings[0];
            if(isNull(itemCode)) {
                pickpriceMaster.setItemcode(strings[0].replace(" ",""));
                pickpriceMaster.setItemname(strings[1].replace(" ",""));
                pickpriceMaster.setStandard(strings[2].replace(" ",""));
                pickpriceMaster.setModel(strings[3].replace(" ",""));
                pickpriceMaster.setBrandname(strings[4].replace(" ",""));
                pickpriceMaster.setChargeunit(strings[5].replace(" ",""));
                pickpriceMaster.setInprice(Double.valueOf("".equals(strings[6].replace(" ",""))?"0.00":strings[6].replace(" ","")));
                pickpriceMaster.setExcludingtax(Double.valueOf("".equals(strings[7].replace(" ",""))?"0.00":strings[7].replace(" ","")));
                pickpriceMaster.setLimitprice(Double.valueOf("".equals(strings[8].replace(" ",""))?"0.00":strings[8].replace(" ","")));
                pickpriceMaster.setPackingsize(strings[9].replace(" ",""));
                pickpriceMaster.setSupplier(strings[10].replace(" ",""));
                pickpriceMaster.setSuppliercode(strings[11].replace(" ",""));
                if (!isExist(itemCode)) {
                    //不存在就添加
                    pickpriceMasterMapper.insertSelective(pickpriceMaster);

                } else {
                    //存在就跳过
                    continue;

                }
            }

        }
    }

    /**
     * 导出表数据到excel
     * @return
     */

    @Override
    public void exportExcel(OutputStream outputStream) throws Exception {
        //获得配货表中所有数据
        PickpriceMasterExample example = new PickpriceMasterExample();
        List<PickpriceMaster> list = pickpriceMasterMapper.selectByExample(example);

        //实例化工具类
        ExportExcelUtil<PickpriceMaster> exportExcelUtil=new ExportExcelUtil();
        exportExcelUtil.setClassName(PickpriceMaster.class.getName());
        //获得表头数据
        List<String> headList = new ArrayList<>();
        headList.add("商品编码");
        headList.add("材料名称");
        headList.add("规格");
        headList.add("型号");
        headList.add("品牌名称");
        headList.add("计价单位");
        headList.add("进价");
        headList.add("不含税价");
        headList.add("厂商限定价");
        headList.add("包装规格");
        headList.add("供应商");
        headList.add("供应商编码");
        exportExcelUtil.setHeadList(headList);

        exportExcelUtil.exportExcel(list,outputStream,"供应商报价表");
    }



    /**
     * 新增数据
     * */
    @Override
    public void createPickpriceMaster(PickpriceMaster pickpriceMaster) throws Exception {
        pickpriceMasterMapper.insertSelective(pickpriceMaster);
    }

    /**
     * 修改数据
     * */
    @Override
    public void updatePickpriceMaster(PickpriceMaster pickpriceMaster) {
        pickpriceMasterMapper.updateByPrimaryKeySelective(pickpriceMaster);
    }

    @Override
    public PickpriceMaster selectOne(String itemCode) {
        PickpriceMaster pickpriceMaster=pickpriceMasterMapper.selectByPrimaryKey(itemCode);

        return pickpriceMaster;
    }


    /**
     * 删除多个供应商报价数据
     * */
    @Override
    public void deletePickpriceMaster(String[] itemCodes) {
        for (int i=0;i<itemCodes.length;i++){
            pickpriceMasterMapper.deleteByPrimaryKey(itemCodes[i]);
        }

    }

    /**
     * 删除一条数据
     */
    @Override
    public void deleteOne(String itemCode) {
        pickpriceMasterMapper.deleteByPrimaryKey(itemCode);

    }

    /**
     * 根据商品名模糊查询
     * @param map
     * @return
     */
    @Override
    public List<PickpriceMaster> like(Map map){
        List<PickpriceMaster> list=pickpriceMasterMapper.like(map);
        return list;
    }

    /**
     * 去重复查询所有供应商及对应供应商编号
     * @return
     */
    @Override
    public List<PickpriceMaster> selectDistinctSupplier() {
        List<PickpriceMaster> list=pickpriceMasterMapper.selectDistinctSupplier();
        return list;
    }

    /**
     * 统计总数
     * @return
     */
    @Override
    public long countByExample() {
        PickpriceMasterExample example = new PickpriceMasterExample();
        return pickpriceMasterMapper.countByExample(example);
    }

}
