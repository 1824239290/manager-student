package com.baiyun.controller;

import com.alibaba.fastjson2.JSONObject;
import com.baiyun.entity.Grade;
import com.baiyun.service.GradeService;
import com.baiyun.service.impl.GradeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/grade")
public class GradeController extends HttpServlet {
    private GradeService gradeService = new GradeServiceImpl();
    /**
     * 分页
     * 页码
     * 条数
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if ("selectAllByPage".equals(method)){
            selectAllByPage(req, resp);
        }else if ("selectAll".equals(method)){
            selectAll(req,resp);
        }
    }
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
    private void selectAllByPage(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int page = Integer.parseInt(req.getParameter("page"));
        int size = Integer.parseInt(req.getParameter("size"));
        List<Grade> list;

        try {
            list = gradeService.getList(page,size);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String jsonString = JSONObject.toJSONString(list);
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().println(jsonString);
    }
    private void selectAll(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        List<Grade> list = gradeService.selectAll();
        String jsonString = JSONObject.toJSONString(list);
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().println(jsonString);
    }
}
