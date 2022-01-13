// 2022/1/13 15:28

package com.pininkara.juc.addition;

import java.util.concurrent.CountDownLatch;

public class TestCountDownLatch {
    public static void main(String[] args) throws InterruptedException {
        //总数是6
        CountDownLatch countDownLatch=new CountDownLatch(6);

        for (int i = 0; i < 6; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"===");
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }

        countDownLatch.await();

        System.out.println("执行完毕");
    }
}
