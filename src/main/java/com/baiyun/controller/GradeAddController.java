package com.baiyun.controller;

import com.baiyun.service.GradeService;
import com.baiyun.service.impl.GradeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 获取数据get
 * 添加数据post
 * 修改数据put
 */
@WebServlet("/grade/add")
public class GradeAddController extends HttpServlet {

    private GradeService gradeService = new GradeServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取年级的名字
        String gradeName = req.getParameter("gradeName");
        //获取课程名称
        String course = req.getParameter("course");
        int add = gradeService.add(gradeName,course);
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().println(add);
    }
}
