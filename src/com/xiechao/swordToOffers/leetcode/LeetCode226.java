package com.xiechao.swordToOffers.leetcode;

public class LeetCode226 {
    private static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        TreeNode result = new TreeNode(root.val);
        if(root.left == null && root.right == null)
            return result;
        result.left = invertTree(root.right);
        result.right = invertTree(root.left);
        return result;
    }
}
