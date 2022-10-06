package com.juc.pra;

import java.util.Scanner;

/**
 * @author Mr.wxx
 * @create 2021-08-12-19:49
 **/
public class Test28 {
    public static void main(String[] args) {
        //处理输入
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; ++i){
            nums[i] = in.nextInt();
        }
//        int n = 9;
//        int k = 3;
//        int[] nums = new int[]{1,3,2,1,1,2,2,2,2};
        int left = 0, right = 0;
        //滑动窗口移动，只要窗口size>=k，持续移动right到头
        int winSum = 0;
        double avg = 0, maxAvg = 0;
        //最大的左右指针
        int maxLeft = 0, maxRight = 0;
        while(left < n && right < n){
            winSum += nums[right];
            if(right-left+1 >= k){
                //计算avg
                avg = winSum * 1.0 / (right-left+1);
                //更新最大的均值
                if(avg > maxAvg){
                    maxAvg = avg;
                    maxLeft = left;
                    maxRight = right;
                }else if(avg == maxAvg){
                    if(right-left > maxRight - maxLeft){
                        maxLeft = left;
                        maxRight = right;
                    }
                }
            }
            right++;
            //当right到顶后，更新left和right，重新遍历
            if(right == n){
                left++;
                right = left;
                winSum = 0;
            }
        }
//        System.out.println("maxAvg = " + maxAvg);
//        System.out.println("maxLeft = " + maxLeft);
//        System.out.println("maxRight = " + maxRight);
        System.out.println(maxLeft + " " + maxRight);
    }
}
