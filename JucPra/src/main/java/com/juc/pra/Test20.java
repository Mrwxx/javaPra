package com.juc.pra;

import java.io.ObjectOutputStream;
import java.util.*;

/**
 * @author Mr.wxx
 * @create 2021-08-03-11:13
 **/
public class Test20 {
    public static void main(String[] args) {
        minWindow("a", "a");
        Object o = new Object();
        synchronized (o){
            try {
                o.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.contains("");
        String a = "89";
        a = a + 1;
        int ai = a.length();
        int i = a.length();
        a = a + 1;

    }

        public static String minWindow(String s, String t) {
            //滑动窗口思路
            int ns = s.length();
            int nt = t.length();
            //判空
            if(ns < nt || (ns == nt && !s.equals(t))){
                return "";
            }
            int left = 0, right = 0;
            //用map保存窗口中的t字符数量
            HashMap<Character, Integer> maps = new HashMap<>();
            HashMap<Character, Integer> mapt = new HashMap<>();
            //将t的所有字符入mapt中
            for(int i = 0; i < nt; ++i){
                mapt.put(t.charAt(i), mapt.getOrDefault(t.charAt(i), 0) + 1);
            }
            int minLen = Integer.MAX_VALUE;
            String minStr = "";
            //比较窗口中的字符数量与mapt中字符数量
            while(right < ns){
                //只有right字符存在于t中才会存入s中
                if(mapt.containsKey(s.charAt(right))){
                    maps.put(s.charAt(right),  maps.getOrDefault(s.charAt(right), 0) + 1);
                }
                //已经覆盖，则记录子串长度，并移动左指针，直到不覆盖
                while(left <= right && compare(maps, mapt)){
                    if(minLen > right-left+1){
                        minLen = right - left + 1;
                        minStr = s.substring(left, right+1);
                    }
                    //删除maps的left字符
                    //只有存在于mapt中，才会删除left
                    if(mapt.containsKey(s.charAt(left))){
                        maps.put(s.charAt(left), maps.getOrDefault(s.charAt(left), 0) -1 );
                    }
                    left++;
                }
                //未覆盖，则继续右移right
                right++;
                System.out.println("left = " + left);
                System.out.println("right = " + right);
            }
            return minStr;
        }

        public static boolean compare(HashMap<Character, Integer> maps, HashMap<Character, Integer> mapt){
            //比较两者是否相同
            for(Map.Entry<Character, Integer> entry : mapt.entrySet()){
                char key = entry.getKey();
                int value = entry.getValue();
                //根据key比较value是否相等
                if(maps.getOrDefault(key, 0) < value){
                    return false;
                }
            }
            return true;
        }

}
