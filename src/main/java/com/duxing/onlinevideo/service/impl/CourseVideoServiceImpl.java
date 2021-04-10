package com.duxing.onlinevideo.service.impl;

import com.duxing.onlinevideo.dao.CourseVideoDao;
import com.duxing.onlinevideo.entity.CourseVideo;
import com.duxing.onlinevideo.service.CourseVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class CourseVideoServiceImpl implements CourseVideoService {

    @Autowired
    CourseVideoDao courseVideoDao;

    @Override
    public List<CourseVideo> getCourseVideoAllByTopicId(Integer topicId) {
        HashMap<String,Object> map = new HashMap<>();
        //找到对应 topicId下所有video
        map.put("topicId",topicId);
        map.put("flag",1);
        List<CourseVideo> list =  courseVideoDao.findCourseVideoByCondition(map);
        return list;
    }

    @Override
    public CourseVideo getCourseVideo(Integer videoId) {
        List<Integer> list = new ArrayList<>();
        list.add(videoId);
        return courseVideoDao.findCourseVideoByIds(list);
    }
}
