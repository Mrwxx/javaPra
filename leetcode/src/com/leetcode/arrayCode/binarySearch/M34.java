package com.leetcode.arrayCode.binarySearch;

/**
 * @author Mr.wxx
 * @create 2023-07-14-21:47
 **/
public class M34 {
    public int[] searchRange(int[] nums, int target) {
        // 思路：二分法查找target，不同的是可能有多个target，找到左边界的target以及右边界的target
        int len = nums.length;
        int left = 0, right = len, mid;
        // 特殊情况
        if (len == 0) {
            return new int[]{-1, -1};
        }
        int leftBorder = Integer.MAX_VALUE, rightBorder = Integer.MIN_VALUE;
        //找左边界的target
        while(left <= right){
            mid = left + (right - left) / 2;
            if(nums[mid] == target){
                leftBorder = mid;
                right = mid - 1; // 一直向左查找左边界
            }else if(nums[mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }


    }

    public int binarySearch(int[] nums, int target, int border, boolean isLeft){
        int len = nums.length;
        int left = 0, right = len, mid;
        // 特殊情况
        if (len == 0) {
            return border;
        }
        //找左边界的target
        while(left <= right){
            mid = left + (right - left) / 2;
            if(nums[mid] == target){
                border = mid;
                if(isLeft){
                    right = mid - 1; // 一直向左查找左边界
                }else{
                    left = mid + 1; // 一直向右查找右边界
                }
                right = mid - 1;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return border;
    }
}
