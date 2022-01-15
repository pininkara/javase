// 2022/1/15 10:24

package com.pininkara.juc.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

//异步调用:异步执行->成功回调、失败回调
public class Demo01 {
    public static void main(String[] args) throws Exception {
        //没有返回值的runAsync异步回调
        /*CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "：runAsync");
        });

        System.out.println("111");

        completableFuture.get();//获取阻塞执行结果*/

        //有返回值的异步回调
        CompletableFuture<Integer> completableFuture=CompletableFuture.supplyAsync(()->{
            return 1024;
        });

        completableFuture.whenComplete((t,u)->{
            System.out.println("t:"+t);
            System.out.println("u:"+u);
        }).exceptionally((e)->{
            e.getMessage();
            return 223;
        }).get();
    }
}
