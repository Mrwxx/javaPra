package com.web.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Mr.wxx
 * @create 2021-04-06-14:59
 **/
@WebServlet(name = "contextServlet", urlPatterns = "/context")
public class contextServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletConfig servletConfig = getServletConfig();
        ServletContext servletContext = servletConfig.getServletContext();
        Integer num = (Integer) servletContext.getAttribute("num");
        System.out.println("num = " + num);
        String realPath = servletContext.getRealPath("/");
        System.out.println(realPath);
        System.out.println(servletContext.getContextPath());
        servletContext.setAttribute("name", "wangxu");
        String name = (String)servletContext.getAttribute("name");
        System.out.println(name);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletConfig servletConfig = getServletConfig();
        ServletContext servletContext = servletConfig.getServletContext();

        // 它会同时设置服务器和客户端都使用 UTF-8 字符集，还设置了响应头
        // 此方法一定要在获取流对象之前调用才有效
        response.setContentType("text/html; charset=UTF-8");

        PrintWriter writer = response.getWriter();
        writer.write("wangxu");

        //设置context-param全局参数
        servletContext.setAttribute("name", "wangxu");
        System.out.println(servletContext.getAttribute("name"));
        System.out.println("ContextServlet接受到");
        //请求重定向
        response.sendRedirect("http://localhost:8080/WebPra/html/form.html");
        //请求转发
//        RequestDispatcher rd = request.getRequestDispatcher("/html/form.html");
//        rd.forward(request,response);

    }
}
