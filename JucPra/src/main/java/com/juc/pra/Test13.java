package com.juc.pra;

import java.util.*;

/**
 * @author Mr.wxx
 * @create 2021-07-25-19:14
 **/
public class Test13 {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        //线段数量n
//        int n = in.nextInt();
//        int l1 = 0, l2 = 0;
//        for(int i = 0; i < n; ++i){
//            l1 = in.nextInt();
//            l2 = in.nextInt();
//            System.out.println(l1);
//            System.out.println(l2);
//        }
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        List<Integer> integers1 = integers.subList(0, 2);
        integers.remove(0);


        Scanner in = new Scanner(System.in);
        //线段数量n
        int n = in.nextInt();
        int[][] nums = new int[n][2];
        int l1 = 0, l2 = 0;
        for(int i = 0; i < n; ++i){
            l1 = in.nextInt();
            l2 = in.nextInt();
            //组成数组
            nums[i] = new int[]{l1, l2};
        }
        //数组按照第一个数字的升序排序
        Arrays.sort(nums, new Comparator<int[]>(){
            public int compare(int[] num1, int[] num2){
                return num1[0] - num2[0];
            }
        });
        //从第一个开始遍历，看看后续的nums[i+1][0] <= nums[i][1]
        //如果小于则继续看nums[i+1][1] <= nums[i][1]
        for(int i = 0; i < n; ++i){
            //nums[i]的右节点是关键
            int right = nums[i][1];
            for(int j = i+1; j < n; ++j){
                //提前剪枝
                if(nums[j][0] > right){
                    break;
                }
                //只有后面的节点左右都包含在right内才合格
                if(nums[j][0] <= right && nums[j][1] <= right){

                }
            }
        }
    }


}

