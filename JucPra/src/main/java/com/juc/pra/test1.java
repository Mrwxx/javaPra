package com.juc.pra;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mr.wxx
 * @create 2021-07-18-15:18
 **/
public class test1 {
    public static void main(String[] args) {

        new HashMap<>();
    }

    HashMap<Character, Integer> tStr;
    HashMap<Character, Integer> dyStr;
    public String findMinOverrideSubString(String source, String target) {
        // write code here
        tStr = new HashMap<>();
        dyStr = new HashMap<>();
        //初始化target的字符数量
        for(int i = 0; i < target.length(); ++i){
            tStr.put(target.charAt(i), tStr.getOrDefault(target.charAt(i), 0) + 1);
        }
        //窗口双指针
        int left = 0, right = -1;
        //最小窗口指针
        int minLeft = -1, minRight = -1;
        //最小窗口大小
        int minWin = Integer.MAX_VALUE;
        //开始遍历
        while(right < source.length()){
            right++;
            //判断right的字符是否在target中
            if(right < source.length() && tStr.containsKey(source.charAt(right))){
                //添加到动态的map中
                dyStr.put(source.charAt(right), dyStr.getOrDefault(source.charAt(right), 0) + 1);
            }
            //判断此时的dyStr是否满足target的条件
            while(check() && left <= right){
                //如果当前窗口更小
                if(right - left + 1 < minWin){
                    minWin = right - left + 1;
                    minLeft = left;
                    minRight = right+1;
                }
                //动态修改dyStr
                if(tStr.containsKey(source.charAt(left))){
                    dyStr.put(source.charAt(left), dyStr.getOrDefault(source.charAt(left), 0) - 1);
                }
                //右移left
                left++;
            }
        }
        return minLeft == -1 ? "" : source.substring(minLeft, minRight);
    }

    //对比两个map
    public boolean check(){
        //如果动态窗口中有字符的个数 < target中字符的个数，则不满足条件
        for(Map.Entry<Character, Integer> entry:tStr.entrySet()){
            Character cha = entry.getKey();
            Integer value = entry.getValue();
            if(dyStr.getOrDefault(cha, 0) < value){
                return false;
            }
        }
        //如果都满足，则返回true
        return true;
    }
}


    /**
     * Note: 类名、方法名、参数名已经指定，请勿修改
     *
     *
     * find min override sub string
     * @param source string字符串
     * @param target string字符串
     * @return string字符串
     */



