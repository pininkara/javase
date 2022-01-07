// 2022/1/7 17:03

package com.pininkara.io.buffered.myreader;

import java.io.*;

public class TestBufferedCopy02 {
    public static void main(String[] args) {
        String srcPath="435.png";
        String destPath="666.png";

        BufferedInputStream inputStream=null;
        BufferedOutputStream outputStream=null;

        try {
            inputStream=new BufferedInputStream(new FileInputStream(srcPath));
            outputStream=new BufferedOutputStream(new FileOutputStream(destPath));

            byte[] buff=new byte[1024];
            int len;

            while ((len=inputStream.read(buff))!=-1){
                outputStream.write(buff,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
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
