// 2022/2/11 16:58

package nnk.my1.dao;

import nnk.my1.pojo.Teacher;
import org.apache.ibatis.annotations.Select;

public interface TeacherMapper {

    @Select("select * from teacher where id=#{id}")
    Teacher getTeacher(int id);
}
