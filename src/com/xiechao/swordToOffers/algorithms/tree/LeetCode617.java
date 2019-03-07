package com.xiechao.swordToOffers.algorithms.tree;

import com.xiechao.swordToOffers.algorithms.TreeNode;

/**
 * @ClassName LeetCode617
 * @Author xiechao
 * @Date 2019/3/7
 * @Time 9:17
 * @Description
 * LeetCode617. Merge Two Binary Trees
 * 合并两个二叉树，值相加合并
 */
public class LeetCode617 {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null ) return t2;
        if(t2 == null) return t1;
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left,t2.left);
        t1.right = mergeTrees(t1.right,t2.right);
        return t1;
    }
}
