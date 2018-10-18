package com.xiechao.swordToOffers.algorithms.bfs;

import com.xiechao.swordToOffers.algorithms.TreeNode;

/**
 * @author: xiechao
 * @Date : 2018/10/18
 * @Time : 16:56
 * @description :Path Sum
 * 判断二叉树有没有root-to-leaf的路径，使得和为给定的target
 */
public class LeetCode112 {
    boolean hasPathSum = false;
    public boolean hasPathSum(TreeNode root, int sum) {
        //if(root == null && sum ==0) return false;
        if(root == null) return false;
        helper(root,sum);
        return hasPathSum;
    }

    private void helper(TreeNode root, int sum) {
        if(root.left == null && root.right == null){
            if(root.val == sum) hasPathSum = true;
            return;
        }
        if(root.left != null)
            helper(root.left,sum-root.val);
        if(root.right != null)
            helper(root.right,sum-root.val);
    }
}
