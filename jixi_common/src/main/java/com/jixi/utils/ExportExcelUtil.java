package com.jixi.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import sun.java2d.pipe.Region;


public class ExportExcelUtil<M> {

    // 导入时排序List
    private List<Integer> sortList;

    // 导出时每行对应的表头名
    private List<String> headList;

    private String className;

    /**
     * 导入excel
     *
     * @param inputStream    excel表格的输入流
     * @return    实体类集合
     */
    public List<M> importExcel(InputStream inputStream) throws Exception {

        // 获取Sheet集合
        Workbook wb = WorkbookFactory.create(inputStream);
        if (!isEqual(wb)) {
            throw new Exception("当前excel的不同sheet数据格式不统一");
        }
        Iterator<Sheet> sheetIterator = wb.sheetIterator();
        List<M> masters = new ArrayList<>();

        // 循环遍历Sheet集合
        while (sheetIterator.hasNext()) {
            // 得到当前下一个sheet
            Sheet sheet = sheetIterator.next();
            // 获取读取的起始行
            int start = getStart(sheet);
            // 根据sheet最大行数进行循环
            for (int i = start; i<sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if (rowValid(row)) {
                    masters.add(voluation(row));
                }
            }
        }
        // 关闭输入流
        try {
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return masters;
    }

    /**
     * 导出excel
     * @param list    实体类集合
     * @param outputStream    输出流
     */
    public void exportExcel(List<M> list, OutputStream outputStream,String sheetName) throws Exception
    {
        // 创建一个workbook 对应一个excel应用文件
        // 在workbook中添加一个sheet,对应Excel文件中的sheet
        Workbook workBook = new XSSFWorkbook();
        Sheet sheet = workBook.createSheet(sheetName);
        CellStyle headStyle = getHeadStyle(workBook);
        CellStyle bodyStyle = getBodyStyle(workBook);
        // 构建表头
        Row headRow = sheet.createRow(0);
        sheet.setColumnWidth(0,256*25);
        // 给表头赋值
        setHeadCell(headRow, headStyle);

        // 构建表体数据
        if (list != null && list.size() > 0) {
            for (int j = 0; j < list.size(); j++) {
                sheet.setColumnWidth(j+1,256*25);
                Row bodyRow = sheet.createRow(j + 1);
                M master = list.get(j);
                setBodyCell(master, bodyRow, bodyStyle);
            }

        }


        // 将workBook写入输出流
        try {
            workBook.write(outputStream);
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 判断workbook中所有的sheet中的数据格式是否统一
     * @param wb
     */
    private Boolean isEqual(Workbook wb) {
        // 定义阶段, 后续通过分词器进行实现

//    Iterator<Sheet> sheetIterator = wb.sheetIterator();
//    while (sheetIterator.hasNext()) {
//      Sheet sheet = sheetIterator.next();
//      Row row = sheet.getRow(0);
//      int cellNum = row.getLastCellNum();
//      String rowName = "";
//      System.out.println("sheet名字:" + sheet.getSheetName() + " ------- sheet宽度:" + cellNum);
//      for (int i=0; i<cellNum; i++) {
//        String name = POIUtil.getCellString1(row.getCell(i));
//        if (name != null)
//          rowName = rowName+(name.trim());
//      }
//      System.out.println(rowName+"-\t");
//    }

        return true;
    }

    /**
     * 通过一定的计算,得出从第几行开始读取
     *
     * @param sheet   当前sheet
     */
    private int getStart(Sheet sheet) {
        // 后续完善, 暂定第二行开始
        return 1;
    }

    /**
     * 确认当前行是否包含有效值
     *
     * @param row   当前行
     */
    private Boolean rowValid(Row row) {
        // 目前只判断:当前行的 第一个内容 是否为空,可完善
        return getCellString(row.getCell(0))!=null;
    }

    /**
     * 获取一个row的所有值
     *
     * @param row   当前行
     * @return    实体类
     */
    private M voluation(Row row) throws Exception{
        Class aClass = Class.forName(className);
        // 获取master实体类的所有属性值
        M master = (M)aClass.newInstance();
        Field[] fields = master.getClass().getDeclaredFields();

        // 遍历所有属性
        for (int j = 0; j < fields.length; j++) {
            String value = getCellString(row.getCell(sortList.get(j)));
            if (value != null) {
                String name = fields[j].getName(); // 获取属性的名字
                System.out.println("属性: " + name + "---值:" + value);
                name = name.substring(0, 1).toUpperCase() + name.substring(1);// 首字母大写
                String type = fields[j].getGenericType().toString(); // 获取属性的类型

                // 实体类属性暂且只有3种
                if (type.equals("class java.lang.String")) { // 如果type是类类型，则前面包含"class "，后面跟类名
                    // 获取当前实体的当前属性的set方法
                    Method m = master.getClass().getDeclaredMethod("set" + name, String.class);
                    // 调用setter方法
                    m.invoke(master, value);
                } else if (type.equals("class java.lang.Double")) {
                    Method m = master.getClass().getDeclaredMethod("set" + name, Double.class);
                    value = value.replace(" ","");
                    m.invoke(master, Double.parseDouble(value));
                } else if (type.equals("class java.lang.Integer")) {
                    Method m = master.getClass().getDeclaredMethod("set" + name, Integer.class);
                    value = value.replace(" ","");
                    m.invoke(master, Integer.parseInt(value));
                }
            }

        }
        return master;
    }

    /**
     * 获取cell的值
     */
    private String getCellString(Cell cell) {
        if (null == cell) {
            return null;
        }

        String cellValueStr = null;

        //根据类型获得值
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_NUMERIC: // 数字
                // 去掉Double的科学计算格式
                BigDecimal bg =new BigDecimal(cell.getNumericCellValue());
                cellValueStr = bg.toPlainString();
                break;
            case Cell.CELL_TYPE_STRING: // 字符串
                cellValueStr = cell.getStringCellValue();
                break;
            case Cell.CELL_TYPE_BLANK: // 空值
                break;
            case Cell.CELL_TYPE_ERROR: // 故障
            default:
                break;
        }

        return cellValueStr;
    }

    /**
     * 设置excel表的头
     * @param headRow     表头所属行
     * @param headStyle   表头样式
     */
    private void setHeadCell(Row headRow, CellStyle headStyle) {
        for (int i=0; i<headList.size(); i++) {
            Cell cell = headRow.createCell(i);
            cell.setCellStyle(headStyle);
            cell.setCellValue(headList.get(i));
        }
    }

    /**
     * 设置excel表的内容
     * @param master    实体类
     * @param row       表内容所属行
     * @param bodyStyle 表内容样式
     * @throws Exception
     */
    private void setBodyCell(M master, Row row, CellStyle bodyStyle) throws Exception{
        Field[] fields = master.getClass().getDeclaredFields();
        for (int j = 0; j < fields.length; j++) { // 遍历所有属性

            String value = null;
            String name = fields[j].getName();
            name = name.substring(0, 1).toUpperCase() + name.substring(1);// 首字母大写
            String type = fields[j].getGenericType().toString(); // 获取属性的类型

            if (type.equals("class java.lang.String")) {
                Method m = master.getClass().getDeclaredMethod("get" + name);
                value = (String)m.invoke(master);

            } else if (type.equals("class java.lang.Double")) {
                Method m = master.getClass().getDeclaredMethod("get" + name);
                Object o = (m.invoke(master));
                if (o != null) {
                    value = o.toString();
                }
            } else if (type.equals("class java.lang.Integer")) {
                Method m = master.getClass().getDeclaredMethod("get" + name);
                Object o = (m.invoke(master));
                if (o != null) {
                    value = o.toString();
                }
            } else if (type.equals("class java.util.Date")) {
                Method m = master.getClass().getDeclaredMethod("get" + name);
                Object o = (m.invoke(master));
                if (o != null) {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                    value=dateFormat.format(o);
                }
            }

            Cell cell = row.createCell(j);
            cell.setCellStyle(bodyStyle);
            cell.setCellValue(value);

        }
    }

    /**
     * 设置表头的单元格样式(复制黏贴的)
     *
     * @return
     */
    private CellStyle getHeadStyle(Workbook wb)
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
    private CellStyle getBodyStyle(Workbook wb)
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
        font.setFontHeight((short) 200);
        cellStyle.setFont(font);
        // 设置单元格边框为细线条
        cellStyle.setBorderLeft(CellStyle.BORDER_THIN);
        cellStyle.setBorderRight(CellStyle.BORDER_THIN);
        cellStyle.setBorderBottom(CellStyle.BORDER_THIN);
        cellStyle.setBorderTop(CellStyle.BORDER_THIN);
        return cellStyle;
    }

    public void setSortList(List<Integer> sortList) {
        this.sortList = sortList;
    }

    public void setHeadList(List<String> headList) {
        this.headList = headList;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setSortListSize(Integer length) {
        if (this.sortList == null) {
            this.sortList = new ArrayList<>();
        }
        for (int i=0; i<length; i++) {
            this.sortList.add(i);
        }
    }
}
