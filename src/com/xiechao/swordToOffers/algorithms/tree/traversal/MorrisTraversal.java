package com.xiechao.swordToOffers.algorithms.tree.traversal;

import com.xiechao.swordToOffers.algorithms.TreeNode;
import com.xiechao.swordToOffers.leetcode.Leetcode897;
import org.junit.Test;

/**
 * @ClassName MorrisTraversal
 * @Author xiechao
 * @Date 2019/3/15
 * @Time 10:48
 * @Description 无栈无递归遍历树，时间复杂度O(n),空间复杂度O(1)
 * 难点在于：如何从子节点回到父节点
 *
 * 解法：利用线索二叉树（叶子节点的左右指针），改变树的结构，然后再恢复，将当前节点的中序遍历的前驱节点的右指针指向当前节点
 *
 */
public class MorrisTraversal {
    public void inorderTraversal(TreeNode root){
        if(root == null) return;
        TreeNode cur = root;
        TreeNode pre = null;
        while(cur != null){
            if(cur.left == null) {
                System.out.print(cur.val + " ");
                cur = cur.right;
            }else{
                pre = cur.left;
                while(pre.right != null && pre.right != cur)
                    pre = pre.right;
                if(pre.right == null){
                    pre.right = cur;
                    cur = cur.left;
                }else{
                    pre.right = null;
                    System.out.print(cur.val + " ");
                    cur = cur.right;
                }
            }
        }
    }

    public void preTraversal(TreeNode root){
        if(root == null) return;
        TreeNode cur = root, pre = null;
        while( cur != null){
            if(cur.left == null){
                System.out.print(cur.val + " ");
                cur = cur.right;
            }else{
                pre = cur.left;
                while(pre.right != null && pre.right != cur){
                    pre = pre.right;
                }
                if(pre.right == null){
                    pre.right = cur;
                    System.out.print(cur.val + " ");
                    cur = cur.left;
                }else{
                    pre.right = null;
                    cur = cur.right;
                }
            }
        }
    }
    public void postTraversal(TreeNode root){
        TreeNode dump = new TreeNode(0);
        dump.left = root;
        TreeNode cur = dump, pre = null;
        while(cur != null){
            if(cur.left == null){
                cur = cur.right;
            }else{
                pre = cur.left;
                while(pre.right != null && pre.right != cur)
                    pre = pre.right;
                if(pre.right == null){
                    pre.right = cur;
                    cur = cur.left;
                }else{
                    printReverse(cur.left,pre);
                    pre.right = null;
                    cur = cur.right;
                }
            }
        }
    }

    private void printReverse(TreeNode from, TreeNode to) {
        reverse(from,to);
        TreeNode p = to;
        while(true){
            System.out.print(p.val + " ");
            if(p == from)
                break;
            p = p.right;
        }
        reverse(to,from);
    }

    private void reverse(TreeNode from, TreeNode to) {
        if(from == to) return;
        TreeNode x = from,y = from.right,z = null;
        while(true){
            z = y.right;
            y.right = x;
            x = y;
            y = z;
            if(x == to)
                break;
        }
    }

    @Test
    public void test(){
         TreeNode root = new  TreeNode(5);
         TreeNode node_3 = new  TreeNode(3);
         TreeNode node_6 = new  TreeNode(6);
         TreeNode node_2 = new  TreeNode(2);
         TreeNode node_4 = new  TreeNode(4);
         TreeNode node_1 = new  TreeNode(1);
         TreeNode node_8 = new  TreeNode(8);
         TreeNode node_7 = new  TreeNode(7);
         TreeNode node_9 = new  TreeNode(9);

        root.left = node_3;
        root.right = node_6;
        node_3.left = node_2;
        node_3.right = node_4;
        node_2.left = node_1;
        node_6.right = node_8;
        node_8.left = node_7;
        node_8.right = node_9;
        inorderTraversal(root);
        System.out.println();
        preTraversal(root);
        System.out.println();
        postTraversal(root);
    }
}
