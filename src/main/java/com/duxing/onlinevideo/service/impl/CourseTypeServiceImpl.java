package com.duxing.onlinevideo.service.impl;

import com.duxing.onlinevideo.dao.CourseTypeDao;
import com.duxing.onlinevideo.entity.CourseType;
import com.duxing.onlinevideo.service.CourseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseTypeServiceImpl implements CourseTypeService {

    @Autowired
    CourseTypeDao courseTypeDao;

    @Override
    public int insertCourseType(CourseType courseType) {
        return courseTypeDao.insertCourseType(courseType);
    }
}
