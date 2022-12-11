package com.leetcode.sortCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Mr.wxx
 * @create 2022-12-08-22:38
 **/
public class EOffer40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        // 思路：优先队列来插入数字，插入一个数字就重新排序
        // 可以直接插入所有的数字，按照升序排列，最后输出k个队列尾部数字
        // 也可以

        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        Arrays.stream(arr).forEach(i -> {queue.offer(i);});
        int[] ans = new int[k];
        for(int i = 0; i < k; ++i){
            ans[i] = queue.poll();
        }
        return ans;
    }
}
