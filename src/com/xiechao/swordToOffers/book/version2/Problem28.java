package com.xiechao.swordToOffers.book.version2;

/**
 * @author: xiehcao
 * @Date : 2018/9/18
 * @Time : 10:51
 * @description :判断两个二叉树是否为对称二叉树
 */
public class Problem28 {
    private static class TreeNode{
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    boolean isSymmetrical(TreeNode pRoot)
    {
        if(pRoot == null) return true;
        return isSymmetricalCore(pRoot,pRoot);
    }

    private boolean isSymmetricalCore(TreeNode pRoot1,TreeNode pRoot2){
        if(pRoot1 == null && pRoot2 == null) return true;
        if(pRoot1 == null || pRoot2 == null) return false;
        if(pRoot1.val != pRoot2.val) return false;
        return isSymmetricalCore(pRoot1.left,pRoot2.right) && isSymmetricalCore(pRoot1.right,pRoot2.left);
    }
}
