// 2022/2/12 11:13

package nnk.my1.dao;

import nnk.my1.pojo.Teacher2;
import org.apache.ibatis.annotations.Param;

public interface Teacher2Mapper {
    //List<Teacher2> getTeacher();

    //获取指定老师信息及其所有学生
    Teacher2 getTeacher(@Param("tid")int id);

    Teacher2 getTeacher2(@Param("tid")int id);
}
