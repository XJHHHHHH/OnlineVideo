package com.duxing.onlinevideo.service;

import com.duxing.onlinevideo.entity.User;

public interface UserService {

    User login(User user);

    int regist(User user);

    User existEmail(String email);
}
