package com.david.example;

import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * @version $Id: null.java, v 1.0 2020/1/20 10:47 AM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
public class MoneyUtil {
    public static final String THOUSANDS_MONEY_FORMAT = ",###,##0.00";
    public static final String DEFAULT_MONEY_FORMAT = "#0.00";
    public static final String DEFAULT_RATE_FORMAT = "#0.#####";
    public static final String MAX_MONEY_FORMAT = "#0.####";
    public static final String MAX_RATE_FORMAT = "#0.######";
    private static final String UNIT = "万仟佰拾亿仟佰拾万仟佰拾元角分";
    private static final String DIGIT = "零壹贰叁肆伍陆柒捌玖";
    private static final double MAX_VALUE = 9.99999999999999E12D;
    private static final int DEFAULT_MONEY_SCALE = 2;
    private static final int DEFAULT_RATE_SCALE = 5;

    public MoneyUtil() {
    }

    public static String formatCoreMoney(String money) {
        if (StringUtils.isEmpty(money)) {
            return "0";
        } else if ((new BigDecimal(money)).compareTo(new BigDecimal("0")) == 0) {
            return "0";
        } else {
            String perMoney = money.substring(0, money.length() - 2);
            String aftMoney = money.substring(money.length() - 2);
            money = perMoney + "." + aftMoney;
            BigDecimal formatMoney = (new BigDecimal(money)).setScale(4, 4);
            return formatMoney.toString();
        }
    }

    public static String formatMoney(BigDecimal amount, String format) {
        if (amount == null) {
            throw new IllegalArgumentException("amount can not be null");
        } else {
            String formatName = "#0.00";
            if (format != null) {
                formatName = format;
            }

            DecimalFormat fmt = new DecimalFormat(formatName);
            return fmt.format(amount);
        }
    }

    public static BigDecimal defaultScaleMoney(BigDecimal amount) {
        if (amount == null) {
            throw new IllegalArgumentException("amount can not be null");
        } else {
            return amount.setScale(2, RoundingMode.DOWN);
        }
    }

    public static String defaultFormatMoney(BigDecimal amount) {
        if (amount == null) {
            throw new IllegalArgumentException("amount can not be null");
        } else {
            return formatMoney(amount, "#0.00");
        }
    }

    public static String thousandthFormatMoney(BigDecimal amount) {
        if (amount == null) {
            throw new IllegalArgumentException("amount can not be null");
        } else {
            return formatMoney(amount, ",###,##0.00");
        }
    }

    public static String defaultFormatRate(BigDecimal rate) {
        if (rate == null) {
            throw new IllegalArgumentException("amount can not be null");
        } else {
            return formatMoney(rate, "#0.#####");
        }
    }

    public static BigDecimal defaultScaleRate(BigDecimal rate) {
        if (rate == null) {
            throw new IllegalArgumentException("amount can not be null");
        } else {
            return rate.setScale(5, RoundingMode.DOWN);
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

    public static BigDecimal defaultString2Money(String amount) {
        if (StringUtils.isEmpty(amount)) {
            throw new IllegalArgumentException("amount can not be null");
        } else {
            return string2Decimal(amount, 2, 1);
        }
    }

    public static BigDecimal defaultString2Rate(String rate) {
        if (StringUtils.isEmpty(rate)) {
            throw new IllegalArgumentException("amount can not be null");
        } else {
            return string2Decimal(rate, 5, 1);
        }
    }

    public static String changeCH(BigDecimal money) {
        double v = money.doubleValue();
        if (v >= 0.0D && v <= 9.99999999999999E12D) {
            long l = Math.round(v * 100.0D);
            if (l == 0L) {
                return "零元整";
            } else {
                String strValue = l + "";
                int i = 0;
                int j = "万仟佰拾亿仟佰拾万仟佰拾元角分".length() - strValue.length();
                String rs = "";

                for(boolean isZero = false; i < strValue.length(); ++j) {
                    char ch = strValue.charAt(i);
                    if (ch == '0') {
                        isZero = true;
                        if ("万仟佰拾亿仟佰拾万仟佰拾元角分".charAt(j) == 20159 || "万仟佰拾亿仟佰拾万仟佰拾元角分".charAt(j) == 19975 || "万仟佰拾亿仟佰拾万仟佰拾元角分".charAt(j) == 20803) {
                            rs = rs + "万仟佰拾亿仟佰拾万仟佰拾元角分".charAt(j);
                            isZero = false;
                        }
                    } else {
                        if (isZero) {
                            rs = rs + "零";
                            isZero = false;
                        }

                        rs = rs + "零壹贰叁肆伍陆柒捌玖".charAt(ch - 48) + "万仟佰拾亿仟佰拾万仟佰拾元角分".charAt(j);
                    }

                    ++i;
                }

                if (!rs.endsWith("分")) {
                    rs = rs + "整";
                }

                rs = rs.replaceAll("亿万", "亿");
                return rs;
            }
        } else {
            return "参数非法!";
        }
    }
}
