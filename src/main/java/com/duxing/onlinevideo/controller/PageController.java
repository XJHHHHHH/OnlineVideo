package com.duxing.onlinevideo.controller;

//import com.duxing.onlinevideo.exception.UserException;
import com.duxing.onlinevideo.entity.CourseTopics;
import com.duxing.onlinevideo.service.CourseTopicsService;
        import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {


    @Autowired
    CourseTopicsService courseTopicService;

    //首页
    @RequestMapping(value = "/")
    public String indexPage() {
        // 获取首页数据

        // 最新
        // 设置分页 第几页，显示N个
        PageInfo<CourseTopics> newsetTopicList = courseTopicService.getIndexNewestTopic(4);
        // type=3
        // 设置分页 第几页，显示N个

        PageInfo<CourseTopics> courseTopicList = courseTopicService.getIndexCourseTopic(3);

        return "index";
    }


    // vip
    @RequestMapping(value = "/vip")
    public String vip() {

        return "vip";
    }

    @RequestMapping(value = "/courseVideo")
    public String courseVideo(){
        return "course_video";
    }


    //课程列表
    @RequestMapping(value = "/courseList")
    public String courseList() {

        return "course_list";
    }

    //工具
    @RequestMapping(value = "/tools")
    public String toolsPage() {

        return "tools";
    }
}
