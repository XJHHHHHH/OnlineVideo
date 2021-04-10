package com.duxing.onlinevideo.controller;

import com.duxing.onlinevideo.entity.CourseTopics;
import com.duxing.onlinevideo.entity.CourseType;
import com.duxing.onlinevideo.service.CourseTopicsService;
import com.duxing.onlinevideo.service.CourseTypeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CourseTopicController {
    @Autowired
    CourseTopicsService courseTopicService;

    @Autowired
    CourseTypeService courseTypeService;

    //课程列表
    @RequestMapping(value = "/courseList")
    public String courseList(Model model) {
        model.addAttribute("navFocus",2);
        model.addAttribute("typeId",0);
        //课程页面，默认是全部,每页16个课程
        PageHelper.startPage(1,16);
        PageInfo<CourseTopics> pageInfo = courseTopicService.getIndexNewestTopic();

        List<CourseType> typeList = courseTypeService.findCourseTypeAll();
        model.addAttribute("typeList",typeList);
        model.addAttribute("topicList",pageInfo);
        return "course_list";
    }

    //@PathVariable注解是 接受请求路径中的占位符  {typeId}
    @RequestMapping(value = "/courseList/type/{typeId}")
    public String courseList(@PathVariable Integer typeId, Model model, Integer pageNum) {
        model.addAttribute("navFocus",2);
        //分页，
        //课程页面，默认是全部,每页16个课程
        if (pageNum==null || pageNum<=1){
            pageNum=1;
        }

        PageHelper.startPage(pageNum,16);
        PageInfo<CourseTopics> pageInfo = null;
        if(typeId==0){
            //typeId==0 说明是课程的全部首页，按最新排序
            pageInfo = courseTopicService.getIndexNewestTopic();
        }else {
            //typeId不是0 说明是 按对应·课程 typeId排序
            pageInfo = courseTopicService.getIndexCourseTopic(typeId);
        }

        List<CourseType> typeList = courseTypeService.findCourseTypeAll();
        model.addAttribute("typeList",typeList);
        model.addAttribute("typeId",typeId);
        model.addAttribute("topicList",pageInfo);
        return "course_list";
    }
}
