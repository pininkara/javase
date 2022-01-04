// 2022/1/2 15:14

package com.pininkara.thread.pro;

//生产者消费者问题2：信号灯法
public class TestPC2 {
    public static void main(String[] args) {
        Tv tv=new Tv();
        new Player(tv).start();
        new Watcher(tv).start();
    }
}

//生产者->演员
class Player extends Thread {
    Tv tv;

    public Player(Tv tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if(i%2==0){
                this.tv.play("节目一播放中");
            }else {
                this.tv.play("广告播放中");
            }
        }
    }
}

//消费者->观众
class Watcher extends Thread {
    Tv tv;

    public Watcher(Tv tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            tv.watch();
        }
    }
}

//产品->节目
class Tv {
    //T演员表演，观众等待；F演员观看，观众等待
    String voice;//表演的节目
    boolean flag = true;

    //表演
    public synchronized void play(String voice) {
        if (!flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("演员表演了：" + voice);
        this.notifyAll();//通知观众观看
        this.voice = voice;
        this.flag = !this.flag;
    }

    //观看
    public synchronized void watch() {
        if (flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("-----观看了：" + voice);
        //通知演员表演
        this.notifyAll();
        this.flag = !this.flag;
    }

}