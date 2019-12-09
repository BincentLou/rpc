package com.david.example.juc;

import java.io.Serializable;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @version $Id: null.java, v 1.0 2019/12/9 10:36 AM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:可重入锁的简单例子
 * ReentrantLock 和synchronized的区别，re就是在api的层面实现可重入，synchronized则是在字节码层面实现的可重入，
 * re还可以实现公平锁，可中断的等待等问题。具体实现模拟synchronized的等待队列。
 * 依赖 AbstractQueuedSynchronizer队列，把等待的线程放入队列，然后可以唤醒。
 * @since 1.0
 **/
public class ReentrantLockDemo implements Lock {


    private final WaitQueue queue = new WaitQueue();

    @Override
    public void lock() {
        queue.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        queue.tryAcquireNanos(1,2000);
    }

    @Override
    public boolean tryLock() {
        //暂时不支持
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        //暂时不支持
        return false;
    }

    @Override
    public void unlock() {
        queue.release(1);
    }

    @Override
    public Condition newCondition() {
        // 暂时不支持 condition多等待线程
        return null;
    }


    //内部类 等待队列
    public class WaitQueue extends AbstractQueuedSynchronizer implements Serializable {

        private static final long serialVersionUID = -8060793292559526565L;


        /**
         * Fair version of tryAcquire.  Don't grant access unless
         * recursive call or no waiters or is first.
         */
        @Override
        protected final boolean tryAcquire(int acquires) {
            final Thread current = Thread.currentThread();
            int c = getState();
            if (c == 0) {
                if (!hasQueuedPredecessors() &&
                        compareAndSetState(0, acquires)) {
                    setExclusiveOwnerThread(current);
                    return true;
                }
            }
            else if (current == getExclusiveOwnerThread()) {
                int nextc = c + acquires;
                if (nextc < 0)
                    throw new Error("Maximum lock count exceeded");
                setState(nextc);
                return true;
            }
            return false;
        }

        @Override
        protected final boolean tryRelease(int releases) {
            int c = getState() - releases;
            if (Thread.currentThread() != getExclusiveOwnerThread())
                throw new IllegalMonitorStateException();
            boolean free = false;
            if (c == 0) {
                free = true;
                setExclusiveOwnerThread(null);
            }
            setState(c);
            return free;
        }
    }
}
