// 2022/1/6 14:01

package com.pininkara.io.file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
    public static void main(String[] args) {
        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;
        String srcPath = "157.png";
        String destPath = "1577.png";

        try {
            inputStream = new FileInputStream(srcPath);
            outputStream = new FileOutputStream(destPath);

            byte[] buf = new byte[1024];
            int len;
            while ((len=inputStream.read(buf))!=-1){
                outputStream.write(buf,0,len);
            }
            System.out.println("复制成功");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
