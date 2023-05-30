package com.baiyun.controller;

import com.alibaba.fastjson2.JSONObject;
import com.baiyun.entity.Clazz;
import com.baiyun.service.ClazzService;
import com.baiyun.service.impl.ClazzServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/clazz")
public class ClazzController extends HttpServlet {
    ClazzService clazzService = new ClazzServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if ("selectAllByPageAndRow".equals(method)){
            selectAllByPageAndRow(req, resp);
        }else if ("selectAlldt".equals(method)){
            selectAlldt(req, resp);
        }
    }
    private void selectAllByPageAndRow(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        List<Clazz> list = null;
        int page = Integer.parseInt(req.getParameter("page"));
        int rows = Integer.parseInt(req.getParameter("rows"));
        list = clazzService.selectAllByPageAndRow(page,rows);
        String jsonString = JSONObject.toJSONString(list);
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().println(jsonString);
    }
    private void selectAlldt(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        String gid = req.getParameter("gid");
        List<Clazz> list = clazzService.selectAlldt(gid);
        String jsonString = JSONObject.toJSONString(list);
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().println(jsonString);
    }
}
