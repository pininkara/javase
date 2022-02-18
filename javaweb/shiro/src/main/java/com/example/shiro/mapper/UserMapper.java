// 2022/2/18 16:37

package com.example.shiro.mapper;

import com.example.shiro.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {

    public User queryUserByName(String name);
}
