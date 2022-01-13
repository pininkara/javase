// 2022/1/13 14:58

package com.pininkara.juc.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class TestCallable {
    public static void main(String[] args) {
        MyThread myThread=new MyThread();
        FutureTask futureTask=new FutureTask(myThread);
        new Thread(futureTask,"A").start();
        new Thread(futureTask,"B").start();

        try {
            int o= (int) futureTask.get();
            System.out.println(o);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyThread implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("Call()");
        return 8080;
    }
}
