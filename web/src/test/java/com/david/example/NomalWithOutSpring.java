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
        String money = "000000000013227";
        if (StringUtils.isEmpty(money)) {

        } else if ((new BigDecimal(money)).compareTo(new BigDecimal("0")) == 0) {
        } else {
            String perMoney = money.substring(0, money.length() - 2);
            String aftMoney = money.substring(money.length() - 2);
            money = perMoney + "." + aftMoney;
            BigDecimal formatMoney = (new BigDecimal(money)).setScale(4, 4);
            System.out.println(formatMoney);
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
