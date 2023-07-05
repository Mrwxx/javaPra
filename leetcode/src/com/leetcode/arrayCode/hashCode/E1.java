package com.leetcode.arrayCode.hashCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mr.wxx
 * @create 2023-06-30-0:25
 **/
public class E1 {
    public int[] twoSum(int[] nums, int target) {
        // a + b = target
        // 通过map来查找
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            // 判断另一个整数是否在map中
            if(!map.containsKey(target - nums[i])){
                // 不存在，则填入nums[i]，以及nums[i]的索引位置
                map.put(nums[i], i);
            }else{
                // 如果存在target-nums[i]，则直接返回两个整数的索引位置
                return new int[]{i, map.get(target-nums[i])};
            }
        }
        return new int[0];
    }
}
