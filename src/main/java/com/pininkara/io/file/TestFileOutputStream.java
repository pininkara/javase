// 2022/1/6 12:21

package com.pininkara.io.file;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestFileOutputStream {

    public static void main(String[] args) {

    }


    @Test
    public void writeFile(){
        FileOutputStream fileOutputStream=null;
        String path="hello.txt";
        String str="Hello World\n";

        try {
            fileOutputStream=new FileOutputStream(path,true);
            //fileOutputStream.write('H');//写一个字节
            fileOutputStream.write(str.getBytes());//写入字符串(char数组)
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
