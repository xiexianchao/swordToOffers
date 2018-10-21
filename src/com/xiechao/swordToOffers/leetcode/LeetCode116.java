package com.xiechao.swordToOffers.leetcode;

/**
 * @ClassName LeetCode116
 * @Author xiechao
 * @Date 2018/10/13
 * @Time 9:21
 * @Description Populating Next Right Pointers in Each Node
 */
public class LeetCode116 {
    class TreeLinkNode {
        int val;
        TreeLinkNode left,right,next;
        TreeLinkNode(int x){ val =x;}
    }
    public void connect(TreeLinkNode root) {
        if(root == null) return;
        helper(root);
    }
    private void helper(TreeLinkNode root) {
         if(root == null) return;
         if(root.left == null || root.right == null) return;

         TreeLinkNode rightNode = null;
         TreeLinkNode leftNode = null;
         TreeLinkNode node1 = root.left;
         TreeLinkNode node2 = root.right;
         while(node1 != null){
             rightNode = node1;
             leftNode = node2;
             rightNode.next = leftNode;
             node1 = node1.right;
             node2 = node2.left;
         }
        helper(root.left);
        helper(root.right);

         /*root.left.next = root.right;
         helper(root.left);
         helper(root.right);
         */
    }
}
