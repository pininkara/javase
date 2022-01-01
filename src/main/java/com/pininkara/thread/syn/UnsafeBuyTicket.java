// 2022/1/1 14:23

package com.pininkara.thread.syn;

//不安全的买票
//加synchronized后同步
public class UnsafeBuyTicket {
    public static void main(String[] args) {
        BuyTicket ticket=new BuyTicket();

        new Thread(ticket,"张三").start();
        new Thread(ticket,"李四").start();
        new Thread(ticket,"王五").start();
    }
}


class BuyTicket implements Runnable{

    //票
    int ticketNums=10;
    boolean flag=true;

    @Override
    public void run() {
        while (flag){
            buy();
        }
    }

    //买票 synchronized同步方法
    private synchronized void buy(){
        if (ticketNums<=0){
            flag=false;
            return;
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"拿到"+ticketNums--);
    }
}