package com.baiyun.controller;


import com.alibaba.fastjson2.JSONObject;
import com.baiyun.entity.GradeCourse;
import com.baiyun.service.GradeCourseService;
import com.baiyun.service.impl.GradeCourseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@WebServlet("/gradeCourse")
public class GradeCourseController extends HttpServlet {
    private GradeCourseService gradeCourseService =new GradeCourseServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<GradeCourse> list = gradeCourseService.getAllGradeCourses();
        String s = JSONObject.toJSONString(list);
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write(s);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String gradeName = req.getParameter("gradeName");
        String courseName = req.getParameter("courseName");
        Map<String,Object>result = null;
        try {
            result = gradeCourseService.addGrade(gradeName,courseName);
            String s = JSONObject.toJSONString(result);
            resp.setContentType("application/json;charset=utf-8");
            resp.getWriter().write(s);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    int gid= Integer.parseInt(req.getParameter("gid"));
        Map<String,Object>result = null;
        result = gradeCourseService.deleteGrade(gid);
        String s = JSONObject.toJSONString(result);
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write(s);
    }
}
