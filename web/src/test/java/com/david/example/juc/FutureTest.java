package com.david.example.juc;

import sun.misc.Unsafe;

import javax.security.auth.callback.Callback;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @version $Id: null.java, v 1.0 2019/12/17 10:36 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
public class FutureTest {
    public static void main(String[] args){
//        runFutureTask();
        runCallable();

    }

    private static void runCallable() {
        Boolean result ;
        FutureTask<Boolean> s = new FutureTask<Boolean>(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                Unsafe unsafe = UnsafeTest.getUnsafe();
                unsafe.park(false,0L);
                return  Thread.interrupted();
            }
        });
        s.run();
        try {
            result = s.get();
            System.out.println("线程"+result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    private static void runFutureTask() {
        final FutureResult result = new FutureResult();
        FutureTask<FutureResult> future= new FutureTask<FutureResult>(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                result.setResult("aaaa") ;
            }
        },result);

        Thread t =  new Thread(future);
        t.start();
        try {
            FutureResult a = future.get();
            System.out.println(a.getResult());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static class FutureResult{
        private String result ;
        private Boolean isInterrrupted;

        public Boolean getInterrrupted() {
            return isInterrrupted;
        }

        public FutureResult setInterrrupted(Boolean interrrupted) {
            isInterrrupted = interrrupted;
            return this;
        }

        public String getResult() {
            return result;
        }

        public FutureResult setResult(String result) {
            this.result = result;
            return this;
        }
    }

}
