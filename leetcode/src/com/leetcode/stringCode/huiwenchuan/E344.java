package com.leetcode.stringCode.huiwenchuan;

/**
 * @author Mr.wxx
 * @create 2022-12-04-17:35
 **/
public class E344 {
    public void reverseString(char[] s) {
        // 思路：双指针交换字符

        // 判空
        if(s.length == 1){
            return;
        }
        int leftIndex = 0, rightIdex = s.length - 1;
        char tmp;
        while(leftIndex < rightIdex){
            tmp = s[leftIndex];
            s[leftIndex] = s[rightIdex];
            s[rightIdex] = tmp;
            leftIndex++;
            rightIdex--;
        }
    }
}
