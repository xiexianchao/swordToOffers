package com.xiechao.swordToOffers.algorithms.bfs;

/**
 * @author: xiechao
 * @Date : 2018/10/18
 * @Time : 12:02
 * @description :Same Tree
 * 判断两棵二叉树是否相同
 */
public class LeetCode100 {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        if(p.val != q.val) return false;
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }


}
