package com.example.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BillController {

    @GetMapping("/bills")
    public String bill(){

//        int i = 1/0;
       int i=0;
        if(i == 0){
            throw new RuntimeException("i不能等于0");
        }
        return "bill/list";
    }
}
