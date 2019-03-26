package com.xiechao.swordToOffers.algorithms.tree;

import com.xiechao.swordToOffers.algorithms.TreeNode;

/**
 * @ClassName LeetCode1008
 * @Author xiechao
 * @Date 2019/3/26
 * @Time 9:20
 * @Description LeetCode1008 Construct Binary Search Tree from Preorder Traversal
 * 根据前序遍历序列构建二叉搜索树
 *
 */
public class LeetCode1008 {
    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder == null) return null;
        return helper(preorder,0,preorder.length);
    }
    //[start,end)
    private TreeNode helper(int[] preorder, int start, int end){
        if(start >= end || start >= preorder.length) return  null;
        int index = start;
        while(  index < end && preorder[index] <= preorder[start])
            index++;
        TreeNode root = new TreeNode(preorder[start]);
        root.left = helper(preorder,start+1, index);
        root.right = helper(preorder, index, end);
        return root;
    }
}
