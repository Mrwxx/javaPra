package com.leetcode.stringCode.subSequence;

import java.util.HashSet;

/**
 * @author Mr.wxx
 * @create 2023-10-16-22:27
 **/
public class M3 {
    public int lengthOfLongestSubstring(String s) {
        // 题目： 要求找出不含重复字符的子串，子串长度最长是多少
        // 思路：
        // 1、判断子串无重复字符的方法：set表示窗口内的字符，重复即为重复字符
        // 2、双指针表示窗口内字符串，set存储窗口内字符

        // 判空处理
        if(s == null || s.length() == 0){
            return 0;
        }

        int left = 0 , right = 0;
        int maxWindows = 0;
        HashSet<Character> windows = new HashSet<>();
        while(right != s.length()) {
            char rightChar = s.charAt(right);
            if (!windows.contains(rightChar)) {
                windows.add(rightChar);
                right++;
            } else {
                // 输出结果计算
                maxWindows = Math.max(maxWindows, windows.size());
                // left右移，直到遇到rightChar为止，说明windows中已无重复字符
                char leftChar = s.charAt(left);
                while (leftChar != rightChar) {
                    windows.remove(leftChar);
                    leftChar = s.charAt(++left);
                }
                // 此时leftChar == rightChar，rightChar无需入库，原有的leftChar也无需出库
                left++;
                right++;
            }
        }
        // 循环中存在两个分支，防止从第一个分支中逃出，输出结果计算
        maxWindows = Math.max(maxWindows, windows.size());
        return maxWindows;
    }
}
