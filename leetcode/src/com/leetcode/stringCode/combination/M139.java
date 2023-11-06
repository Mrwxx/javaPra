package com.leetcode.stringCode.combination;

import java.util.List;

/**
 * @author Mr.wxx
 * @create 2023-10-30-21:55
 **/
public class M139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        // 题目：从多个字符串中取k个组成一个固定的字符串
        // 思路：固定题目，从n个字符串中取k个字符串，组成一个新的字符串，可以使用回溯、动态规划的思路
        // 动态规划状态定义：dp[i]，前i个字符可以由指定的多个字符串组成，结果就是整个字符串是否可以由多个字符串组成
        // 状态变化逻辑：遍历字符串链表，判断每一个字符串能否通过减去该字符串长度的前序字符串+当前字符串组合而成
        // dp[i] = dp[i-word.length()] && s.substring(i-word.length(), i+1).equals(word)
        // 特殊值：dp[0] = false

       boolean[] dp = new boolean[s.length() + 1];
       dp[0] = true;
       for(int i = 1; i <= s.length(); i++){
           // 每一个字符串都可以重复使用，因此从头遍历
           for(String word : wordDict){
               if(i - word.length() >= 0 && dp[i - word.length()] && s.substring(i - word.length(), i).equals(word)){
                   dp[i] = true;
                   break;
               }
           }
       }
        return dp[s.length()];
    }
}
