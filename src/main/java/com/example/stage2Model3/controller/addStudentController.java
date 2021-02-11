package com.example.stage2Model3.controller;

import com.example.stage2Model3.entity.Student;
import com.example.stage2Model3.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class addStudentController extends HttpServlet
{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
        int id= Integer.parseInt(request.getParameter("id"));
        String name= request.getParameter("name");
        String sex = request.getParameter("sex");
        String birthday= request.getParameter("birthday");
        Student student = new Student(id,name,sex,birthday);
        StudentService studentservice = new StudentService();
        boolean result=studentservice.AddStudent(student);
        //out对象的获取方法
        PrintWriter out = response.getWriter();
        if(result) {

            out.println("添加成功");
        }else {

            out.println("添加失败");
        }
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}
