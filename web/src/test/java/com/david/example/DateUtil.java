package com.david.example;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @version $Id: null.java, v 1.0 2019/10/18 10:13 AM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
public class DateUtil {


    /** 年 */
    public final static String YYYY = "yyyy";
    /** 月 */
    public final static String MM = "MM";
    /** 日 */
    public final static String DD = "dd";
    /** 年月 */
    public final static String YYYYMM = "yyyyMM";
    /** 年月日 */
    public final static String YYYYMMDD = "yyyyMMdd";
    /** 年月日时分秒 */
    public final static String YYYY_MM_DDHHMMSS = "yyyy-MM-dd HH:mm:ss";
    /** 年月日时分秒 */
    public final static String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

    public final static String DEFAULT_DATE_FORMAT = "yyyy/MM/dd";
    /** 时分秒 */
    public final static String HHMMSS = "HHmmss";
    /** 年-月-日 */
    public final static String YYYY_MM_DD = "yyyy-MM-dd";

    /**
     * 获取一天起始时间
     * @param bizDate
     * @return
     */
    public static Date getDayBegin(Date bizDate) {
        Calendar cale = Calendar.getInstance();
        cale.setTime(bizDate);
        cale.set(Calendar.HOUR_OF_DAY, 0);
        cale.set(Calendar.SECOND, 0);
        cale.set(Calendar.MINUTE, 0);
        cale.set(Calendar.MILLISECOND, 0);
        return cale.getTime();
    }

    /**
     * 当前日期格式化
     *
     * @param format
     * @return
     */
    public static String formatDate(String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date());
    }

    /**
     * 指定日期格式化
     *
     * @author huanglei17407
     * @param date
     * @param format
     * @return
     */
    public static String formatDate(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    /**
     * 获取系统时间
     *
     * @author huanglei17407
     * @return
     */
    public static Date getSystemTime() {
        return new Date();
    }

    /**
     * 字符串转日期
     *
     * @author huanglei17407
     * @param strDate
     * @return
     * @throws ParseException
     */
    public static Date parseDate(String strDate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(strDate);
        Date date = null;
        date = sdf.parse(strDate);
        return date;
    }

    /**
     * 字符串转日期
     * @param strDate
     * @param format
     * @return
     * @throws ParseException
     */
    public static Date parseDate(String strDate,String format) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date = null;
        date = sdf.parse(strDate);
        return date;
    }

    /**
     * 日期加指定天数
     *
     * @param day 天数
     * @return 返回相加后的日期
     */
    public static Date addDate(Date d, long day) {

        long time = d.getTime();
        day = day * 24 * 60 * 60 * 1000;
        time += day;
        return new Date(time);

    }

    /**
     * 日期加上多少月后的日期
     *
     * @param now
     * @param month
     * @return
     */
    public static Date dateAddMonth(Date now,int month){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        calendar.add(Calendar.MONTH, month);
        return calendar.getTime();
    }

    /**
     * 日期加上多少年后的日期
     *
     * @param now
     * @param year
     * @return
     */
    public static Date dateAddYear(Date now,int year){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        calendar.add(Calendar.YEAR, year);
        return calendar.getTime();
    }

    public static void main(String[] args){
        String a = "2020-06-30 16:22:15";
        Date now = new Date();
        try {
           Date b =  DateUtil.parseDate(a,"yyyy-MM-dd");
//            now = DateUtil.parseDate("2026-12-11",DateUtil.YYYY_MM_DD);
            System.out.println(DateUtil.formatDate(b,"yyyy-MM-dd"));
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
    }

}
