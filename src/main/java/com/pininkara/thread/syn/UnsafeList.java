// 2022/1/1 16:28

package com.pininkara.thread.syn;

import java.util.ArrayList;
import java.util.List;

//线程不安全集合
public class UnsafeList {
    public static void main(String[] args) {
        List<String> list=new ArrayList<String>();
        for (int i = 0; i < 10000; i++) {
            new Thread(()->{
                synchronized (list){
                    list.add(Thread.currentThread().getName());
                }
            }).start();
        }
        System.out.println(list.size());
        try {
            Thread.sleep(3000);
            System.out.println(list.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
