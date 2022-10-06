package com.juc.pra;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mr.wxx
 * @create 2021-07-19-16:10
 **/
public class test2 {
    public static void main(String[] args) {
        String a = "100";
        int i = Integer.parseInt(a);
        System.out.println(i);
    }



    public class Solution {
        /**
         * Note: 类名、方法名、参数名已经指定，请勿修改
         *
         *
         *
         * @param rowIndex int整型 第几行
         * @param columnIndex int整型 第几列
         * @return int整型
         */

        public int getValue(int rowIndex, int columnIndex) {
            // write code here
            //模拟完事了
            List<List<Integer>> allList = new ArrayList<List<Integer>>();
            allList.add(new ArrayList<Integer>());
            allList.get(0).add(1);
            if(rowIndex == 1){
                return allList.get(0).get(0);
            }else{
                for(int i = 1; i < rowIndex; ++i){
                    List<Integer> row = new ArrayList<>();
                    row.add(1);
                    for(int j = 1; j < i; ++j){
                        row.add(allList.get(i-1).get(j-1) + allList.get(i-1).get(j));
                    }
                    row.add(1);
                    allList.add(row);
                }
            }
            return allList.get(rowIndex-1).get(columnIndex-1);
        }
    }

}
