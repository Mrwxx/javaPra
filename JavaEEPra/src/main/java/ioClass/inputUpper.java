package ioClass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Mr.wxx
 * @create 2022-10-06-12:31
 **/
public class inputUpper {
    public static void main(String[] args) {
        System.out.println("请输入信息（退出输入e或exit）：");
        // 将标准输入流这个字节流包装为字符流，再包装为缓冲流
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = null;
        try {
            while((s = br.readLine()) != null){
                if("e".equalsIgnoreCase(s) || "exit".equalsIgnoreCase(s)){
                    System.out.println("安全退出！");
                    break;
                }
                // 将读取到的字符串转为大写输出
                System.out.println("==>" + s.toUpperCase());
                System.out.println("继续输入信息");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(br != null){
                try {
                    // 关闭过滤流时，会自动关闭它包装的底层节点流
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
