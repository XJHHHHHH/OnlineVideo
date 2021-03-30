package com.duxing.onlinevideo.service;

import com.duxing.onlinevideo.entity.CourseTopics;
import com.github.pagehelper.PageInfo;

public interface CourseTopicsService {

    PageInfo<CourseTopics> getIndexCourseTopic(int typeId);

    PageInfo<CourseTopics> getIndexNewestTopic(int limit);
}
