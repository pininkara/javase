// 2022/1/4 17:05

package com.pininkara.internet.udp.chat;

public class TalkTeacher {
    public static void main(String[] args) {
        new Thread(new TalkSend(5555,"localhost",8888)).start();
        new Thread(new TalReceive(9999,"Stu")).start();
    }
}
