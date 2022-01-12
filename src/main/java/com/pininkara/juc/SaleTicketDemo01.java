// 2022/1/12 15:40

package com.pininkara.juc;

public class SaleTicketDemo01 {
    public static void main(String[] args) {
        Ticket ticket=new Ticket();
        new Thread(()->{
            for (int i = 0; i < 50; i++) {
                ticket.sale();
            }
        },"A").start();

        new Thread(()->{
            for (int i = 0; i < 50; i++) {
                ticket.sale();
            }
        },"B").start();

        new Thread(()->{
            for (int i = 0; i < 50; i++) {
                ticket.sale();
            }
        },"C").start();
    }
}

class Ticket{
    private int number=50;
    public synchronized void sale(){
        if(number>0){
            System.out.println(Thread.currentThread().getName()+"买到了第"+number--+"张票，剩余"+number+"张");
        }
    }

}
