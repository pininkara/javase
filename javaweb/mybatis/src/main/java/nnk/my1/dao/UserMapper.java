// 2022/2/10 13:31

package nnk.my1.dao;

import nnk.my1.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    //查询全部用户
    List<User> getUserList();

    //根据ID查询用户
    @Select("select * from user where id = #{id}")
    User getUserById(int id);

    //模糊查询
    List<User> getUserLike(String value);

    //插入用户
    int addUser(User user);

    @Insert("insert into user (id,name,pwd) values(#{id},#{name},#{pwd})")
    int addUser2(Map<String,Object> map);

    //修改用户
    int updateUser(User user);


    //删除用户
    int deleteUser(int id);

    //分页
    List<User> getUserByLimit(Map<String,Integer> map);

    //分页2
    @Select("select * from user")
    List<User> getUserByRowBounds();


    User queryUserById(int id);

}
