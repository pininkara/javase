// 2022/1/4 16:11

package com.pininkara.internet.udp.chat;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpReceiveDemo01 {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(7777);
        while (true){
            //准备接收包裹
            byte[] container = new byte[1024];
            DatagramPacket packet=new DatagramPacket(container,0,container.length);
            socket.receive(packet);

            //断开连接 bye
            byte[] data = packet.getData();
            String receive = new String(data, 0, data.length);

            System.out.println(receive.trim());

            if (receive.trim().equals("bye")){
                break;
            }
        }
        socket.close();
    }
}
