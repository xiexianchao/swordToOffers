package com.xiechao.swordToOffers.algorithms.tree;

import com.xiechao.swordToOffers.algorithms.TreeNode;

/**
 * @ClassName LeetCode814
 * @Author xiechao
 * @Date 2019/3/26
 * @Time 9:37
 * @Description 删除子树不包含1的节点
 */
public class LeetCode814 {
    public TreeNode pruneTree(TreeNode root) {
        if(root == null) return null;
        helper(root);
        return root;
    }
    //返回包含此节点的1的个数
    private int helper(TreeNode root){
        if(root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        if(left == 0)
            root.left = null;
        if(right == 0)
            root.right = null;
        //return root.val == 1 ? 1+left + right: left +right;
        return left + right + (root.val == 1 ? 1 : 0);
    }
}
