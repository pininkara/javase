// 2022/2/11 16:58

package nnk.dao;

import nnk.pojo.Teacher;
import org.apache.ibatis.annotations.Select;

public interface TeacherMapper {

    @Select("select * from teacher where id=#{id}")
    Teacher getTeacher(int id);
}
