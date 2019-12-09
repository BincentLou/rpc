package com.david.example.juc;

import java.util.ArrayList;
import java.util.List;

/**
 * @version $Id: null.java, v 1.0 2019/12/9 11:17 AM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
public class ReentranLockTest {

    public static void main(String[] args){

        ReentrantLockDemo reentrantLockDemo = new ReentrantLockDemo();
        List<Thread> list = new ArrayList<>(10);
        for(int i=0;i<10;i++){
            Thread a = new Thread(new Runnable() {
                @Override
                public void run() {
                    reentrantLockDemo.lock();
                    list.add(Thread.currentThread());
                    System.out.println("执行任务");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    reentrantLockDemo.unlock();
                }
            });
            a.start();
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list.size());
        System.out.println(list.get(0).getState());
    }

}
