package com.xiechao.swordToOffers.algorithms.tree;

import com.xiechao.swordToOffers.algorithms.TreeNode;

/**
 * @ClassName LeetCode112
 * @Author xiechao
 * @Date 2019/3/19
 * @Time 10:17
 * @Description LeetCode112 Path Sum
 * 求二叉树中是否有根到叶子的路径使得，路径上所有节点的和为target
 *
 */
public class LeetCode112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        if(root.val == sum && root.left == null && root.right == null) return true;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
