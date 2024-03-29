package com.example.springboot08datajdbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

//@Controller
@RestController
public class ProviderController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/providers")
    private Map list(){
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from provider");
        Map<String, Object> map = maps.get(2);
        return map;
    }
}
