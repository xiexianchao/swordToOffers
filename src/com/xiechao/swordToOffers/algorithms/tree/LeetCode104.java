package com.xiechao.swordToOffers.algorithms.tree;

import com.xiechao.swordToOffers.algorithms.TreeNode;

/**
 * @ClassName LeetCode104
 * @Author xiechao
 * @Date 2019/3/9
 * @Time 9:14
 * @Description LeetCode104 Maximum Depth of Binary Tree
 */
public class LeetCode104 {
    public int maxDepth(TreeNode root){
        if(root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }


}
