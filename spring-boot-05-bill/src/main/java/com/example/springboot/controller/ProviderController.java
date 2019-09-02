package com.example.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 供应商的控制层
 */
@Controller
public class ProviderController {

    @GetMapping("/providers")
    public String list(){
        return "provider/list";
    }
}
