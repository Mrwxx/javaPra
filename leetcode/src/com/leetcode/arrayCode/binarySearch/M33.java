package com.leetcode.arrayCode.binarySearch;

/**
 * @author Mr.wxx
 * @create 2023-07-12-23:38
 **/
public class M33 {
    public int search(int[] nums, int target) {
        // 算法目的：在一个数组中找到指定的值
        // 思路：1、O(n)顺序查找；2、O(logn)二分法查找
        // 二分法思路：mid位置的值必然会将数组拆分为一个有序或两个有序的队列，有序的队列中可以使用二分法进行查找，如果target在有序的队列中，则可以进行二分法；如果target不在有序的队列中，则可以在无序的队列中再次二分；
        int len = nums.length;
        int left = 0, right = len - 1, mid;

        // 特殊边界情况： len == 1 || len == 2
        if(len == 0){
            return -1;
        }
        // left == rigth时，也能够搜索最后一次
        while (left <= right) {
            mid = left + (right - left) / 2;
            if(nums[mid] == target){
                return mid;
            }
            // 通过nums[mid]判断左右两侧队列的有序性
            if (nums[0] <= nums[mid]) {
                // [left, mid]，之间的队列为递增序列
                if(nums[0] <= target && nums[mid] > target){
                    // target在递增序列[0, mid]之间
                    right = mid - 1;
                }else{
                    // target不在[0. mid]递增序列之间，则继续在[mid+1, right]之间查找
                    left = mid + 1;
                }
            }else{
                // [mid, right]，之间的队列为递增序列
                if(nums[mid] < target && nums[right] >= target){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
