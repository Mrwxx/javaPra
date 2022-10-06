package com.juc.pra;

import java.util.Scanner;

/**
 * @author Mr.wxx
 * @create 2021-08-10-20:05
 **/
public class Test24 {
    public static void main(String[] args) {
        //处理输入
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
//        String s = "1101010110010110";
        //滑动窗口判断，继续滑动条件：窗口大小 < 3 || right以及前面的两个字符组成的不是110
        int n = s.length();
        int left =0 , right = 0;
        int maxLen = 0;
        while(right < n){
            //窗口长度不够
            if(right - left + 1 < 3){
                right++;
                continue;
            }
            //right组成了110，记录窗口大小
            if(s.substring(right - 2, right+1).equals("110")){
                maxLen = Math.max(maxLen, right - left);
                //修改left
                left = right-1;
            }
            right++;
        }
        System.out.println(maxLen);
    }
}
