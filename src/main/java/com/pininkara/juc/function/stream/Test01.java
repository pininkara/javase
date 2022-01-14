// 2022/1/14 15:53

package com.pininkara.juc.function.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Test01 {
    public static void main(String[] args) {
        User u1=new User(1,"a",21);
        User u2=new User(2,"b",22);
        User u3=new User(3,"c",23);
        User u4=new User(4,"d",24);
        User u5=new User(6,"e",25);
        List<User> list = Arrays.asList(u1, u2, u3, u4, u5);

        Stream<User> stream = list.stream();
        stream.filter(user -> user.getId()%2==0)
                .filter(user -> user.getAge()>23)
                .map(user -> user.getName().toUpperCase())
                .sorted((uu1,uu2)->{ return  uu2.compareTo(uu1);})
                .limit(1)
                .forEach(System.out::println);
    }
}
