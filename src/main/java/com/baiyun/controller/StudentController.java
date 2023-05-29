package com.baiyun.controller;

import com.alibaba.fastjson2.JSONObject;
import com.baiyun.entity.Student;
import com.baiyun.service.StudentService;
import com.baiyun.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/student")
public class StudentController extends HttpServlet {
    private StudentService studentService = new StudentServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if ("selectAll".equals(method)){
            selectALL(req, resp);
        }else if ("selectAlldt".equals(method)){
            selectALLdt(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
    private void selectALL(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        List<Student> list = studentService.selectAll();
        String jsonString = JSONObject.toJSONString(list);
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().println(jsonString);
    }
    private void selectALLdt(HttpServletRequest req,HttpServletResponse resp) throws IOException{
        Map<String, String> map = null;
        String gid = null,cid = null;
        if (req.getParameter("gid") !=null){
            gid = req.getParameter("gid");
        }
        if (req.getParameter("cid")!= null){
            cid = req.getParameter("cid");
        }
        int page = Integer.parseInt(req.getParameter("page"));
        int rows = Integer.parseInt(req.getParameter("rows"));
//        map.put("rows",req.getParameter("rows"));
        List<Student> list = studentService.selectAlldt(gid,cid,page,rows);
        String jsonString = JSONObject.toJSONString(list);
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().println(jsonString);
    }
}
