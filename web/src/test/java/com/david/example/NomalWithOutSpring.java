package com.david.example;


import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @version $Id: null.java, v 1.0 2019/10/12 2:25 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
public class NomalWithOutSpring {

    public static void main(String[] args){
        String a = "[\"1\",\"2\"]";
        System.out.println(a.contains("1"));

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
