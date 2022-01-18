// 2022/1/18 13:16

package com.pininkara.collections.map;

import java.util.*;

public class Properties_ {
    public static void main(String[] args) {
        Map map=new TreeMap();
        map.put("Java","17");
        map.put("Python","3.8");
        map.put("Node.Js","14.17.0");
        map.put("ADB","31.0.3");
        map.put("Maven","3.5.0");

        System.out.println(map);

        map.put("ADB","1.1.1");
        System.out.println(map);
    }
}

