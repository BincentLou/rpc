package com.david.example.juc;

import sun.misc.Unsafe;
import sun.reflect.Reflection;

import java.lang.reflect.Field;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Future;

/**
 * @version $Id: null.java, v 1.0 2019/12/7 10:19 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:Unsafe的 测试类
 * @since 1.0
 **/
public class UnsafeTest {
    public static void main(String[] args){

//        Integer a = 10;
//        // unsafe 的构造函数对classloader有限制，所以要用反射获取实例
        Unsafe finalUnsafe = getUnsafe();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (i<200){
                    if(i==100){
                        System.out.println("需要中断");
                        finalUnsafe.park(false,0L);
                        Thread.interrupted();
                    }
                    System.out.println("嘻嘻"+i);
                    i++;
                }
            }
        });
        t1.start();

//        finalUnsafe.unpark(t1);

    }

    public static Unsafe getUnsafe() {
        Field unsafeObj = Unsafe.class.getDeclaredFields()[0];
        unsafeObj.setAccessible(true);
        Unsafe unsafe = null;
        try {
            unsafe = (Unsafe) unsafeObj.get(null);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
//        long offset = 0;
//        try {
//            offset =  unsafe.objectFieldOffset(Integer.class.getDeclaredField("value"));
//        } catch (NoSuchFieldException e) {
//            e.printStackTrace();
//        }
//        unsafe.compareAndSwapInt(a,offset,10,2);
////        unsafe.putInt(a,offset,2);
//        System.out.println(a.intValue());

//        unsafe.park(false,0L);
//        System.out.println("嘻嘻");

        return unsafe;
    }
}
