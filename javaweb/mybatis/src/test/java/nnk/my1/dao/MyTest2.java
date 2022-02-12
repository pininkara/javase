// 2022/2/11 17:01

package nnk.my1.dao;

import nnk.my1.pojo.Student;
import nnk.my1.pojo.Teacher;
import nnk.my1.pojo.User;
import nnk.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyTest2 {
    @Test
    public void test1() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacher(1);
        System.out.println(teacher);
        sqlSession.close();
    }

    @Test
    public void test2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> list = mapper.getStudent();
        for (Student student : list) {
            System.out.println(student);
        }
        sqlSession.close();
    }

    @Test
    public void test3() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        Teacher2Mapper mapper = sqlSession.getMapper(Teacher2Mapper.class);
        System.out.println(mapper.getTeacher(1));
        sqlSession.close();
    }

  @Test
    public void test4() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        Teacher2Mapper mapper = sqlSession.getMapper(Teacher2Mapper.class);
        System.out.println(mapper.getTeacher2(1));
        sqlSession.close();
    }

  @Test
    public void test5() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
      UserMapper mapper = sqlSession.getMapper(UserMapper.class);

      User user = mapper.queryUserById(1);
      System.out.println("nnk"+user);
      User user2 = mapper.queryUserById(1);
      System.out.println("nnk"+user2);

      sqlSession.close();
    }


}
