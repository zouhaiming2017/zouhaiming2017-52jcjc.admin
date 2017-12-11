package com.jixi.service.impl;

import com.jixi.mapper.PickpriceMasterMapper;
import com.jixi.mapper.SupplierMapper;
import com.jixi.pojo.PickpriceMaster;
import com.jixi.pojo.PickpriceMasterExample;
import com.jixi.pojo.Supplier;
import com.jixi.pojo.SupplierExample;
import com.jixi.service.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by zhm on 2017/8/29.
 */
@Service
public class SupplierService implements ISupplierService {

    @Autowired
    private SupplierMapper supplierMapper;

    @Autowired
    private PickpriceMasterMapper pickpriceMasterMapper;

    /**
     * 判断suppliercode是否存在于Supplier表
     * @param suppliercode
     * @return
     */
    public boolean isExist(String suppliercode) {
        try {
            Supplier supplier = supplierMapper.selectByPrimaryKey(suppliercode);
            if (supplier==null) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    /**
     * 判断suppliercode是否为空
     * */
    public boolean isNull(String suppliercode){
        if(suppliercode!=null&&!"".equals(suppliercode)){
            return true;
        }
        return false;
    }

    /**
     * 供应商列表查询
     * @return
     */
    @Override
    public List<Supplier> getSupplierList() {
        //执行查询
        SupplierExample example = new SupplierExample();
        List<Supplier> list = supplierMapper.selectByExample(example);

        return list;
    }

    /**
     * 去重查询所在地
     * @return
     */
    @Override
    public List<Supplier> selectDistinctAddress() {
        return supplierMapper.selectDistinctAddress();
    }

    /**
     * 去重查询供应类别
     * @return
     */
    @Override
    public List<Supplier> selectDistinctVip() {
        return supplierMapper.selectDistinctVip();
    }

    /**
     * 去重查询供应指数
     * @return
     */
    @Override
    public List<Supplier> selectDistinctSupplierIndex() {
        return supplierMapper.selectDistinctSupplierIndex();
    }

    /**
     * 模糊查询
     * @param map
     * @return
     */
    @Override
    public List<Supplier> like(Map map) {
        return supplierMapper.like(map);
    }

    /**
     * 从报价表更新数据
     */
    @Override
    public void updateByMasterTab() {
        //查询供应商报价表所有数据
        PickpriceMasterExample example = new PickpriceMasterExample();
        List<PickpriceMaster> list = pickpriceMasterMapper.selectByExample(example);
        //实例化Supplier接收信息
        Supplier supplier=new Supplier();
        for(PickpriceMaster p:list){
            String suppliercode=p.getSuppliercode();
            if(isNull(suppliercode)) {
                supplier.setSuppliercode(suppliercode);
                supplier.setSuppliername(p.getSupplier());
                if (!isExist(suppliercode)) {
                    //不存在就添加
                    supplierMapper.insertSelective(supplier);
                } else {
                    //存在就跳过
                    continue;

                }
            }


        }

    }

    /**
     * 查询一个
     * @param suppliercode
     * @return
     */
    @Override
    public Supplier selectOne(String suppliercode) {
        return supplierMapper.selectByPrimaryKey(suppliercode);
    }

    /**
     * 新增供应商
     * */
    @Override
    public void createSupplier(Supplier supplier) throws Exception {
        supplierMapper.insertSelective(supplier);

    }

    /**
     * 修改供应商
     * */
    @Override
    public void updateSupplier(Supplier supplier) throws Exception {
        supplierMapper.updateByPrimaryKeySelective(supplier);
    }

    /**
     * 删除供应商
     * */
    @Override
    public void deleteSupplier(String[] supplierCodes) {
        for (int i=0;i<supplierCodes.length;i++){
            supplierMapper.deleteByPrimaryKey(supplierCodes[i]);
        }
    }

    /**
     * 删除一个
     * @param suppliercode
     */
    @Override
    public void deleteOne(String suppliercode) {
        supplierMapper.deleteByPrimaryKey(suppliercode);
    }

    /**
     * 统计总数
     * @return
     */
    @Override
    public long countByExample() {
        SupplierExample example = new SupplierExample();
        return supplierMapper.countByExample(example);
    }
}
