// 2022/2/12 13:04

package nnk.my2.utils;

import java.util.UUID;

public class IdUtils {
    public static String getId(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}
