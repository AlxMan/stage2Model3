package com.example.stage2Model3.controller;

import com.example.stage2Model3.dao.LoginDao;
import com.example.stage2Model3.entity.Login;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String name= request.getParameter("name");
        String pwd= request.getParameter("pwd");
        Login login=new Login(name,pwd);
        //调用模型层的登录功能
        int result= LoginDao.login(login);
        if(result>0) {
                request.getRequestDispatcher("welcome.jsp").forward(request, response);
        }else {//返回登录页，重新登录
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
