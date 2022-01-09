// 2022/1/9 11:37

package com.pininkara.io.print;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TestPrintWriter {
    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(new FileWriter("hello.txt"));
        pw.println("Hello明月几时有把酒问青天");
        pw.close();
    }
}
