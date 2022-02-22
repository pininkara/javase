// 2022/2/21 16:04

package nnk.nono.sw.controller;

import io.swagger.annotations.ApiOperation;
import nnk.nono.sw.pojo.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @ApiOperation("返回User实体类")
    //只要我们的接口的返回值中存在实体类，它就会扫描
    @PostMapping("/user")
    public User user(){
        return new User();
    }
}
