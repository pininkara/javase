// 2022/1/13 11:34

package com.pininkara.juc.lock8;

import java.util.concurrent.TimeUnit;

public class Test04 {
    public static void main(String[] args) {
        Phone4 phone=new Phone4();
        Phone4 phone2=new Phone4();

        new Thread(()->{
            phone.sendSms();
        },"A").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()->{
            phone2.call();
        },"B").start();

    }
}

class Phone4{

    public static synchronized void sendSms(){
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("sendSms");
    }

    public synchronized void call(){
        System.out.println("call");
    }


}
