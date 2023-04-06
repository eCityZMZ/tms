package com.itheima.tms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.tms.entity.User;
import com.itheima.tms.mapper.UserMapper;
import com.itheima.tms.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService{
}
