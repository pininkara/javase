// 2022/1/8 14:14

package com.pininkara.io.object;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class TestObjectInputStream {
    public static void main(String[] args) throws IOException {
        String path="hello.txt";

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));

        //反序列化顺序要和序列化顺序一致
        System.out.println(ois.readInt());
        System.out.println(ois.readBoolean());
        System.out.println(ois.readChar());
        System.out.println(ois.readDouble());
        System.out.println(ois.readUTF());

        try {
            Object object=ois.readObject();
            System.out.println("运行类型："+object.getClass());
            System.out.println("Dog："+object);
            Dog dog=(Dog) object;
            System.out.println(dog.getName());
            System.out.println(dog);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        ois.close();
    }
}
