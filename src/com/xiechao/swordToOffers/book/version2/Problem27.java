package com.xiechao.swordToOffers.book.version2;

import org.junit.Test;

/**
 * @author: xiehcao
 * @Date : 2018/9/18
 * @Time : 10:27
 * @description :二叉树的镜像
 */
public class Problem27 {
    private static class TreeNode{
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    //23ms
    public void Mirror(TreeNode root) {
        if(root == null) return;
        if(root.left == null && root.right == null) return;
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        Mirror(root.left);
        Mirror(root.right);

    }

    @Test
    public void tets(){
        TreeNode node_1 = new TreeNode(8);
        TreeNode node_2 = new TreeNode(6);
        TreeNode node_3 = new TreeNode(10);
        TreeNode node_4 = new TreeNode(5);
        TreeNode node_5 = new TreeNode(7);
        TreeNode node_6 = new TreeNode(9);
        TreeNode node_7 = new TreeNode(11);
        node_1.left = node_2;
        node_1.right = node_3;
        node_2.left = node_4;
        node_2.right = node_5;
        node_3.left = node_6;
        node_3.right = node_7;
        Mirror(node_1);
    }



}
