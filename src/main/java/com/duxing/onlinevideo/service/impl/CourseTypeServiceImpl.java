package com.duxing.onlinevideo.service.impl;

import com.duxing.onlinevideo.dao.CourseTypeDao;
import com.duxing.onlinevideo.entity.CourseType;
import com.duxing.onlinevideo.service.CourseTypeService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class CourseTypeServiceImpl implements CourseTypeService {

    @Autowired
    CourseTypeDao courseTypeDao;

    @Override
    public int insertCourseType(CourseType courseType) {
        return courseTypeDao.insertCourseType(courseType);
    }

    @Override
    public List<CourseType> findCourseTypeAll() {
        return courseTypeDao.findCourseTypeAll();
    }

    @Override
    public PageInfo<CourseType> getPageInfoCourseType() {
        HashMap<String,Object> map = new HashMap<>();
        map.put("flag",1);
        List<CourseType> list = courseTypeDao.findCourseTypeByCondition(map);

        PageInfo<CourseType> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
