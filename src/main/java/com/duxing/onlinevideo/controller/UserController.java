package com.duxing.onlinevideo.controller;


import cn.hutool.core.util.ReUtil;
import cn.hutool.core.util.StrUtil;
import com.duxing.onlinevideo.dto.LoginToken;
import com.duxing.onlinevideo.dto.ResponseResult;
import com.duxing.onlinevideo.entity.User;
//import com.duxing.onlinevideo.exception.UserException;
import com.duxing.onlinevideo.service.UserService;
import com.duxing.onlinevideo.util.Constants;
import com.duxing.onlinevideo.util.UserAutoLoginUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
public class UserController {

    @Autowired
    UserService userService;


    @RequestMapping(value = "/checkLogin", method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult checkLogin(User user) {

        ResponseResult responseResult = new ResponseResult(-1, "login error");
        if (StrUtil.isEmpty(user.getEmail()) || StrUtil.isEmpty(user.getPassword())) {
            return responseResult;
        }

        User dbUser = userService.login(user);
        if (dbUser == null) {
            return responseResult;
        }
        responseResult.setRcode(1);
        responseResult.setMessage("ok");
        return responseResult;
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpSession session, HttpServletResponse response, HttpServletRequest request) {

        // 1清空用户session
        session.removeAttribute("login_user");


        // 2清空application中用户的登录数据
        String tokenValue = UserAutoLoginUtil.getCookieTokenValue(request);
        if (!StrUtil.isEmpty(tokenValue)) {
            ServletContext application = request.getServletContext();
            HashMap<String, LoginToken> map = (HashMap<String, LoginToken>) application.getAttribute(Constants.AUTO_LOGIN_TOKEN);
            // 删除服务器中token对应的user数据
            map.remove(tokenValue);
        }

        // 3设置cookie失效
        Cookie cookie = new Cookie("autoToken", "invalid");
        // 设置COOKIE保存属性
        cookie.setPath("/");
        // 单位秒
        cookie.setMaxAge(1);
        response.addCookie(cookie);


        // 重定向到首页
        return "redirect:/";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(User user, String autoLogin, HttpServletRequest request,
                        HttpSession session,
                        HttpServletResponse response) {

        ServletContext application = request.getServletContext();

        if (StrUtil.isEmpty(user.getEmail()) || StrUtil.isEmpty(user.getPassword())) {

           // throw new UserException("参数错误");
        }

        User dbUser = userService.login(user);
        if (dbUser != null) {
            // 登录
            session.setAttribute("login_user", user);
        }

        // TODO 上面是账号密码的判断

        // TODO 自动登录
        if (!StrUtil.isEmpty(autoLogin) || "1".equals(autoLogin)) {
            // 1 生成cookie返回给客户端凭证cookie
            // 2 服务器端保存token对应loginToken数据,application
            LoginToken loginToken = UserAutoLoginUtil.generateLoginToken(request, user);
            Cookie cookie = new Cookie("autoToken", loginToken.generateToken());
            // 设置COOKIE保存属性
            cookie.setPath("/");
            // 单位秒 48小时 60 * 60 * 48;
            cookie.setMaxAge(60 * 60 * 48);
            response.addCookie(cookie);

            // TODO 服务器保存对应的LoginToken用户登录数据
            HashMap<String,LoginToken> tokenMap = UserAutoLoginUtil.getTokenMap(application);
            //将loginToken数据存入 tokenMap
            tokenMap.put(loginToken.generateToken(), loginToken);
        }
        // 重定向到首页
        return "redirect:/";
    }

    @RequestMapping(value = "/regist", method = RequestMethod.POST)
    public String regist(User user, HttpSession session, String vcode) {

        // TODO 后台表单数据验证
        String sVcode = (String) session.getAttribute("session_vcode");
        if (StrUtil.isEmpty(vcode)) {
            // TODO 跳转到错误页面

            //throw new UserException("验证码错误");
        }

        boolean emailMatch = ReUtil.isMatch("[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?", user.getEmail());
        boolean phoneMatch = ReUtil.isMatch("1[3456789]\\d{9}$", user.getMobile());
        boolean passwordMatch = ReUtil.isMatch("^(?![\\d]+$)(?![a-zA-Z]+$)(?![^\\da-zA-Z]+$).{6,20}$", user.getPassword());
        if (!phoneMatch || !emailMatch || !passwordMatch) {
            // TODO 跳转到错误页面

            //throw new UserException("注册信息错误");
        }

        // 参数验证通过
        int code = userService.regist(user);
        if (code != 1) {
            // TODO 数据库插入数据失败，跳转错误页面

            //throw new UserException("注册失败");
        }

        // 注册成功直接登录
        session.setAttribute("login_user", user);

        // 重定向到首页
        return "redirect:/";
    }

    // 返回json
    @RequestMapping("/checkEmail")
    @ResponseBody
    public ResponseResult checkEmail(String email) {

        ResponseResult result = new ResponseResult(-1, "email exist");

        User user = userService.existEmail(email);
        if (user == null) {
            result.setRcode(1);
            result.setMessage("ok");
            return result;
        }

        return result;

    }
}
