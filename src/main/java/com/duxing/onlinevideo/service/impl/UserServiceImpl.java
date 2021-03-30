package com.duxing.onlinevideo.service.impl;


import com.duxing.onlinevideo.dao.UserDao;
import com.duxing.onlinevideo.entity.User;
import com.duxing.onlinevideo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.Date;
import java.util.HashMap;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    UserDao userDao;


    @Override
    public User login(User user) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("email", user.getEmail());
        map.put("password", user.getPassword());
        return userDao.findUserByCondition(map);
    }

    @Override
    public int regist(User user) {
        user.setCreateTime(new Date());
        user.setVipFlag(0);
        return userDao.insertUser(user);
    }

    @Override
    public User existEmail(String email) {

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("email", email);

        return userDao.findUserByCondition(map);
    }
}
