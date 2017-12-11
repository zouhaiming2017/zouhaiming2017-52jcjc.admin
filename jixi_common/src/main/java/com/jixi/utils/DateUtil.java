package com.jixi.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by zhm on 2017/11/8.
 */
public class DateUtil {

    public static Map<String,Date> getDates(String year,String month) throws ParseException {
        Map<String,Date> map=new HashMap();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat monthFormat=new SimpleDateFormat("yyyy-MM");

        if(year==null||month==null||"0".equals(year)||"0".equals(month)){
            month=monthFormat.format(new Date());
        }else {
            month=year.substring(0,4)+"-"+month.substring(0,2);
        }

        String startDate=month+"-01";

        Calendar calendar=new GregorianCalendar();
        calendar.setTime(monthFormat.parse(month));
        calendar.add(calendar.MONTH, 1);
        String endDate=monthFormat.format(calendar.getTime())+"-01";

        map.put("startDate",format.parse(startDate));
        map.put("endDate",format.parse(endDate));

        return map;
    }
}
