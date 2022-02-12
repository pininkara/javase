// 2022/2/10 13:50

package nnk.my1.dao;

import nnk.my1.pojo.User;
import nnk.utils.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

public class MyTest {
    @Test
    public void test() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //方式一：getMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserList();
        for (User user : userList) {
            System.out.println(user);
        }

        //方式二：不推荐
        List<User> list = sqlSession.selectList("nnk.my1.dao.UserMapper.getUserList");
        for (User user : list) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void test2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(1);
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void test3() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.addUser(new User(4, "关羽", "246161"));
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test4() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.updateUser(new User(4, "刘备", "111111"));
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test5() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteUser(4);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test6() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        HashMap<String, Object> map = new HashMap<>();
        map.put("id", 1);
        map.put("name", "黄忠");

        mapper.addUser2(map);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test7() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> list = mapper.getUserLike("李");
        for (User user : list) {
            System.out.println(user);
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test8() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        HashMap<String, Integer> map = new HashMap<>();
        map.put("startIndex", 0);
        map.put("pageSize", 2);
        List<User> list = mapper.getUserByLimit(map);
        for (User user : list) {
            System.out.println(user);
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test9() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //通过java实现分页
        RowBounds rowBounds = new RowBounds(0, 2);
        List<User> list = sqlSession.selectList("nnk.my1.dao.UserMapper.getUserByRowBounds",null,rowBounds);
        for (User user : list) {
            System.out.println(user);
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test10() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper2 mapper = sqlSession.getMapper(UserMapper2.class);
        List<User> list = mapper.getUsers();
        for (User user : list) {
            System.out.println(user);
        }
        sqlSession.commit();
        sqlSession.close();
    }

   @Test
    public void test11() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper2 mapper = sqlSession.getMapper(UserMapper2.class);
       System.out.println(mapper.getUserById(1, ""));
       sqlSession.commit();
        sqlSession.close();
    }




}
