package com.xiechao.swordToOffers.algorithms.tree;

import com.sun.org.apache.xerces.internal.dom.ParentNode;
import com.xiechao.swordToOffers.algorithms.TreeNode;
import org.junit.Test;

import java.util.Stack;

/**
 * @ClassName LeetCode897
 * @Author xiechao
 * @Date 2019/3/8
 * @Time 9:17
 * @Description LeetCode897 Increasing Order Search Tree
 * 将一棵二叉搜索树重新排序成一个递增的链表
 *
 */
public class LeetCode897 {
    public TreeNode increasingBST(TreeNode root) {
        if(root == null) return null;
        Stack<TreeNode> stack = new Stack<>();


        TreeNode fakeRoot = new TreeNode(0);

        TreeNode parent = fakeRoot;
        TreeNode cur = root;

        while(!stack.isEmpty()||cur != null){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            if(!stack.isEmpty()){
                TreeNode node = stack.pop();
              //  TreeNode newNode = new TreeNode(node.val);
                parent.right = node;
                parent = node;
                parent.left = null;
                cur = node.right;
            }
        }
        return fakeRoot.right;
    }
    @Test
    public void test1(){
        TreeNode root = new TreeNode(5);
        TreeNode node_3 = new TreeNode(3);
        TreeNode node_6 = new TreeNode(6);
        TreeNode node_2 = new TreeNode(2);
        TreeNode node_4 = new TreeNode(4);
        TreeNode node_1 = new TreeNode(1);
        TreeNode node_8 = new TreeNode(8);
        TreeNode node_7 = new TreeNode(7);
        TreeNode node_9 = new TreeNode(9);

        root.left = node_3;
        root.right = node_6;
        node_3.left = node_2;
        node_3.right = node_4;
        node_2.left = node_1;
        node_6.right = node_8;
        node_8.left = node_7;
        node_8.right = node_9;
        increasingBST(root);
    }
}
