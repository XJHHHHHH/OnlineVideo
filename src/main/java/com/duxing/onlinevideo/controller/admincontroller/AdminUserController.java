package com.duxing.onlinevideo.controller.admincontroller;

import com.duxing.onlinevideo.entity.User;
import com.duxing.onlinevideo.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AdminUserController {
    @Autowired
    UserService userService;


    //管理网站后台的控制类
    @RequestMapping("/admin/user")
    public String adminUser(Model model, Integer pageNum) {
        model.addAttribute("navFocus",1);
        //首页显示所有的user数据,每页显示8个
        if (pageNum == null || pageNum <= 1) {
            pageNum = 1;
        }
        PageHelper.startPage(pageNum, 10);
        PageInfo<User> pageInfo = userService.adminUser();
        model.addAttribute("userList", pageInfo);
        return "admin";
    }

    @RequestMapping("/admin/user/del/{userId}")
    public String delUser(Model model, @PathVariable Integer userId, Integer pageNum) {
        userService.adminDeleteUserFlag(userId);
        //首页显示所有的user数据,每页显示8个

        if (pageNum == null || pageNum <= 1) {
            pageNum = 1;
        }
        return "redirect:/admin/user?pageNum=" + pageNum;
    }

    @RequestMapping("/admin/user/update/{userId}")
    public String updateUser(@PathVariable Integer userId,Model model,Integer pageNum) {
        model.addAttribute("navFocus",1);
        User user = userService.getUserById(userId);
        model.addAttribute("user",user);
        model.addAttribute("pageNum",pageNum);
        return "admin_updateUser";
    }

    @RequestMapping(value = "/admin/updateUser",method = RequestMethod.POST)
    public String updateUser(User user,Integer pageNum) {
        userService.adminUpdateUser(user);
        return "redirect:/admin/user?pageNum="+pageNum;
    }

    @RequestMapping("/admin/add")
    public String adminAddUser(User user){
        int code = userService.regist(user);
        return "redirect:/admin/user";
    }

}


