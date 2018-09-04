package com.xiechao.swordToOffers.leetcode;

import org.junit.Test;

import javax.xml.transform.TransformerException;
import java.util.Stack;

/**
 * @author: xiehcao
 * @Date : 2018/9/3
 * @Time : 20:56
 * @description :实质上就是中序遍历，每次取出一个节点，连接成新的树；
 */
public class Leetcode897 {
    private static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val=x;}
    }

    public TreeNode increasing(TreeNode root){
        if(root == null) return null;
        TreeNode node = root;
        TreeNode resultRoot = null;
        TreeNode currentNode = null;
        TreeNode preNode = null;
        boolean isRoot = true;
        Stack<TreeNode> stack = new Stack<>();
        while(node != null || !stack.isEmpty()){
            while(node != null){
                stack.push(node);
                node = node.left;
            }
            if(!stack.isEmpty()) {
                TreeNode temp = stack.pop();
                System.out.println(temp.val);
                if (isRoot) {                              //第一个节点
                    resultRoot = new TreeNode(temp.val);  //注意此处不能直接使用temp,不然会改变原来树的结构
                    isRoot = false;
                    preNode = resultRoot;
                } else {
                    currentNode = new TreeNode(temp.val);
                    preNode.right = currentNode;
                    preNode.left = null;
                    preNode = currentNode;
                }
                node = temp.right;  //再括号之外
            }
        }
        return resultRoot;
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
        increasing(root);
    }

    @Test
    public void test2(){
        TreeNode node_106 = new TreeNode(106);
        TreeNode node_183 = new TreeNode(183);
        node_106.left = null;
        node_106.right = node_183;
        increasing(node_106);
    }
}
