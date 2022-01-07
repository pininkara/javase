// 2022/1/6 16:25

package com.pininkara.io.file;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TestFileReader {
    public static void main(String[] args) {
        String path="hello.txt";
        FileReader fileReader=null;
        int data;

        //使用字符数组
        char[] buf=new char[8];
        int len;

        try {
            fileReader=new FileReader(path);
            /*while ((data=fileReader.read())!=-1){  //一个一个字符读取
                System.out.print((char) data);
            }*/
            System.out.println("======");
            while ((len=fileReader.read(buf))!=-1){  //len为实际读取到的字符数，返回-1则为文件结束
                System.out.print(new String(buf,0,len));
            }

            //以上两种方式不能共存

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }




    }
}
