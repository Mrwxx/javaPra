package com.web.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Mr.wxx
 * @create 2021-04-06-14:59
 **/
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
        System.out.println("ContextServlet接受到");
    }
}
