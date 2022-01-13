// 2022/1/13 11:34

package com.pininkara.juc.lock8;

import java.util.concurrent.TimeUnit;

public class Test03 {
    public static void main(String[] args) {
        Phone3 phone=new Phone3();
        Phone3 phone1=new Phone3();

        new Thread(()->{
            phone.sendSms();
        },"A").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()->{
            phone1.call();
        },"B").start();

    }
}

class Phone3{

    public static synchronized void sendSms(){
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("sendSms");
    }

    public static synchronized void call(){
        System.out.println("call");
    }


}
