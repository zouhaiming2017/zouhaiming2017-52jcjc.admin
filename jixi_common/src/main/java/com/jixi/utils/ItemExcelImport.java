package com.jixi.utils;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;
import org.junit.Test;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by zhm on 2017/11/22.
 */
public class ItemExcelImport {

    @Test
    public void test() throws Exception {

        /**
         * 导入测试
         */
        String fileInPath = "C:\\Users\\zhm\\Desktop\\10月订单汇总1\\10月订单汇总\\黄哲辉\\2017102210590968155中山北一路.xlsx";
        File inFile = new File(fileInPath);

        List<List<List<String>>>  sss=readExcel(new FileInputStream(inFile),fileInPath,false);
        for(List<List<String>> ss:sss){
            for(int i=3;i<ss.size()-7;i++){
//                System.out.println(ss.get(i));
                for(int j=0;j<ss.get(i).size();j++){
                    System.out.println((int)(Double.parseDouble(ss.get(i).get(8))));
                }
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
    public static List<List<List<String>>> readExcel(InputStream input, String path, boolean isSellorder) throws Exception {
        //判断是否为Excel文件，不是则返回null
        if(!path.endsWith("xlsx") && !path.endsWith("xls")){
            return null;
        }else{
            //存有合并单元格行的集合、无合并单元格行集合
            List<List<List<String>>> twoLists=new ArrayList<>();

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

                //存每个sheet内容集合
                List<List<String>> lists = new ArrayList<>();

                // 循环行
                for (int rowNum = 2; rowNum <= sheet.getLastRowNum(); rowNum++) {
                    Row row = sheet.getRow(rowNum);
                    if (row == null|| row.getLastCellNum()<10) {
                        continue;
                    }

                    //存每行内容集合
                    List<String> list=new ArrayList<>();

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
                            list.add(splits(getMergedRegionValue(sheet, rowNum, i)));
                        } else if (isMergedRegion(sheet, rowNum, i - 1) || isMergedRegion(sheet, rowNum, i + 1)) {
                            if("".equals(getCellValue(cell).replace(" ",""))){
                                continue;
                            }
//
                            list.add(getCellValue(cell));
                        }else{
                            list.add(getCellValue(cell));
                        }
                    }
                    lists.add(list);
                }

                //进行判断，如果是订单表，只读第一个sheet便退出循环
                if(isSellorder){
                    break;
                }
                //将数据添加到集合
                twoLists.add(lists);
            }

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
}
