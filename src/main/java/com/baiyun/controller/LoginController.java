package com.baiyun.controller;

import com.alibaba.fastjson2.JSONObject;
import com.baiyun.config.VerificationCode;
import com.baiyun.entity.User;
import com.baiyun.service.UserService;
import com.baiyun.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


/**
 * 登录功能
 * account
 * password
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
         if ("code".equals(action)){
            //说明是想要验证码，不是登录
            VerificationCode verificationCode = new VerificationCode();

            BufferedImage image = verificationCode.getImage();

            String text = verificationCode.getText();
            System.out.println("text = "+text);
            req.getSession().setAttribute("code",text);
            VerificationCode.output(image,resp.getOutputStream());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String account =  req.getParameter("account");
        String password = req.getParameter("password");
        //获取前端传来的验证码
        String vcode = req.getParameter("vcode");
        String code =(String) req.getSession().getAttribute("code");

        if (vcode != null && !"".equals(vcode) && vcode.equalsIgnoreCase(code)){
            //说明前端传来验证码和服务端相同
            //调用业务层登录方法
            User user =  userService.login(account,password);
            if (user != null){
                //说明登录成功
                //将登录信息放到session中
                req.getSession().setAttribute("user",user);
            }
            String userJson = JSONObject.toJSONString(user);
            //将json返回给客户端
            // 声明返回类型json，字符集utf-8
            resp.setContentType("application/json;charset=utf-8");
            resp.getWriter().println(userJson);
        }else {
            //前端传来验证码有误
            Map<String,Object> map = new HashMap<>();
            map.put("status",500);
            map.put("message","验证码输入有误，请重新登录");
            String userJson = JSONObject.toJSONString(map);
            //将json返回给客户端
            // 声明返回类型json，字符集utf-8
            resp.setContentType("application/json;charset=utf-8");
            resp.getWriter().println(userJson);
        }
    }
}
