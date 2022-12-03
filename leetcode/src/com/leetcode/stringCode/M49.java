package com.leetcode.stringCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author Mr.wxx
 * @create 2022-11-09-21:50
 **/
public class M49 {
    public static void main(String[] args) {
        String s = "123";
        s.trim();
        ArrayList<Integer> integerArrayList = new ArrayList<Integer>();
        Integer[] integers = integerArrayList.toArray(new Integer[integerArrayList.size()]);
        int[] ansArray = new int[integers.length];
        // Integer的List转int[]数组
        int[] objects = integerArrayList.stream().mapToInt(Integer::intValue).toArray();
    }
}
