package com.boot.controller;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Mr.wxx
 * @create 2021-11-01-22:35
 **/
public class getFileLineNums {
    public static void main(String[] args) {
        String path = "D:\\MR.WANG\\JAVA\\PaperParent";
        int lineNum = lineNumberCounter(path);
        System.out.println("lineNum:" + lineNum);
    }


    private static List<String> fileList = new ArrayList<>();

    /**
     * 通过递归一个路径获取所有文件的路径，不限深度
     * @param path
     */
    static void getFiles(final String path)
    {
        File file = new File(path);
        String[] list = file.list();
        for (final String s : list) {
            File subFile = new File(file.getPath()+"\\"+s);
            if(subFile.isDirectory())
            {
                getFiles(subFile.getPath());
            }else if(subFile.isFile())
            {
                if(subFile.getName().endsWith("java")){
                    fileList.add(subFile.getPath());
                }
            }
        }
    }

    /**
     * 获取文件行数的例子
     * @param path
     * @return
     */
    public static int lineNumberCounter(String path)
    {
        System.out.println("===============开始===============");
        getFiles(path);
        int sum = 0;
        LineNumberReader lineNumberReader = null;
        for (String file : fileList) {
            try {
                lineNumberReader = new LineNumberReader(new FileReader(new File(file)));
                lineNumberReader.skip(Long.MAX_VALUE);
                sum += lineNumberReader.getLineNumber();
                System.out.println("当前的文件为："+file+"\t\t\t\t 行数为："+lineNumberReader.getLineNumber());
                lineNumberReader = null;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return -1;
            } catch (IOException e) {
                e.printStackTrace();
                return -1;
            }
        }
        return sum;
    }

}
