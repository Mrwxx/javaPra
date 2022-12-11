package com.leetcode.stringCode.huiwenchuan;

import sun.util.resources.cldr.ga.CurrencyNames_ga;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Mr.wxx
 * @create 2022-12-04-10:55
 **/
public class E125 {
    static int a = 1;
    public static void main(String[] args) {
        E125 e125 = new E125();
        e125.isPalindrome("null");
    }

    public boolean isPalindrome(String s) {
        // 思路：遍历去除非字母，再转小写字母，最后验证回文串
        // 判空
        if(null == s || s.length() == 0 || s.length() == 1){
            return true;
        }
        a = 2;
        int[] ints = {1, 2, 3};
        long ansNum = Arrays.stream(ints).filter(i -> i < 3).limit(2).count();
        // 遍历去除非字母字符与转小写
        StringBuilder stringBuilder = new StringBuilder();
        char[] sCharArray = s.toCharArray();
        for (char i : sCharArray) {
            // 判断是否是字母或数字
            if(!Character.isAlphabetic(i) && !Character.isDigit(i)){
                continue;
            }
            else if(Character.isUpperCase(i)){
                stringBuilder.append(Character.toLowerCase(i));
            }
            else{
                stringBuilder.append(i);
            }
        }
        // 验证回文串，可以通过双指针首尾遍历验证
        return isPalindromeDirect(stringBuilder.toString());
    }

    public boolean isPalindromeDirect(String str){
        // 双指针首尾验证

        System.out.println(str);
        // 判空
        if(str.length() == 0 || str.length() == 1){
            return true;
        }
        if(str.length() == 2){
            return str.charAt(0) == str.charAt(1);
        }
        int leftIndex = 0, rightIndex = str.length() - 1;
        while(leftIndex < rightIndex){
            if(str.charAt(leftIndex) != str.charAt(rightIndex)){
                return false;
            }
            leftIndex++;
            rightIndex--;
        }
        // 两种情况是回文串：偶数长度时两个指针相邻(注意最后一次指针变动后左指针在右指针后面)，奇数长度时两个指针相等
        return leftIndex == rightIndex || rightIndex == leftIndex - 1;
    }
}
