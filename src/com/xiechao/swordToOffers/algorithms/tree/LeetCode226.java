package com.xiechao.swordToOffers.algorithms.tree;

import com.xiechao.swordToOffers.algorithms.TreeNode;

/**
 * @ClassName LeetCode226
 * @Author xiechao
 * @Date 2019/3/10
 * @Time 9:39
 * @Description LeetCode226 Invert Binary Tree
 * 反转二叉树
 * Input:
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * Output:
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 */
public class LeetCode226 {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        TreeNode right = root.right;
        TreeNode left = root.left;
        root.right = invertTree(left);
        root.left = invertTree(right);
        return root;
    }
}
