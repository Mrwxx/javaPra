package com.leetcode.stringCode.tonggou;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author Mr.wxx
 * @create 2022-12-04-16:45
 **/
public class E290 {
    public boolean wordPattern(String pattern, String s) {
        // 思路，同样也是两个字符串的映射问题，相同字符对应相同的字符串
        // 1.map存储字符与字符串的映射关系
        // 2.set存储已出现过的字符串，不允许两个不同的字符对应同一个字符串
        // 3.双指针遍历两个字符串，判断映射关系是否对应

        // 判空
        if(null == pattern || null == s){
            return false;
        }
        String[] sArray = s.split(" ");
        // 判空
        if(pattern.length() != sArray.length){
            return false;
        }

        HashMap<Character, String> map = new HashMap<>();
        HashSet<String> existedSet = new HashSet<>();
        for(int i = 0; i < pattern.length(); ++i){
            char pChar = pattern.charAt(i);
            String sString = sArray[i];

            if(!map.containsKey(pChar) && !existedSet.contains(sString)){
                map.put(pChar, sString);
                existedSet.add(sString);
            }
            else if(!map.containsKey(pChar) && existedSet.contains(sString)){
                return false;
            }
            else{
                if(!map.get(pChar).equals(sString)){
                    return false;
                }
            }
        }
        return true;
    }
}
