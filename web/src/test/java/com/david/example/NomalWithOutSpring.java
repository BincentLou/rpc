package com.david.example;


import com.alibaba.fastjson.JSON;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @version $Id: null.java, v 1.0 2019/10/12 2:25 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
public class NomalWithOutSpring {

    public static void main(String[] args){

//        List<String> a= Arrays.asList("0000-00-00","0000-00-00","2030-07-11","2019-11-12");

//        test_streamSorted();
//        BigDecimal a = null;
//        if(a!=null&&a.compareTo(BigDecimal.ZERO)>0){
//            System.out.println("想哭");
//        }else {
//            System.out.println("还是想哭");
//        }
//
//        List<String> a = Arrays.asList("","0000-00","1992-10-11","2019-12-21","20191211");
//        List<String> b = a.stream().filter(item -> {
//            return !(StringUtils.isEmpty(item) || item.contains("0000"));
//        }).collect(Collectors.toList());
//        System.out.println(JSON.toJSONString(b));

        String d = "2021-01-02T09:13:33.550Z";

        Date dd = JSON.parseObject(d, Date.class);
        System.out.println(dd);
    }


    private static void test_streamSorted() {
        DateDemo b = new DateDemo("0000-00-00","b");
        DateDemo c = new DateDemo("0000-00-00","c");
        DateDemo d = new DateDemo("2030-07-11","d");
        DateDemo e = new DateDemo("2019-11-12","e");
        List<DateDemo> ar = Arrays.asList(b,c,d,e);
        List<DateDemo> nar = ar.stream().sorted((c1, c2) -> {
            return c2.getPrdt().compareTo(c1.getPrdt());
        }).collect(Collectors.toList());

        System.out.println(JSON.toJSONString(nar));
    }

    static public class DateDemo{

        public DateDemo(String prdt, String name) {
            this.prdt = prdt;
            this.name = name;
        }

        String prdt;
        String name;

        public String getPrdt() {
            return prdt;
        }

        public DateDemo setPrdt(String prdt) {
            this.prdt = prdt;
            return this;
        }

        public String getName() {
            return name;
        }

        public DateDemo setName(String name) {
            this.name = name;
            return this;
        }
    }
    private static void compareDate() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.set(Calendar.YEAR,2030);
        c.set(Calendar.MONTH,02);
        c.set(Calendar.DAY_OF_MONTH,01);
        Date busiDate = c.getTime();
        c.set(Calendar.MONTH,07);
        c.set(Calendar.DAY_OF_MONTH,11);
        Date endDate = c.getTime();
        System.out.println(busiDate.after(endDate));
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(df.format(busiDate));
        System.out.println(df.format(endDate));
    }

    public static BigDecimal defaultString2Money(String amount) {
        if (StringUtils.isEmpty(amount)) {
            throw new IllegalArgumentException("amount can not be null");
        } else {
            return string2Decimal(amount, 2, 1);
        }
    }


    public static BigDecimal string2Decimal(String amount, int newScale, int roundingMode) {
        if (amount == null) {
            throw new IllegalArgumentException("amount can not be null");
        } else if (newScale < 0) {
            throw new IllegalArgumentException("newScale can not less zero");
        } else if (roundingMode >= 0 && roundingMode <= 7) {
            return (new BigDecimal(amount)).setScale(newScale, roundingMode);
        } else {
            throw new IllegalArgumentException("Invalid rounding mode");
        }
    }

}
