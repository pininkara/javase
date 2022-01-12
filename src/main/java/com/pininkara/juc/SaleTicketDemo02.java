// 2022/1/12 15:40

package com.pininkara.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SaleTicketDemo02 {
    public static void main(String[] args) {
        Ticket2 ticket2 = new Ticket2();
        new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                ticket2.sale();
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                ticket2.sale();
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                ticket2.sale();
            }
        }, "C").start();
    }
}

class Ticket2 {
    private int number = 50;
    Lock lock = new ReentrantLock();

    public synchronized void sale() {

        lock.lock();//加锁

        try {
            if (number > 0) {
                System.out.println(Thread.currentThread().getName() + "买到了第" + number-- + "张票，剩余" + number + "张");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
