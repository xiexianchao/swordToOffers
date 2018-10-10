package com.xiechao.swordToOffers.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: xiehcao
 * @Date : 2018/9/28
 * @Time : 11:16
 * @description :102. Binary Tree Level Order Traversal
 */
public class LeetCode102 {
    private class TreeNode {
        int val;
     TreeNode left;
     TreeNode right;TreeNode(int x)
        { val = x; }
 }
    private int toPrint  = 0;
    private int numPrint = 1;

        //1 ms 剑指Offer上解法
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if(root == null) return result;
            List<Integer> list = new ArrayList<>();
            levelOrderCore(root,result,list);
            return result;
        }

        private void levelOrderCore(TreeNode root,List<List<Integer>> result,List<Integer> list){
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            toPrint = 1;
            numPrint = 0;
            while(!queue.isEmpty()){
                TreeNode node = queue.remove();
                list.add(node.val);
                toPrint--;

                if( node.left != null)
                {
                    queue.add(node.left);
                    numPrint++;
                }
                if( node.right != null){
                    queue.add(node.right);
                    numPrint++;
                }
                if(toPrint == 0){
                    result.add(list);
                    list = new ArrayList<>();
                    toPrint = numPrint;
                    numPrint = 0;
                }
            }

        }

        //LeetCode 大神 0ms
        public List<List<Integer>> levelOrder2(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if( root == null) return result;
            levelOrder2Core(root,result,0);
            return result;
        }
        private void levelOrder2Core(TreeNode root,List<List<Integer>> result ,int level){
            if(root == null){
                return;
            }else{
             if(level >= result.size()){
                 List<Integer> temp = new ArrayList<>();
                 temp.add(root.val);
                 result.add(temp);
             }else{
                 result.get(level).add(root.val);
             }
            levelOrder2Core(root.left,result,level+1);
            levelOrder2Core(root.right,result,level+1);
            }
        }



    @Test
    public void test(){
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
        System.out.println(levelOrder(root));
        
        
    }


}
