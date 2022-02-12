// 2022/2/11 16:56

package nnk.my1.pojo;

import lombok.Data;

@Data
public class Student {
    private int id;
    private String name;
    //学生需要关联一个老师
    private Teacher teacher;
}
