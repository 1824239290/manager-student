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
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

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
        }else if (method.equals("selectAll")){
            selectAll(req,resp);
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
    private void selectAll(HttpServletRequest req,HttpServletResponse resp) throws IOException{
        String gid=null;
        gid=req.getParameter("gid");
        List<Clazz> list = null;
        try {
            list = clazzService.getAllClazz(gid);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String s = JSONObject.toJSONString(list);
        resp.setContentType("application/json; charset=utf-8");
        resp.getWriter().write(s);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if ("addClazz".equals(method)){
            addClazz(req,resp);
        }else if ("deleteClazz".equals(method)){
            deleteClazz(req, resp);
        }
    }
    private void addClazz(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        String clazzName = req.getParameter("clazzName");
        int gid = Integer.parseInt(req.getParameter("gid"));
        Map<String, Object> result = clazzService.addClazz(clazzName, gid);
        resp.setContentType("application/json; charset=utf-8");
        String c = JSONObject.toJSONString(result);
        resp.getWriter().write(c);
    }

    private void deleteClazz(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        String clazzName = req.getParameter("clazzid");
        Map<String, Object> result = clazzService.deleteClazz(clazzName);
        resp.setContentType("application/json; charset=utf-8");
        String c = JSONObject.toJSONString(result);
        resp.getWriter().write(c);
    }
}
