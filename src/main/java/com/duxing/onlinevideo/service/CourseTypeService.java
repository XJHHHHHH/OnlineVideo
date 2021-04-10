package com.duxing.onlinevideo.service;

import com.duxing.onlinevideo.entity.CourseType;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface CourseTypeService {

    int insertCourseType(CourseType courseType);
    List<CourseType> findCourseTypeAll();

    PageInfo<CourseType> getPageInfoCourseType();
}
