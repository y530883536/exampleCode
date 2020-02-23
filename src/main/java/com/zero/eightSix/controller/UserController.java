package com.zero.eightSix.controller;


import com.zero.eightSix.mapper.UserMapper;
import com.zero.eightSix.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/getById/{id}")
    public User getById(@PathVariable int id){
        User user = userMapper.selectById(id);
        return user;
    }

}

