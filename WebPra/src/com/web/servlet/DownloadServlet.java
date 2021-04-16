package com.web.servlet;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Mr.wxx
 * @create 2021-04-07-13:37
 **/
public class DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 要下载的文件名
        String file = "4.3.txt";
        //2. 读取文件内容，通过ServletContext对象读取
        ServletContext servletContext = getServletContext();
        // 获取文件类型
        String mimeType = servletContext.getMimeType("/file/" + file);
        System.out.println(mimeType);
        // 4。 将文件类型返回给客户端
        response.setContentType(mimeType);
        Cookie cookie = new Cookie("name", "wangux");
        cookie.setMaxAge(1);
        cookie.setPath("/path");
        response.addCookie(cookie);
        HttpSession session = request.getSession();
        String id = session.getId();
        session.setAttribute("name", "wangx");
        int maxInactiveInterval = session.getMaxInactiveInterval();
        //5. 告诉客户端该文件用于下载
        response.setHeader("Content-Disposition", "attachment;filename=" + file);
        InputStream resourceAsStream = servletContext.getResourceAsStream("/file/" + file);
        //获取响应的输出流
        ServletOutputStream outputStream = response.getOutputStream();
        //3. 读入响应的输出流中，回传给客户端
        IOUtils.copy(resourceAsStream, outputStream);
    }
}
