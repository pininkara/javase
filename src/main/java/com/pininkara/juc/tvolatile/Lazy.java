// 2022/1/15 13:33

package com.pininkara.juc.tvolatile;

import java.lang.reflect.Constructor;

public class Lazy {
    private Lazy() {
        synchronized (Lazy.class){
            if (lazy!=null){
                throw new RuntimeException("不可以这样哦~");
            }
        }
    }

    public volatile static Lazy lazy;

    public static Lazy getInstance() {
        if (lazy == null) {
            synchronized (Lazy.class) {
                if (lazy == null) {
                    lazy = new Lazy();
                }
            }
        }
        return lazy;
    }

    public static void main(String[] args) throws Exception {
        //Lazy lazy = Lazy.getInstance();
        Constructor<Lazy> constructor = Lazy.class.getDeclaredConstructor(null);
        constructor.setAccessible(true);
        Lazy lazy1 = constructor.newInstance();
        Lazy lazy2 = constructor.newInstance();
        System.out.println(lazy1.hashCode());
        System.out.println(lazy2.hashCode());

    }
}
