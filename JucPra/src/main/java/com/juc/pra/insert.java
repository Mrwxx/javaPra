package com.juc.pra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Mr.wxx
 * @create 2021-07-18-10:57
 **/
public class insert {
    public static void main(String[] args) {
        int[] ans = new int[]{4,2, 1, 5};
        select(ans);
        for(int a : ans){
            System.out.println(a);
        }

        ArrayList<Integer> integers = new ArrayList<>();
    }

    public static void in(int[] nums){
        //插入排序
        //只有长度 >= 2才会排序
        int n = nums.length;
        //有序的位置
        if(n >= 2){
            //从i=1开始遍历
            for(int i = 1; i < n; ++i){
                //从后往前遍历有序的数组
                int x = nums[i];
                int j = i-1;
                while(j >= 0 && nums[j] > x){
                    //后移
                    nums[j+1] = nums[j];
                    j--;
                }
                //找到  nums[j] <= x的位置了，插入x
                nums[j+1] = x;
            }
        }
    }

    public static void bubble(int[] nums){
        //冒泡排序
        int n = nums.length;
        for(int i = 1; i < n; ++i){
            for(int j = 0; j < n-1; ++j){
                //交换每对顺序
                if(nums[j] > nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
    }

    public static void select(int[] nums){
        //选择排序
        //从未排序队列中选择最小的数字，排序到前方或者是后续位置
        int n = nums.length;
        for(int i = 0; i < n-1; ++i){
            int min = i;
            for(int j = i+1; j < n; ++j){
                if(nums[j] < nums[min]){
                    min = j;
                }
            }
            //交换min和i
            if(min != i){
                int temp = nums[min];
                nums[min] = nums[i];
                nums[i] = temp;
            }
        }
    }
}
