package com.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Mr.wxx
 * @create 2021-04-06-18:51
 **/
public class ResServlet1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //第一种方式
        response.setStatus(302);
        response.setHeader("Location", "http://localhost:8080/WebPra/resServlet2");
        // 第二种方式
//        response.sendRedirect("http://localhost:8080/WebPra/resServlet2");
    }
}
