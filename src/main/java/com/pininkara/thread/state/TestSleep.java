// 2021/12/31 15:28

package com.pininkara.thread.state;

//模拟网络延迟：放大问题的发生性
public class TestSleep implements Runnable {
    private int ticketNum = 10; //票数

    @Override
    public void run() {
        while (true) {
            if (ticketNum <= 0)
                break;

            //模拟延迟
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "拿到了第" + ticketNum-- + "票");
        }
    }

    public static void main(String[] args) {
        TestSleep ticket = new TestSleep();

        new Thread(ticket, "张").start();
        new Thread(ticket, "李四").start();
        new Thread(ticket, "王五五").start();//线程不安全
    }
}
