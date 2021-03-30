package com.duxing.onlinevideo.service.impl;

import com.duxing.onlinevideo.dao.CourseTopicsDao;
import com.duxing.onlinevideo.entity.CourseTopics;
import com.duxing.onlinevideo.service.CourseTopicsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;


@Service
public class CourseTopicsServiceImpl implements CourseTopicsService {

    @Autowired
    CourseTopicsDao courseTopicsDao;

    @Override
    public PageInfo<CourseTopics> getIndexCourseTopic(int typeId) {
        //当前第 1 页 ，每页 4 个数据
        PageHelper.startPage(1, 4);
        HashMap<String, Object> map = new HashMap<>();
        // 类型ID
        map.put("typeId", typeId);
        // flag=1
        map.put("flag", 1);

        List<CourseTopics> list = courseTopicsDao.findCourseTopicsByCondition(map);

        PageInfo<CourseTopics> pageInfo = new PageInfo<>(list);

        return pageInfo;
    }

    @Override
    public PageInfo<CourseTopics> getIndexNewestTopic(int limit) {
        // TODO 1
        PageHelper.startPage(1, limit);

        HashMap<String, Object> map = new HashMap<>();
        // 排序 ==1 倒序 desc
        map.put("order", 1);
        // flag=1
        map.put("flag", 1);
        List<CourseTopics> list = courseTopicsDao.findCourseTopicsByCondition(map);

        // TODO 2
        // TODO 3 MYBATIS 配置文件拦截器
        PageInfo<CourseTopics> pageInfo = new PageInfo<>(list);

        return pageInfo;

    }
}
