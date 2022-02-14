// 2022/2/14 11:54

package nnk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class ModelTest1 {
    @RequestMapping("/model1")
    public String test1(Model model){
        model.addAttribute("msg","ModelTest1");
        return "/jsp/model1.jsp";
    }
}
