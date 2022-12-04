package com.leetcode.stringCode.map;

import java.util.HashMap;

/**
 * @author Mr.wxx
 * @create 2022-12-04-18:38
 **/
public class E387 {
    public int firstUniqChar(String s) {
        /**  思路：限定条件：唯一字符，第一个；
         1.先找到所有的唯一字符；
         2.再从头开始遍历找到第一个字符；
         */

        // 判空
        if(s == null || s.length() == 1){
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for(int i = 0; i < s.length(); ++i){
            if(map.get(s.charAt(i)) == 1){
                return i;
            }
        }
        return -1;
    }
}
