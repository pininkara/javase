// 2022/1/15 13:44

package com.pininkara.juc.tvolatile;

public class Holder {
    private Holder(){
    }

    public static Holder getInstance(){
        return InnerClass.HOLDER;
    }

    public static class InnerClass{
        private static final Holder HOLDER=new Holder();
    }
}
