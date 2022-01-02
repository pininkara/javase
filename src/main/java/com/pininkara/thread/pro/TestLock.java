// 2022/1/2 12:15

package com.pininkara.thread.pro;

import java.util.concurrent.locks.ReentrantLock;

//测试Lock锁
public class TestLock {
    public static void main(String[] args) {
        TestLock2 testLock2=new TestLock2();

        new Thread(testLock2).start();
        new Thread(testLock2).start();
        new Thread(testLock2).start();
    }
}

class TestLock2 implements Runnable {

    int ticketNum = 1000;

    //定义lock锁
    private ReentrantLock lock=new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            lock.lock();//加锁
            try{
                if (ticketNum >= 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"买到第" + ticketNum-- + "张票");
                } else {
                    break;
                }
            }finally {
                lock.unlock();//解锁
            }

        }
    }
}
