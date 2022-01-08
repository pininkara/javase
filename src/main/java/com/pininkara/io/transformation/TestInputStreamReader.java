// 2022/1/8 17:06

package com.pininkara.io.transformation;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class TestInputStreamReader {
    public static void main(String[] args) throws IOException {
        String path="hello.txt";
        InputStreamReader isr = new InputStreamReader(new FileInputStream(path), "gbk");

        BufferedReader br=new BufferedReader(isr);

        String s= br.readLine();
        System.out.println(s);

        br.close();
    }
}
