package com.xiechao.swordToOffers.leetcode;

import java.util.*;

/**
 * @ClassName LeetCode101
 * @Author xiechao
 * @Date 2018/9/14
 * @Time 21:52
 * @Description Symmetric Tree
 * 求一个二叉树是否是镜像
 *
 * 我原本以为如果二叉树中序遍历序列为一个回文序列即为一棵镜像二叉树，其实不然。例如，{1，2，3，3，null,2,null}
 *
 */
public class LeetCode101 {
    private static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){ val = x;}
    }
    //LeetCode 大神
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isMirror(root,root);
    }
    private boolean isMirror(TreeNode root1,TreeNode root2){
        if( root1 == null && root2 == null) return true;
        if( root1 == null || root2 == null) return false;
        return (root1.val == root2.val) && isMirror(root1.left,root2.right) && isMirror(root1.right,root2.left);
    }
    //LeetCode 大神
    public boolean isSymmetric2(TreeNode root){
        if( root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode t1 = queue.poll();
            TreeNode t2 = queue.poll();
            if( t1 == null && t2 == null) continue;
            if( t1 == null || t2 == null) return false;
            if( t1.val != t2.val) return false;
            queue.add(t1.left);
            queue.add(t2.right);
            queue.add(t1.right);
            queue.add(t2.left);
        }
        return true;

    }





    private boolean errorMethod(TreeNode root) {
        if(root == null ) return   true;
        List<Integer> list = inOrderTraverse(root);
        for (int i = 0; i <= list.size()/2; i++) {
            if(list.get(i) != list.get( list.size() -1 -i))
                return false;
        }
        return true;
    }

    private List<Integer> inOrderTraverse(TreeNode root){
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while(  ! stack.isEmpty() || node != null){
            while( node != null){
                stack.push(node);
                node = node.left;
            }
            if( !stack.isEmpty()){
                TreeNode temp = stack.pop();
                list.add(temp.val);
                node = temp.right;
            }
        }
        return list;
    }

}
