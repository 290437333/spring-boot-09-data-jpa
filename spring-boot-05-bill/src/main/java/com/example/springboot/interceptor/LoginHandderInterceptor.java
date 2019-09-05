package com.example.springboot.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandderInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object session = request.getSession().getAttribute("loginUser");
        if (session != null){
            //放行
            return true;
        }
        //没有登录过
        request.setAttribute("msg","没有权限，请先登录！");
        request.getRequestDispatcher("/index.html").forward(request,response);
        return false;
    }
}
