package com.jixi.service.impl;

import com.jixi.mapper.PickorderItemMapper;
import com.jixi.pojo.PickorderItem;
import com.jixi.pojo.PickorderItemExample;
import com.jixi.pojo.PickorderItemRank;
import com.jixi.pojo.PickorderSum;
import com.jixi.service.IPickorderItemService;
import com.jixi.utils.DoubleFormatUtil;
import com.jixi.utils.ExcelUtil;
import com.jixi.utils.ItemExcelImport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by zhm on 2017/11/22.
 */
@Service
public class PickorderItemService implements IPickorderItemService {

    @Autowired
    private PickorderItemMapper pickorderItemMapper;


    /**
     * 判断id是否存在
     *
     * @param id
     * @return
     */
    public boolean isExist(String id) {
        try {
            PickorderItem pickorderItem = pickorderItemMapper.selectByPrimaryKey(id);
            if (pickorderItem == null) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    /**
     * 判断id是否为空
     */
    public boolean isNull(String id) {
        if (id != null && !"".equals(id)) {
            return true;
        }
        return false;
    }



    /**
     * 导入excel数据
     * @param myFile
     * @param path
     * @throws Exception
     */
    @Override
    public void saveBath(MultipartFile myFile, String path) throws Exception {
        List<List<List<String>>> sss= ItemExcelImport.readExcel(myFile.getInputStream(),path,false);
        for(List<List<String>> ss:sss){
            for(int i=3;i<ss.size()-7;i++){
                PickorderItem pickorderItem=new PickorderItem();
                for(int j=0;j<ss.get(i).size();j++) {
                    if(ss.get(i).size()<12){
                        continue;
                    }
                    if(ss.get(i).get(1)==null || ss.get(i).get(1).equals("")){
                        continue;
                    }
                    //获得id
                    String id =ss.get(0).get(0).replace(" ","")+"-"+ss.get(i).get(1).replace(" ","");
                    if (isNull(id)) {
                        //获得供应商名
                        pickorderItem.setSuppliername(ss.get(0).get(1));
                        //获得购买时间
                        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                        SimpleDateFormat format2 = new SimpleDateFormat("yyyyMMdd");
                        String pickDate = format.format(format2.parse(ss.get(0).get(0).substring(0, 8)));
                        pickorderItem.setPickdate(format.parse(pickDate));

                        //获得其他数据
                        pickorderItem.setId(id);
                        pickorderItem.setItemcode(ss.get(i).get(1));
                        pickorderItem.setItemname(ss.get(i).get(2));
                        pickorderItem.setStandard(ss.get(i).get(3));
                        pickorderItem.setModel(ss.get(i).get(4));
                        pickorderItem.setBrandname(ss.get(i).get(5));
                        pickorderItem.setPackingsize(ss.get(i).get(6));
                        pickorderItem.setChargeunit(ss.get(i).get(7));
                        pickorderItem.setCount((int)Double.parseDouble(ss.get(i).get(8)));
                        pickorderItem.setInprice(DoubleFormatUtil.getFormatDouble(ss.get(i).get(9)));
                        pickorderItem.setSumprice(DoubleFormatUtil.getFormatSums(pickorderItem.getInprice() * pickorderItem.getCount()));
                        pickorderItem.setRemark(ss.get(i).get(11));

                        if (!isExist(id)) {
                            //不存在就添加
                            pickorderItemMapper.insertSelective(pickorderItem);
                        } else {
                            //存在就跳过
                            continue;
                        }
                    }
                }
            }
        }

    }

    /**
     * 查询数据列表
     * @return
     */
    @Override
    public List<PickorderItem> getPickorderItrems() {
        PickorderItemExample example=new PickorderItemExample();
        return pickorderItemMapper.selectByExample(example);
    }

    /**
     * 删除一个
     * @param id
     */
    @Override
    public void deleteOne(String id) {
        pickorderItemMapper.deleteByPrimaryKey(id);
    }

    /**
     * 删除多个
     * @param ids
     */
    @Override
    public void deletePickorderItem(String[] ids) {
        for(int i=0;i<ids.length;i++){
            pickorderItemMapper.deleteByPrimaryKey(ids[i]);
        }
    }

    /**
     * 新增
     * @param pickorderItem
     */
    @Override
    public void add(PickorderItem pickorderItem) {
        pickorderItemMapper.insertSelective(pickorderItem);
    }

    /**
     * 更新
     * @param pickorderItem
     */
    @Override
    public void update(PickorderItem pickorderItem) {
        pickorderItemMapper.updateByPrimaryKeySelective(pickorderItem);
    }

    /**
     * 查找一个
     * @param id
     * @return
     */
    @Override
    public PickorderItem selectOne(String id) {
        return pickorderItemMapper.selectByPrimaryKey(id);
    }

    /**
     * 去重复查询供应商
     * @return
     */
    @Override
    public List<PickorderItem> selectDistinctSupplier() {
        return pickorderItemMapper.selectDistinctSupplier();
    }

    /**
     * 去重复查询品牌名
     * @return
     */
    @Override
    public List<PickorderItem> selectDistinctBrandName() {
        return pickorderItemMapper.selectDistinctBrandName();
    }


    /**
     * 去重复查询商品编号
     * @return
     */
    @Override
    public List<PickorderItem> selectDistinctItemCode() {
        return pickorderItemMapper.selectDistinctItemCode();
    }

    /**
     * 模糊查询
     * @param map
     * @return
     */
    @Override
    public List<PickorderItem> like(Map map) {
        return pickorderItemMapper.like(map);
    }

    /**
     * 导出
     * @param outputStream
     * @param ids
     * @throws Exception
     */
    @Override
    public void exportExcel(OutputStream outputStream, String[] ids) throws Exception {
        List<List<String>> stringList=new ArrayList<>();
        //创建表头内容
        List<String> headList = new ArrayList<>();
        headList.add("序号");
        headList.add("商品编码");
        headList.add("材料名称");
        headList.add("规格");
        headList.add("型号");
        headList.add("品牌");
        headList.add("包装规格");
        headList.add("单位");
        headList.add("含税单价");
        headList.add("数量");
        headList.add("合价");
        //获得表尾数据
        List<String> tails=new ArrayList<>();
        int counts=0;
        Double sums=0.0;

        for(String id:ids) {
            List<String> ss = new ArrayList<>();
            PickorderItem pickorderItem=pickorderItemMapper.selectByPrimaryKey(id);

            ss.add(pickorderItem.getId());
            ss.add(pickorderItem.getItemcode());
            ss.add(pickorderItem.getItemname());
            ss.add(pickorderItem.getStandard());
            ss.add(pickorderItem.getModel());
            ss.add(pickorderItem.getBrandname());
            ss.add(pickorderItem.getPackingsize());
            ss.add(pickorderItem.getChargeunit());
            ss.add(pickorderItem.getInprice().toString());
            ss.add(pickorderItem.getCount()+"");
            ss.add(pickorderItem.getSumprice().toString());

            sums+=pickorderItem.getSumprice();
            counts+=pickorderItem.getCount();

            stringList.add(ss);
        }
        tails.add("");
        tails.add("");
        tails.add("");
        tails.add("");
        tails.add("");
        tails.add("");
        tails.add(counts+"");
        tails.add(DoubleFormatUtil.getFormatSums(sums)+"");

        ExcelUtil.outputToExcel(stringList,headList,tails,"商品配货表",outputStream);
    }

    /**
     * 导出到excel（商品销售排行）
     * @param outputStream
     * @param itemcodes
     * @throws Exception
     */
    @Override
    public void exportRankExcel(OutputStream outputStream, String[] itemcodes) throws Exception {
        List<List<String>> stringList=new ArrayList<>();
        //创建表头内容
        List<String> headList = new ArrayList<>();
        headList.add("商品编码");
        headList.add("材料名称");
        headList.add("规格");
        headList.add("型号");
        headList.add("品牌");
        headList.add("包装规格");
        headList.add("单位");
        headList.add("购买总量");
        headList.add("购买总价");
        //获得表尾数据
        List<String> tails=new ArrayList<>();
        Double sums=0.0;
        for(int i=0;i<itemcodes.length;i++) {
            List<String> ss = new ArrayList<>();
            List<PickorderItem> pickorderItems=pickorderItemMapper.selectByItemcode(itemcodes[i]);
            PickorderItemRank pickorderItemRank=new PickorderItemRank();
            int counts=0;
            Double sumPrices=0.0;

            for(PickorderItem pickorderItem:pickorderItems){
                pickorderItemRank.setItemcode(pickorderItem.getItemcode());
                pickorderItemRank.setItemname(pickorderItem.getItemname());
                pickorderItemRank.setStandard(pickorderItem.getStandard());
                pickorderItemRank.setModel(pickorderItem.getModel());
                pickorderItemRank.setBrandname(pickorderItem.getBrandname());
                pickorderItemRank.setPackingsize(pickorderItem.getPackingsize());
                pickorderItemRank.setChargeunit(pickorderItem.getChargeunit());
                pickorderItemRank.setCount(counts+=pickorderItem.getCount());
                pickorderItemRank.setSumprice(sumPrices+=pickorderItem.getSumprice());
            }
            if(pickorderItemRank.getItemcode()==null){
                continue;
            }else {
                ss.add(pickorderItemRank.getItemcode());
                ss.add(pickorderItemRank.getItemname());
                ss.add(pickorderItemRank.getStandard());
                ss.add(pickorderItemRank.getModel());
                ss.add(pickorderItemRank.getBrandname());
                ss.add(pickorderItemRank.getPackingsize());
                ss.add(pickorderItemRank.getChargeunit());
                ss.add(pickorderItemRank.getCount()+"");
                ss.add(DoubleFormatUtil.getFormatSums(pickorderItemRank.getSumprice()).toString());

                sums+=pickorderItemRank.getSumprice();
            }

            stringList.add(ss);
        }
        tails.add("");
        tails.add("");
        tails.add("");
        tails.add("");
        tails.add("");
        tails.add(DoubleFormatUtil.getFormatSums(sums)+"");

        ExcelUtil.outputToExcel(stringList,headList,tails,"商品销售排行表",outputStream);
    }
}
