// 2022/1/13 14:23

package com.pininkara.juc.collections;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class TestMap {
    public static void main(String[] args) {
        Map<String,String> map= new ConcurrentHashMap<>();
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                map.put(Thread.currentThread().getName(),UUID.randomUUID().toString().substring(0,5));
                System.out.println(map);
            },String.valueOf(i)).start();
        }
    }
}
