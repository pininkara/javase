// 2022/1/18 12:40

package com.pininkara.collections.map;

import java.util.Hashtable;
import java.util.Map;

public class Table_ {
    public static void main(String[] args) {
        Map map= new Hashtable();
        map.put("Java","17");
        map.put("Python","3.8");
        map.put("Node.Js","14.17.0");
        map.put("ADB","31.0.3");
        map.put("Maven","3.5.0");

        System.out.println(map);
        map.put("ADB","13.0.4");

        System.out.println(map);

    }

}
