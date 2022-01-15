// 2022/1/15 15:25

package com.pininkara.juc.lock8;

public class Demo01 {
    public static void main(String[] args) {
        MyPhone myPhone = new MyPhone();
        new Thread(()->{
            myPhone.sms();
        },"A").start();

        new Thread(()->{
            myPhone.sms();
        },"B").start();


    }
}

class MyPhone{
    public synchronized void sms(){
        System.out.println(Thread.currentThread().getName()+" ：sms");
        call();
    }

    public synchronized void call(){
        System.out.println(Thread.currentThread().getName()+" ：call");
    }

}
