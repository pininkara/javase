// 2022/1/13 12:37

package com.pininkara.juc.collections;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

public class TestList {
    public static void main(String[] args) {
        List<String> list= new CopyOnWriteArrayList<>();

        for (int i=1;i<10;i++){
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(list);
            },String.valueOf(i)).start();
        }
    }
}
