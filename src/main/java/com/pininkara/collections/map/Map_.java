// 2022/1/17 16:22

package com.pininkara.collections.map;

import java.util.*;

public class Map_ {
    public static void main(String[] args) {
        Map map=new HashMap();
        map.put("Java","17");
        map.put("Python","3.8");
        map.put("Node.Js","14.17.0");
        map.put("ADB","31.0.3");
        map.put("Maven","3.5.0");

        Set keySet=map.keySet();
        /*for (Object o : keySet) {
            System.out.println(map.get(o));
        }*/

        Collection values = map.values();
        /*for (Object value : values) {
            System.out.println(value);
        }*/

        Set set = map.entrySet();
        for (Object o : set) {
            Map.Entry entry= (Map.Entry) o;
            System.out.println(entry.getValue());
        }

    }
}
