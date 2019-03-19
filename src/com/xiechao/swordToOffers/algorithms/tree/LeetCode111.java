package com.xiechao.swordToOffers.algorithms.tree;

import com.xiechao.swordToOffers.algorithms.TreeNode;

/**
 * @ClassName LeetCode111
 * @Author xiechao
 * @Date 2019/3/19
 * @Time 10:23
 * @Description LeetCode111  Minimum Depth of Binary Tree
 *
 * 返回从头节点到叶子节点的最短路径值(包含多少个节点),
 *
 */
public class LeetCode111 {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        if(root.left == null)
            return minDepth(root.right) + 1;
        if(root.right == null)
            return minDepth(root.left) + 1;
        return Math.min(minDepth(root.left),minDepth(root.right)) + 1;

    }
}
