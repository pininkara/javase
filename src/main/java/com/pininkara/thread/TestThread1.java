// 2021/12/30 12:26

package com.pininkara.thread;

//创建线程方式一：继承Thread类，重写run()方法
public class TestThread1 extends Thread {
    @Override
    public void run() {
        //run方法线程体
        for (int i = 0; i < 20; i++) {
            System.out.println("run方法" + (i+1));
        }
    }

    public static void main(String[] args) {
        //main线程，主线程

        //创建一个线程对象
        TestThread1 testThread1 = new TestThread1();

        //调用start()方法
        testThread1.start();

        for (int i = 0; i < 50; i++) {
            System.out.println("主线程" + (i+1));
        }
    }
}
