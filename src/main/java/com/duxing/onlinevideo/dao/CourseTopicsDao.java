package com.duxing.onlinevideo.dao;

import com.duxing.onlinevideo.entity.CourseTopics;

import java.util.HashMap;
import java.util.List;

public interface CourseTopicsDao {

    int insertCourseTopic(CourseTopics courseTopic);

    List<CourseTopics> findCourseTopicsByCondition(HashMap<String, Object> map);

    List<CourseTopics> findCourseTopicsByIds(List<Integer> list);
}
