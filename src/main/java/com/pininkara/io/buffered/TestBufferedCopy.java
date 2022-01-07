// 2022/1/7 16:39

package com.pininkara.io.buffered;

import java.io.*;

public class TestBufferedCopy {
    public static void main(String[] args) {
        String srcPath="hello.txt";
        String destPath="hi.txt";

        BufferedReader reader=null;
        BufferedWriter writer=null;
        String line;

        try {
            reader=new BufferedReader(new FileReader(srcPath));
            writer=new BufferedWriter(new FileWriter(destPath));

            while ((line=reader.readLine())!=null){//不会读取换行
                //每读取到一行就写入
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (reader != null) {
                    reader.close();
                }
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
