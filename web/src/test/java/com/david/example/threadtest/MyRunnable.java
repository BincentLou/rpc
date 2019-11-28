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
        AtomicInteger b = new AtomicInteger(1);
        for(int i=0;i<5;i++){
            Runnable task = new Runnable() {

                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+"新的任务线程:"+a.getAndIncrement());
                }
            };
            task.run();
        }
    }
}
