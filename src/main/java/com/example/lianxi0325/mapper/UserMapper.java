package com.example.lianxi0325.mapper;

import com.example.lianxi0325.entity.User;

public interface UserMapper {
    User selectUser(String username);

    void insert(User user);

    void updatePassword(User currentUser);

}
