package com.xiechao.swordToOffers.algorithms.dfs;

import com.xiechao.swordToOffers.algorithms.TreeNode;

/**
 * @author: xiechao
 * @Date : 2018/10/18
 * @Time : 16:12
 * @description :Balanced Binary Tree
 * 判断二叉树是否是平衡二叉树。即任意结点的左右子树最大深度之差小于1
 */
public class LeetCode110 {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        return  isBalanced(root.left) &&
                isBalanced(root.right) &&
                Math.abs(getDepth(root.left) - getDepth(root.right)) <= 1;

    }
    private int getDepth(TreeNode root){
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        return 1 + Math.max(getDepth(root.left),getDepth(root.right));
    }


}
