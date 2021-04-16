package com.web.servlet;



import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author Mr.wxx
 * @create 2021-04-06-13:24
 **/
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
        String method = httpServletRequest.getMethod();
        if(method.equals("GET")){
            doGet();
        }else if(method.equals("POST")){
            doPost();
        }
        ServletConfig servletConfig = getServletConfig();
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
