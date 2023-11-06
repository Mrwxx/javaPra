package com.leetcode.stringCode.simulation;

/**
 * @author Mr.wxx
 * @create 2023-10-22-16:53
 **/
public class M38 {
    public static void main(String[] args) {
        M38 m38 = new M38();
        m38.countAndSay(4);
    }
    public String countAndSay(int n) {
        // 题目：后一个字符串描述前一个字符串，迭代而成
        // 思路：从1开始模拟生成后面的字符串，描述前一个字符串，找出每一段连续的数字，
        // 描述该连续的数字即可，生成新的字符串

        // 特殊情况：无
        String preStr = "1";
        for(int i = 2; i <= n; i++){
            // 遍历前一个字符串
            int index =0 ;
            StringBuilder sb = new StringBuilder();
            while(index < preStr.length()){
                // 寻找相同的字符
                int count = 1;
                while(index + 1 < preStr.length() && preStr.charAt(index + 1) == preStr.charAt(index)){
                    index++;
                    count++;
                }
                // 后一个字符与当前字符不相同
                sb.append(count).append(preStr.charAt(index));
                index++;
            }
            preStr = sb.toString();
        }
        return preStr;
    }
}
