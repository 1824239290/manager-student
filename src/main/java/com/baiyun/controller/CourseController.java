package com.baiyun.controller;

import com.alibaba.fastjson2.JSONObject;
import com.baiyun.entity.Course;
import com.baiyun.service.CourseService;
import com.baiyun.service.impl.CourseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@WebServlet("/course")
public class CourseController extends HttpServlet {
    private CourseService courseService = new CourseServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Course> list = null;
        try {
            list = courseService.getAllCourses();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String jsonString = JSONObject.toJSONString(list);
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().println(jsonString);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String courseName = req.getParameter("courseName");
        Map<String,Object> result = courseService.addCourse(courseName);
        resp.setContentType("application/json;charset=utf-8");
        String s = JSONObject.toJSONString(result);
        resp.getWriter().write(s);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int cid = Integer.parseInt(req.getParameter("cid"));
        int add = 0;
        Map<String,Object> result = null;
        try {
            result = courseService.deleteCourse(cid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        resp.setContentType("application/json;charset=utf-8");
        String s = JSONObject.toJSONString(result);
        resp.getWriter().write(s);
    }
}
