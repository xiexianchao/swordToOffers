package com.xiechao.swordToOffers.algorithms.tree;

import com.xiechao.swordToOffers.algorithms.TreeNode;

/**
 * @ClassName LeetCode101
 * @Author xiechao
 * @Date 2019/3/15
 * @Time 9:47
 * @Description LeetCode101 Symmetric Tree
 *
 * 判断某一棵树是否是镜像二叉树
 * 思路：判断两棵二叉树是否对称
 */
public class LeetCode101 {
    public boolean isSymmetric(TreeNode root) {
        return helper(root,root);
    }
    private boolean helper(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null) return false;
        if(root1.val != root2.val) return false;
        return helper(root1.left, root2.right) && helper(root1.right, root2.left);
    }


}
