// 2022/1/14 16:14

package com.pininkara.juc.forkjoin;

import java.util.concurrent.RecursiveTask;

public class TestForkJoin01 extends RecursiveTask<Long> {
    private long start;
    private long end;
    private long temp = 10000L;  //临界值

    public TestForkJoin01(long start, long end) {
        this.start = start;
        this.end = end;
    }

    /**
     * 计算方法
     *
     * @return long
     */
    @Override
    protected Long compute() {
        if ((end - start) < temp) {
            long sum = 0;
            for (long i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        } else {
            long middle = (start + end) / 2;
            TestForkJoin01 testForkJoin01 = new TestForkJoin01(start, middle);
            testForkJoin01.fork();
            TestForkJoin01 testForkJoin02 = new TestForkJoin01(middle + 1, end);
            testForkJoin02.fork();
            return testForkJoin01.join() + testForkJoin02.join();
        }
    }

}
