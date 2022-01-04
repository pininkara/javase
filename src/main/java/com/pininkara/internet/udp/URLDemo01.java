// 2022/1/4 17:33

package com.pininkara.internet.udp;

import org.apache.commons.io.FileUtils;

import javax.net.ssl.HttpsURLConnection;
import java.io.File;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLDemo01 {
    public static void main(String[] args) throws Exception {
        URL url = new URL("https://img.moegirl.org.cn/common/a/ac/%E4%B8%8D%E5%90%AB%E6%9C%88%E9%93%83%E5%A7%90%E5%A6%B9.jpg");
        System.out.println("Protocol："+url.getProtocol());

        URLConnection urlConnection = url.openConnection();
        InputStream inputStream = urlConnection.getInputStream();
        FileUtils.copyInputStreamToFile(inputStream,new File("no.jpg"));
    }
}
