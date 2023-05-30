package com.baiyun.controller;

import com.alibaba.fastjson2.JSONObject;
import com.baiyun.entity.Teacher;
import com.baiyun.service.TeacherService;
import com.baiyun.service.impl.TeacherServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/teacher")
public class TeacherController extends HttpServlet {

    private TeacherService teacherService=new TeacherServiceImpl();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if ("selectAll".equals(method)){
            selectAll(req, resp);
        }else if ("delete".equals(method)){
            delete(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String number=req.getParameter("number");
        String name=req.getParameter("name");
        String gender=req.getParameter("gender");
        String phone=req.getParameter("phone");
        String qq=req.getParameter("qq");
        Map<String,Object> result=teacherService.addTeacher(number,name,gender,phone,qq);
        String s= JSONObject.toJSONString(result);
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write(s);
    }

    private void selectAll(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        List<Teacher> list =teacherService.getAllTeachers();
        String s= JSONObject.toJSONString(list);
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write(s);
    }
    private void delete(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        String ids[] = req.getParameterValues("ids[]");
        Map<String,Object> result = teacherService.delete(ids);
        String s = JSONObject.toJSONString(result);
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write(s);
    }
}
