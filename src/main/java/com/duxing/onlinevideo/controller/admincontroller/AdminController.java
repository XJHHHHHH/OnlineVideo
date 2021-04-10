package com.duxing.onlinevideo.controller.admincontroller;

import com.duxing.onlinevideo.entity.CourseType;
import com.duxing.onlinevideo.entity.User;
import com.duxing.onlinevideo.service.CourseTypeService;
import com.duxing.onlinevideo.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    UserService userService;

    @Autowired
    CourseTypeService courseTypeService;


    //管理网站后台的控制类
    @RequestMapping("/admin")
    public String admin(Model model,Integer pageNum){
        //首页显示所有的user数据,每页显示8个
        if(pageNum==null || pageNum<=1){
            pageNum=1;
        }

        PageHelper.startPage(pageNum,10);
        PageInfo<User> pageInfo =  userService.adminUser();
        model.addAttribute("userList",pageInfo);
        return "admin";
    }

    @RequestMapping("/admin/courseType")
    public String adminCourseType(Model model,Integer pageNum){
        model.addAttribute("navFocus",2);
        if(pageNum==null || pageNum<=1){
            pageNum=1;
        }
        PageHelper.startPage(pageNum,8);
        PageInfo<CourseType> pageInfo =  courseTypeService.getPageInfoCourseType();
        model.addAttribute("courseTypeList",pageInfo);
        return "admin_courseType";
    }

    @RequestMapping("/admin/courseType/add")
    public String adminAddCourseType(CourseType courseType){
        courseTypeService.insertCourseType(courseType);
        return "redirect:/admin/courseType";
    }
}
