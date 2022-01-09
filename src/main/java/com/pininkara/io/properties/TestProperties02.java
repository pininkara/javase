// 2022/1/9 12:18

package com.pininkara.io.properties;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

//使用Properties类
public class TestProperties02 {
    public static void main(String[] args) throws IOException {
        Properties properties=new Properties();
        properties.load(new FileReader("src\\main\\resources\\mysql.properties"));

        //properties.list(System.out);

        //System.out.println(properties.getProperty("ip"));

    }
}
