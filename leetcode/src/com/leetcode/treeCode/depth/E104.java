package com.leetcode.treeCode.depth;

import java.util.LinkedList;

/**
 * @author Mr.wxx
 * @create 2022-12-09-0:21
 **/
public class E104 {
    /**
     * DFS 思路解法
     */
    int maxTreeHeight = 0;
    public int maxDepth(TreeNode root) {
        // 思路：
        // 1、DFS走遍所有的叶子结点，计算最长路径下的节点数
        // 2、BFS一层层地模拟，直到最后一层

        // 判空留给dfs函数
        dfs(root, 1);
        return maxTreeHeight;
    }

    public void dfs(TreeNode root, int depth) {
        // 通过depth参数传递当前节点所在的深度
        // 递归终止条件：root == null
        if (root == null) {
            return;
        }
        // 判断当前节点是否是叶子节点
        maxTreeHeight = Math.max(maxTreeHeight, depth);
        // 继续递归：左子树递归，右子树递归
        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }


    /**
     * BFS 思路解法
     * @param root
     * @return
     */
    public int maxDepth2(TreeNode root) {
        if(root == null){
            return 0;
        }
        //BFS思路
        LinkedList<TreeNode> q = new LinkedList<>();
        q.offerLast(root);
        int height = 0;
        while(!q.isEmpty()){
            int size = q.size();
            height++;
            for(int i = 0; i < size; ++i){
                TreeNode tmp = q.pollFirst();
                if(tmp.left != null){
                    q.offerLast(tmp.left);
                }
                if(tmp.right != null){
                    q.offerLast(tmp.right);
                }
            }
        }
        return height;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
