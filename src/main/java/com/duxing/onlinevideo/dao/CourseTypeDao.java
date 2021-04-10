package com.duxing.onlinevideo.dao;

import com.duxing.onlinevideo.entity.CourseType;

import java.util.HashMap;
import java.util.List;


public interface CourseTypeDao {

    int insertCourseType(CourseType courseType);

    List<CourseType> findCourseTypeAll();

    List<CourseType> findCourseTypeByCondition(HashMap<String,Object> map);

}
