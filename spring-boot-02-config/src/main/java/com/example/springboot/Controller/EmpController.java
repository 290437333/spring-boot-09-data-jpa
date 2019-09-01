package com.example.springboot.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EmpController {

    @Value("${emp.lastname}")
    private String name;

    @ResponseBody
    @RequestMapping("/say")
    public String sayHello(){
        return "hello"+name;
    }
}
