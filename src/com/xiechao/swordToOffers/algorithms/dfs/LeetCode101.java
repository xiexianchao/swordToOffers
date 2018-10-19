package com.xiechao.swordToOffers.algorithms.dfs;

import com.xiechao.swordToOffers.algorithms.TreeNode;

/**
 * @author: xiechao
 * @Date : 2018/10/18
 * @Time : 16:03
 * @description :101. Symmetric Tree
 * 判断二叉树是否是对称二叉树
 */
public class LeetCode101 {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return helper(root,root);
    }
    private boolean helper(TreeNode root1,TreeNode root2){
        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null) return false;
        if(root1.val != root2.val) return false;
        return helper(root1.left,root2.right) && helper(root1.right,root2.left);
    }
}
