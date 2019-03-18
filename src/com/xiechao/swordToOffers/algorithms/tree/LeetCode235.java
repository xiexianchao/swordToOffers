package com.xiechao.swordToOffers.algorithms.tree;

import com.xiechao.swordToOffers.algorithms.TreeNode;

/**
 * @ClassName LeetCode235
 * @Author xiechao
 * @Date 2019/3/15
 * @Time 9:21
 * @Description LeetCode235 Lowest Common Ancestor of a Binary Search Tree
 *  在BST中寻找输入两个节点的最低公共祖先节点
 *  思路：利用BST性质
 *
 */
public class LeetCode235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        TreeNode minNode = p.val > q.val ? q : p;
        TreeNode maxNode = p.val > q.val ? p : q;
        if(root.val >= minNode.val && root.val <= maxNode.val)
            return root;
        else if(root.val > maxNode.val)
            return lowestCommonAncestor(root.left,p,q);
        else
            return lowestCommonAncestor(root.right,p,q);
    }
}
