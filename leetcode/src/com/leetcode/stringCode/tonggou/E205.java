package com.leetcode.stringCode.tonggou;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author Mr.wxx
 * @create 2022-12-04-14:12
 **/
public class E205 {
    public boolean isIsomorphic(String s, String t) {
        // 思路：字符的映射关系，相同字符只能够映射到相同的字符上，使用Map来映射

        // 判空
        if(s == null || t == null || s.length() != t.length()){
            return false;
        }
        HashMap<Character, Character> map = new HashMap<>();
        HashSet<Character> existedSet = new HashSet<Character>();
        for (int i = 0; i < s.length(); ++i) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            // 如果s中对应index的字符不存在，且t中对应index的字符也不存在，则可以新增
            if(!map.containsKey(sChar) && !existedSet.contains(tChar)){
                map.put(sChar, tChar);
                existedSet.add(tChar);
            }
            // 如果s中对应index的字符不存在，但是t中对应index的字符存在，则说明之前已经有对应字符存在，映射错误
            else if(!map.containsKey(sChar) && existedSet.contains(tChar)){
                return false;
            }
            // s中对应index的字符存在，则判断t中对应字符是否与map相同
            else{
                if(map.get(sChar) != tChar){
                    return false;
                }
            }
        }
        return true;
    }
}
