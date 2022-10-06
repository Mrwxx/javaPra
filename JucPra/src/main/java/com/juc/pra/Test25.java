package com.juc.pra;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Mr.wxx
 * @create 2021-08-10-20:25
 **/
public class Test25 {
    public static void main(String[] args) {
        //数据输入
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; ++i){
            a[i] = in.nextInt();
        }
        //从大的开始嵌套
        Arrays.sort(a);
        int side = a[n-1] / 3;
        int sum = 0;
        for(int i = n-1 ; i >= 0; i--){
            if(a[i] > side){
                continue;
            }
            for(int j = n-1; j >= i+1; j--){
                if(a[j] > 3 * a[i]){
                    //嵌套，修改a[j]为-1
                    a[j] = -1;
                    sum++;
                    break;
                }
            }
        }
        System.out.println(n-sum);
    }
}
