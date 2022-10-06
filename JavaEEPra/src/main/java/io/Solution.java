package io;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
//        System.out.println(beautySum("aabcb"));
//        System.out.println(one("aabbcccc"));
//        String s = "";
//        s.substring()
        Scanner scanner = new Scanner(System.in);
        for(int i = 0; i < 2; ++i){
            int i1 = scanner.nextInt();
            System.out.println(i1);
        }
//        int i = scanner.nextInt();

    }
    public static List<String> list = new ArrayList<>();
    public static int beautySum(String s) {
        // 美丽值为0，即每个字符数量相同
        // 排列组合问题？ 比如2,2,1  220,211,201,210,221,200,100，121

        //求出所有的子串
        char[] sc = s.toCharArray();
        int n = sc.length;
        dfs("", s, 0, n);
        int sum = 0;
        for(int i= 0; i < list.size(); ++i){
            sum += one(list.get(i));
        }
        return sum;

    }

    public static void dfs(String curs, String s, int cur, int len){
        // 递归什么时候终止？到达最后一个字符
        if(cur == len){
            return;
        }
        // 添加一个字符到s中
        StringBuilder sb = new StringBuilder(curs);
        for(int i = cur; i < len; ++i){
            sb.append(s.charAt(i));
            list.add(sb.toString());
            dfs(sb.toString(), s, i+1, len);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static int one(String s){
        // 先统计所有字符的个数
        char[] sc = s.toCharArray();
        int[] num = new int[26];
        for(int i = 0; i < sc.length; ++i){
            num[sc[i]-'a'] += 1;
        }
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int i = 0; i < 26; ++i){
            if(num[i] == 0) continue;
            min = Math.min(min, num[i]);
            max = Math.max(max, num[i]);
        }
        return max - min;
    }
}
