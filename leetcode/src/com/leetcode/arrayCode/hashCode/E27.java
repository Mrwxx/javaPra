package com.leetcode.arrayCode.hashCode;

/**
 * @author Mr.wxx
 * @create 2023-07-05-0:40
 **/
public class E27 {
    public int removeElement(int[] nums, int val) {
        // 思路：双指针
        // 左右指针相向而行，交换两个指针所指向的值
        int len = nums.length;
        int left = 0, right = len - 1;
        while (left <= right) {
            // 从左开始查找==val的值
            int mid = left + (right - left) / 2;
            while (left <= right && nums[left] != val) {
                left++;
            }
            // 从右开始查找!=val的值
            while (right >= left && nums[right] == val) {
                right--;
            }
            // 交换两个指针
            if (left <= right) {
                swap(nums, left, right);
            }
        }
        return left;
    }

    public void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void main(String[] args) {
        E27 e27 = new E27();
        e27.removeElement(new int[]{2}, 3);
    }
}
