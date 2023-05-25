package com.baiyun.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Properties;

@WebServlet("/index")
public class IndexController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Object user = session.getAttribute("user");
        if (user == null){
            //说明用户没登录
            resp.sendRedirect("/login.jsp");
            return;
        }
//        IndexController.class.getResourceAsStream("/systemInfo.properties");
        Properties properties = new Properties();
        properties.load(IndexController.class.getResourceAsStream("/systemInfo.properties"));
//        Set<Object> keySet =  properties.keySet();
//        for (Object key : keySet){
//            Object value = properties.get(key);
//            System.out.println(key + ">>>" +value);
//        }

        req.setAttribute("systemInfo",properties);
        req.setAttribute("user",req.getSession().getAttribute("user"));
        req.getRequestDispatcher("/admin/admin.jsp").forward(req,resp);
    }
}
