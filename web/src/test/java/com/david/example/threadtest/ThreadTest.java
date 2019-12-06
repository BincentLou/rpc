package com.david.example.threadtest;

/**
 * @version $Id: null.java, v 1.0 2019/11/5 10:16 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
public class ThreadTest {
    public static void main(String[] args){
        Runnable runnable = new MyRunnable();
//        for (int i=0;i<10;i++){
            Thread thread = MyThreadFactory.getThread(runnable);
            thread.start();
            Thread b = MyThreadFactory.getThread(new Runnable() {
                @Override
                public void run() {
                   thread.interrupt();
                }
            });
           System.out.println("thread 的interrupt"+thread.isInterrupted());
            b.start();
        System.out.println("thread 的interrupt"+thread.isInterrupted());
        System.out.println("b 的interrupt"+b.isInterrupted());
//        }
    }
}
