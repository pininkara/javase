// 2022/1/13 15:36

package com.pininkara.juc.addition;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class TestCyclicBarrier {
    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,()->{
            System.out.println("召唤成功");
        });

        for (int i = 1; i <= 7; i++) {
            final int temp=i;
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"收集到了第"+temp+"颗龙珠");

                try {
                    cyclicBarrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            },String.valueOf(i)).start();
        }
    }
}
