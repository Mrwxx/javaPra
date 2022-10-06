package com.juc.pra;

/**
 * @author Mr.wxx
 * @create 2021-07-28-18:54
 **/
public class Test14 {
    public static void main(String[] args) {
        int[] nums = new int[]{12, 15, 18, 1, 3, 2, 5, 100};
        quickSort(nums, 0, nums.length-1);
        for(int num : nums){
            System.out.println(num);
        }
    }

    public static void quickSort(int[] nums, int left, int right){
        if(left < right){
            //划分
            int par = getIndex(nums, left, right);
            quickSort(nums, left, par-1);
            quickSort(nums, par+1, right);
        }
    }

    public static int getIndex(int[] nums, int left, int right){
        int j = left;
        for(int i = left+1; i <= right; ++i){
            if(nums[i] < nums[left]){
                j++;
                swap(nums, i, j);
            }
        }
        //j的位置就是left的索引位置
        swap(nums, j, left);
        return j;
    }

    public static void swap(int[] nums, int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
