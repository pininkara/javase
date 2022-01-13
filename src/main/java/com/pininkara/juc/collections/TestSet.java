// 2022/1/13 13:32

package com.pininkara.juc.collections;

import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

public class TestSet {
    public static void main(String[] args) {
        Set<String> set = new CopyOnWriteArraySet<>();

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0, 5));
                System.out.println(set);
            }, String.valueOf(i)).start();
        }
    }
}
