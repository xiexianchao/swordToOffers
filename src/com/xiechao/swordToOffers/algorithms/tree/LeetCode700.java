package com.xiechao.swordToOffers.algorithms.tree;

import com.xiechao.swordToOffers.algorithms.TreeNode;

/**
 * @ClassName LeetCode700
 * @Author xiechao
 * @Date 2019/3/7
 * @Time 9:30
 * @Description LeetCode700. Search in a Binary Search Tree
 * 在BST中求出以给定值作为root节点的子树，不存在则返回null
 *
 */
public class LeetCode700 {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null) return null;
        if(root.val == val) return root;
        if(root.val > val)
            return searchBST(root.left, val);
        else
            return searchBST(root.right,val);
    }
}
