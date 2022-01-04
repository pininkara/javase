// 2022/1/3 10:48

package com.pininkara.internet.tcp;

import org.apache.commons.io.IOUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

//服务端
public class TcpServerDemo01 {
    public static void main(String[] args) {
        System.out.println("===服务器已经启动===");
        ServerSocket serverSocket=null;
        Socket socket=null;
        InputStream inputStream=null;
        ByteArrayOutputStream stream=null;
        try {
            //服务器地址
            serverSocket = new ServerSocket(9999);
            //等待客户端连接
            socket=serverSocket.accept();
            //接收消息
            inputStream = socket.getInputStream();
            //管道流
            /*stream=new ByteArrayOutputStream();
            byte[] buffer =new byte[1024];
            int len;
            while ((len=inputStream.read(buffer))!=-1){
                stream.write(buffer,0,len);
            }
            System.out.println(stream.toString());*/

            //使用commons-io
            String s = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
            System.out.println(s);

        } catch (IOException e) {
            e.printStackTrace();
        }/*finally {//关闭流
            try {
                if (stream != null) {
                    stream.close();
                    inputStream.close();
                    socket.close();
                    serverSocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }*/
    }
}
