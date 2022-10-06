package io;

import java.io.File;
import java.io.IOException;

/**
 * @author Mr.wxx
 * @create 2021-03-24-13:23
 **/
public class FileTest {
    static long num = 0;

    public static void main(String[] args)  {

        File f1 = new File("1.txt");
        System.out.println(f1);
        File absoluteFile = f1.getAbsoluteFile();
        System.out.println(absoluteFile);
        File f2 = new File("D:\\2.txt");
        System.out.println(f2);
        File f4 = new File("D:\\" + File.separator + "2.txt");
        String[] list = f4.list();
        boolean b = f1.renameTo(f2);
        System.out.println(f1.isFile());
        System.out.println(f1.exists());
        try {
            f1.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(f1.isFile());
        System.out.println(f1.exists());
        f2.mkdir();
        if(!f2.exists()){
            f2.mkdir();
            System.out.println("创建f2目录成功");
        }else{
            System.out.println("f2目录已存在");
            f2.delete();
        }
        // 遍历所有文件和目录
        File f5 = new File("D:\\BaiduNetdiskDownload\\尚硅谷Java\\0javase\\资料\\1_课件\\第2部分：Java高级编程\\尚硅谷_宋红康_第13章_IO流");
        File[] files = f5.listFiles();
        for(File f : files){
            if(f.isDirectory()){

                System.out.println("Dir: " + f);
            }else{
                System.out.println("File: " + f);
            }
        }
        for(File f : files){
            if(f.getName().endsWith(".txt")){
                System.out.println(f);
            }

        }

        dfs(files);
        System.out.println(num/(1024*1024) + "MB");
    }

    public static void dfs(File[] files){
        for(File f : files){
            if(f.isDirectory()){
                dfs(f.listFiles());
            }else{
                num += f.length();
                System.out.println(f);
            }
        }
    }
}
