package com.leetcode.stringCode.combination;

import java.util.List;

/**
 * @author Mr.wxx
 * @create 2023-10-31-8:28
 **/
public class M93 {
    public List<String> restoreIpAddresses(String s) {
        // 题目：普通的回溯思路，解决将原字符串分割为多个IP地址的问题
        // 回溯停止条件：此时在IP地址的第四个位置，已经到达字符串的末尾，生成结果
        // 递归继续：若没有到达字符串末尾，则继续递归，向后取值，判断是否在1-255之间，如果是0则直接作为单独的位置不再向后延伸


    }
}
