// 2022/2/14 17:05

package nnk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/lo")
public class LoginController {

    @RequestMapping("/main")
    public String toMain(){
        return "main";
    }

    @RequestMapping("/gologin")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("/login")
    public String login(HttpSession session,String username, String password){
        session.setAttribute("user",username);//将用户登录信息存在session中

        return "main";
    }
}
