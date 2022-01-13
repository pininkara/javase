// 2022/1/13 11:34

package com.pininkara.juc.lock8;

import java.util.concurrent.TimeUnit;

public class Test02 {
    public static void main(String[] args) {
        Phone2 phone2=new Phone2();
        Phone2 phone3=new Phone2();

        new Thread(phone2::sendSms,"A").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(phone3::call,"B").start();

    }
}

class Phone2{

    public synchronized void sendSms(){
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

    public void hello(){
        System.out.println("Hello");
    }

}
