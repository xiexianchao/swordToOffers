package com.xiechao.swordToOffers.algorithms.tree;

import com.xiechao.swordToOffers.algorithms.TreeNode;

/**
 * @ClassName LeetCode965
 * @Author xiechao
 * @Date 2019/3/7
 * @Time 9:25
 * @Description LeetCode965. Univalued Binary Tree
 * 判断树的所有节点的值是否相等
 *
 */
public class LeetCode965 {
    public boolean isUnivalTree(TreeNode root) {
        if(root == null) return true;
        return helper(root.left,root.val) && helper(root.right, root.val);
    }
    private boolean helper(TreeNode root, int val){
        if(root == null) return true;
        if(root != null && root.val != val)
            return false;
        return helper(root.left,val) && helper(root.right,val);
    }
}
