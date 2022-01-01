// 2022/1/1 11:39

package com.pininkara.thread.state;

//测试线程优先级
public class TestPriority{
    public static void main(String[] args) {
        //主线程优先级：默认优先级
        System.out.println(Thread.currentThread().getName()+"-->"+Thread.currentThread().getPriority());

        MyPriority myPriority=new MyPriority();

        Thread t1=new Thread(myPriority,"t1");
        Thread t2=new Thread(myPriority,"t2");
        Thread t3=new Thread(myPriority,"t3");
        Thread t4=new Thread(myPriority,"t4");
        Thread t5=new Thread(myPriority,"t5");
        Thread t6=new Thread(myPriority,"t6");

        //先设置优先级，再启动
        t1.start();

        t2.setPriority(1);
        t2.start();

        t3.setPriority(4);
        t3.start();

        t4.setPriority(Thread.MAX_PRIORITY);
        t4.start();

        t5.setPriority(6);
        t5.start();

        t6.setPriority(3);
        t6.start();


    }
}

class MyPriority implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"-->"+Thread.currentThread().getPriority());
    }
}