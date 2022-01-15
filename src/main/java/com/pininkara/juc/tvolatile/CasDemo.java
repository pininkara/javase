// 2022/1/15 14:18

package com.pininkara.juc.tvolatile;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

public class CasDemo {
    public static void main(String[] args) {
        //AtomicInteger integer=new AtomicInteger(2022);
        AtomicStampedReference<Integer> integer=new AtomicStampedReference<>(10,1);

       new Thread(()->{
           int stamp=integer.getStamp();
           System.out.println("a1=>"+stamp);

           try {
               TimeUnit.SECONDS.sleep(3);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }

           System.out.println(integer.compareAndSet(10, 12, integer.getStamp(), integer.getStamp() + 1));
           System.out.println("a2=>"+integer.getStamp());

           System.out.println(integer.compareAndSet(12, 10, integer.getStamp(), integer.getStamp() + 1));
           System.out.println("a3=>"+integer.getStamp());


       },"A").start();

       new Thread(()->{
           int stamp=integer.getStamp();
           System.out.println("b1=>"+stamp);

           try {
               TimeUnit.SECONDS.sleep(3);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }

           System.out.println(integer.compareAndSet(10, 66, stamp, stamp + 1));

           System.out.println("b2=>"+integer.getStamp());

       },"B").start();


    }
}
