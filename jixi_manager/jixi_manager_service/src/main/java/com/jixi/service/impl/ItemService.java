package com.jixi.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jixi.mapper.ItemMapper;
import com.jixi.mapper.PickpriceMasterMapper;
import com.jixi.mapper.SellpriceMasterMapper;
import com.jixi.pojo.*;
import com.jixi.service.IItemService;
import com.jixi.utils.DoubleFormatUtil;
import com.jixi.utils.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by zhm on 2017/8/21.
 */
@Service
public class ItemService implements IItemService {

    @Autowired
    private ItemMapper itemMapper;

    @Autowired
    private PickpriceMasterMapper pickpriceMasterMapper;

    @Autowired
    private SellpriceMasterMapper sellpriceMasterMapper;


    @Override
    public Item getItemByItemCode(String itemCode) {

		/*利用ID查询*/
//		itemMapper.selectByPrimaryKey(itemCode);

		/*利用模板对象查询*/
        ItemExample example = new ItemExample();
        ItemExample.Criteria criteria = example.createCriteria();
        criteria.andItemcodeEqualTo(itemCode);

        List<Item> items = itemMapper.selectByExample(example);
        if (items != null && items.size() > 0){
            Item item = items.get(0);
            System.out.println(item);
            return item;
        }

        return null;
    }


    /**
     * 商品列表查询
     * @return
     */

    @Override
    public List<Item> getItemList() {
        //执行查询
        ItemExample example = new ItemExample();
        List<Item> list = itemMapper.selectByExample(example);

        return list;
    }

    /**
     * 查询一个
     * @param itemcode
     * @return
     */
    @Override
    public Item selectOne(String itemcode) {
        return itemMapper.selectByPrimaryKey(itemcode);
    }

    /**
     * 去重复查询
     * @return
     */
    @Override
    public List<Item> selectDistinctSupplier() {
        return itemMapper.selectDistinctSupplier();
    }

    @Override
    public List<Item> selectDistinctBrandName() {
        return itemMapper.selectDistinctBrandName();
    }

    @Override
    public List<Item> like(Map map) {
        return itemMapper.like(map);
    }

    /**
     * 新增商品
     * @return
     */
    @Override
    public void createItem(Item item) throws Exception {
        // 商品状态, 1-正常, 2-下架, 3-删除
        item.setStatus((byte)1);
        item.setCreated(new Date());
        item.setUpdated(new Date());
        // 插入到数据库
        itemMapper.insertSelective(item);
    }

    /**
     * 修改商品
     * @return
     */
    @Override
    public void updateItem(Item item) {
        itemMapper.updateByPrimaryKeySelective(item);
    }


    /**
     * 批量删除
     * @param itemCodes
     * @return
     */
    @Override
    public void deleteItem(String[] itemCodes) {
        for (int i=0;i<itemCodes.length;i++){
            itemMapper.deleteByPrimaryKey(itemCodes[i]);
        }
    }

    /**
     * 删除一个
     * @param itemcode
     */
    @Override
    public void deleteOne(String itemcode) {
        itemMapper.deleteByPrimaryKey(itemcode);
    }

    /**
     * 导出
     * @param outputStream
     * @param itemcodes
     * @throws Exception
     */
    @Override
    public void exportExcel(OutputStream outputStream, String[] itemcodes) throws Exception {
        List<List<String>> stringList=new ArrayList<>();
        //创建表头内容
        List<String> headList = new ArrayList<>();
        headList.add("商品编码");
        headList.add("商品名称");
        headList.add("供应商");
        headList.add("规格");
        headList.add("型号");
        headList.add("品牌");
        headList.add("包装规格");
        headList.add("单位");
        headList.add("数量");
        //获得表尾数据
        List<String> tails=new ArrayList<>();
        int counts=0;
        for(String itemcode:itemcodes) {
            List<String> ss = new ArrayList<>();
            Item item=itemMapper.selectByPrimaryKey(itemcode);

            ss.add(item.getItemcode());
            ss.add(item.getItemname());
            ss.add(item.getSuppliername());
            ss.add(item.getStandard());
            ss.add(item.getModel());
            ss.add(item.getBrandname());
            ss.add(item.getPackingsize());
            ss.add(item.getChargeunit());
            ss.add(item.getCount()+"");

            counts+=item.getCount();

            stringList.add(ss);
        }
        tails.add("");
        tails.add("");
        tails.add("");
        tails.add("");
        tails.add("");
        tails.add(counts+"");

        ExcelUtil.outputToExcel(stringList,headList,tails,"商品库存表",outputStream);
    }

    /**
     * 判断itemCode是否存在于Item表
     * @param itemCode
     * @return
     */
    public boolean isExist(String itemCode) {
        try {
            Item item = itemMapper.selectByPrimaryKey(itemCode);
            if (item==null) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    /**
     * 判断itemCode是否存在于SellpriceMaster表
     * @param itemCode
     * @return
     */
    public boolean isExistInSellpriceMaster(String itemCode) {
        try {
            SellpriceMaster sellpriceMaster = sellpriceMasterMapper.selectByPrimaryKey(itemCode);
            if (sellpriceMaster==null) {
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
     * 统计总数
     * @return
     */
    @Override
    public long countByExample() {
        ItemExample example = new ItemExample();
        return itemMapper.countByExample(example);
    }

}
