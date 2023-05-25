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
import java.util.List;

@WebServlet("/grade/list")
public class GradeListController extends HttpServlet {
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
        int page = Integer.parseInt(req.getParameter("page"));
        int size = Integer.parseInt(req.getParameter("size"));


        try {
            List<Grade> list = gradeService.list(page,size);
            String jsonString = JSONObject.toJSONString(list);
            resp.setContentType("application/json;charset=utf-8");
            resp.getWriter().println(jsonString);
        }catch(Exception e) {
            throw new RuntimeException();
        }
    }
}
