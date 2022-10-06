package reflection;

import org.junit.Test;

import java.io.*;

/**
 * @author Mr.wxx
 * @create 2021-06-21-21:53
 **/
public class Tests {
    public static void main(String[] args) {


    }

    //默认从module中读取
    @Test
    public void test1() {
        System.out.println(A.m);
        FileReader fis = null;
        try {
            File file = new File("src/7.txt");
            System.out.println(file.getAbsolutePath());
            fis = new FileReader(file);
            char[] buffer = new char[1024];
            int read = 0;
            while ((read = fis.read(buffer)) != -1) {
                System.out.println(new String(buffer, 0, read));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //类加载器getResourceAsStream()从src目录下读取
    @Test
    public void test2(){
        InputStream resourceAsStream = null;
        InputStreamReader inputStreamReader = null;
        try {
            resourceAsStream = this.getClass().getClassLoader().getResourceAsStream("7.txt");
            inputStreamReader = new InputStreamReader(resourceAsStream);
            char[] buffer = new char[1024];
            int read;
            while((read = inputStreamReader.read(buffer)) != -1){
                System.out.println(new String(buffer,0,read));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                resourceAsStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                inputStreamReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

class A{
    static{
        m = 100;
    }

    public static int m = 300;
}
