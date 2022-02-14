// 2022/2/14 12:23

package nnk.controller;

import com.google.gson.Gson;
import nnk.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    @GetMapping("/t1")
    public String test1(Model model) {
        Gson gson = new Gson();
        User user = new User(123, "捏捏卡", 16);
        String json = gson.toJson(user);
        model.addAttribute("user", json);

        return "user1";
    }

    @RequestMapping("/t2")
    public String test2() {
        return "user1";
    }


}
