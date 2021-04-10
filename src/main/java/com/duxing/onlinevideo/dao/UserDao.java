package com.duxing.onlinevideo.dao;

import com.duxing.onlinevideo.entity.User;
import org.apache.ibatis.ognl.ObjectElementsAccessor;

import java.util.HashMap;
import java.util.List;

public interface UserDao {

    int insertUser(User user);

    User findUserByCondition(HashMap<String, Object> map);

    List<User> findUserAll();

    int updateUser(User user);

    User findUserByIds(List<Integer> list);
}
