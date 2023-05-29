package com.baiyun.controller;

import com.alibaba.fastjson2.JSONObject;
import com.baiyun.service.impl.StudentServiceImpl;
import com.baiyun.entity.Student;
import com.baiyun.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet("/student")
public class StudentController extends HttpServlet {
    private StudentService studentService = new StudentServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> list = studentService.selectAll();
        String jsonString = JSONObject.toJSONString(list);
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().println(jsonString);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
