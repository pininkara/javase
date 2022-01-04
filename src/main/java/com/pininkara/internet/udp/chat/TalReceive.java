// 2022/1/4 16:53

package com.pininkara.internet.udp.chat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class TalReceive implements Runnable{

    private int port;
    private String msgFrom;

    DatagramSocket socket=null;

    public TalReceive(int port,String msgFrom) {
        this.msgFrom=msgFrom;
        this.port = port;
        try {
            socket=new DatagramSocket(port);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true){
            //准备接收包裹

            try {
                byte[] container = new byte[1024];
                DatagramPacket packet=new DatagramPacket(container,0,container.length);
                socket.receive(packet);
                //断开连接 bye
                byte[] data = packet.getData();
                String receive = new String(data, 0, data.length);

                System.out.println("接收到来自"+msgFrom+"的消息："+receive.trim());

                if (receive.trim().equals("bye")){
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
        socket.close();
    }
}
