package com.leetcode.sortCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Mr.wxx
 * @create 2023-11-01-22:01
 **/
public class M56 {
    public int[][] merge(int[][] intervals) {
        // 题目：将多个重叠区间进行合并，输出合并后不重叠的区间数组
        // 思路：a、b区间重叠，是因为b的left值 <= a的right值
        // 将所有区间按照left值进行排序，这样就能够从小到大合并区间，前后区间不断合并，如果下一个区间与当前已合并的区间依然可以合并则继续合并
        // 如果不能合并，则将当前区间加入最终输出的队列中

        int len = intervals.length;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // left值升序
                return o1[0] - o2[0];
            }
        });
        ArrayList<int[]> ans = new ArrayList<>();
        int index = 0;
        int curLeft = intervals[0][0];
        int curRight = intervals[0][1];
        while(index < len){
            // 合并区间 = Math.min(a.left, b.left), Math.max(a.right, b.right)
            // 用curLeft, curRight 来表示当前已合并的区间值
            // 如果是新开始的区间，则正常进行
            if(intervals[index][0] <= curRight){
                // 区间存在重合，合并区间，更新curLeft, curRight，表示合并区间范围
                curLeft = Math.min(curLeft, intervals[index][0]);
                curRight = Math.max(curRight, intervals[index][1]);
                index++;
            }else{
                // 区间并无重合，输出curLeft, curRight 对应区间
                ans.add(new int[]{curLeft, curRight});
                // 当前index区间作为新的初始区间，刷新curLeft,curRight
                curLeft = intervals[index][0];
                curRight = intervals[index][1];
            }
        }
        // 最后一个区间无论是重合合并、还是不重合，都会遗漏
        ans.add(new int[]{curLeft, curRight});
        return ans.toArray(new int[ans.size()][]);
    }
}
