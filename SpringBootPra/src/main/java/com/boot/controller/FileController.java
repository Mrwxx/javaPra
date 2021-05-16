package com.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author Mr.wxx
 * @create 2021-04-29-14:04
 **/
@Controller
public class FileController {

    @RequestMapping(value = "/upload")
    public void upload(@RequestPart(value = "file")MultipartFile file){
        System.out.println("文件的类型为：" + file.getContentType());
        System.out.println("文件的上传名称为：" + file.getName());
        System.out.println("文件的本名为：" + file.getOriginalFilename());
        System.out.println("文件的大小为：" + file.getSize());
        try {
            file.transferTo(new File("D:\\" + file.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
