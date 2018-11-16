package com.xiechao.swordToOffers.leetcode;

import com.xiechao.swordToOffers.algorithms.TreeNode;

/**
 * @ClassName LeetCode235
 * @Author xiechao
 * @Date 2018/11/15
 * @Time 12:06
 * @Description Lowest Common Ancestor of a Binary Search Tree
 * 在一棵二叉搜索树中，求两个节点的最低父亲节点
 *
 */
public class LeetCode235 {
    //8ms
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if((root.val >= p.val && root.val <= q.val)||
                (root.val <= p.val && root.val >= q.val)) return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left == null && right == null) return null;
        return left != null? left:right;
    }
    //leetcode大神 5ms
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor2(root.left,p,q);
        TreeNode right = lowestCommonAncestor2(root.right,p,q);
        if(left != null && right != null) return root;
        return left != null?left:right;
    }
    //剑指 4ms 解决
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        TreeNode maxNode = p.val >= q.val? p:q;
        TreeNode minNode = p.val < q.val ? p:q;

        if(root.val > maxNode.val)
         return    lowestCommonAncestor3(root.left,p,q);
        else if(root.val < minNode.val)
         return  lowestCommonAncestor3(root.right,p,q);
        else
            return root;

    }
}
