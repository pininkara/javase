// 2022/1/8 14:04

package com.pininkara.io.object;

import java.io.*;

public class TestObjectOutputStream {
    public static void main(String[] args) throws IOException {
        String path="hello.txt";

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));

        oos.writeInt(100);//int -> Integer(实现了Serialized接口)
        oos.writeBoolean(true);
        oos.writeChar('a');
        oos.writeDouble(9.99);
        oos.writeUTF("Hello你好");

        oos.writeObject(new Dog("狗子",3));

        oos.close();
    }
}
