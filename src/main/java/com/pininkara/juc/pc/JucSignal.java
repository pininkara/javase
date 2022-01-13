// 2022/1/13 10:51

package com.pininkara.juc.pc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//juc通知指定线程
//ABC依次执行
public class JucSignal {
    public static void main(String[] args) {
        Data3 data3 = new Data3();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                data3.printA();
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                data3.printB();
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                data3.printC();
            }
        }, "C").start();
    }
}

class Data3 {
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();
    private int num = 1;

    public void printA() {
        lock.lock();
        try {
            while (num != 1) {
                condition1.await();
            }
            System.out.println(Thread.currentThread().getName() + "===>AAA");
            num = 2;
            condition2.signal();//唤醒指定线程
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public void printB() {
        lock.lock();
        try {
            while (num != 2) {
                condition2.await();
            }
            System.out.println(Thread.currentThread().getName() + "===>BBB");
            num = 3;
            condition3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printC() {
        lock.lock();
        try {
            while (num != 3) {
                condition3.await();
            }
            System.out.println(Thread.currentThread().getName() + "===>CCC");
            num = 1;
            condition1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
