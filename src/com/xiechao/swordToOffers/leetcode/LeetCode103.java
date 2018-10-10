package com.xiechao.swordToOffers.leetcode;

import org.junit.Test;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: xiehcao
 * @Date : 2018/10/10
 * @Time : 16:14
 * @description :剑指Offer上之字形打印二叉树
 */
public class LeetCode103 {
     class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x;}
    }
    //用栈，2ms
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Stack<TreeNode>[] stacks = new Stack[2];
        stacks[0] = new Stack<>();
        stacks[1] = new Stack<>();
        int current = 0;
        stacks[current].push(root);
        List<Integer> list = new ArrayList<>();
        while( (!stacks[current].isEmpty()) || (!stacks[1-current].isEmpty())){
            TreeNode node = stacks[current].pop();
            list.add(node.val);
            if(current == 0) {
                if (node.left != null)
                    stacks[1-current].push(node.left);
                if (node.right != null)
                    stacks[1-current].push(node.right);
            }else{
                if (node.right != null)
                    stacks[1-current].push(node.right);
                if (node.left != null)
                    stacks[1-current].push(node.left);
            }
            if( stacks[current].isEmpty()){
                result.add(list);
                list = new ArrayList<>();
                current = 1- current;
            }
        }
        return result;
    }

    //LeetCode大神 用递归 0ms
    public List<List<Integer>> zigzagLevelOrder2(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        result.add(new ArrayList<>());
        travel(result,root,0);
        return result;
    }

    private void travel(List<List<Integer>> result, TreeNode root, int level) {
        if(root == null) return;
        if(level > result.size()-1) {
            result.add(new ArrayList<>());
        }
        List<Integer> list = result.get(level);
        if( (level &1) == 0){
            list.add(root.val);
        }else{
            list.add(0,root.val);
        }
        travel(result,root.left,level+1);
        travel(result,root.right,level+1);
        return;
    }


    @Test
    public void test(){
        TreeNode node3 = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);
        node3.left = node9;
        node3.right = node20;
        node20.left = node15;
        node20.right = node7;
        zigzagLevelOrder(node3);
    }
}
