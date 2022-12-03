package wxx.javaPra;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mr.wxx
 * @create 2022-10-23-17:47
 **/
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        // 双指针 滑动窗口
        int leftPoint = 0, rightPoint = 0;
        // 窗口包含字符Map
        Map<Character, Integer> windowMap = new HashMap<>();
        int maxLen = 0;
        while(rightPoint < s.length()){
            if(!windowMap.containsKey(s.charAt(rightPoint))){
                // 记录元素的index
                windowMap.put(s.charAt(rightPoint), rightPoint);
            }else{
                // 记录当前map中元素个数
                maxLen = Math.max(maxLen, windowMap.size());
                // 删除窗口中左边界到重复元素的所有元素
                for(int i = leftPoint; i <= windowMap.get(s.charAt(rightPoint)); i++){
                    windowMap.remove(s.charAt(i));
                    leftPoint++;
                }
            }
            rightPoint++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.lengthOfLongestSubstring("abcabcbb");
    }
}
