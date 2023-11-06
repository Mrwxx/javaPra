package com.leetcode.stringCode.simulation;

import java.util.Arrays;

/**
 * @author Mr.wxx
 * @create 2023-10-22-13:48
 **/
public class M6 {
    public static void main(String[] args) {
        M6 m6 = new M6();
        String paypalishiring = m6.convert("PAYPALISHIRING", 4);
        System.out.println(paypalishiring);
    }
    public String convert(String s, int numRows) {
        // 题目：模拟转换新的字符串，从上至下模拟一个二维字符数组
        // 思路：找到模拟的规律，numRows + (numRows-2) 为一个规律模拟

        if(numRows == 1){
            return s;
        }

        int len = s.length();
        int lines = 2 * len / (2 * numRows - 2) + 2;
        char[][] charArray = new char[numRows][lines];
        for(int i = 0; i < numRows; i++){
            for(int j = 0; j < lines; j++){
                charArray[i][j] = '0';
            }
        }
        for(int i = 0; i < len; i++){
            // 怎么判断
            int index = i % (2 * numRows - 2);
            int times = i / (2 * numRows - 2) * 2;
            if(index < numRows){
                // 循环规律的第一列
                charArray[index][times] = s.charAt(i);
            }else{
                // 循环规律的第二列
                charArray[2 * numRows - 2 - index][times+1] = s.charAt(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < numRows; i++){
            for(int j = 0; j < lines; j++){
                if(charArray[i][j] != '0'){
                    sb.append(charArray[i][j]);
                }
            }
        }
        return sb.toString();
    }
}
