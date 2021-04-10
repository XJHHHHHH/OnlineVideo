package com.duxing.onlinevideo.dao;

import com.duxing.onlinevideo.entity.CourseVideo;

import java.util.HashMap;
import java.util.List;

public interface CourseVideoDao {

    int insertCourseVideo(CourseVideo courseVideo);

    List<CourseVideo> findCourseVideoByCondition(HashMap<String,Object> map);

    CourseVideo findCourseVideoByIds(List<Integer> list);
}
