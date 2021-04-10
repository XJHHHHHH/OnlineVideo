package com.duxing.onlinevideo.controller;

//import com.duxing.onlinevideo.exception.UserException;
import com.duxing.onlinevideo.entity.CourseTopics;
import com.duxing.onlinevideo.service.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class PageController {


    @Autowired
    CourseTopicsService courseTopicService;

    @Autowired
    BannerService bannerService;

    @Autowired
    CourseTypeService courseTypeService;


    //首页
    @RequestMapping(value = "/")
    public String indexPage(Model model) {
        //首页导航条的navFocus，用于点击聚焦
        model.addAttribute("navFocus",1);
        // 获取首页数据
        model.addAttribute("bannerList",bannerService.findBannerByCondition());
        // 最新
        // 设置分页 第几页，显示N个
        PageHelper.startPage(1, 4);
        PageInfo<CourseTopics> newsetTopicList = courseTopicService.getIndexNewestTopic();
        model.addAttribute("newsetTopicList",newsetTopicList);
        // type=3
        // 设置分页 第几页，显示N个

        PageHelper.startPage(1, 4);
        PageInfo<CourseTopics> courseTopicList = courseTopicService.getIndexCourseTopic(2);
        model.addAttribute("courseTopicList",courseTopicList);
        return "index";
    }


    // vip
    @RequestMapping(value = "/vip")
    public String vip(Model model) {
        model.addAttribute("navFocus",3);
        return "vip";
    }


    @RequestMapping("/live")
    public String livePage(){
        return  "redirect:https://www.douyu.com";
    }


}
