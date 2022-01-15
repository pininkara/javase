// 2022/1/15 13:53
package com.pininkara.juc.tvolatile;

import java.lang.reflect.Constructor;

public enum EnumSingle {
    INSTANCE;

    public EnumSingle getInstance(){
        return INSTANCE;
    }

}


class Test{
    public static void main(String[] args) throws Exception {
        EnumSingle single1=EnumSingle.INSTANCE;
        Constructor<EnumSingle> constructor = EnumSingle.class.getDeclaredConstructor(String.class,int.class);
        constructor.setAccessible(true);
        EnumSingle single2 = constructor.newInstance();

        System.out.println(single1.hashCode());
        System.out.println(single2.hashCode());
    }
}