package com.example.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.thymeleaf.util.StringUtils;

import java.util.Map;

@Controller
public class LoginController {

    @PostMapping("/login")
    public String login(String username, String password, Map<String,Object> map){
        //判断用户名不为空，且密码为123，则登录成功
        if(!StringUtils.isEmpty(username) && "123".equals(password)){
            //登录成功
            return "redirect:/main.html";
        }
        //登录失败
        map.put("msg","用户名或密码错误");

        return "main/login";
    }
}
