package com.duxing.onlinevideo.service;

import com.duxing.onlinevideo.entity.CourseVideo;

import java.util.List;

public interface CourseVideoService {
    List<CourseVideo> getCourseVideoAllByTopicId(Integer topicId);

    CourseVideo getCourseVideo(Integer videoId);
}
