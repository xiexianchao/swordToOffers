package com.xiechao.swordToOffers.algorithms.bfs;

import com.xiechao.swordToOffers.algorithms.TreeNode;

/**
 * @author: xiechao
 * @Date : 2018/10/18
 * @Time : 17:04
 * @description :Minimum Depth of Binary Tree
 * 求二叉树的最小深度
 */
public class LeetCode111 {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        if(root.left == null) return minDepth(root.right) + 1;
        if(root.right == null) return minDepth(root.left) + 1;
        return Math.min(minDepth(root.left),minDepth(root.right))+1;
    }

}
