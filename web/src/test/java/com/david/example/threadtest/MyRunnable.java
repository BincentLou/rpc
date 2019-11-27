package com.david.example.threadtest;

/**
 * @version $Id: null.java, v 1.0 2019/11/5 10:06 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
public class MyRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println("我是新的线程");
    }
}
