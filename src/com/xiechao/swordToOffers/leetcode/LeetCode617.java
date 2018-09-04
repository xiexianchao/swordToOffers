package com.xiechao.swordToOffers.leetcode;


/*经验：不要在代码多丑，多次直接return可以缩短时间*/


import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;



public class LeetCode617 {
    private static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){ val = x;}
    }
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

        if( t1 == null && t2 == null)
         return null;
        if(t1 == null )
           return t2;
        if( t2 == null)
            return  t1;
        TreeNode root = null;
        root = new TreeNode(t1.val+t2.val);
        root.left = mergeTrees(t1.left,t2.left);
        root.right = mergeTrees(t1.right,t2.right);
        return root;
    }




}
