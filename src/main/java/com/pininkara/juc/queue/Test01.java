// 2022/1/13 16:58

package com.pininkara.juc.queue;

import java.util.concurrent.ArrayBlockingQueue;

public class Test01 {
    public static void main(String[] args) {
        test2();
    }

    public static void test1(){
        ArrayBlockingQueue blockingQueue=new ArrayBlockingQueue(3);

        System.out.println(blockingQueue.add("A"));
        System.out.println(blockingQueue.add("B"));
        System.out.println(blockingQueue.add("C"));

        System.out.println("====");

        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());

    }

    public static void test2(){
        ArrayBlockingQueue blockingQueue=new ArrayBlockingQueue(3);

        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        System.out.println(blockingQueue.offer("d"));
    }

}
