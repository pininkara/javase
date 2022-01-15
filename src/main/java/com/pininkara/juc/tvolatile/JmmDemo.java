// 2022/1/15 11:53

package com.pininkara.juc.tvolatile;

import java.util.concurrent.TimeUnit;

public class JmmDemo {
    private volatile static int num=0;

    public static void main(String[] args) {
        new Thread(()->{
            while (num==0){

            }
            System.out.println("线程停止");
        }).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        num=1;
        System.out.println(num);
    }
}
