package com.juc.pra;

import java.util.PriorityQueue;

/**
 * @author Mr.wxx
 * @create 2021-07-28-22:52
 **/
public class Test16 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 23, 21, 22};
        sortArray(nums);
        PriorityQueue<Integer> integers = new PriorityQueue<>();
//        integers.
    }

        public static int[] sortArray(int[] nums) {
            //插入排序，遍历思路，将未排序数组中的首个值插入已排序数组中
            //从后往前比较，找到合适的插入位置
            int n = nums.length;
            for(int i = 1; i < n; ++i){
                //倒序比较查询nums[i]的位置
                //记录nums[i]的值，因为要移动数组的部分值
                int temp = nums[i];
                for(int j = i-1; j >= 0; j--){
                    if(temp <= nums[j]){
                        //后移nums[j]
                        nums[j+1] = nums[j];
                        //填入nums[i]
                        nums[j] = temp;
                        break;
                    }else{
                        //后移nums[j]
                        nums[j+1] = nums[j];
                    }
                }
            }
            return nums;
        }

}
