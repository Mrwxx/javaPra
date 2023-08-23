package com.leetcode.treeCode.binary;

/**
 * @author Mr.wxx
 * @create 2023-08-24-0:06
 **/
public class M96 {
    public int numTrees(int n) {
        // 二叉搜索树：左子树 < root < 右子树
        // 题目目的：由1-n这n个节点所组成的二叉搜索树有多少种？
        // G(n)：由n个节点所组成的二叉搜索树数量；F(i,n)：以i为root节点的二叉搜索树数量；G(n)=(i从1-n)情况下的所有F(i,n)相加
        // F(i,n)中，左子树由（1，i-1）组成，右子树由（i+1,n）组成，所以F(i,n) = G(i-1) * G(n-i)，所以G(n)=(i从1-n)情况下的所有G(i-1) * G(n-i)相加
        // G(1) = 1; G(2) = 1; G(3) = F(1,3) + F(2,3) + F(3,3)

        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        // 从n=2开始，开始计算dp[n]，即1-n这n个节点所组成的二叉搜索树有多少种
        for(int i = 2; i <=n; i++){
            for(int j = 1; j <= i; ++j){
                dp[i] += dp[j-1] * dp[i-j];
            }
        }
        return dp[n];
    }
}
