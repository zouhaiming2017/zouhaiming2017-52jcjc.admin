package com.jixi.controller;

import com.jixi.pojo.PickorderItem;
import com.jixi.pojo.PickorderItemRank;
import com.jixi.service.IPickorderItemService;
import com.jixi.utils.DoubleFormatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by zhm on 2017/11/22.
 */
@Controller
@RequestMapping("pickorderItem")
public class PickorderItemController {

    @Autowired
    private IPickorderItemService pickorderItemService;


    /**
     * 商品销售列表及模糊查询
     */
    @RequestMapping("/list")
    public String like(Model model,String pickdateMin,String pickdateMax,String supplier,String brandname,String itemname) throws ParseException {
        Map<String,Object> map=new HashMap();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");

        //商品编号未null
        map.put("itemcode",null);

        //获得供应商名
        if(supplier==null||supplier.equals("0")){
            supplier=null;
        }
        map.put("supplier",supplier);

        //获得品牌名
        if(brandname==null||brandname.equals("0")){
            brandname=null;
        }
        map.put("brandname",brandname);

         /*获得开始时间*/
        Date pickdateMin1=new Date();
        if(pickdateMin==null||"".equals(pickdateMin.replace(" ",""))){
            //若开始时间为空，则赋予时间2017-01-01
            pickdateMin="2017-01-01";
            pickdateMin1=format.parse(pickdateMin);
        }else {
            pickdateMin1=format.parse(pickdateMin);
        }
        map.put("pickdateMin",pickdateMin1);
        model.addAttribute("pickdateMin",pickdateMin1);


        /*获得结束时间*/
        Date pickdateMax2=new Date();
        if(pickdateMax==null||"".equals(pickdateMax.replace(" ",""))){
            //若结束时间为空，则赋予当前时间
            pickdateMax2=format.parse(format.format(pickdateMax2));
        }else {
            pickdateMax2=format.parse(pickdateMax);
        }
        map.put("pickdateMax",pickdateMax2);
        model.addAttribute("pickdateMax",pickdateMax2);

        //获得商品名
        String itemnameLike="";
        if(itemname==null||itemname.equals("")||itemname.equals(" ")) {
            itemnameLike = null;

        }else{
             itemnameLike="%"+itemname+"%";
        }
        map.put("itemname",itemnameLike);
        List<PickorderItem> pickorderItems=pickorderItemService.like(map);

        List<PickorderItem> suppliers=pickorderItemService.selectDistinctSupplier();
        List<PickorderItem> brandnames=pickorderItemService.selectDistinctBrandName();

        model.addAttribute("pickorderItems",pickorderItems);
        model.addAttribute("suppliers",suppliers);
        model.addAttribute("brandnames",brandnames);
        model.addAttribute("itemname",itemname);

        return "pickorderItem/list";
    }

    /**
     * 跳转导入页面
     */
    @RequestMapping(value = "/excelUpload")
    public String excelUpload(){
        return "pickorderItem/excelUpload";
    }

    /**
     * 将excel数据导入数据库
     * */
    @RequestMapping(value = "/importExcel")
    public String uploadExcel(@RequestParam("file")MultipartFile file) throws Exception {
        String fileName = "";//文件名
        if (file != null)
        {
            fileName = file.getOriginalFilename();
            if (fileName.endsWith(".xls") || fileName.endsWith(".xlsx"))
            {
                pickorderItemService.saveBath(file,file.getOriginalFilename()); //service实现方法
            }
        }
        return "redirect:/pickorderItem/list";
    }

    /**
     * 跳转新增页面
     */
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String add(){
        return "pickorderItem/add";
    }

    /**
     * 新增
     * @param pickorderItem
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String add(PickorderItem pickorderItem){
        pickorderItem.setSumprice(DoubleFormatUtil.getFormatSums(pickorderItem.getInprice()*pickorderItem.getCount()));
        pickorderItemService.add(pickorderItem);
        return "redirect:/pickorderItem/list";
    }

    /**
     * 跳转修改页面
     */
    @RequestMapping(value = "/update",method = RequestMethod.GET)
    public String update(String id,Model model){
        PickorderItem pickorderItem=pickorderItemService.selectOne(id);
        model.addAttribute("pickorderItem",pickorderItem);
        return "pickorderItem/update";
    }

    /**
     * 修改
     * @param pickorderItem
     * @return
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String update(PickorderItem pickorderItem){
        pickorderItem.setSumprice(DoubleFormatUtil.getFormatSums(pickorderItem.getInprice()*pickorderItem.getCount()));
        pickorderItemService.update(pickorderItem);
        return "redirect:/pickorderItem/list";
    }

    /**
     * 删除一个
     * @param id
     * @return
     */
    @RequestMapping(value = "/deleteOne")
    public String deleteOne(String id){
        pickorderItemService.deleteOne(id);
        return "redirect:/pickorderItem/list";
    }

    /**
     * 多个删除
     * @return
     */
    @RequestMapping(value = "/delete")
    public String delete(String ids){
        String[] ids1=ids.split(",");
        pickorderItemService.deletePickorderItem(ids1);
        return "redirect:/pickorderItem/list";
    }

    /**
     * 查询一个
     */
    @RequestMapping(value = "/detail")
    public String selectOne(String id,Model model){
        PickorderItem pickorderItem=pickorderItemService.selectOne(id);
        model.addAttribute("pickorderItem",pickorderItem);
        return "pickorderItem/detail";
    }


    /**
     * 导出数据到excel
     * @return
     */
    @RequestMapping(value = "/exportExcel")
    public String exportExcel(HttpServletResponse response, String ids) throws Exception {

        String[] codes=ids.split(",");


        response.reset();
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename="+ new String(("pickorderItem"+".xlsx").getBytes(), "utf-8"));

        ServletOutputStream out=response.getOutputStream();
        pickorderItemService.exportExcel(out,codes);

        return "redirect:/pickorderItem/list";
    }

    /**
     * 商品销售排行
     */
    @RequestMapping(value = "/ranking")
    public String itemSellRanking(String pickdateMin,String pickdateMax,Model model) throws ParseException {
        Map<String,Object> map=new HashMap();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        List<PickorderItemRank> pickorderItemRanks=new ArrayList<>();
        //获得所有商品编号
        List<PickorderItem> itemcodes=pickorderItemService.selectDistinctItemCode();
        for(PickorderItem p:itemcodes){
            //获得商品编码
            map.put("itemcode",p.getItemcode());
             /*获得开始时间*/
            if(pickdateMin==null||"".equals(pickdateMin.replace(" ",""))){
                //若开始时间为空，则赋予时间2017-01-01
                pickdateMin="2017-01-01";
                Date pickdateMin1=format.parse(pickdateMin);
                map.put("pickdateMin",pickdateMin1);
                model.addAttribute("pickdateMin",null);
            }else {
                Date selldateMin1=format.parse(pickdateMin);
                map.put("pickdateMin",selldateMin1);
                model.addAttribute("pickdateMin",selldateMin1);
            }

        /*获得结束时间*/
            if(pickdateMax==null||"".equals(pickdateMax.replace(" ",""))){
                //若结束时间为空，则赋予当前时间
                Date pickdateMax1=new Date();
                Date pickdateMax2=format.parse(format.format(pickdateMax1));

                map.put("pickdateMax",pickdateMax2);
                model.addAttribute("pickdateMax",pickdateMax2);
            }else {
                Date pickdateMax1=format.parse(pickdateMax);
                Calendar calendar=new GregorianCalendar();
                calendar.setTime(pickdateMax1);//设置起时间
                calendar.add(calendar.DATE,1);//把日期往后增加一天.整数往后推,负数往前移动
                Date pickdateMax2=calendar.getTime();

                map.put("pickdateMax",pickdateMax2);
                model.addAttribute("pickdateMax",pickdateMax1);
            }

            List<PickorderItem> pickorderItems=pickorderItemService.like(map);
            int counts=0;
            Double sumPrices=0.0;
            PickorderItemRank pickorderItemRank=new PickorderItemRank();
            for(PickorderItem pickorderItem:pickorderItems){
                pickorderItemRank.setItemcode(pickorderItem.getItemcode());
                pickorderItemRank.setItemname(pickorderItem.getItemname());
                pickorderItemRank.setStandard(pickorderItem.getStandard());
                pickorderItemRank.setModel(pickorderItem.getModel());
                pickorderItemRank.setBrandname(pickorderItem.getBrandname());
                pickorderItemRank.setPackingsize(pickorderItem.getPackingsize());
                pickorderItemRank.setChargeunit(pickorderItem.getChargeunit());
                pickorderItemRank.setCount(counts+=pickorderItem.getCount());
                pickorderItemRank.setSumprice(DoubleFormatUtil.getFormatSums(sumPrices+=pickorderItem.getSumprice()));
            }
            if(pickorderItemRank.getItemcode()==null){
                continue;
            }else {
                pickorderItemRanks.add(pickorderItemRank);
            }
        }
        model.addAttribute("pickorderItemRanks",pickorderItemRanks);

        return "pickorderItem/ranking";
    }

    /**
     * 导出商品排行数据到excel
     * @return
     */
    @RequestMapping(value = "/exportRankExcel")
    public String exportRankExcel(HttpServletResponse response, String itemcodes) throws Exception {
        String[] codes=itemcodes.split(",");

        response.reset();
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename="+ new String(("itemRanking"+".xlsx").getBytes(), "utf-8"));

        ServletOutputStream out=response.getOutputStream();
        pickorderItemService.exportRankExcel(out,codes);

        return "redirect:/pickorderItem/ranking";
    }
}
