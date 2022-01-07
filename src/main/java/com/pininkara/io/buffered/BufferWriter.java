// 2022/1/7 15:16

package com.pininkara.io.buffered;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferWriter {
    public static void main(String[] args) throws IOException {
        String path="hello.txt";
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path,true));
        bufferedWriter.write("HelloWorld,你好世界\\n\n");
        bufferedWriter.newLine();
        bufferedWriter.write("HelloWorld2,你好世界2\n");
        bufferedWriter.write("HelloWorld3,你好世界3\n");
        bufferedWriter.newLine();


        bufferedWriter.close();
    }
}
