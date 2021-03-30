package com.duxing.onlinevideo.interceptor;

import com.duxing.onlinevideo.util.Constants;
import com.duxing.onlinevideo.util.UserAutoLoginUtil;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AutoLoginInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Cookie[] cookies = request.getCookies();
        ServletContext application = request.getServletContext();
        HttpSession session = request.getSession(true);
        boolean valid = UserAutoLoginUtil.checkLoginToken(cookies, application);
        if (valid) {
            // 有效的token，恢复用户的登录状态
            session.setAttribute(Constants.LOGIN_USER, UserAutoLoginUtil.getUserByApplication(cookies, application));
        }

        return true;
    }
}
