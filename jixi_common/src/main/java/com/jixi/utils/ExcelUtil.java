package com.jixi.utils;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;
import org.junit.Test;

import javax.swing.plaf.synth.Region;
import java.io.*;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by SZJ on 2017/3/21.
 * 导入Excel表格并解析
 * 导出对象并存入Excel文件
 */
public class ExcelUtil {


    @Test
    public void test() throws Exception {

        /**
         * 导入测试
         */
        String fileInPath = "C:\\Users\\zhm\\Desktop\\10月订单汇总1\\10月订单汇总\\张波\\2017103116422868155影佳路-张波.xlsx";
        File inFile = new File(fileInPath);

        List<List<List<String>>> sss=readExcel(new FileInputStream(inFile),fileInPath,false);
//
//        for(List<String> list:sss.get(1)){
//            if(list.size()>=11){
//                int i=0;
//                for(String s:list){
//                    System.out.println(s+"-->"+i);
//                    i++;
//                }
//            }
//        }

        for(int i=0;i<sss.size();i++){
            for(int j=i;j<sss.get(i).size();j++){
                System.out.println(sss.get(i).get(j));
            }
        }
    }

    /**
     * 合并单元格按冒号分割取右边的值
     */
    public static String  splits(String s) throws Exception {
        s=s+" ";
        String[] kv=new String[2];
        if (s.indexOf("：") != -1) {
            kv = s.split("：");
//            if (kv.length != 2) {
//                throw new Exception("分割错误");
//            }
        } else if(s.indexOf(":") != -1){
            kv = s.split(":");
//            if (kv.length != 2) {
//                throw new Exception("分割错误");
//            }
        }else{
            kv[1]=s;
        }
        return kv[1];

    }


    /**
     * 读取Excel
     * 封装表格对象,返回一个List<List<List<String>>>类型的集合（合并单元格和非合并单元格分开存）
     * @param input  流对象
     * @param path   导入表格的名字
     * @return 数据集合
     */
    public static List<List<List<String>>> readExcel(InputStream input,String path,boolean isSellorder) throws Exception {
        //判断是否为Excel文件，不是则返回null
        if(!path.endsWith("xlsx") && !path.endsWith("xls")){
            return null;
        }else{
            //存有合并单元格行的集合、无合并单元格行集合
            List<List<List<String>>> twoLists=new ArrayList<>();
            //存有合并单元格行的集合
            List<List<String>> mergedLists = new ArrayList<List<String>>();
            //存无合并单元格行集合
            List<List<String>> lists = new ArrayList<List<String>>();

            boolean isE2007 = false; // 判断是否是excel2007格式
            if (path.endsWith("xlsx")) {
                isE2007 = true;
            }

            // 准备workbook
            // 同时支持Excel 2003、2007
            Workbook workbook = null;

            // 根据文件格式(2003或者2007)来初始化
            if (isE2007) {
                workbook = new XSSFWorkbook(input);
            } else {
                workbook = new HSSFWorkbook(input);
            }
           input.close();

            /**
             * 循环工作表（公司的配货表从第2个sheet开始，故numSheet = 1；最后一个sheet废表，故长度-1）
             */
            for (int numSheet = 1; numSheet < workbook.getNumberOfSheets() - 1; numSheet++) {
                //进行判断，如果是订单表，只读第一个sheet，若不是，从第二个sheet读
                if(isSellorder){
                    numSheet=0;
                }

                Sheet sheet = workbook.getSheetAt(numSheet);
                if (sheet == null) {
                    continue;
                }

                //存合并单元格内容集合
                List<String> mergedList = new ArrayList<String>();

                // 循环行
                for (int rowNum = 2; rowNum <= sheet.getLastRowNum(); rowNum++) {
                    Row row = sheet.getRow(rowNum);
                    if (row == null|| row.getLastCellNum()<10) {
                        continue;
                    }

                    // 将单元格中的内容存入集合
                    List<String> list = new ArrayList<String>();

                    Cell cell;
                    //循环列
                    for (int i = 0; i < row.getLastCellNum(); i++) {
                        cell = row.getCell(i);
                        if(cell==null){
                            continue;
                        }
//
                        //根据是否合并单元格读数据
                        if (isMergedRegion(sheet, rowNum, i)) {
                            //过滤合并单元格重复读取的内容（判断是否和前一合并单元格或上一合并单元格内容一样）
                            if (getMergedRegionValue(sheet, rowNum, i).equals(getMergedRegionValue(sheet, rowNum, i - 1)) || getMergedRegionValue(sheet, rowNum, i).equals(getMergedRegionValue(sheet, rowNum - 1, i))) {
                                continue;
                            }
                            mergedList.add(splits(getMergedRegionValue(sheet, rowNum, i)));
                        } else if (isMergedRegion(sheet, rowNum, i - 1) || isMergedRegion(sheet, rowNum, i + 1)) {
                            if("".equals(getCellValue(cell).replace(" ",""))){
                                continue;
                            }
//
                            mergedList.add(getCellValue(cell));
                        }else{
                            list.add(getCellValue(cell));
                        }
                    }
                    //将数据添加到集合
                    lists.add(list);
                }
                mergedLists.add(mergedList);

                //进行判断，如果是订单表，只读第一个sheet便退出循环
                if(isSellorder){
                    break;
                }

            }
            twoLists.add(mergedLists);
            twoLists.add(lists);
            return twoLists;

        }
    }



    /**
     * 获取合并单元格的值
     * @param sheet
     * @param row
     * @param column
     * @return
     */
    public static String getMergedRegionValue(Sheet sheet ,int row , int column){

        int sheetMergeCount = sheet.getNumMergedRegions();

        for(int i = 0 ; i < sheetMergeCount ; i++){
            CellRangeAddress ca = sheet.getMergedRegion(i);
            int firstColumn = ca.getFirstColumn();
            int lastColumn = ca.getLastColumn();
            int firstRow = ca.getFirstRow();
            int lastRow = ca.getLastRow();

            if(row >= firstRow && row <= lastRow){
                if(column >= firstColumn && column <= lastColumn){
                    Row fRow = sheet.getRow(firstRow);
                    Cell fCell = fRow.getCell(firstColumn);
                    return getCellValue(fCell) ;
                }
            }
        }
        return null ;
    }

    /**
     * 判断指定的单元格是否是合并单元格
     * @param sheet
     * @param row
     * @param column
     * @return
     */
    public static boolean isMergedRegion(Sheet sheet , int row , int column){

        int sheetMergeCount = sheet.getNumMergedRegions();

        for(int i = 0 ; i < sheetMergeCount ; i++ ){
            CellRangeAddress ca = sheet.getMergedRegion(i);
            int firstColumn = ca.getFirstColumn();
            int lastColumn = ca.getLastColumn();
            int firstRow = ca.getFirstRow();
            int lastRow = ca.getLastRow();

            if(row >= firstRow && row <= lastRow){
                if(column >= firstColumn && column <= lastColumn){
                    return true ;
                }
            }
        }
        return false ;
    }

    /**
     * 获取单元格的值
     * @param cell
     * @return
     */
    public static String getCellValue(Cell cell){

        if(cell == null) return "";

        if(cell.getCellType() == Cell.CELL_TYPE_STRING){   //字符串

            return cell.getStringCellValue();

        }else if(cell.getCellType() == Cell.CELL_TYPE_BOOLEAN){   //Boolean

            return String.valueOf(cell.getBooleanCellValue());

        }else if(cell.getCellType() == Cell.CELL_TYPE_FORMULA){   //公式
//            return cell.getCellFormula() ;
            return String.valueOf(cell.getCellFormula());

        }else if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC){   //数字
//            return String.valueOf((int)cell.getNumericCellValue());
            return String.valueOf(cell.getNumericCellValue());

        }else if(cell.getCellType() == Cell.CELL_TYPE_ERROR){   //故障

            return "非法字符";

        }
        return "";
    }


    /**
     * 将对象写入Excel表中
     */
    public static void outputToExcel(List<List<String>> stringList,List<String> headList,List<String> tails,String sheetName,OutputStream outputStream) throws IOException{

        // 创建一个Excel文件
        XSSFWorkbook workbook = new XSSFWorkbook();
        // 创建一个工作表
        XSSFSheet sheet = workbook.createSheet(sheetName);
        // 设置单元格格式居中
        CellStyle headStyle=getHeadStyle(workbook);
        CellStyle cellStyle = getBodyStyle(workbook);
        cellStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);

        //创建表头前三行
        getHeadRow(sheet,headList,cellStyle,sheetName);
        //设置表尾行
        getTailRow(stringList,sheet,headStyle,tails);

        // 添加表头第四行
        XSSFRow headRow3 =sheet.createRow(3);


        // 添加表头第四行内容
        XSSFCell xssfCell;
        for(int i = 0 ; i < headList.size() ; i++){
            xssfCell=headRow3.createCell(i);
            xssfCell.setCellValue(headList.get(i));
            xssfCell.setCellStyle(headStyle);
            sheet.setColumnWidth(i, 5000);
            sheet.setDefaultRowHeightInPoints(40);
        }

        // 添加数据内容
        for(int i = 0 ; i < stringList.size() ; i++){
            headRow3 = sheet.createRow(i+4);
            XSSFCell cell;
            for(int j = 0 ; j<stringList.get(i).size() ; j++){
                cell =  headRow3.createCell(j);
                cell.setCellValue(stringList.get(i).get(j));
                cell.setCellStyle(cellStyle);
            }
        }

        workbook.write(outputStream);

    }

    /**
     * 创建导出的表头前两行
     */
    public static void getHeadRow(XSSFSheet sheet,List<String> headList,CellStyle cellStyle,String SendRowName){
        // 添加表头第一行
        XSSFRow headRow1 =sheet.createRow(0);
        sheet.addMergedRegion(new CellRangeAddress(0,0,0,headList.size()-1));
        XSSFCell cell = headRow1.createCell(0);
        cell.setCellValue("集曦商城 51jcjc.com ");
        for (int i=1;i<headList.size();i++){
            headRow1.createCell(i);
            headRow1.createCell(i).setCellStyle(cellStyle);
        }
        // 添加表头第二行
        sheet.addMergedRegion(new CellRangeAddress(1,2,0,headList.size()-1));
        for(int j=1;j<=2;j++){
            XSSFRow headRow2 =sheet.createRow(j);
            XSSFCell cell2 = headRow2.createCell(0);
            if(j==1){
                cell2.setCellValue(SendRowName);
                cell2.setCellStyle(cellStyle); // 样式
            }
            for (int i=1;i<headList.size();i++){
                headRow2.createCell(i);
                headRow2.createCell(i).setCellStyle(cellStyle);
            }
        }
    }

    /**
     * 设置导出的尾行
     */
    public static void getTailRow(List<List<String>> stringList,XSSFSheet sheet,CellStyle cellStyle,List<String> tails){
        sheet.addMergedRegion(new CellRangeAddress(stringList.size()+4,stringList.size()+5,0,2));
        for(int i=0;i<=tails.size();i++){
            sheet.addMergedRegion(new CellRangeAddress(stringList.size()+4,stringList.size()+5,i+3,i+3));
        }
        //合并两行中的第一行
        XSSFRow tailRow=sheet.createRow(stringList.size()+4);
        XSSFCell cell = tailRow.createCell(0);
        //要合并的单元格
        cell.setCellValue("价格统计：");
        cell.setCellStyle(cellStyle);

        for(int i=1;i<=2;i++){
            cell= tailRow.createCell(i);
            cell.setCellStyle(cellStyle);
        }
        //不合并的单元格
        for(int i=3;i<stringList.get(0).size();i++){
            cell= tailRow.createCell(i);
            cell.setCellValue(tails.get(i-3));
            cell.setCellStyle(cellStyle);
        }

        //合并两行中的第二行
        XSSFRow tailRow2=sheet.createRow(stringList.size()+5);
        for(int i=0;i<stringList.get(0).size();i++){
            XSSFCell cell2 = tailRow2.createCell(i);
            cell2.setCellStyle(cellStyle);
        }
    }


    /**
     * 设置表头的单元格样式(复制黏贴的)
     *
     * @return
     */
    private static CellStyle getHeadStyle(Workbook wb)
    {
        // 创建单元格样式
        CellStyle cellStyle = wb.createCellStyle();
        // 设置单元格的背景颜色为淡蓝色
        cellStyle.setFillForegroundColor(HSSFColor.PALE_BLUE.index);
        cellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        // 设置单元格居中对齐
        cellStyle.setAlignment(CellStyle.ALIGN_CENTER);

        // 设置单元格垂直居中对齐
        cellStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        // 创建单元格内容显示不下时自动换行
        cellStyle.setWrapText(true);
        // 设置单元格字体样式
        Font font = wb.createFont();
        // 设置字体加粗
        font.setBoldweight(Font.BOLDWEIGHT_BOLD);
        font.setFontName("宋体");
        font.setFontHeight((short) 200);
        cellStyle.setFont(font);
        // 设置单元格边框为细线条
        cellStyle.setBorderLeft(CellStyle.BORDER_THIN);
        cellStyle.setBorderRight(CellStyle.BORDER_THIN);
        cellStyle.setBorderBottom(CellStyle.BORDER_THIN);
        cellStyle.setBorderTop(CellStyle.BORDER_THIN);
        return cellStyle;
    }

    /**
     * 设置表体的单元格样式(复制黏贴的)
     *
     * @return
     */
    private static CellStyle getBodyStyle(Workbook wb)
    {
        // 创建单元格样式
        CellStyle cellStyle = wb.createCellStyle();
        // 设置单元格居中对齐
        cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
        // 设置单元格垂直居中对齐
        cellStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        // 创建单元格内容显示不下时自动换行
        cellStyle.setWrapText(true);
        // 设置单元格字体样式
        Font font = wb.createFont();
        // 设置字体加粗
        font.setBoldweight(Font.BOLDWEIGHT_BOLD);
        font.setFontName("宋体");
        font.setFontHeight((short) 180);
        cellStyle.setFont(font);
        // 设置单元格边框为细线条
        cellStyle.setBorderLeft(CellStyle.BORDER_THIN);
        cellStyle.setBorderRight(CellStyle.BORDER_THIN);
        cellStyle.setBorderBottom(CellStyle.BORDER_THIN);
        cellStyle.setBorderTop(CellStyle.BORDER_THIN);
        return cellStyle;
    }


    @Test
    public void test2() throws IOException {
        String s="1.25";
        Double a=Double.parseDouble(s.substring(0,4));
        System.out.println(a);
//        List<List<String>> stringList=new ArrayList<>();
//
//        //创建表头内容
//        List<String> headList = new ArrayList<>();
//        headList.add("工段名称");
//        headList.add("工段编码");
//        for(int i=0;i<2;i++){
//            List<String> ss=new ArrayList<>();
//            ss.add("2");
//            ss.add("19999999");
//            stringList.add(ss);
//        }
//        OutputStream out = new FileOutputStream("G://aaa.xlsx");
//        outputToExcel(stringList,headList,"订单表",out,);
    }
}
