// 2022/1/9 11:22

package com.pininkara.io.print;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

//字节打印流
public class TestPrintStream {
    public static void main(String[] args) throws IOException {
        PrintStream ps=System.out;
        ps.println("HelloWorld");
        ps.write("你好世界".getBytes(StandardCharsets.UTF_8));
        ps.close();

        System.setOut(new PrintStream("hello.txt"));
        System.out.println("三千越甲可吞吴");

    }
}
