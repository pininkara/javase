// 2022/2/21 18:38

package nnk.nono.sw.controller;

import nnk.nono.sw.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AsyncController {

    @Autowired
    AsyncService service;

    @RequestMapping("/async")
    public String hello(){
        service.hello();
        return "OK";
    }
}
