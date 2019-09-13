package com.example.springboot.controller;

import com.example.springboot.dao.UserRepository;
import com.example.springboot.entity.User;
import com.example.springboot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    IUserService userService;

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable("id") Integer id){
        Optional<User> userOptional = userRepository.findById(id);
        User user = userOptional.get();
        return user;
    }

    @GetMapping("/user")
    public User AddUser(User user){
        User user2 = userRepository.save(user);
        return user2;
    }

    @GetMapping("/user2")
    public User AddUser2(User user){
        userService.addUser(user);
        return user;
    }
}
