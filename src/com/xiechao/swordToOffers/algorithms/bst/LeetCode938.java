package com.xiechao.swordToOffers.algorithms.bst;

import com.xiechao.swordToOffers.algorithms.TreeNode;

/**
 * @ClassName LeetCode938
 * @Author xiechao
 * @Date 2019/1/22
 * @Time 11:40
 * @Description TODO
 */
public class LeetCode938 {
    int sum = 0;
    public int rangeSumBST(TreeNode root, int L, int R) {
        if(root == null ) return 0;
        inOrderTraverse(root,L,R);
        return sum;
    }

    private void inOrderTraverse(TreeNode root, int l, int r) {
        if(root == null)
            return;
        if(root.left != null)
            inOrderTraverse(root.left,l,r);
        if(root.val >= l && root.val <= r){
            sum += root.val;
        }
        if(root.right != null)
            inOrderTraverse(root.right,l,r);
    }
}
