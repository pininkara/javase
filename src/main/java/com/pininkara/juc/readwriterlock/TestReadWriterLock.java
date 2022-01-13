// 2022/1/13 16:10

package com.pininkara.juc.readwriterlock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TestReadWriterLock {
    public static void main(String[] args) {
        MyCacheLock cache = new MyCacheLock();
        for (int i = 0; i < 5; i++) {
            final int temp = i;
            new Thread(() -> {
                cache.put(String.valueOf(temp), temp);
            }, String.valueOf(i)).start();
        }

        for (int i = 0; i < 5; i++) {
            final int temp = i;
            new Thread(() -> {
                cache.get(String.valueOf(temp));
            }, String.valueOf(i)).start();
        }

    }
}

//自定义缓存
class MyCache {
    private volatile Map<String, Object> map = new HashMap<>();

    public void put(String key, Object value) {//写
        System.out.println(Thread.currentThread().getName() + "正在写入" + key);
        map.put(key, value);
        System.out.println(Thread.currentThread().getName() + "写入完毕");
    }

    public Object get(String key) {//读
        System.out.println(Thread.currentThread().getName() + "正在读取" + key);
        Object o = map.get(key);
        System.out.println(Thread.currentThread().getName() + "读取完毕");
        return o;
    }
}

//加锁的缓存
class MyCacheLock {
    private volatile Map<String, Object> map = new HashMap<>();
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();//读写锁，能更加精细地控制

    public void put(String key, Object value) {//只能允许一线程写
        lock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "正在写入" + key);
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "写入完毕");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }
    }

    public Object get(String key) {//可以多个线程一起读
        lock.readLock().lock();
        Object o = null;
        try {
            System.out.println(Thread.currentThread().getName() + "正在读取" + key);
            o = map.get(key);
            System.out.println(Thread.currentThread().getName() + "读取完毕");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.readLock().unlock();
        }
        return o;
    }
}
