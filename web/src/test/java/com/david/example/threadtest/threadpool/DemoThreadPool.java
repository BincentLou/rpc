package com.david.example.threadtest.threadpool;

import org.springframework.util.CollectionUtils;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @version $Id: null.java, v 1.0 2019/11/27 7:40 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
public class DemoThreadPool {

    private volatile int corePoolSize;

    private volatile int maximunPoolSize;

    private volatile int rejectExecutorHandler;

    private static volatile int workCount;

    private Set<Worker> coreWorkerSet = new HashSet<>();

    /**
     * 等待执行的任务最大数量
     */
    private volatile int maxQueueSize = 50;

    private AtomicInteger rejectCount = new AtomicInteger(1);

    private BlockingDeque<Runnable> taskQueue = new LinkedBlockingDeque<>();
    private ThreadFactoryDemo threadFactory;

    public DemoThreadPool(int corePoolSize, int maximunPoolSize, int rejectExecutorHandler) {
        this.corePoolSize = corePoolSize;
        this.maximunPoolSize = maximunPoolSize;
        this.rejectExecutorHandler = rejectExecutorHandler;
        threadFactory = new ThreadFactoryDemo();
    }

    //新增任务
    public void submit(Runnable task){
        // 如果工作线程小于核心线程数
        if(workCount<corePoolSize){
            Worker w =addWork(task,true);
            coreWorkerSet.add(w);
            if(w.thread!=null){
                w.thread.start();
            }
            return;
        }
        //如果工作线程大于核心线程 且工作队列还没满，放入队列
        if(workCount>=corePoolSize&&taskQueue.size()<maxQueueSize){
            taskQueue.add(task);
            System.out.println("waiting task 数量"+taskQueue.size());
            return;
        }
        //如果任务队列满了，且工作线程小于最大线程数量，则新增线程
        if(workCount>=corePoolSize&&workCount<maximunPoolSize&&taskQueue.size()==maxQueueSize){
            Worker w = addWork(null,false);
            if(w.thread!=null){
                w.thread.start();
            }
            return;
        }
        //如果队列满了，线程也到达最大值，拒绝执行
        if(workCount==maximunPoolSize){
            System.out.println("reject thread "+rejectCount.getAndIncrement());
        }
    }

    //新增工作线程
    private Worker addWork(Runnable task,boolean core) {
        Worker worker =  new Worker(task);
        if(core){
            coreWorkerSet.add(worker);
        }
        increaseWorkCount();
        return worker;
    }

    private void increaseWorkCount() {
        workCount++;
        System.out.println("工作线程数量："+workCount);
    }

    public class Worker implements Runnable{

        //current Thread
        private Thread thread;

        private Runnable task;

        public Worker(Runnable task) {
            this.thread = getThreadFactory().newThread(this);
            this.task = task;
        }

        @Override
        public void run() {
            runWork(this);
        }

        private void runWork(Worker worker) {
            while(task!=null||(task = getTask())!=null){
                task.run();
                task = null;
            }
            this.task = null;
            decreaseWorkCount();
            coreWorkerSet.remove(worker);
        }

        private Runnable getTask() {
            for(;;){
                if(CollectionUtils.isEmpty(taskQueue)){
                    return null;
                }
                try {
                    return taskQueue.take();
                } catch (InterruptedException e) {
                    decreaseWorkCount();
                    return null;
                }
            }
        }

        private void decreaseWorkCount() {
            workCount--;
            System.out.println("工作线程数量："+workCount);
        }
    }

    private ThreadFactoryDemo getThreadFactory() {
        return this.threadFactory;
    }
}
