package com.xiechao.swordToOffers.algorithms.tree;

import com.xiechao.swordToOffers.algorithms.TreeNode;

/**
 * @ClassName LeetCode701
 * @Author xiechao
 * @Date 2019/3/25
 * @Time 10:31
 * @Description LeetCode701 Insert into a BST
 * 在BST中插入一个原来不存在的值，返回root
 */
public class LeetCode701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        return helper(root,val);
    }
    private TreeNode helper(TreeNode root, int val){
        if(root == null) return new TreeNode(val);
        if(val > root.val){
            if(root.right == null)
                root.right = new TreeNode(val);
            else
                helper(root.right, val);
        }else{
            if(root.left == null)
                root.left = new TreeNode(val);
            else
                helper(root.left, val);
        }
        return root;
    }
}
