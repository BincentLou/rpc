package com.david.example.threadtest;

/**
 * @version $Id: null.java, v 1.0 2019/11/10 10:18 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:
 * @since 1.0
 **/
public class CurrentRunnableTest {

    public static void main(String[] args){

        ResourceObj resourceObj = new ResourceObj();
        Runnable a =  new CurrentRunnable(resourceObj);
        Runnable b =  new CurrentRunnable(resourceObj);
        Thread ta =  new Thread(a);
        Thread tb = new Thread(b);
        ta.start();
//        System.out.println(Thread.currentThread().getName()+"准备打断ta的睡眠");
        tb.start();
//        try {
//            ta.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        ta.interrupt();
//        System.out.println(Thread.currentThread().getName()+"运行完毕");
    }

}
