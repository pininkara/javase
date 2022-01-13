// 2022/1/13 11:34

package com.pininkara.juc.lock8;

import java.net.Socket;
import java.util.concurrent.TimeUnit;

public class Test01 {
    public static void main(String[] args) {
        Phone phone=new Phone();
        new Thread(phone::sendSms,"A").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(phone::call,"B").start();
    }
}

class Phone{

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

}
