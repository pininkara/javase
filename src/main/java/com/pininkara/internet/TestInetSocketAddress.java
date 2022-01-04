// 2022/1/3 10:36

package com.pininkara.internet;

import java.net.InetSocketAddress;

//套接字
public class TestInetSocketAddress {
    public static void main(String[] args) {
        InetSocketAddress socketAddress = new InetSocketAddress("127.0.0.1", 8080);
        System.out.println(socketAddress.getAddress());
        System.out.println(socketAddress.getPort());
    }
}
