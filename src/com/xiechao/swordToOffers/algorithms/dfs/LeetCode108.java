package com.xiechao.swordToOffers.algorithms.dfs;


import org.junit.Test;

import java.util.Arrays;

/**
 * @author: xiechao
 * @Date : 2018/10/18
 * @Time : 15:40
 * @description :Convert Sorted Array to Binary Search Tree
 * 将排序好的数组转成二叉搜索树
 */
public class LeetCode108 {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length <= 0) return null;
        return helper(nums,0,nums.length-1);
    }
    private TreeNode helper(int[] nums,int start,int end){
        if(start > end) return null;
        int mid = ((end - start)>>>1) + start;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums,start,mid-1);
        root.right = helper(nums,mid+1,end);
        return root;
    }
    @Test
    public void test(){

    }

}
