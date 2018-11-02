package com.xiechao.swordToOffers.book.version2;

import com.xiechao.swordToOffers.algorithms.TreeNode;

/**
 * @ClassName Problem55
 * @Author xiechao
 * @Date 2018/11/2
 * @Time 9:07
 * @Description 二叉树的深度
 */
public class Problem55 {
    public int TreeDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        return Math.max(TreeDepth(root.left),TreeDepth(root.right))+1;
    }
}
