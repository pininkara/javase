// 2022/1/14 13:57

package com.pininkara.juc.addition.pool;

import java.util.concurrent.*;

public class Test01 {
    public static void main(String[] args) {
        //ExecutorService service = Executors.newSingleThreadExecutor();//单个线程线程池
        //ExecutorService service =Executors.newFixedThreadPool(6);//固定大小线程池
        //ExecutorService service =Executors.newCachedThreadPool();//大小可变线程池
        ExecutorService service=new ThreadPoolExecutor(2,5,10,
                TimeUnit.SECONDS,new LinkedBlockingDeque<>(3),Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy());//自定义线程池

        try {
            for (int i = 0; i < 10; i++) {
                service.execute(()->{  //使用线程池创建线程
                    System.out.println(Thread.currentThread().getName()+" ok");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            service.shutdownNow();//线程池用完要关闭
        }



    }
}
