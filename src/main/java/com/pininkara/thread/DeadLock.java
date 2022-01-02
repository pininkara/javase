// 2022/1/2 10:56

package com.pininkara.thread;

//死锁
public class DeadLock {
    public static void main(String[] args) {
        Makeup g1 = new Makeup(0, "张三");
        Makeup g2 = new Makeup(1, "李四");

        g1.start();
        g2.start();
    }
}

//口红
class Lipstick {

}

//镜子
class Mirror {

}

//化妆
class Makeup extends Thread {

    //用static来保证只要一份资源
    static Lipstick lipstick = new Lipstick();
    static Mirror mirror = new Mirror();

    int choice;//选择
    String girlName;

    public Makeup(int choice, String girlName) {
        this.choice = choice;
        this.girlName = girlName;
    }

    @Override
    public void run() {
        try {
            makeup();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void makeup() throws InterruptedException {
        if (choice == 0) {
            synchronized (lipstick) {//获得口红的锁
                System.out.println(this.girlName + "获得口红");
                Thread.sleep(1000);
            }
            synchronized (mirror) {//一秒钟后获得镜子
                System.out.println(this.girlName + "获得镜子");
            }
        } else {
            synchronized (mirror) {//获得镜子的锁
                System.out.println(this.girlName + "获得镜子");
                Thread.sleep(1000);
            }
            synchronized (lipstick) {//一秒钟后获得口红
                System.out.println(this.girlName + "获得口红");
            }
        }
    }

}
