package com.xiechao.swordToOffers.book;

import com.xiechao.swordToOffers.commom.TreeNode;

public class Problem7 {
    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        TreeNode root = null;
        if( pre.length >0 &&  in.length >0){
           root = reConstructBinaryTreeCore(pre,in,0,pre.length-1,0,in.length-1);
        }
        return root;
    }

    private TreeNode reConstructBinaryTreeCore(int[] pre, int[] in, int startPre, int endPre, int startIn, int endIn) {
        if(startPre < 0 || startIn < 0 || endPre > pre.length-1 || endIn > in.length-1)
            return null;
        TreeNode root = new TreeNode(pre[startPre]);
        root.right = null;
        root.left = null;









        return null;
    }


}
