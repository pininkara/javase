// 2022/1/18 15:07

package com.pininkara.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Collections_ {
    public static void main(String[] args) {
        List list1=new ArrayList();
        List list2=new ArrayList();

        list1.add("Java");
        list1.add("ADB");
        list1.add("Python");
        list1.add("JavaScript");
        list1.add("PHP");

        list2.add("Objective-C");
        list2.add("Swift");
        list2.add("Shell");
        list2.add("Shell");
        list2.add("Shell");
        list2.add("Shell");

        System.out.println("list2:  "+list2);

        Collections.replaceAll(list2,"Shell","powershell");

        System.out.println("list2:  "+list2);
    }
}
