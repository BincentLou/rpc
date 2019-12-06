package com.david.example.threadtest;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @version $Id: null.java, v 1.0 2019/11/5 10:06 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
public class MyRunnable implements Runnable{

    private static AtomicInteger a = new AtomicInteger(1);
    @Override
    public void run() {
        System.out.println("当前线程打断状态："+Thread.interrupted());
        System.out.println("当前线程打断状态："+Thread.interrupted());
        System.out.println(Thread.currentThread().getName()+"新的任务线程:"+a.getAndIncrement());
        try {
            Thread.sleep(1000);
            System.out.println("当前线程打断状态："+Thread.interrupted());
        } catch (InterruptedException e) {
            System.out.println("睡眠被打断");
            System.out.println("当前线程打断状态："+Thread.interrupted());
        }
    }
}
