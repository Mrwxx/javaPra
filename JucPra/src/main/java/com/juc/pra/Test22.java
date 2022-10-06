package com.juc.pra;

import java.util.Scanner;

/**
 * @author Mr.wxx
 * @create 2021-08-04-20:57
 **/
public class Test22 {
    public static void main(String[] args) {
        //数据输入
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        int i = 0;
        int[] nums = new int[8];
        int index=  0;
        while(i < input.length()){
            int sum = 0;
            if(Character.isDigit(input.charAt(i))){
                //数字，持续相加
                while(Character.isDigit(input.charAt(i))){
                    sum = sum * 10 + (input.charAt(i) - '0');
                    i++;
                }
                nums[index++] = sum;
            }else{
                i++;
            }
        }

        int p1_x = nums[0], p1_y = nums[1], p2_x = nums[2], p2_y = nums[3];
        int p3_x = nums[4], p3_y = nums[5], p4_x = nums[6], p4_y = nums[7];
        //不相交的情况
        if(p1_x > p4_x || p2_x < p3_x || p1_y > p4_y || p2_y < p3_y){
            System.out.println(0);
            return;
        }
        int len = Math.min(p2_x, p4_x) - Math.max(p1_x, p3_x);
        int wid = Math.min(p2_y, p4_y) - Math.max(p1_y, p3_y);
        System.out.println(len * wid);
    }
}


//import java.util.*;
//
//
//public class Solution {
//    /**
//     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
//     *
//     *
//     * @param grid int整型二维数组 为n*m 的二维数组
//     * @return int整型
//     */
//    int maxSum = 0;
//    public int getMaximumResource (int[][] grid) {
//        // write code here
//        //从任意非0点出发
//        int m = grid.length;
//        int n = grid[0].length;
//        for(int i = 0; i < m; ++i){
//            for(int j = 0; j < n; ++j){
//                if(grid[i][j] != 0){
//                    dfs(grid, i, j, 0);
//                }
//            }
//        }
//        return maxSum;
//    }
//
//    public void dfs(int[][] grid, int i, int j, int sum){
//        int m = grid.length;
//        int n = grid[0].length;
//        if(i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0 || grid[i][j] == -1){
//            return;
//        }
//        //继续递归，相加
//        int val = grid[i][j];
//        grid[i][j] = -1;
//        maxSum = Math.max(maxSum, sum + val);
//        dfs(grid, i-1, j, sum + val);
//        dfs(grid,i, j-1, sum + val);
//        dfs(grid, i+1, j, sum + val);
//        dfs(grid, i, j+1, sum + val);
//        grid[i][j] = val;
//    }
//}
//
//
//import java.util.*;
//
//
//public class Solution {
//    /**
//     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
//     *
//     *
//     * @param height int整型一维数组 舞蹈员身高的一维数组
//     * @return int整型
//     */
//    public int TeamNums (int[] height) {
//        // write code here
//        int n = height.length;
//        int sum = 0;
//        for(int i = 0; i < n; ++i){
//            for(int j = i+1; j < n; ++j){
//                for(int k = j+1; k < n; ++k){
//                    if(height[i] < height[j] && height[j] < height[k]){
//                        sum++;
//                    }
//                    if(height[i] > height[j] && height[j] > height[k]){
//                        sum++;
//                    }
//                }
//            }
//        }
//        return sum;
//    }
//}