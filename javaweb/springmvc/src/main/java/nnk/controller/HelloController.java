// 2022/2/13 14:55

package nnk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
    @RequestMapping("/hello")
    public String hello(Model model) {
        //封装数据
        model.addAttribute("msg", "Hello,SpringMVCAnnotation");
        //返回的内容会被视图解析器处理
        return "hello";
    }
}
