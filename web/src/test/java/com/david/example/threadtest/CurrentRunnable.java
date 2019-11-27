package com.david.example.threadtest;

/**
 * @version $Id: null.java, v 1.0 2019/11/10 10:22 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
public class CurrentRunnable implements Runnable {

    private ResourceObj resourceObj;

    public CurrentRunnable(ResourceObj resourceObj) {
        this.resourceObj = resourceObj;
    }

    @Override
    public void run() {

        resourceObj.getA();
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            System.out.println(Thread.currentThread().getName()+"休眠被打断");
//        }
        System.out.println(Thread.currentThread().getName()+"运行完毕");
    }
}
