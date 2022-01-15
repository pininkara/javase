// 2022/1/15 15:35

package com.pininkara.juc.lock8;

import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;

public class SpinLockDemo {
    AtomicReference<Thread> atomicReference=new AtomicReference<>();

    public void myLock(){
        Thread thread=Thread.currentThread();

        System.out.println(Thread.currentThread().getName()+"：mylock");

        //自旋锁
        while (atomicReference.compareAndSet(null,thread)){

        }
    }


    public void myUnlock(){
        Thread thread=Thread.currentThread();

        System.out.println(Thread.currentThread().getName()+"：myunlock");

        //自旋锁
        while (atomicReference.compareAndSet(null,thread)){
            atomicReference.compareAndSet(thread,null);
        }
    }


    @Test
    public void test1() throws Exception {
        ReentrantLock reentrantLock=new ReentrantLock();
        reentrantLock.lock();
        reentrantLock.unlock();

        SpinLockDemo lock=new SpinLockDemo();

        new Thread(()->{
            lock.myLock();
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.myUnlock();
            }
        },"T1").start();

        TimeUnit.SECONDS.sleep(3);

        new Thread(()->{
            lock.myLock();
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.myUnlock();
            }
        },"T2").start();
    }

}


