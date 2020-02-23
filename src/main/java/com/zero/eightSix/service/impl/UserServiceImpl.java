package com.zero.eightSix.service.impl;

import com.zero.eightSix.model.User;
import com.zero.eightSix.mapper.UserMapper;
import com.zero.eightSix.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
