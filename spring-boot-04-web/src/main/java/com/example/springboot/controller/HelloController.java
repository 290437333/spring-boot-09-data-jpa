package com.example.springboot.controller;

import com.example.springboot.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class HelloController {

    @ResponseBody
    @RequestMapping("/success")
    public String execute(){
        return "hello!!!";
    }

    @RequestMapping({"/execute"})
    public String success(Map<String,Object> map){
        map.put("name","名字");
        //classpath:templates/success.html
        return "success";
    }

    @RequestMapping("/study")
    public String study(Map<String,Object> map, HttpServletRequest request){
        List<User> userList = new ArrayList<>();
        userList.add(new User("晓萌",1));
        userList.add(new User("小李",2));
        userList.add(new User("小张",1));

        map.put("userList",userList);

        map.put("sex",2);
        map.put("man",1);

        map.put("desc","<h1>helloworld<h1/>");

        //将user对象绑定到session中
        request.getSession().setAttribute("user", new User("小刘",2));


        return "study";
    }
}
