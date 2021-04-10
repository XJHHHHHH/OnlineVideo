package com.duxing.onlinevideo.service;

import com.duxing.onlinevideo.entity.User;
import com.github.pagehelper.PageInfo;

import java.util.HashMap;
import java.util.List;

public interface UserService {

    User login(User user);

    int regist(User user);

    User existEmail(String email);

    PageInfo<User> adminUser();

    int adminDeleteUserFlag(Integer userId);

    User getUserById(Integer userId);

    int adminUpdateUser(User user);
}
