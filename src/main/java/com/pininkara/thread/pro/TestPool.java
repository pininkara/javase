// 2022/1/2 15:38

package com.pininkara.thread.pro;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//测试线程池
public class TestPool {
    public static void main(String[] args) {
        //1.创建线程池
        ExecutorService service = Executors.newFixedThreadPool(10);

        service.execute(new MyThread());
        service.execute(new MyThread());
        service.execute(new MyThread());
        service.execute(new MyThread());
        service.execute(new MyThread());

        //2.关闭链接
        service.shutdownNow();
    }
}

class MyThread implements Runnable {

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName());

    }
}
