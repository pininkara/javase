// 2022/2/14 11:10

package nnk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RestFulController {
    @RequestMapping(value = "rest/{a}/{b}" ,method = RequestMethod.POST)
    public String test1(@PathVariable int a, @PathVariable String b, Model model) {
        model.addAttribute("msg", "Post结果为：" + a+b);
        return "rest";
    }


    @RequestMapping(value = "rest/{a}/{b}" ,method = RequestMethod.GET)
    public String test2(@PathVariable int a, @PathVariable String b, Model model) {
        model.addAttribute("msg", "Get结果为：" + a+b);
        return "rest";
    }
}
