package com.xiechao.swordToOffers.algorithms.bst;

import com.xiechao.swordToOffers.algorithms.TreeNode;
import org.junit.Test;

/**
 * @ClassName LeetCode783
 * @Author xiechao
 * @Date 2019/1/22
 * @Time 9:24
 * @Description TODO
 */
public class LeetCode783 {
    //层序遍历,存在冗余
    public int minDiffInBST(TreeNode root) {
        if(root.left == null && root.right == null)
            return Integer.MAX_VALUE;
        TreeNode leftMaxNode = getLeftMaxNode(root.left);
        TreeNode rightMinNode = getRightMinNode(root.right);
        int minDiff = Integer.MAX_VALUE;
        if(leftMaxNode != null && rightMinNode != null){
            int temp1= Math.abs(root.val - leftMaxNode.val);
            int temp2 = Math.abs(root.val - rightMinNode.val);
            minDiff = temp1 >= temp2 ? temp2:temp1;
        }else{
            if(leftMaxNode == null)
                minDiff = Math.abs(root.val - rightMinNode.val);
            else
                minDiff = Math.abs(root.val - leftMaxNode.val);
        }
        int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
        if(root.left != null){
            left = minDiffInBST(root.left);
        }
        if(root.right != null)
            right = minDiffInBST(root.right);

        return min(minDiff,left,right);

    }

    private int min(int minDiff, int left, int right) {
        return Math.min(Math.min(minDiff,left),right);
    }

    private TreeNode getLeftMaxNode(TreeNode node){
        if(node == null)
            return null;
        TreeNode pre = node;
        while(node != null ){
            pre = node;
            node = node.right;
        }
        return pre;
    }
    private TreeNode getRightMinNode(TreeNode node){
        if(node == null){
            return null;
        }
        TreeNode pre = node;
        while(node != null){
            pre = node;
            node = node.left;
        }
        return pre;
    }

    TreeNode pre = null;
    public int minDiffInBST2(TreeNode root){

        int[] result = new int[]{Integer.MAX_VALUE};
        inOrderTraversal(root, result);
        return result[0];
    }

    private void inOrderTraversal(TreeNode root, int... result) {
        if(root == null)
            return;
        if(root.left != null){
            inOrderTraversal(root.left,result);
        }
        if (pre != null)
            result[0] = Math.min(result[0], Math.abs(root.val - pre.val));
        pre = root;

        if(root.right != null){
            inOrderTraversal(root.right,result);
        }

    }
    @Test
    public void test(){
        TreeNode root_5 = new TreeNode(5);
        TreeNode root_4 = new TreeNode(4);
        TreeNode root_7 = new TreeNode(7);
        root_5.left = root_4;
        root_5.right = root_7;
        System.out.println(minDiffInBST2(root_5));
    }

}
