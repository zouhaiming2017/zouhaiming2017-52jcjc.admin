package com.jixi.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ComplexExcelUtil<M> {

  private String className;

  FormulaEvaluator evaluator;

  private String contactInfo;

  private String title;

  private Map<String, String> mapping;

  private Map<String, String> price;

  private Map<String, String> tail;

  /**
   * 导入excel-配货订单表
   *
   * @param inputStream excel表格的输入流
   * @return 实体类集合
   */
  public List<M> importPickExcel(InputStream inputStream) throws Exception {

    // 获取Sheet集合
    Workbook wb = WorkbookFactory.create(inputStream);
    setEvaluator(wb.getCreationHelper().createFormulaEvaluator());

    Iterator<Sheet> sheetIterator = wb.sheetIterator();
    List<M> masters = new ArrayList<>();

    // 循环遍历Sheet集合
    for(int sheetNum = 1;sheetNum < wb.getNumberOfSheets()-1;sheetNum++){
      //获得当前sheet工作表
      Sheet sheet = wb.getSheetAt(sheetNum);
      if(sheet == null){
        continue;
      }
      Class aClass = Class.forName(className);
      M master = (M) aClass.newInstance();

      setBaseInfo(master, getBaseInfo(sheet));
      setPriceInfo(master, getPriceInfo(sheet));
      if (tail != null) {
        setTailInfo(master, getTailInfo(sheet));
      }

      masters.add(master);

    }
//    // 循环遍历Sheet集合
//    while (sheetIterator.hasNext()) {
//      // 得到当前下一个sheet
//      Sheet sheet = sheetIterator.next();
//
//      Class aClass = Class.forName(className);
//      M master = (M) aClass.newInstance();
//
//      setBaseInfo(master, getBaseInfo(sheet));
//      setPriceInfo(master, getPriceInfo(sheet));
//      if (tail != null) {
//        setTailInfo(master, getTailInfo(sheet));
//      }
//
//      masters.add(master);
//    }
    // 关闭输入流
    try {
      inputStream.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return masters;
  }


  /**
   * 导入excel-客户订单表
   *
   * @param inputStream excel表格的输入流
   * @return 实体类集合
   */
  public List<M> importSellExcel(InputStream inputStream) throws Exception {
    // 获取Sheet集合
    Workbook wb = WorkbookFactory.create(inputStream);
    setEvaluator(wb.getCreationHelper().createFormulaEvaluator());

    Iterator<Sheet> sheetIterator = wb.sheetIterator();
    List<M> masters = new ArrayList<>();

    //获得第一个sheet工作表
    Sheet sheet = wb.getSheetAt(0);

    Class aClass = Class.forName(className);
    M master = (M) aClass.newInstance();

    setBaseInfo(master, getBaseInfo(sheet));
    setPriceInfo(master, getPriceInfo(sheet));
    if (tail != null) {
      setTailInfo(master, getTailInfo(sheet));
    }

    masters.add(master);

    // 关闭输入流
    try {
      inputStream.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return masters;
  }

  private void setTailInfo(M master, List<String> tailInfo) throws Exception {
    for (String s : tailInfo) {
      String[] kv;
      if (s.indexOf(":") != -1) {
        kv = s.split(":");
        if (kv.length == 1) {
          String[] keyValue = new String[2];
          keyValue[0] = kv[0];
          keyValue[1] = null;
          kv = keyValue;
        } else if (kv.length != 2) {
          throw new Exception("分割错误");
        }
      } else {
        kv = s.split("：");
        if (kv.length == 1) {
          String[] keyValue = new String[2];
          keyValue[1] = null;
          keyValue[0] = kv[0];
          kv = keyValue;
        } else if (kv.length != 2) {
          throw new Exception("分割错误");
        }
      }

      String attribute = tail.get(kv[0]);
      attribute = attribute.substring(0, 1).toUpperCase() + attribute.substring(1);
      Method method = master.getClass().getDeclaredMethod("set" + attribute, String.class);
      method.invoke(master, kv[1]);
    }
  }

  private void setPriceInfo(M master, Map<String, Double> priceInfo) throws Exception {
    Set<String> keySet = priceInfo.keySet();
    for (String s : keySet) {
      String attribute = price.get(s);
      attribute = attribute.substring(0, 1).toUpperCase() + attribute.substring(1);
      Method method = master.getClass().getDeclaredMethod("set" + attribute, Double.class);
      method.invoke(master, priceInfo.get(s));
    }
  }

  private void setBaseInfo(M master, List<String> baseInfo) throws Exception {
    for (String s : baseInfo) {
      String[] kv;
      if (s.indexOf("：") != -1) {
        kv = s.split("：");
        if (kv.length != 2) {
          throw new Exception("分割错误");
        }
      } else {
        kv = s.split(":");
        if (kv.length != 2) {
          throw new Exception("分割错误");
        }
      }

      String attribute = mapping.get(kv[0]);
      attribute = attribute.substring(0, 1).toUpperCase() + attribute.substring(1);
      if (kv[1].matches("\\d{4}-\\d{2}-\\d{2}")) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(kv[1]);
        Method method = master.getClass().getDeclaredMethod("set" + attribute, Date.class);
        method.invoke(master, date);
      } else {
        Method method = master.getClass().getDeclaredMethod("set" + attribute, String.class);
        method.invoke(master, kv[1]);
      }
    }
  }

  private Map<String, Double> getPriceInfo(Sheet sheet) {
    // 获取读取的起始行
    int start = getBaseInfoEnd();
    int end = getPriceEnd();
    Map<String, Double> priceInfo = new LinkedHashMap<>();
    // 根据sheet最大行数进行循环
    for (int i = start; i < end; i++) {
      Row row = sheet.getRow(i);
      priceInfo.putAll(getOnePrice(row));
    }
    return priceInfo;
  }

  private Map<String, Double> getOnePrice(Row row) {
    List<Object> list = new ArrayList();
    String key;
    Double value;
    Map<String, Double> map = new LinkedHashMap<>();
    for (int i = 0; i < row.getLastCellNum(); i++) {
      String data = getCellString(row.getCell(i));
      if (data != null && !"".equals(data.trim())) {
        list.add(data);
      }
    }
    key = (String) list.get(0);
    value = Double.parseDouble((String) list.get(1));
    map.put(key, value);
    return map;
  }

  private List<String> getBaseInfo(Sheet sheet) throws Exception {
    // 获取读取的起始行
    int start = getBaseInfoStart();
    int end = getBaseInfoEnd();
    List<String> baseInfo = new ArrayList<>();
    // 根据sheet最大行数进行循环
    for (int i = start; i < end; i++) {
      Row row = sheet.getRow(i);
      baseInfo.addAll(voluation(row));
    }
    return baseInfo;
  }

  private List<String> getTailInfo(Sheet sheet) throws Exception {
    int start = getPriceEnd();
    int end = getTailEnd();
    List<String> tailInfo = new ArrayList<>();
    for (int i = start; i < end; i++) {
      Row row = sheet.getRow(i);
      tailInfo.addAll(voluation(row));
    }
    return tailInfo;
  }

  private Integer getBaseInfoStart() {
    // 后续完善, 暂定第二行开始
    return 2;
  }

  private Integer getBaseInfoEnd() {
    Integer end = mapping.size() / 2;
    Integer size = mapping.size() % 2 == 0 ? end : end + 1;
    return size + getBaseInfoStart();
  }

  private Integer getPriceEnd() {
    return price.size() + getBaseInfoEnd();
  }

  private Integer getTailEnd() {
    if (tail != null) {
      Integer end = tail.size() / 2;
      Integer size = tail.size() % 2 == 0 ? end : (end + 1);
      return size + getPriceEnd();
    } else {
      return getPriceEnd();
    }
  }

  /**
   * 导出excel
   *
   * @param list 实体类集合
   * @param outputStream 输出流
   */
  public void exportExcel(List<M> list, OutputStream outputStream) throws Exception {
    Workbook workbook = new XSSFWorkbook();
    for (int j = 0; j < list.size(); j++) {
      M master = list.get(j);
      Sheet sheet = workbook.createSheet("测试创建格式"+j);
      CellStyle cellStyle = workbook.createCellStyle();

      Font fontStyle = workbook.createFont(); // 字体样式
      fontStyle.setBold(true); // 加粗
      fontStyle.setFontName("黑体"); // 字体
      fontStyle.setFontHeightInPoints((short) 11); // 大小
      cellStyle.setFont(fontStyle);

      Font fontStyle_2 = workbook.createFont(); // 字体样式
      fontStyle_2.setBold(true); // 加粗
      fontStyle_2.setFontName("黑体"); // 字体
      fontStyle_2.setFontHeightInPoints((short) 15); // 大小

      // 居中样式
      CellStyle cellStyle_2 = workbook.createCellStyle();
      cellStyle_2.setVerticalAlignment(CellStyle.VERTICAL_CENTER);//垂直
      cellStyle_2.setAlignment(CellStyle.ALIGN_CENTER);
      cellStyle_2.setFont(fontStyle_2);

//    CellStyle cellStyle = workbook.createCellStyle();
      Row row_1 = sheet.createRow(0);
      Cell cell_1 = row_1.createCell(0);
      cell_1.setCellStyle(cellStyle);
      cell_1.setCellValue(contactInfo);
      Row row_2 = sheet.createRow(1);
      row_2.setHeight((short) 450);
      Cell cell_2 = row_2.createCell(0);
      cell_2.setCellValue(title);
      cell_2.setCellStyle(cellStyle_2);

//      Map<String, String> map = getMapping();
      Iterator<String> iterator = mapping.keySet().iterator();
      for (int i = 2; i < getBaseInfoEnd(); i++) {
        Row row = sheet.createRow(i);

        Cell cell_3 = row.createCell(0);
        String key1 = iterator.next();
        String attrbute = mapping.get(key1);
        attrbute = attrbute.substring(0, 1).toUpperCase() + attrbute.substring(1);
        Method m = master.getClass().getDeclaredMethod("get" + attrbute);
        String value = (String) m.invoke(master);
        cell_3.setCellValue(key1 + "：" + value);
        cell_3.setCellStyle(cellStyle);

        Cell cell_4 = row.createCell(8);
        String key2 = iterator.next();
        String attr = mapping.get(key2);
        attr = attr.substring(0, 1).toUpperCase() + attr.substring(1);
        Method method = master.getClass().getDeclaredMethod("get" + attr);
        Object value_2 = method.invoke(master);
        if (value_2 instanceof String) {
          cell_4.setCellValue(key2 + "：" + (String) value_2);
        } else {
          SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
          cell_4.setCellValue(key2 + "：" + sdf.format((Date) value_2));
        }
        cell_4.setCellStyle(cellStyle);
      }

      // 居左
      CellStyle cellStyle_3 = workbook.createCellStyle();
      cellStyle_3.setAlignment(CellStyle.ALIGN_LEFT);// 水平方向的对齐方式
      cellStyle_3.setVerticalAlignment(CellStyle.VERTICAL_CENTER);// 垂直方向的对齐方式
      cellStyle_3.setFont(fontStyle);
      // 居右
      CellStyle cellStyle_4 = workbook.createCellStyle();
      cellStyle_4.setAlignment(CellStyle.ALIGN_RIGHT);// 水平方向的对齐方式
      cellStyle_4.setVerticalAlignment(CellStyle.VERTICAL_CENTER);// 垂直方向的对齐方式
      cellStyle_4.setFont(fontStyle);

//      Map<String, String> mapPrice = getPrice();
      Iterator<String> iteratorPrice = price.keySet().iterator();
      for (int i = getBaseInfoEnd(); i < getPriceEnd(); i++) {
        String priceKey = iteratorPrice.next();
        Row row = sheet.createRow(i);
        Cell cell_3 = row.createCell(0);
        cell_3.setCellValue(priceKey);
        cell_3.setCellStyle(cellStyle_4);
        Cell cell_4 = row.createCell(8);
        String attr = price.get(priceKey);
        attr = attr.substring(0, 1).toUpperCase() + attr.substring(1);
        Method method = master.getClass().getDeclaredMethod("get" + attr);
        cell_4.setCellValue((Double) method.invoke(master));
        cell_4.setCellStyle(cellStyle_3);
      }

      // 设置尾部的值
      if (tail != null) {
//        Map<String, String> tail = getTail();
        Iterator<String> tailIterator = tail.keySet().iterator();
        for (int i = getPriceEnd(); i < getTailEnd(); i++) {
          Row row = sheet.createRow(i);
          Cell cell_3 = row.createCell(0);
          String key1 = tailIterator.next();
          String attrbute = tail.get(key1);
          attrbute = attrbute.substring(0, 1).toUpperCase() + attrbute.substring(1);
          Method m = master.getClass().getDeclaredMethod("get" + attrbute);
          String value = (String) m.invoke(master);
          cell_3.setCellValue(key1 + "：" + value);
          cell_3.setCellStyle(cellStyle);

          Cell cell_4 = row.createCell(8);
          String key2 = tailIterator.next();
          String attr = tail.get(key2);
          attr = attr.substring(0, 1).toUpperCase() + attr.substring(1);
          Method method = master.getClass().getDeclaredMethod("get" + attr);
          Object value_2 = method.invoke(master);
          cell_4.setCellValue(key2 + "：" + (String) value_2);
          cell_4.setCellStyle(cellStyle);
        }
      }

      for (int i = 0; i < 2; i++) {
        CellRangeAddress cra = new CellRangeAddress(i, i, 0, 12);
        // 使用RegionUtil类为合并后的单元格添加边框
        RegionUtil.setBorderBottom(1, cra, sheet, workbook); // 下边框
        RegionUtil.setBorderLeft(1, cra, sheet, workbook); // 左边框
        RegionUtil.setBorderRight(1, cra, sheet, workbook); // 有边框
        RegionUtil.setBorderTop(1, cra, sheet, workbook); // 上边框
        sheet.addMergedRegion(cra);
      }
      for (int i = 2; i < getTailEnd(); i++) {
        CellRangeAddress cra = new CellRangeAddress(i, i, 0, 7);
        CellRangeAddress cra_2 = new CellRangeAddress(i, i, 8, 12);
        // 使用RegionUtil类为合并后的单元格添加边框
        RegionUtil.setBorderBottom(1, cra, sheet, workbook); // 下边框
        RegionUtil.setBorderLeft(1, cra, sheet, workbook); // 左边框
        RegionUtil.setBorderRight(1, cra, sheet, workbook); // 有边框
        RegionUtil.setBorderTop(1, cra, sheet, workbook); // 上边框
        RegionUtil.setBorderBottom(1, cra_2, sheet, workbook); // 下边框
        RegionUtil.setBorderLeft(1, cra_2, sheet, workbook); // 左边框
        RegionUtil.setBorderRight(1, cra_2, sheet, workbook); // 有边框
        RegionUtil.setBorderTop(1, cra_2, sheet, workbook); // 上边框
        sheet.addMergedRegion(cra);
        sheet.addMergedRegion(cra_2);
      }
    }

    // 将workBook写入输出流
    try {
      workbook.write(outputStream);
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

  private List<String> voluation(Row row) throws Exception {
    List<String> list = new ArrayList<>();
    for (int i = 0; i < row.getLastCellNum(); i++) {
      String data = getCellString(row.getCell(i));
      if (data != null && !"".equals(data.trim())) {
        list.add(data);
      }
    }
    return list;
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
//        BigDecimal bg =new BigDecimal(cell.getNumericCellValue());
        cellValueStr = ((Double) cell.getNumericCellValue()).toString();
        break;
      case Cell.CELL_TYPE_STRING: // 字符串
        cellValueStr = cell.getStringCellValue();
        break;
      case Cell.CELL_TYPE_BLANK: // 空值
        break;
      case Cell.CELL_TYPE_ERROR: // 故障
        break;
      case Cell.CELL_TYPE_FORMULA:
        cellValueStr = ((Double) evaluator.evaluate(cell).getNumberValue()).toString();
        break;
      default:
        break;
    }

    return cellValueStr;
  }


  public void setClassName(String className) {
    this.className = className;
  }

  public void setEvaluator(FormulaEvaluator evaluator) {
    this.evaluator = evaluator;
  }

  public void setMapping(Map<String, String> mapping) {
    this.mapping = mapping;
  }

  public void setPrice(Map<String, String> price) {
    this.price = price;
  }

  public void setTail(Map<String, String> tail) {
    this.tail = tail;
  }

  public void setContactInfo(String contactInfo) {
    this.contactInfo = contactInfo;
  }

  public void setTitle(String title) {
    this.title = title;
  }
}
