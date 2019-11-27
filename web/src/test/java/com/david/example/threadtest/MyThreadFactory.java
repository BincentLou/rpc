package com.david.example.threadtest;

/**
 * @version $Id: null.java, v 1.0 2019/11/5 10:13 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
public class MyThreadFactory {

    private static String ThreadNamePre = "David's Thread group";

    private static volatile int num = 0;
    public static Thread getThread(Runnable runnable){
        Thread a = new Thread(runnable,ThreadNamePre+num);
        num++;
        return a;
    }
}
