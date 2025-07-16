package com.kapibala.example.provider;

import com.kapibala.example.common.model.User;
import com.kapibala.example.common.service.UserService;

public class UserServiceImpl implements UserService {
    public User getUser(User user) {
        System.out.println("用户名：" + user.getName());
        return user;
    }
}

