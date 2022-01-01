// 2021/12/30 14:37

package com.pininkara.thread;

//多线程同时操作同一个对象
//一个买火车票的实例
public class TestThread4 implements Runnable{

    private int ticketNum=10; //票数

    @Override
    public void run() {
        while (true){
            if (ticketNum<=0)
                break;

            //模拟延迟
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName()+"拿到了第"+ticketNum--+"票");
        }
    }

    public static void main(String[] args) {
        TestThread4 ticket=new TestThread4();

        new Thread(ticket,"张").start();
        new Thread(ticket,"李四").start();
        new Thread(ticket,"王五五").start();//线程不安全

    }

}
