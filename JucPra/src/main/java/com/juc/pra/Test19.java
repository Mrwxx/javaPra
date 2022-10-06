package com.juc.pra;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * @author Mr.wxx
 * @create 2021-08-01-16:35
 **/
public class Test19 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //处理输入
        int[] rains = new int[10];
        int[] res = new int[rains.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        TreeSet<Integer> set = new TreeSet<>();
        for(int i = 0; i < rains.length; ++i){
            if(rains[i] == 0){
                set.add(i);
            }else{
                if(map.containsKey(rains[i])){
                    Integer day = set.higher(map.get(rains[i]));
                    if(day != null){
                        res[day] = rains[i];
                        set.remove(day);
                    }else{
//                        return new int[0];
                    }
                }
                map.put(rains[i], i);
                res[i] =-1;
            }
        }
        for(int i : set){
            res[i] = 1;
        }
//        return res;
    }
}


