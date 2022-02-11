// 2022/2/11 15:39
package nnk.dao;

import nnk.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper2 {

    @Select("select * from user")
    List<User> getUsers();

    //方法有多个参数，每个参数前必须加@Param注解
    @Select("select * from user where id=#{id}")
    User getUserById(@Param("id") int id2, @Param("name") String name);

    @Select("insert into user(id,name,pwd) value(#{id},#{name},#{pwd})")
    int addUser(User user);

}
