// 2022/1/14 16:37

package com.pininkara.juc.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

public class Test {
    public static void main(String[] args) {
        test3();
    }

    public static void test1() {  //393
        long sum = 0;
        long start = System.currentTimeMillis();
        for (long i = 1; i <= 10_00_00_0000; i++) {
            sum += i;
        }
        long end = System.currentTimeMillis();
        System.out.println("Sum："+sum+" Test1耗时：" + (end - start));
    }

    public static void test2() throws ExecutionException, InterruptedException {  //161
        long start = System.currentTimeMillis();

        ForkJoinPool forkJoinPool=new ForkJoinPool();
        ForkJoinTask<Long> task = new TestForkJoin01(0L, 10_0000_0000L);
        ForkJoinTask<Long> submit=forkJoinPool.submit(task);//提交任务

        Long sum = submit.get();

        long end = System.currentTimeMillis();
        System.out.println("Sum："+sum+"  Test2耗时：" + (end - start));
    }


    /**
     * 并行流
     */
    public static void test3() {  //121
        long start = System.currentTimeMillis();

        long sum = LongStream.rangeClosed(0L, 10_00_00_0000)
                .parallel()
                .reduce(0, Long::sum);

        long end = System.currentTimeMillis();
        System.out.println("Sum："+sum+" Test3耗时：" + (end - start));
    }


}
