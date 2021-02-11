package com.example.stage2Model3.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class addStudentFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request=  (HttpServletRequest) servletRequest;
        HttpServletResponse response =  (HttpServletResponse) servletResponse;
        if(request.getMethod().equalsIgnoreCase("post")){
            request.setCharacterEncoding("UTF-8");
        }
        response.setContentType("text/html;charset=utf-8");
        HttpSession session = request.getSession(true);
        Object username=session.getAttribute("name");
        if(null!=username) {//已登录
            filterChain.doFilter(servletRequest,servletResponse);
        }else {//未登录
            //直接重定向到登录页面
            response.sendRedirect(request.getContextPath()+"/login.jsp");
        }
    }

    @Override
    public void destroy() {

    }
}
