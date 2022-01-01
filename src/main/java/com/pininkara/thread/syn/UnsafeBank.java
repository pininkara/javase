// 2022/1/1 15:22

package com.pininkara.thread.syn;

import lombok.AllArgsConstructor;

public class UnsafeBank {
    public static void main(String[] args) {
        Account account=new Account(100,"结婚基金");

        Drawing you=new Drawing(account,50,"你");
        Drawing girlFriend=new Drawing(account,100,"girlFriend");

        you.start();
        girlFriend.start();
    }
}
//账户
@AllArgsConstructor
class Account{
    int money;//余额
    String name;//卡名
}

//银行
class Drawing extends Thread{
    Account account;//账户
    int drawingMoney;//取了多少钱
    int nowMoney;//手上的现金

    public Drawing(Account account,int drawingMoney,String name){
        super(name);
        this.account=account;
        this.drawingMoney=drawingMoney;
    }

    //取钱
    @Override
    public void run() {
        synchronized (account){
            if (account.money-drawingMoney<0){
                System.out.println(Thread.currentThread().getName()+"钱不够，取不了");
                return;
            }

            //sleep可以放大问题的发生性
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            account.money=account.money-drawingMoney;

            nowMoney=nowMoney+drawingMoney;

            System.out.println("余额为："+account.money);
            System.out.println(this.getName()+"取到："+nowMoney);
        }


    }
}


