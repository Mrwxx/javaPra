package com.redisPra;
import java.io.*;

/**
 * @author Mr.wxx
 * @create 2021-04-25-16:37
 **/
public class ChaName {
    public static void main(String[] args) {
        File file = new File(ChaName.class.getResource("").getPath());
        System.out.println(file);
        String name = args[0];
        change(name,file);
    }

    /***
     * 修改当前目录下的指定文件内容，并生成新的文件
     * @param name
     * @param file
     */
    public static void change(String name,File file){
        //修改yml文件的第三行
        //首先查找当前目录下是否存在yml文件
        // 获取当前路径下的所有文件
        File[] files = file.listFiles();
        String fileName = "";
        for (int i = 0; i < files.length; i++) {
            //每个文件的名称
            fileName = files[i].getName();
            // 查找后缀为yml的文件
            String substring = fileName.substring(fileName.length() - 3, fileName.length());
            if(substring.equals("yml")){
                System.out.println(fileName);
                break;
            }
        }
        //找到该文件
        File fileCha = new File(file,fileName);
        // 修改后的临时文件
        File outFile = new File(file, "tmp.yml");
        if(fileCha.exists()){
            System.out.println("该文件存在");
        }else{
            System.out.println("该文件不存在");
            return;
        }
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileCha)));
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile)));
            String s = null;
            //记录该文件的所有内容
            while((s = bufferedReader.readLine()) != null){
                StringBuilder sb = new StringBuilder(s);
                System.out.println(s + " 长度为：" + s.length());
                if(s.substring(s.length()-5, s.length()).equals("exeSS")){
                    // 替换为传入的参数name
                    sb.replace(sb.length()-5, sb.length(), name+"_exeSS");
                }
                // 读一行，写一行
                bufferedWriter.write(sb.toString());
                //换行符
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(bufferedReader != null)
                    bufferedReader.close();
                if(bufferedWriter != null)
                    bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //删除源文件
        fileCha.delete();
        //改名为源文件
        outFile.renameTo(fileCha);
    }
}
