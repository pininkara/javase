// 2022/2/7 16:59

package nnk.pininkara.pojo;

import lombok.Data;

@Data
public class Person {
    private String name;
    private int age;

    public Person(String name) {
        this.name = name;
    }

}
