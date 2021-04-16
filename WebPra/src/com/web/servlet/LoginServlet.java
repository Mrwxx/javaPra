package com.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Mr.wxx
 * @create 2021-04-08-9:14
 **/
@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 防止中文乱码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=gbk");
        //获取输入的参数
        String user = request.getParameter("username");
        String pass = request.getParameter("password");
        if("wx".equals(user) && "123".equals(pass)){
            //密码正确，登录成功，向Session中添加参数
            request.getSession().setAttribute("user", user);
            response.getWriter().write("登录成功");
        }else{
            //登录失败
            response.getWriter().write("登录失败，重新登录");
            request.getRequestDispatcher("/html/login.html").forward(request,response);
        }
    }
}
