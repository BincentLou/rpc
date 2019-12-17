package com.david.example.threadtest.threadpool;

import org.springframework.util.CollectionUtils;

import java.util.HashSet;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @version $Id: null.java, v 1.0 2019/12/14 11:06 AM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:ThreadPool基础设计
 * @since 1.0
 **/
public class DemoThreadPoolArch {
    /**
     * 工作线程的集合
     */
    private HashSet<Worker> workerSet = new HashSet<>();
    /**
     * 任务队列
     */
    private BlockingQueue<Runnable> taskQueue =  new LinkedBlockingDeque<>();
    /**
     * 提交任务的方法
     * @param task
     */
    public void submit(Runnable task){
        if(CollectionUtils.isEmpty(workerSet)){
            addWorker();
        }
        taskQueue.add(task);
    }
    /**
     * 创建新的线程，并启动
     */
    private void addWorker() {
        Worker worker = new Worker();
        worker.thread = getThread();
        workerSet.add(worker);
        worker.thread.start();
    }
    /**
     * 依赖线程工厂，生产工作线程
     * @return
     */
    private Thread getThread() {
        //TODO
        return null;
    }
    /**
     * 工作线程的基础实现
     */
    public class Worker implements Runnable{

        /**
         * 当前运行的线程
         */
        private Thread thread;

        /**
         * 获取的task
         */
        private Runnable task;

        @Override
        public void run() {
            while (!CollectionUtils.isEmpty(taskQueue)){
                taskQueue.poll().run();
            }
        }
    }
}
