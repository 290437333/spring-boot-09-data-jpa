package com.example.springboot.service.impl;

import com.example.springboot.dao.UserRepository;
import com.example.springboot.entity.User;
import com.example.springboot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserRepository userRepository;
    //isolation指定隔离级别，propagation指令传播行为
    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED)   //当前方法开启事务管理
    @Override
    public Boolean addUser(User user) {
        //成功
        userRepository.save(new User("1","1"));
        userRepository.save(new User("12","12"));
        userRepository.save(new User("123","123"));
        userRepository.save(new User("1234","1234"));
        userRepository.save(new User("12345","12345"));

        //失败
        //userRepository.save(new User("123456","12345"));
        //userRepository.save(new User("1234567","12345"));

        userRepository.save(user);
        return null;
    }
}
