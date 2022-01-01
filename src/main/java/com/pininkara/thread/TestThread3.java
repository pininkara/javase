// 2021/12/30 13:19

package com.pininkara.thread;

//创建线程方式2:实现runnable，重写run方法，执行线程需要丢入runnable接口的实现类
public class TestThread3 implements Runnable{
    @Override
    public void run() {
        //run方法线程体
        for (int i = 0; i < 20; i++) {
            System.out.println("run方法" + (i+1));
        }
    }

    public static void main(String[] args) {
        //创建runnable接口的实现类对象
        TestThread3 testThread3=new TestThread3();

        //创建线程对象，通过线程对象来开启线程（代理实现）
        /*Thread thread = new Thread(testThread3);
        thread.start();*/
        new Thread(testThread3).start();

        for (int i = 0; i < 50; i++) {
            System.out.println("主线程" + (i+1));
        }
    }
}
