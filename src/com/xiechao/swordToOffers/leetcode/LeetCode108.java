package com.xiechao.swordToOffers.leetcode;

/**
 * @ClassName Problem108
 * @Author xiechao
 * @Date 2018/9/14
 * @Time 15:51
 * @Description Convert Sorted Array to Binary Search Tree
 */
public class LeetCode108 {
    private static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){ this.val =x;}
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        if( null == nums || nums.length <=0) return null;
        return sortedArrayToBSTCore(nums,0,nums.length-1);
    }

    private TreeNode sortedArrayToBSTCore(int[] nums, int start, int end) {
        TreeNode root = null;
        if(start >=0 && end >=0 && start <= end && end < nums.length){
            int mid = (end + start)>>>1;
             root = new TreeNode(nums[ mid ]);
            root.left = sortedArrayToBSTCore(nums,start,mid - 1);
            root.right = sortedArrayToBSTCore(nums,mid + 1,end);
        }
       return root;
    }


}
