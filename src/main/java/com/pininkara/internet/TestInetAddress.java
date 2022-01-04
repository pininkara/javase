// 2022/1/3 10:07

package com.pininkara.internet;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

//测试IP
public class TestInetAddress {
    public static void main(String[] args) {
        try {

            System.out.println(InetAddress.getByName("localhost"));
            System.out.println(InetAddress.getLocalHost());

            //查询网站IP
            InetAddress name3 = InetAddress.getByName("www.baidu.com");
            System.out.println(name3);
            System.out.println("Address："+Arrays.toString(name3.getAddress()));
            System.out.println("CanonicalHostName："+name3.getCanonicalHostName());
            System.out.println("HostName："+name3.getHostName());
            System.out.println("HostAddress："+name3.getHostAddress());



        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
