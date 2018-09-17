package com.xiechao.swordToOffers.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName LeetCode94
 * @Author xiechao
 * @Date 2018/9/17
 * @Time 19:27
 * @Description Binary Tree Inorder Traversal
 */
public class LeetCode94 {
    private static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if( root == null) return list;
        Stack<TreeNode> stack = new Stack();
        TreeNode cur = root;
        while( cur != null || !stack.isEmpty()){
          while( cur != null){
              stack.push(cur);
              cur = cur.left;
          }
          if( ! stack.isEmpty()){
             cur = stack.pop();
             list.add(cur.val);
             cur = cur.right;
          }
        }
        return list;
    }
}
