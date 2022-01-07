// 2022/1/6 16:37

package com.pininkara.io.file;

import java.io.FileWriter;
import java.io.IOException;

public class TestFileWriter {
    public static void main(String[] args) {
        String path="hello.txt";
        FileWriter fileWriter=null;

        try {
            fileWriter=new FileWriter(path,true);
            fileWriter.write("忆往昔峥嵘岁月稠");//write有5个常用重载
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (fileWriter != null) {
                    fileWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
