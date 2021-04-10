package com.duxing.onlinevideo.service.impl;


import com.duxing.onlinevideo.dao.UserDao;
import com.duxing.onlinevideo.entity.User;
import com.duxing.onlinevideo.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.ognl.ObjectElementsAccessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

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
        //vipFlag == 0 代表不是会员
        user.setVipFlag(0);
        //flag==1 ，代表有效数据
        user.setFalg(1);
        return userDao.insertUser(user);
    }

    @Override
    public User existEmail(String email) {

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("email", email);

        return userDao.findUserByCondition(map);
    }

    //查询所有的flag==1 的User
    @Override
    public PageInfo<User> adminUser() {
        List<User> list = userDao.findUserAll();
        PageInfo<User> pageInfo =  new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public int adminDeleteUserFlag(Integer userId) {
        User user = getUserById(userId);
        user.setFalg(0);
        return userDao.updateUser(user);
    }

    @Override
    public User getUserById(Integer userId) {
        List<Integer> list = new ArrayList<>();
        list.add(userId);
        return userDao.findUserByIds(list);
    }

    @Override
    public int adminUpdateUser(User user){
        return userDao.updateUser(user);
    }
}
