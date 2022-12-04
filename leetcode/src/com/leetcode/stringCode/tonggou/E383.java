package com.leetcode.stringCode.tonggou;

import java.util.HashMap;

/**
 * @author Mr.wxx
 * @create 2022-12-04-17:59
 **/
public class E383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        // 思路：判断A字符串的字符出现次数 <= B字符串的字符出现次数
        // 遍历magazine字符串获取字符出现次数，最后遍历ransomNote字符串判断是否超出

        // 判空
        if(ransomNote == null || magazine == null){
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        // 遍历ransomNote字符串
        for (char c : ransomNote.toCharArray()) {
            // 如果当前字符在magazine字符串中已无法对应
            if(map.getOrDefault(c, 0) == 0){
                return false;
            }else{
                // 当前字符在magazine字符串中相应地减掉1
                map.put(c, map.get(c) - 1);
            }
        }
        return true;
    }
}
