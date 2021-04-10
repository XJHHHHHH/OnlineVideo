package com.duxing.onlinevideo.controller;

import com.duxing.onlinevideo.entity.CourseTopics;
import com.duxing.onlinevideo.entity.CourseVideo;
import com.duxing.onlinevideo.service.CourseTopicsService;
import com.duxing.onlinevideo.service.CourseVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CourseVideoController {

    @Autowired
    CourseVideoService courseVideoService;

    @Autowired
    CourseTopicsService courseTopicsService;

    @RequestMapping(value = "/courseVideo/{topicId}/{videoId}")
    public String courseVideo(@PathVariable Integer topicId,@PathVariable  Integer videoId, Model model){
        model.addAttribute("navFocus",2);

        //查询对应topicId的所有视频
        List<CourseVideo> list =  courseVideoService.getCourseVideoAllByTopicId(topicId);
        //如果videoId为-1,则是从专题直接点入的，默认返回对应专题视频的第一个
        if(videoId==-1){
            model.addAttribute("toVideo",list.get(0));
        }else {
            //否则获取对应videoId的courseVideo，存入model中
            model.addAttribute("toVideo",courseVideoService.getCourseVideo(videoId));
        }

        //获取对应topicId的 courseTopic  为了  加载该课程的 简介topic_intro
        CourseTopics courseTopics = courseTopicsService.getCourseTopicByID(topicId);

        model.addAttribute("courseTopic",courseTopics);
        model.addAttribute("videoList",list);
        return "course_video";
    }

}
