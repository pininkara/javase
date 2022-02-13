// 2022/2/13 14:55

package nnk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HelloController{
    @RequestMapping("/hello")
    public String hello(Model model){
        //封装数据
        model.addAttribute("msg","Hello,SpringMVCAnnotation");
        //返回的内容会被视图解析器处理
        return "hello";
    }
}
