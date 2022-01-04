// 2022/1/4 17:02

package com.pininkara.internet.udp.chat;

public class TalkStudent {
    public static void main(String[] args) {
        //开启两个线程
        new Thread(new TalkSend(7777,"localhost",9999)).start();
        new Thread(new TalReceive(8888,"Tea")).start();
    }
}
