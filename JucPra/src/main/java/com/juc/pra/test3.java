package com.juc.pra;

import java.util.HashMap;

/**
 * @author Mr.wxx
 * @create 2021-07-19-16:37
 **/
public class test3 {



    public class Solution {
        /**
         * Note: 类名、方法名、参数名已经指定，请勿修改
         *
         *
         *
         * @param order string字符串
         * @return int整型一维数组
         */
        public int[] GetEndPoint(String order) {
            // write code here
            //解析字符串即可
            HashMap<Character, Integer> map = new HashMap<>();
            int n = order.length();
            int tmpNum = 1;
            int i = 0;
            while(i < n){
                //拆分数字和字母
                StringBuffer sb = new StringBuffer();
                int num = 1;
                if(i < n && order.charAt(i) >= '0' && order.charAt(i) <= '9'){
                    while(order.charAt(i) >= '0' && order.charAt(i) <= '9'){
                        sb.append(order.charAt(i));
                        i++;
                    }
                    num = Integer.parseInt(sb.toString());
                }
                map.put(order.charAt(i), map.getOrDefault(order.charAt(i), 0) + num);
                i++;
            }
            int xDis = 0, yDis = 0;
            xDis = map.getOrDefault('D', 0) - map.getOrDefault('A', 0);
            yDis = map.getOrDefault('W', 0) - map.getOrDefault('S', 0);
            return new int[]{xDis, yDis};
        }
    }

}
