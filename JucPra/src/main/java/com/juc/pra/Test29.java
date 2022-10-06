package com.juc.pra;

import java.util.Scanner;

/**
 * @author Mr.wxx
 * @create 2021-08-12-20:25
 **/
public class Test29 {
    static int[][] nums;
    static int[] begin;
    public static void main(String[] args) {
        //处理输入
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        //数字转换操作数量
        nums = new int[][]{{0, 4, 3, 3, 4, 3, 2, 3, 1, 2},
                        {4, 0, 5, 3, 2, 5, 6, 1, 5, 4},
                        {3, 5, 0, 2, 5, 4, 3, 4, 2, 3},
                        {3, 3, 2, 0, 3, 2, 3, 2, 2, 1},
                        {4, 2, 5, 3, 0, 3, 4, 3, 3, 2},
                        {3, 5, 4, 2, 3, 0, 1, 4, 2, 1},
                        {2, 6, 3, 3, 4, 1, 0, 5, 1, 2},
                        {3, 1, 4, 2, 3, 4, 5, 0, 4, 3},
                        {1, 5, 2, 2, 3, 2, 1, 4, 0, 1},
                        {2, 4, 3, 1, 2, 1, 2, 3, 1, 0}
        };
        //初始每个数字对应的操作数
        begin = new int[]{6, 2, 4, 5, 4, 5, 6, 3, 8, 7};
        //原始的String为空的，则为s.substring(0, l+1)

        //函数计算从String a到 String b的操作次数
        for(int i = 0; i < str.length()-1; ++i){
            System.out.print(eacSsize(str,i+1) + " ");
        }
        System.out.print(eacSsize(str, str.length()));
    }

    public static int  changeNum(String a, String b){
        int n = a.length();
        int ans = 0;
        for(int i = 0; i < n; ++i){
            ans += (nums[a.charAt(i)-'0'][b.charAt(i)-'0']);
        }
        return ans;
    }

    public static int eacSsize(String str, int size){
        //每个窗口大小可以得到的操作总数
        int n = str.length();
        int ans = 0;
        //初始的窗口str
        String win = str.substring(0, size);
        //保存之前的string
        String tmp;
        //初始的窗口操作数
        for(int i = 0; i < win.length(); ++i){
            ans += begin[win.charAt(i)-'0'];
        }
        //开始变换
        for(int i = 1; i + size <= str.length(); ++i){
            //需要转换为的string
            tmp = str.substring(i, i+size);
            ans += changeNum(win, tmp);
            win = tmp;
        }
        return ans;
    }

}
