// 2022/1/3 10:44

package com.pininkara.internet.tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

//客户端
public class TcpClientDemo01 {
    public static void main(String[] args) {
        Socket socket = null;
        OutputStream outputStream=null;
        try {
            //1.ip地址
            InetAddress ip = InetAddress.getByName("127.0.0.1");
            //2.端口号
            int port=9999;
            //3.创建一个socket连接
            socket=new Socket(ip,port);
            //4.发送消息
            outputStream = socket.getOutputStream();
            outputStream.write("这是客户端发送给服务端的消息".getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (socket != null) {
                    socket.close();
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
