package com.xiechao.swordToOffers.leetcode;

public class LeetCode104 {
    private static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return  1 + Math.max(maxDepth(root.left),maxDepth(root.right));
    }
}
