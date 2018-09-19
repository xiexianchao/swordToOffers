package com.xiechao.swordToOffers.leetcode;

import java.util.Stack;

/**
 * @author: xiehcao
 * @Date : 2018/9/19
 * @Time : 20:37
 * @description :Kth Smallest Element in a BST
 * 二叉搜索树中第k个最小的数
 */
public class LeetCode230 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    // 中序遍历 2ms
    public int kthSmallest(TreeNode root, int k) {
        if( root == null) return 0;
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        int result = 0;
        while( cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            if( !stack.isEmpty()){
                cur = stack.pop();
                k--;
                if( k == 0){
                    return cur.val;
                }
                cur = cur.right;

            }
        }
        return -1;
    }

    private int count;
    private int res;
    //LeetCode大神 0ms
    public int kthSmallest2(TreeNode root, int k){
        if(root == null) return  -1;
        count = 0;
        res = 0;
        kthSmallestCore(root,k);
        return res;

    }
    private void kthSmallestCore(TreeNode root,int k){
        if( root != null){
            kthSmallestCore(root.left,k);
            count++;
            if( count == k)
                res = root.val;
            kthSmallestCore(root.right,k);
        }

    }
}
