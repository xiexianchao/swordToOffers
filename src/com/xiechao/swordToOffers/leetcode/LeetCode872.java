package com.xiechao.swordToOffers.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 叶子结点相等的二叉树
 *
 */

public class LeetCode872 {
     private static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if(null == root1 && null == root2)  return true;
        if(null == root1 || null == root2) return false;
        List<TreeNode> listOfPostOrderWithRoot1 = postTraverseInOrder(root1);
        List<TreeNode> listOfPostOrderWithRoot2 = postTraverseInOrder(root2);
        if(listOfPostOrderWithRoot1.size() != listOfPostOrderWithRoot2.size())
            return false;

        for (int i = 0; i < listOfPostOrderWithRoot1.size(); i++) {
            if(listOfPostOrderWithRoot1.get(i).val != listOfPostOrderWithRoot2.get(i).val)
                return false;
        }
        return true;

    }

    List<TreeNode> postTraverseInOrder(TreeNode root){
         if( null == root)
             return null;
         List<TreeNode> listNode = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        stack.push(node);
        while(!stack.empty()){
            node = stack.pop();

            if(node.left == null && node.right == null)
                listNode.add(node);
            if(node.right != null)
                stack.push(node.right);
            if(node.left != null)
                stack.push(node.left);
        }
        return listNode;
    }




}
