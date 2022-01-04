// 2022/1/4 15:56

package com.pininkara.internet.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

//还是要等待数据
public class UdpServerDemo01 {
    public static void main(String[] args) throws Exception {
        //开放端口
        DatagramSocket socket=new DatagramSocket(9000);
        //接收数据包
        byte[] buffer =new byte[1024];
        DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);

        socket.receive(packet);
        System.out.println(packet.getAddress().getHostAddress());
        System.out.println(new String(packet.getData(),0, packet.getLength()));

        socket.close();
    }
}
