// 2022/1/9 12:25

package com.pininkara.io.properties;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

//创建Properties类并写入配置文件
public class TestProperties03 {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();

        properties.setProperty("charset", "utf8");
        properties.setProperty("user", "Tom汤姆");
        properties.setProperty("pwd", "888888");

        properties.store(new FileWriter("src\\main\\resources\\mysql3.properties"), null);
        //properties.store(new FileOutputStream("src\\main\\resources\\mysql2.properties"),"HelloWorld");
        System.out.println("保存成功");
    }
}
