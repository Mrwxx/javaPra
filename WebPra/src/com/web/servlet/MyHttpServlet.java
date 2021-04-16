package com.web.servlet;

import javafx.scene.control.cell.ChoiceBoxTableCell;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Mr.wxx
 * @create 2021-04-06-15:59
 **/
public class MyHttpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getRequestURI());
        System.out.println(req.getRequestURL());
        System.out.println(req.getRemoteHost());
        System.out.println(req.getHeader("User-Agent"));
        System.out.println(req.getMethod());
        //获取请求参数
        System.out.println(req.getParameter("username"));
        System.out.println(req.getParameter("password"));
        for (String hobby : req.getParameterValues("hobby")) {
            System.out.println(hobby);
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/context");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // post请求中文乱码
        req.setCharacterEncoding("utf-8");
        //获取请求参数
        System.out.println(req.getParameter("username"));
        System.out.println(req.getParameter("password"));
        for (String hobby : req.getParameterValues("hobby")) {
            System.out.println(hobby);
        }
    }
}
