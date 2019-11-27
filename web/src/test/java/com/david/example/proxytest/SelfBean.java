package com.david.example.proxytest;

/**
 * @version $Id: null.java, v 1.0 2019/10/28 10:30 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:本体bean
 * @since 1.0
 **/
public class SelfBean implements SelfInterface {
    private static Integer a =0;
    @Override
    public String getName() {

        System.out.println("selfBean");
        return "this is SelfBean";
    }

    @Override
    public Integer getNo() {
        synchronized (a){
            a++;
        }
        return a;
    }
}
