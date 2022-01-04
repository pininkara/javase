// 2022/1/4 15:49

package com.pininkara.internet.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

public class UdpClientDemo01 {
    public static void main(String[] args) throws Exception {
        //1.建立一个Socket
        DatagramSocket socket=new DatagramSocket();
        //2.建立包
        String msg="Hello World";
        InetAddress localhost=InetAddress.getByName("localhost"); //接收方地址
        int port=9000;

        DatagramPacket packet = new DatagramPacket(msg.getBytes(StandardCharsets.UTF_8), 0, msg.getBytes(StandardCharsets.UTF_8).length, localhost, port);
        //3.发送包
        socket.send(packet);

        socket.close();
    }
}
