// 2022/1/6 11:46

package com.pininkara.io.file;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class TestFileInputStream {
    public static void main(String[] args) {

    }

    @Test
    public void readFile01() {
        String path = "hello.txt";
        int readData = 0;
        FileInputStream fileInputStream = null;  //字节流
        try {
            fileInputStream = new FileInputStream(path);
            while ((readData = fileInputStream.read()) != -1) {//返回-1表示读取完毕
                System.out.print((char) readData);//转换成char显示
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    //使用read(byte[] b)读取文件，提供效率
    public void readFile02() {
        String path = "hello.txt";
        int readLen = 0;
        byte[] buf=new byte[32];//字节数组，一次读取8字节
        FileInputStream fileInputStream = null;  //字节流
        try {
            fileInputStream = new FileInputStream(path);

            while ((readLen=fileInputStream.read(buf)) != -1) {//如果读取正常，则返回实际读取的字节数
                System.out.print(new String(buf,0,readLen));//转换成char显示
                if (readLen!= buf.length){
                    System.out.println(readLen);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
