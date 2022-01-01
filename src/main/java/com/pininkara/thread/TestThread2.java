// 2021/12/30 12:50

package com.pininkara.thread;

import lombok.AllArgsConstructor;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

//练习：实现多线程下载图片
@AllArgsConstructor
public class TestThread2 extends Thread{

    private String url;
    private String name;


    @Override
    public void run() {
        Downloader downloader=new Downloader();
        downloader.download(url,name);
        System.out.println("下载了文件名为"+name);
    }

    public static void main(String[] args) {
        TestThread2 t1=new TestThread2("https://img.moegirl.org.cn/common/3/31/Gochiusa_cafe_du_lapin_p014_chino.jpg","chino.jpg");
        TestThread2 t2=new TestThread2("https://img.moegirl.org.cn/common/6/69/Maya-paint.jpg","maya.jpg");
        TestThread2 t3=new TestThread2("https://img.moegirl.org.cn/common/4/4c/Megu-paint.jpg","megu.jpg");

        t1.start();
        t2.start();
        t3.start();
    }
}

//下载器
class Downloader{
    //下载方法
    public void download(String url,String name){
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (IOException e) {
            System.out.println("IO异常，downloader方法出现问题");
            e.printStackTrace();
        }
    }
}
