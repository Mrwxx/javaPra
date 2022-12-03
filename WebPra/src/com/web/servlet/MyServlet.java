package com.web.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @author Mr.wxx
 * @create 2021-04-06-13:24
 **/
@WebServlet(name = "MyServlet", urlPatterns = "/hello", initParams = {
    @WebInitParam(name = "username", value = "root"),
        @WebInitParam(name = "password", value = "123")} )
public class MyServlet implements Servlet {

    public MyServlet(){
        System.out.println("Servlet构造器");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init开始");
        System.out.println("username + " + servletConfig.getInitParameter("username"));
        System.out.println("password + " + servletConfig.getInitParameter("password"));
        System.out.println("servlet name = " + servletConfig.getServletName());
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Servlet已执行");
        HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;
        HttpServletResponse httpServletResponse =  (HttpServletResponse)servletResponse;
        //获取请求头
        System.out.println(httpServletRequest.getHeader("name"));
        //设置响应头
        httpServletResponse.setHeader("return","wangxu");
        String method = httpServletRequest.getMethod();
        if(method.equals("GET")){
            doGet();
        }else if(method.equals("POST")){
            doPost();
        }
    }

    //Get请求处理方法
    public void doGet(){
        System.out.println("Get请求");
    }
    //Post请求处理方法
    public void doPost(){
        System.out.println("Post请求");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("Servlet销毁");
    }
}
