// 2022/1/15 12:47

package com.pininkara.juc.tvolatile;

import java.util.concurrent.atomic.AtomicInteger;

public class JmmDemo2 {
    private volatile static AtomicInteger num=new AtomicInteger();

    public static void add(){
        num.getAndIncrement();
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 20; i++) {
            new Thread(()->{
                for (int i1 = 0; i1 < 1000; i1++) {
                    add();
                }
            }).start();
        }

        while (Thread.activeCount()>2){
            Thread.yield();
        }

        System.out.println(Thread.currentThread().getName()+"："+num);

    }
}
