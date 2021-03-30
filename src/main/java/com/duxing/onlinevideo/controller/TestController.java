package com.duxing.onlinevideo.controller;

import com.duxing.onlinevideo.entity.CourseType;
import com.duxing.onlinevideo.service.CourseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @Autowired
    CourseTypeService courseTypeService;

    @RequestMapping("/test")
    public String test(){


        return "course_video";
    }
}
