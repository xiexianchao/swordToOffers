package com.xiechao.swordToOffers.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author: xiehcao
 * @Date : 2018/10/12
 * @Time : 8:42
 * @description :Construct Binary Tree from Preorder and Inorder Traversal
 */
public class LeetCode105 {
   class TreeNode{
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x){ val = x;}
   }


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null) return null;
        if(preorder.length <=0 || inorder.length != preorder.length) return null;

       return helper(preorder,0,preorder.length - 1,inorder,0,inorder.length - 1);

    }

    private TreeNode helper(int[] preorder, int startPre, int endPre, int[] inorder, int startIn, int endIn) {
        if(startPre >=0 && endPre >= startIn && endPre < preorder.length &&
                startIn >=0 && endIn >= startIn && endIn < inorder.length){
            TreeNode node = new TreeNode(preorder[startPre]);
            int indexOfNodeInOrder = getIndexOfKey(inorder,preorder[startPre]);
            int countOfLeft = indexOfNodeInOrder - startIn;
            node.left = helper(preorder,startPre+1,startPre+countOfLeft,inorder,startIn,indexOfNodeInOrder-1);
            node.right = helper(preorder,startPre+countOfLeft+1,endPre,inorder,indexOfNodeInOrder+1,endIn);
            return node;
        }
        return null;
   }

    private int getIndexOfKey(int[] inorder, int key) {
        for (int i = 0; i < inorder.length; i++) {
            if(key == inorder[i])
                return i;
        }
        return -1;
   }

    @Test
   public void test(){

       buildTree(new int[]{3,9,20,15,7},new int[]{9,3,15,20,7});
   }

}
