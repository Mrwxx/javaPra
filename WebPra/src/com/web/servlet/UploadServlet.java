package com.web.servlet;


import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author Mr.wxx
 * @create 2021-04-07-11:02
 **/
public class UploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Post请求收到");
        //1 先判断上传的数据是否多段数据（只有是多段的数据，才是文件上传的）
        if (ServletFileUpload.isMultipartContent(request)) {
// 创建 FileItemFactory 工厂实现类
            FileItemFactory fileItemFactory = new DiskFileItemFactory();
// 创建用于解析上传数据的工具类 ServletFileUpload 类
            ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
            try {
// 解析上传的数据，得到每一个表单项 FileItem
                List<FileItem> list = servletFileUpload.parseRequest(request);
// 循环判断，每一个表单项，是普通类型，还是上传的文件
                for (FileItem fileItem : list) {
                    if (fileItem.isFormField()) {
// 普通表单项
                        System.out.println(" 表单项的 name  属性值：" + fileItem.getFieldName());
// 参数 UTF-8. 解决乱码问题
                        System.out.println(" 表单项的 value  属性值：" + fileItem.getString("UTF-8"));
                    } else {
// 上传的文件
                        System.out.println(" 表单项的 name  属性值：" + fileItem.getFieldName());
                        System.out.println(" 上传的文件名：" + fileItem.getName());
                        fileItem.write(new File("D:\\" + fileItem.getName()));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
