// 2022/1/4 15:00

package com.pininkara.internet.tcp;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class TcpServerDemo02 {
    public static void main(String[] args) throws Exception {
        System.out.println("==服务器已启动==");
        //1.创建服务
        ServerSocket serverSocket = new ServerSocket(9000);
        //2.监听客户端的连接
        Socket socket = serverSocket.accept();
        //3.获取输入流
        InputStream inputStream=socket.getInputStream();
        FileUtils.copyInputStreamToFile(inputStream,new File("receive.jpg"));

        inputStream.close();
        socket.close();
        serverSocket.close();
    }
}
