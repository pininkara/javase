// 2022/2/16 14:03

package nnk.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

@Controller
public class TestController {

    @RequestMapping("/a")
    public String test1(Model model){
        model.addAttribute("msg","<h1>你好呀！</h1>");
        model.addAttribute("list", Arrays.asList("java1.8","java11","java17"));
        return "test";
    }
}
