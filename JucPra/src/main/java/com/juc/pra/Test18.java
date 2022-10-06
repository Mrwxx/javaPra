package com.juc.pra;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

/**
 * @author Mr.wxx
 * @create 2021-08-01-15:46
 **/
public class Test18 {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
//        5,6,8,26,50,48,52,55,10,1,2,1,20,5:3
//        int[] nums = new int[]{5,6,8,26,50,48,52,55,10,1,2,1,20,5};
//        int k = 3;
        String input = in.next();
        //逗号分隔
        String[] inputArr = input.split(",");
        int n = inputArr.length;
        int[] nums = new int[n];
        int k = 0;
        for(int i = 0; i < inputArr.length; ++i){
            if(i == inputArr.length-1){
                nums[i] = Integer.parseInt(inputArr[i].split(":")[0]);
                k = Integer.parseInt(inputArr[i].split(":")[1]);
                break;
            }
            nums[i] = Integer.parseInt(inputArr[i]);
        }
        //输入数据
        //输入数组

        //滑动窗口
        int left = 0, right = -1;
        //窗口大小固定，直接移动right即可
        int preSum = 0;
        int sum = 0;
        for(int i = 0; i < k; ++i){
            right++;
            sum += nums[right];
        }
        preSum = sum;
        //此时的right = k-1，left = 0，窗口长度为k
        double up = 0;
        while(right <= n-2){
            preSum = sum;
            sum += nums[++right];
            sum -= nums[left++];
            //比较
            up = Math.max((sum - preSum) * 1.0/ preSum, up);
        }
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        String format1 = decimalFormat.format(up);
        NumberFormat fmt = NumberFormat.getPercentInstance();
        fmt.setMaximumFractionDigits(2);
        String format2 = String.format("%.2f", up*100);
        System.out.println(format2);
//        String format = fmt.format(up);
//        System.out.println(format);
    }
}
