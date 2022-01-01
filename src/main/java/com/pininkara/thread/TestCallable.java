// 2021/12/30 15:55

package com.pininkara.thread;

import lombok.AllArgsConstructor;

import java.util.concurrent.*;

//线程创建方式三：实现Callable接口
@AllArgsConstructor
public class TestCallable implements Callable<Boolean> {
    private String url;
    private String name;


    @Override
    public Boolean call() {
        Downloader downloader = new Downloader();
        downloader.download(url, name);
        System.out.println("下载了文件名为" + name);
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestCallable t1 = new TestCallable("https://img.moegirl.org.cn/common/3/31/Gochiusa_cafe_du_lapin_p014_chino.jpg", "chino.jpg");
        TestCallable t2 = new TestCallable("https://img.moegirl.org.cn/common/6/69/Maya-paint.jpg", "maya.jpg");
        TestCallable t3 = new TestCallable("https://img.moegirl.org.cn/common/4/4c/Megu-paint.jpg", "megu.jpg");

        //创建执行服务
        ExecutorService service = Executors.newFixedThreadPool(3);

        //提交执行
        Future<Boolean> r1 = service.submit(t1);
        Future<Boolean> r2 = service.submit(t2);
        Future<Boolean> r3 = service.submit(t3);

        //获取结果
        System.out.println(r1.get());
        System.out.println(r2.get());
        System.out.println(r3.get());

        //关闭服务
        service.shutdownNow();
    }

}

