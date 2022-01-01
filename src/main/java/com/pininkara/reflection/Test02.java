// 2021/12/29 13:52

package com.pininkara.reflection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class Test02 extends Object{
    public static void main(String[] args) throws ClassNotFoundException {
        //通过反射获取类的class对象
        Class c1 = Class.forName("com.pininkara.reflection.User");
        System.out.println(c1);

        //一个类在内存中只有一个Class对象
        //一个类被加载后,类的整个结构都会被封装在Class中
        Class c2 = Class.forName("com.pininkara.reflection.User");
        Class c3 = Class.forName("com.pininkara.reflection.User");
        Class c4 = Class.forName("com.pininkara.reflection.User");

        System.out.println(c2.hashCode());
        System.out.println(c3.hashCode());
        System.out.println(c4.hashCode());
    }
}

//实体类:pojo,entity
@Data
@NoArgsConstructor
@AllArgsConstructor
class User{
    private String name;
    private int id;
    private int age;
}
