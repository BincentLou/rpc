package com.david.example;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @version $Id: null.java, v 1.0 2019/10/18 10:13 AM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
public class DateUtil {
    public static final String YYYYMMDD = "yyyyMMdd";
    public static final String YYYY_MM_DD = "yyyy-MM-dd";

    public static void main(String[] args){
        ss(YYYY_MM_DD);
    }

    public static Date parseDate(String strDate, String format) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date = null;
        date = sdf.parse(strDate);
        return date;
    }

    public static Date parseDate(String strDate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(strDate);
        Date date = null;
        date = sdf.parse(strDate);
        return date;
    }

    public static String formatDate(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

      public static void ss(String format) {
        String a = "2019-10-10";
//        Date d = new Date(Long.valueOf(a));
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        SimpleDateFormat sdfd = new SimpleDateFormat("yyyyMMdd");
          try {
             Date ds =  sdf.parse(a);
             System.out.println(sdfd.format(ds));
          } catch (ParseException e) {
              e.printStackTrace();
          }
      }


}
