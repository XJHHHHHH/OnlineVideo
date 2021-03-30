package com.duxing.onlinevideo.dao;

import com.duxing.onlinevideo.entity.User;

import java.util.HashMap;

public interface UserDao {

    int insertUser(User user);

    User findUserByCondition(HashMap<String, Object> map);
}
