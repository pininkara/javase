// 2021/12/29 14:39

package com.pininkara.reflection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//测试Class类的创建方式
public class Test03 {
    public static void main(String[] args) throws ClassNotFoundException {
        Person person=new Student();
        System.out.println("这个人是："+person.name);

        //方式一：通过对象获得
        Class c1=person.getClass();
        System.out.println(c1.hashCode());

        //方式二：forName获得
        Class c2=Class.forName("com.pininkara.reflection.Student");
        System.out.println(c2.hashCode());

        //方式三：通过类名.class
        Class c3=Student.class;
        System.out.println(c3.hashCode());
        
        //方式四：基本内置对象的包装内都有一个TYPE属性
        Class<Integer> c4 = Integer.TYPE;
        System.out.println(c4);

        //获得父类类型
        Class c5 = c1.getSuperclass();
        System.out.println(c5);
    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Person{
    String name;
}

class Student extends Person{
    public Student(){
        this.name="学生";
    }
}

class Teacher extends Person{
    public Teacher(){
        this.name="老师";
    }
}