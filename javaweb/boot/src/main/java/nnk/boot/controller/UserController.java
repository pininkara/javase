// 2022/2/17 11:48

package nnk.boot.controller;

import nnk.boot.mapper.UserMapper;
import nnk.boot.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/query")
    public List<User> queryUserList(){
        return userMapper.queryUserList();
    }

    @GetMapping("/query2")
    public User queryUserById(){
        return userMapper.queryUserById(1);
    }

    @GetMapping("/query3")
    public int addUser(){
        return userMapper.addUser(new User(100,"罗翔","adicae"));
    }
}
