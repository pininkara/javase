// 2022/1/7 15:03

package com.pininkara.io.buffered;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TestBufferReader {
    public static void main(String[] args) throws IOException {
        String path="hello.txt";
        String line;

        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        //按行读取

        //line = bufferedReader.readLine(); //返回null则为读完

        while ((line=bufferedReader.readLine())!=null){
            System.out.println(line);
        }

        //关闭流
        bufferedReader.close(); //只需关闭BufferedReader，会自动关闭FileReader
    }
}
