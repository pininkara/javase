// 2022/1/13 15:52

package com.pininkara.juc.addition;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class TestSemaphore {
    public static void main(String[] args) {
        Semaphore semaphore=new Semaphore(3);

        for (int i = 0; i < 6; i++) {
            new Thread(()->{

                try {
                    semaphore.acquire();//得到资源
                    System.out.println(Thread.currentThread().getName()+"得到车位");
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println(Thread.currentThread().getName()+"离开车位");
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();//释放资源
                }


            },String.valueOf(i)).start();
        }
    }
}
