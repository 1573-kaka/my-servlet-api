package com.imust.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/first")
public class FirstServlet implements Servlet {
    public FirstServlet() {
        System.out.println("1.构造器方法");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("2.init初始化方法");
        // 可以获取Servlet程序的别名servlet-name的值
        String name = servletConfig.getServletName();
        System.out.println("name = " + name);
        // 获取初始化参数init-param
        String parameter = servletConfig.getInitParameter("url");
        System.out.println("parameter = " + parameter);
        // 获取ServletContext对象
        ServletContext context = servletConfig.getServletContext();
        System.out.println("context = " + context);

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("3.service方法");

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String method = request.getMethod();
        System.out.println("method = " + method);
        if ("get".equalsIgnoreCase(method)) {
            System.out.println("get请求");
        } else if("post".equalsIgnoreCase(method)) {
            System.out.println("post请求");
        } else {
            System.out.println("其他请求");
        }

    }

    public void doGet() {

    }

    public void doPost() {

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("4.destroy方法");
    }
}
