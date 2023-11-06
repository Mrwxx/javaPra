package com.leetcode.stringCode.tonggou;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Mr.wxx
 * @create 2023-10-22-22:43
 **/
public class M49 {
    public static void main(String[] args) {
        M49 m49 = new M49();
        m49.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        System.out.println(1);
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        // 题目：字符串数组，将同构字符串组合在一起
        // 思路：同构字符串，可以通过字符串排序组合在一起，如果要将原有的字符串和排序后的字符串关联起来，
        // 可以使用Pair关联， 并且使用数组进行排序，然后连在一起的就是同构字符串

        int len = strs.length;
        String[][] afterSort = new String[len][2];
        for (int i = 0; i < strs.length; i++) {
            afterSort[i][0] = strs[i];
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            afterSort[i][1] = Arrays.toString(chars);
        }
        // 基于第二个已排序的字符串进行排序，将同构字符串连接在一起
        Arrays.sort(afterSort, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return o1[1].compareTo(o2[1]);
            }
        });
        // 遍历第一个未排序的字符串，查看前后哪些相同，构造新的list输出
        ArrayList<List<String>> lists = new ArrayList<>();
        int index = 0;
        while(index < len){
            ArrayList<String> strings = new ArrayList<>();
            // 后一个 == 当前的
            while(index + 1 < len && afterSort[index][1].equals(afterSort[index + 1][1])){
                strings.add(afterSort[index++][0]);
            }
            // 后一个 != 当前的
            strings.add(afterSort[index++][0]);
            lists.add(strings);
        }
        return lists;
    }
}
