package com.david.example.threadtest;

/**
 * @version $Id: null.java, v 1.0 2019/11/10 10:12 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:资源征用第一个资源
 * @since 1.0
 **/
public class ResourceObj {

    private Object lock = new Object();
    private Object lockB = new Object();

    private volatile int num = 0;

    public void getA(){
        synchronized (lock){
            System.out.println(Thread.currentThread().getName()+"得到A资源");
            num ++;
            System.out.println("num======"+num);
            getB();
        }
    }

    public void getB(){
        synchronized (lockB){
            System.out.println(Thread.currentThread().getName()+"得到B资源");
            if(num==1){
                System.out.println(Thread.currentThread().getName()+"释放B资源");
                Thread.currentThread().yield();
            }
            try {
                System.out.println(Thread.currentThread().getName()+"准备睡眠");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
