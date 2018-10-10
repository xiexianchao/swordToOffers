package com.xiechao.swordToOffers.book.version2;

import sun.reflect.generics.tree.Tree;

import java.util.Stack;

/**
 * @ClassName Problem36
 * @Author xiechao
 * @Date 2018/9/26
 * @Time 19:27
 * @Description 二叉搜索树转换成双向链表
 */
public class Problem36 {
    private class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    //直接用中序遍历实现，但空间复杂度为O(n)
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pHead = null;
        TreeNode node = pRootOfTree;
        TreeNode pre = null;
        while( node != null || !stack.isEmpty()){
            while( node != null){
                stack.push(node);
                node = node.left;
            }
            if( !stack.isEmpty()){
                node = stack.pop();
                if(pre == null){
                    pHead = node;
                    pre = node;
                }else{
                    pre.right = node;
                    node.left = pre;
                    pre = node;
                }
                node = node.right;
            }
        }
        return pHead;
    }

    //大神  递归
    private TreeNode head = null;
    private TreeNode tail = null;

    public TreeNode Convert2(TreeNode pRootOfTree){
        if(pRootOfTree == null) return null;
        visit(pRootOfTree);
        return head;
    }
    private void visit(TreeNode root){
        if( root == null)
            return;
        visit(root.left);
        createList(root);
        visit(root.right);
    }
    private void createList(TreeNode cur){
        cur.left = tail;
        if( tail == null){
            head = cur;
        }else{
            tail.right = cur;
        }
        tail = cur;
    }
}
