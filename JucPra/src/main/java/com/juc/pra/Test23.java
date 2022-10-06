package com.juc.pra;
import java.util.Scanner;
/**
 * @author Mr.wxx
 * @create 2021-08-09-17:48
 **/
public class Test23 {
    // 本题为考试多行输入输出规范示例，无需提交，不计分。
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int k = 2;
            System.out.println(n+"=");
            while(n != k){
                if(n % k == 0){
                    n = n / k;
                    System.out.print(k + "*");
                }else{
                    k++;
                }
            }
            System.out.println(n);
        }

}
