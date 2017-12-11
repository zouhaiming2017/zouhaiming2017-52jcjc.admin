package com.jixi.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jixi.mapper.SellpriceMasterMapper;
import com.jixi.pojo.SellpriceMaster;
import com.jixi.pojo.SellpriceMasterExample;
import com.jixi.service.ISellPriceMasterService;
import com.jixi.utils.ExportExcelUtil;
import jxl.Sheet;
import jxl.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by zhm on 2017/8/24.
 */
@Service
public class SellPriceMasterService implements ISellPriceMasterService{
    @Autowired
    private SellpriceMasterMapper sellpriceMasterMapper;


    /**
     * 判断itemCode是否存在
     *
     * @param itemCode
     * @return
     */
    public boolean isExist(String itemCode) {
        try {
            SellpriceMaster sellpriceMaster = sellpriceMasterMapper.selectByPrimaryKey(itemCode);
            if (sellpriceMaster== null) {
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
        try {
            if(itemCode!=null&&!"".equals(itemCode)){
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    /**
     * 数据列表查询
     * @return
     */
    @Override
    public List<SellpriceMaster> getSellPriceMasterList() {
        //执行查询
        SellpriceMasterExample example = new SellpriceMasterExample();
        List<SellpriceMaster> list = sellpriceMasterMapper.selectByExample(example);

        return list;
    }

    /**
     * 去重复查询供应商
     * @return
     */
    @Override
    public List<SellpriceMaster> selectDistinctSupplierCode() {
        List<SellpriceMaster> list=sellpriceMasterMapper.selectDistinctSupplierCode();

        return list;
    }

    /**
     * 查询一个
     * @param itemcode
     * @return
     */
    @Override
    public SellpriceMaster selectOne(String itemcode) {
        SellpriceMaster sellpriceMaster=sellpriceMasterMapper.selectByPrimaryKey(itemcode);
        return sellpriceMaster;
    }

    /**
     * 模糊查询
     * @param map
     * @return
     */
    @Override
    public List<SellpriceMaster> like(Map map) {
        List<SellpriceMaster> list=sellpriceMasterMapper.like(map);
        return list;
    }

    /**
     * 从excel导入数据到商城上线价目表
     * @param list
     * @return
     */
    @Override
    public void saveBath(List<String[]> list) {
        SellpriceMaster sellpriceMaster=new SellpriceMaster();
        for (String[] strings : list) {
            String itemCode = strings[0];
            if(isNull(itemCode)) {
                sellpriceMaster.setItemcode(strings[0].replace(" ",""));
                sellpriceMaster.setItemname(strings[1].replace(" ",""));
                sellpriceMaster.setItemnamecode(strings[2].replace(" ",""));
                sellpriceMaster.setStandard(strings[3].replace(" ",""));
                sellpriceMaster.setStandardcode(strings[4].replace(" ",""));
                sellpriceMaster.setModel(strings[5].replace(" ",""));
                sellpriceMaster.setModelcode(strings[6].replace(" ",""));
                sellpriceMaster.setBrandname(strings[7].replace(" ",""));
                sellpriceMaster.setBrandcode(strings[8].replace(" ",""));
                sellpriceMaster.setChargeunit(strings[9].replace(" ",""));
                sellpriceMaster.setOutprice(Double.valueOf("".equals(strings[10].replace(" ",""))?"0.00":strings[10].replace(" ","")));
                sellpriceMaster.setPackingsize(strings[11].replace(" ",""));
                sellpriceMaster.setSuppliercode(strings[12].replace(" ",""));

                if (!isExist(itemCode)) {
                    //不存在就添加
                    sellpriceMasterMapper.insertSelective(sellpriceMaster);
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
     * @return
     * @throws Exception
     */
    @Override
    public void exportExcel(OutputStream outputStream) throws Exception {
        //查询所有SellpriceMaster信息
        SellpriceMasterExample example = new SellpriceMasterExample();
        List<SellpriceMaster> list = sellpriceMasterMapper.selectByExample(example);
        //实例化工具类
        ExportExcelUtil<SellpriceMaster> exportExcelUtil=new ExportExcelUtil();
        exportExcelUtil.setClassName(SellpriceMaster.class.getName());
        //获得表头数据
        List<String> headList = new ArrayList<>();
        headList.add("商品编码");
        headList.add("商品名称");
        headList.add("商品名编码");
        headList.add("规格");
        headList.add("规格编码");
        headList.add("型号");
        headList.add("型号编码");
        headList.add("品牌");
        headList.add("品牌编码");
        headList.add("计价单位");
        headList.add("售价");
        headList.add("包装规格");
        headList.add("供应商编码");
        exportExcelUtil.setHeadList(headList);

        exportExcelUtil.exportExcel(list,outputStream,"商城上线价目表");
    }


    /**
     * 新增商城上线价目
     * @param sellpriceMaster
     * @return
     * @throws Exception
     */
    @Override
    public void createSellpriceMaster(SellpriceMaster sellpriceMaster) throws Exception {
        sellpriceMasterMapper.insertSelective(sellpriceMaster);
    }

    /**
     * 修改商城上线价目
     * @param sellpriceMaster
     * @return
     */
    @Override
    public void updateSellpriceMaster(SellpriceMaster sellpriceMaster) {
        sellpriceMasterMapper.updateByPrimaryKeySelective(sellpriceMaster);
    }

    /**
     * 批量删除商城上线价目
     * @param itemCodes
     * @return
     */
    @Override
    public void deleteSellpriceMaster(String[] itemCodes) {
        for (int i=0;i<itemCodes.length;i++){
            sellpriceMasterMapper.deleteByPrimaryKey(itemCodes[i]);
        }
    }

    /**
     * 删除一个
     * @param itemcode
     */
    @Override
    public void deleteOne(String itemcode) {
        sellpriceMasterMapper.deleteByPrimaryKey(itemcode);

    }

    /**
     * 统计总数
     * @return
     */
    @Override
    public long countByExample() {
        SellpriceMasterExample example = new SellpriceMasterExample();
        return sellpriceMasterMapper.countByExample(example);
    }
}
