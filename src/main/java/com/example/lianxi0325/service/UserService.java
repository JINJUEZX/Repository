package com.example.lianxi0325.service;

import com.example.lianxi0325.entity.User;
import com.example.lianxi0325.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User selectUser(String username) {
        return userMapper.selectUser(username);
    }

    public void insert(User user) {
        userMapper.insert(user);
    }

    public void updatePassword(User currentUser) {

        userMapper.updatePassword(currentUser);
    }
}
