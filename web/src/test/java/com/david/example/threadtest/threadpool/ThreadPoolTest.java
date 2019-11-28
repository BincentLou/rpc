package com.david.example.threadtest.threadpool;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @version $Id: null.java, v 1.0 2019/11/27 9:51 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
public class ThreadPoolTest {
    private static final AtomicInteger i = new AtomicInteger(1);

    public static void main(String[] args){
        DemoThreadPool demoThreadPool = new DemoThreadPool(5,10,2);
        int a =0;
        while (a<100) {
            a++;
            demoThreadPool.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        System.out.println("线程睡眠被打断");
                    }
                    System.out.println("执行任务"+i.getAndIncrement());
                }
            });
        }
    }
}
