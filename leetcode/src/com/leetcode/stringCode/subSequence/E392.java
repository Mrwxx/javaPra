package com.leetcode.stringCode.subSequence;

/**
 * @author Mr.wxx
 * @create 2022-12-04-19:03
 **/
public class E392 {
    public boolean isSubsequence(String s, String t) {
        /**
         思路：
         1.根据s字符串的字符顺序遍历t字符串；
         2.遍历完毕后，如果无法遍历完s字符串的所有字符，则说明t中字符串无法通过删除字符的方式得到s字符串
         3.注意，一定要将t字符串遍历完毕，因为子序列的要求只是删除t字符串中若干字符即可得到s字符串，没有遍历完毕皆有可能

         */
        // 判空，""也是子序列
        if(s == null || t == null){
            return false;
        }
        if(s.equals("")){
            return true;
        }
        // 双指针遍历字符串，对比s字符串中的字符顺序
        int sIndex = 0;
        for (char c : t.toCharArray()) {
            // 只要t字符串中出现了sIndex当前指向的字符，就可以按照该顺序继续遍历
            if(sIndex < s.length() && c == s.charAt(sIndex)){
                sIndex++;
            }
        }
        // 如果s字符串遍历完毕，说明按照s字符串中字符顺序在t字符串中全部出现
        return sIndex == s.length();
    }
}
