// 2022/1/9 11:58

package com.pininkara.io.properties;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TestProperties01 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src\\main\\resources\\mysql.properties"));
        String line = "";
        while ((line = bufferedReader.readLine()) != null) {
            String[] split = line.split("=");
            System.out.println(split[0] + " 的值：" + split[1]);
        }

        bufferedReader.close();
    }
}
