// 2022/1/8 17:33

package com.pininkara.io.transformation;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class TestOutputStreamReader {
    public static void main(String[] args) throws IOException {
        String path="hello.txt";
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(path), "utf8");
        osw.write("剑阁峥嵘而崔鬼，一夫当关，万夫莫开by Li bai");
        osw.close();
    }
}
