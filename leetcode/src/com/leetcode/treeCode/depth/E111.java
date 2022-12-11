package com.leetcode.treeCode.depth;

/**
 * @author Mr.wxx
 * @create 2022-12-09-0:45
 **/
public class E111 {

    /**
     * DFS 思路解法
     */
    int minTreeHeight = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        // 思路：
        // 1、DFS递归所有的叶子节点，计算最小的深度；
        // 2、BFS遍历所有的层次，在第一个遇到的叶子节点处返回

        // 判空
        dfs(root, 1);
        return root == null ? 0 : minTreeHeight;
    }

    public void dfs(TreeNode root, int depth){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            minTreeHeight = Math.min(minTreeHeight, depth);
        }
        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }
}