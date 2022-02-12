// 2022/2/12 11:03

package nnk.my1.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Teacher2 {
    private int id;
    private String name;
    //一个老师有多个学生
    private List<Student2> students;
}
