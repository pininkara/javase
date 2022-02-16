// 2022/2/16 16:46

package nnk.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.PublicKey;
import java.util.List;
import java.util.Map;

@RestController
public class JdbcController {
    @Autowired
    JdbcTemplate jdbcTemplate;
    //查询数据库的所有信息
    //没有实体类，用map获取信息
    @GetMapping("/userlist")
    public List<Map<String,Object>> userList(){
        String sql="select * from user";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        return list;
    }
}
