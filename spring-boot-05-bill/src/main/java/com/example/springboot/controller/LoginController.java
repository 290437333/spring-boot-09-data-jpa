package com.example.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    @PostMapping("/login")
    public String login(HttpSession session, String username, String password, Map<String,Object> map){
        //判断用户名不为空，且密码为123，则登录成功
        if(!StringUtils.isEmpty(username) && "123".equals(password)){
            session.setAttribute("loginUser",username);
            //登录成功
            //重定向
            return "redirect:/main.html";
        }
        //登录失败
        map.put("msg","用户名或密码错误");

        return "main/login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        //1.清空session
        session.removeAttribute("loginUser");
        //2.注销session
        session.invalidate();
        //3.返回登录页面
        return "redirect:/index.html";
    }
}
