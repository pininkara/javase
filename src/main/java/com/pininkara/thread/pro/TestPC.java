// 2022/1/2 14:20

package com.pininkara.thread.pro;

import java.util.ArrayList;
import java.util.List;

//测试：生产者消费者模型-->利用缓冲区：管程法
public class TestPC {
    public static void main(String[] args) {
        SynContainer container = new SynContainer();
        new Producer(container).start();
        new Consumer(container).start();
    }
}

//生产者
class Producer extends Thread {

    SynContainer container;

    public Producer(SynContainer container) {
        this.container = container;
    }

    //生产
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            container.push(new Chicken(i));
            System.out.println("生产了第" + i + "只鸡");
        }
    }
}

//消费者
class Consumer extends Thread {

    SynContainer container;

    public Consumer(SynContainer container) {
        this.container = container;
    }

    //消费
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("----消费了第" + container.pop().id + "只鸡");
        }
    }
}

//产品
class Chicken {
    int id;//产品编号

    public Chicken(int id) {
        this.id = id;
    }
}

//缓冲区
class SynContainer {

    List<Chicken> chickens = new ArrayList<>();//容器大小

    //生产者放入产品
    public synchronized void push(Chicken chicken) {
        //如果容器满了，就需要等待消费者消费
        if (chickens.size() >= 10) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        chickens.add(chicken);//没有满，则放入并通知消费者消费
        this.notifyAll();

    }

    //消费者消费产品
    public synchronized Chicken pop() {
        if (chickens.size() == 0) {//等待生产者生产
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Chicken chicken = chickens.get(0);
        chickens.remove(0);
        this.notifyAll();
        return chicken;
    }

}
