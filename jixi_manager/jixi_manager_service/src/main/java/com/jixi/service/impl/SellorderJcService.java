package com.jixi.service.impl;

import com.jixi.mapper.SellorderJcMapper;
import com.jixi.pojo.SellorderJc;
import com.jixi.pojo.SellorderJcExample;
import com.jixi.service.ISellorderJcService;
import com.jixi.utils.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by zhm on 2017/11/20.
 */
@Service
public class SellorderJcService implements ISellorderJcService {
    @Autowired
    private SellorderJcMapper sellorderJcMapper;

    /**
     * 判断sellordercode是否存在
     *
     * @param sellordercode
     * @return
     */
    public boolean isExist(String sellordercode) {
        try {
            SellorderJc sellorderJc = sellorderJcMapper.selectByPrimaryKey(sellordercode);
            if (sellorderJc == null) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    /**
     * 判断sellordercode是否为空
     */
    public boolean isNull(String sellordercode) {
        if (sellordercode != null && !"".equals(sellordercode)) {
            return true;
        }
        return false;
    }


    /**
     * 查询所有
     * @return
     */
    @Override
    public List<SellorderJc> getSellorderJcList() {
        SellorderJcExample example=new SellorderJcExample();
        return sellorderJcMapper.selectByExample(example);
    }

    /**
     * 新增
     */
    @Override
    public void addSellorderJc(SellorderJc sellorderJc) {
        sellorderJcMapper.insertSelective(sellorderJc);
    }

    /**
     * 查询一个
     * @param sellordercode
     */
    @Override
    public SellorderJc selectOne(String sellordercode) {
        return sellorderJcMapper.selectByPrimaryKey(sellordercode);
    }

    /**
     * 更新
     * @param sellorderJc
     */
    @Override
    public void updateSellorderJc(SellorderJc sellorderJc) {
        sellorderJcMapper.updateByPrimaryKeySelective(sellorderJc);
    }

    /**
     * 删除一个
     * @param sellordercode
     */
    @Override
    public void delectOne(String sellordercode) {
        sellorderJcMapper.deleteByPrimaryKey(sellordercode);
    }

    /**
     * 删除多个
     * @param sellordercode
     */
    @Override
    public void deleteSellorderJc(String[] sellordercode) {
        for (int i = 0; i < sellordercode.length; i++) {
            sellorderJcMapper.deleteByPrimaryKey(sellordercode[i]);
        }
    }

    /**
     * 导入集兮仓库订单
     * @param myFile
     * @param path
     * @throws Exception
     */
    @Override
    public void saveBath(MultipartFile myFile, String path) throws Exception {
        List<List<List<String>>> ss= ExcelUtil.readExcel(myFile.getInputStream(),path,true);
        for(List<String> list:ss.get(0)) {
            SellorderJc sellorderJc = new SellorderJc();
            //获得订单编号
            String sellordercode =list.get(0);
            //添加数据或更新
            if (isNull(sellordercode)) {
                sellorderJc.setSellordercode(list.get(0));
                sellorderJc.setMaketableman(list.get(1));
                sellorderJc.setProjectname(list.get(2));
                sellorderJc.setCompany(list.get(3));
                sellorderJc.setCustomername(list.get(4));
                sellorderJc.setCustomerphone(list.get(5));
                sellorderJc.setSellman(list.get(6));
                sellorderJc.setSendman(list.get(7));
                sellorderJc.setPickman(list.get(8));
                sellorderJc.setPickmanphone(list.get(9));
                sellorderJc.setAddress(list.get(10));
                sellorderJc.setSendtype(list.get(11));
                sellorderJc.setOnlinesum("".equals(list.get(13)) ? 0.00 : Double.parseDouble(list.get(13)));
                sellorderJc.setUnderlinesum("".equals(list.get(15)) ? 0.00 : Double.parseDouble(list.get(15)));
                sellorderJc.setFreight("".equals(list.get(17)) ? 0.00 : Double.parseDouble(list.get(17)));
                sellorderJc.setAllsum("".equals(list.get(19)) ? 0.00 : Double.parseDouble(list.get(19)));
                sellorderJc.setDiscountprice("".equals(list.get(21)) ? 0.00 : Double.parseDouble(list.get(21)));

                //获得时间
                String selldateStr = sellorderJc.getSellordercode().substring(0, 8);
                SimpleDateFormat format1 = new SimpleDateFormat("yyyyMMdd");
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                Date selldateDate = format1.parse(selldateStr);
                String selldate = format.format(selldateDate);
                sellorderJc.setSelldate(format.parse(selldate));
                //补充其它字段
                sellorderJc.setAllpaystatue("0");
                sellorderJc.setTicketstatus("0");

                if (!isExist(sellordercode)) {
                    //不存在就添加
                    sellorderJcMapper.insertSelective(sellorderJc);
                } else {
                    //存在就跳过
                    continue;
                }
            }

        }

    }

    /**
     * 导出集兮仓库订单
     * @param outputStream
     * @param sellordercodes
     * @throws Exception
     */
    @Override
    public void exportExcel(OutputStream outputStream, String[] sellordercodes) throws Exception {
        List<List<String>> stringList=new ArrayList<>();
        //创建表头内容
        List<String> headList = new ArrayList<>();
        headList.add("订单编号");
        headList.add("项目名称");
        headList.add("公司名称");
        headList.add("线上商品合计");
        headList.add("线下商品合计");
        headList.add("运费");
        headList.add("总计");
        //获得表尾数据
        List<String> tails=new ArrayList<>();
        Double onlineSums=0.0;
        Double underLineSums=0.0;
        Double freights=0.0;
        Double discountprices=0.0;

        for(int i=0;i<sellordercodes.length;i++) {
            List<String> ss = new ArrayList<>();
            SellorderJc sellorderJc=sellorderJcMapper.selectByPrimaryKey(sellordercodes[i]);

            ss.add(sellorderJc.getSellordercode());
            ss.add(sellorderJc.getProjectname());
            ss.add(sellorderJc.getCompany());
            ss.add(sellorderJc.getOnlinesum().toString());
            ss.add(sellorderJc.getUnderlinesum().toString());
            ss.add(sellorderJc.getFreight().toString());
            ss.add(sellorderJc.getDiscountprice().toString());

            onlineSums+=sellorderJc.getOnlinesum();
            underLineSums+=sellorderJc.getUnderlinesum();
            freights+=sellorderJc.getFreight();
            discountprices+=sellorderJc.getDiscountprice();

            stringList.add(ss);
        }
        tails.add(onlineSums.toString());
        tails.add(underLineSums.toString());
        tails.add(freights.toString());
        tails.add(discountprices.toString());

        ExcelUtil.outputToExcel(stringList,headList,tails,"集兮仓库订单表",outputStream);
    }

    /**
     * 去重复查询项目名
     * @return
     */
    @Override
    public List<SellorderJc> selectDistinctProjectname() {
        return sellorderJcMapper.selectDistinctProjectname();
    }


    /**
     * 去重复查询公司名
     * @return
     */
    @Override
    public List<SellorderJc> selectDistinctCompany() {
        return sellorderJcMapper.selectDistinctCompany();
    }

    /**
     * 去重复查询地址
     * @return
     */
    @Override
    public List<SellorderJc> selectDistinctAddress() {
        return sellorderJcMapper.selectDistinctAddress();
    }

    /**
     * 去重复查询客户名
     * @return
     */
    @Override
    public List<SellorderJc> selectDistinctCustomerName() {
        return sellorderJcMapper.selectDistinctCustomerName();
    }

    /**
     * 去重复查询业务员
     * @return
     */
    @Override
    public List<SellorderJc> selectDistinctSellman() {
        return sellorderJcMapper.selectDistinctSellman();
    }

    /**
     * 去重复查询客户类型
     * @return
     */
    @Override
    public List<SellorderJc> selectDistinctCustomerType() {
        return sellorderJcMapper.selectDistinctCustomerType();
    }

    /**
     * 去重复查询客户手机号
     * @return
     */
    @Override
    public List<SellorderJc> selectDistinctCustomerPhone() {
        return sellorderJcMapper.selectDistinctCustomerPhone();
    }

    /**
     * 模糊查询
     * @param map
     * @return
     */
    @Override
    public List<SellorderJc> like(Map map) {
        return sellorderJcMapper.like(map);
    }

    /**
     * 价格汇总
     * @param list
     * @return
     */
    @Override
    public Map<String, Double> countSums(List<SellorderJc> list) {
        Map<String,Double> map=new HashMap<String,Double>();
        Double onlineSums=0.0;
        Double underlineSums=0.0;
        Double freights=0.0;
        Double commissions=0.0;
        Double discountprices=0.0;
        Double receivedsums=0.0;
        Double noReceivedsums=0.0;

        for(SellorderJc sellorderJc:list){
            if(sellorderJc.getCommission()==null){
                sellorderJc.setCommission(0.00);
            }
            if(sellorderJc.getDiscountprice()==null){
                sellorderJc.setDiscountprice(sellorderJc.getAllsum());
            }
            if(sellorderJc.getReceivedsum()==null){
                sellorderJc.setReceivedsum(0.0);
            }
            sellorderJc.setNoreceivedsum(sellorderJc.getDiscountprice()-sellorderJc.getReceivedsum());
            sellorderJcMapper.updateByPrimaryKeySelective(sellorderJc);

            onlineSums+=sellorderJc.getOnlinesum();
            underlineSums+=sellorderJc.getUnderlinesum();
            freights+=sellorderJc.getFreight();
            commissions+=sellorderJc.getCommission();
            discountprices+=sellorderJc.getDiscountprice();
            receivedsums+=sellorderJc.getReceivedsum();
            noReceivedsums+=sellorderJc.getNoreceivedsum();
        }
        map.put("onlineSums",onlineSums);
        map.put("underlineSums",underlineSums);
        map.put("freights",freights);
        map.put("allSums",onlineSums+underlineSums+freights);
        map.put("commissions",commissions);
        map.put("discountprices",discountprices);
        map.put("receivedsums",receivedsums);
        map.put("noReceivedsums",noReceivedsums);

        return map;
    }
}
