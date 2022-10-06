package com.juc.pra;

/**
 * @author Mr.wxx
 * @create 2021-08-12-19:08
 **/
public class Test27 {
    public static void main(String[] args) {
        //处理输入

        //二维数组记录i到j的平均值
        int n = 9;
        int k = 3;
        int[] nums = new int[n];
        double[][] avg = new double[n][n];
        int[][] sum = new int[n][n];
        //开始计算总和和均值
        //初始化
        for(int i = 0; i < n; ++i){
            sum[i][i] =  nums[i];
        }
        for(int i = 0; i < n; ++i){
            //窗口至少为k
            for(int j = i+1; j < n; ++j){
                sum[i][j] += sum[i][j-1] + nums[j];
            }
        }
        //计算均值
        double maxAvg = 0;
        for(int i = 0; i <= n-k; ++i){
            for(int j = i+k-1; j < n; ++j){
                avg[i][j] = sum[i][j] / (i-j+1);
                maxAvg = Math.max(maxAvg, avg[i][j]);
            }
        }
        //找到最大的均值，再来找有无最长，l最小的
        for(int i  = 0; i < n; ++i){
            for(int j = 0; j < n; ++j){

            }
        }
//        //滑动窗口
//        int[] nums = new int[9];
//        int n = nums.length;
//        int k = 3;
//        int left =0 , right = 0;
//        double curAvg = 0;
//        double maxAvg = 0;
//        int winSum = 0;
//        int maxLeft = 0, maxRight = 0;
//        while(right < n){
//            if(right - left + 1 < k){
//                right++;
//                //窗口总和++
//                winSum += nums[right];
//            }else{
//                //对left - right相加，计算平均值
//                curAvg =  winSum / (right-left+1);
//                if(curAvg > maxAvg){
//                    //修改最大平均值窗口的左右指针
//                    maxLeft = left;
//                    maxRight = right;
//                }
//            }
//        }
    }
}
