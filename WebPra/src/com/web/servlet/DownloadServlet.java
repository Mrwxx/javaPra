package com.web.servlet;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

/**
 * @author Mr.wxx
 * @create 2021-04-07-13:37
 **/
@WebServlet(name = "download", urlPatterns = "/download")
public class DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 要下载的文件名
        String file = "王.txt";
        //2. 读取文件内容，通过ServletContext对象读取
        ServletContext servletContext = getServletContext();
        //3.获取服务器中的指定文件类型
        String mimeType = servletContext.getMimeType("/file/" + file);
        System.out.println(mimeType);
        //4.将文件类型返回给客户端
        response.setContentType(mimeType);


        Cookie cookie = new Cookie("name", "wangux");
        cookie.setMaxAge(1);
        cookie.setPath("/path");
        response.addCookie(cookie);
        HttpSession session = request.getSession();
        String id = session.getId();
        session.setAttribute("name", "wangx");
        int maxInactiveInterval = session.getMaxInactiveInterval();

        String str = "attachment;filename=" + URLEncoder.encode(file, "UTF-8");
        //5. 通过响应头告诉客户端该文件用于下载
        response.setHeader("Content-Disposition", str);
        //6.从服务器文件中获取输入流
        InputStream resourceAsStream = servletContext.getResourceAsStream("/file/" + file);
        //7.获取响应的输出流
        ServletOutputStream outputStream = response.getOutputStream();
        //8.将服务器文件的输入流复制到响应的输出流中，回传给客户端
        IOUtils.copy(resourceAsStream, outputStream);
    }
}
