package com.baiyun.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebFilter(urlPatterns = "/*")
public class PermissionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        //获取当前请求路径
        String requestURI =req.getRequestURI();
        if (requestURI.contains("/login")||requestURI.endsWith(".html")||requestURI.endsWith(".js")||requestURI.endsWith(".css")||requestURI.endsWith(".jpg")||requestURI.endsWith(".ttf")||requestURI.endsWith(".png")||requestURI.endsWith(".woff")){
            filterChain.doFilter(servletRequest,servletResponse);
        } else {
            Object user = req.getSession().getAttribute("user");
            if (user != null){
                filterChain.doFilter(servletRequest,servletResponse);
            }else {
                HttpServletResponse resp = (HttpServletResponse) servletResponse;
                resp.sendRedirect("/login.jsp");
            }
        }
    }
}
