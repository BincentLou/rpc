package com.david.example.juc;

import com.david.example.threadtest.threadpool.DemoThreadPool;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.locks.Condition;

/**
 * @version $Id: null.java, v 1.0 2019/12/9 3:05 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:ReentrantLock的简单测试用例
 * @since 1.0
 **/
public class ConditionTest {
    private static volatile int size = 0;
    public static void main(String[] args){

        Queue<String> messageQueue = new LinkedBlockingDeque<>(10);
        ReentrantLockDemo lock = new ReentrantLockDemo();
        Condition read = lock.newCondition();
        Condition write = lock.newCondition();

//        DemoThreadPool demoThreadPool = new DemoThreadPool(3,5,2);

        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                wirteMessageRunnable(messageQueue, lock, read, write);
            }
        });
        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                readMessageRunnable(messageQueue, lock, read, write);
            }
        });
        b.start();

        a.start();
    }

    private static void readMessageRunnable(Queue<String> messageQueue, ReentrantLockDemo lock, Condition read, Condition write) {
        for(int i=0;i<3;i++){
            Thread b = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (;;){
                        lock.lock();
                        try{
                            readMessage(write, read, messageQueue);
                        }catch (InterruptedException e){

                        }finally {
                            lock.unlock();
                        }
                    }
                }
            });
            b.start();
        }
    }

    private static void wirteMessageRunnable(Queue<String> messageQueue, ReentrantLockDemo lock, Condition read, Condition write) {
        for(int i=0;i<20;i++){
            Thread a = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        lock.lock();
                        writeMessga(read, write, messageQueue);
                    }catch (InterruptedException e){

                    }finally {
                        lock.unlock();
                    }
                }
            });
            a.start();
        }
    }

    private static void readMessage(Condition write, Condition read, Queue<String> messageQueue) throws InterruptedException {
            while (size==0){
                System.out.println("队列为空");
                read.await();
            }
            size--;
            System.out.println(messageQueue.poll()+".size:"+size);
            write.signalAll();
    }

    private static void writeMessga(Condition read, Condition write, Queue<String> messageQueue) throws InterruptedException {
        while (size>=10){
            System.out.println("消息队列已满");
            write.await();
        }
        size++;
        messageQueue.add("新的消息，size"+size);
        read.signalAll();
    }
}
