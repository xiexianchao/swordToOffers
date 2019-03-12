package com.xiechao.swordToOffers.algorithms.tree;

import com.xiechao.swordToOffers.algorithms.TreeNode;
import org.junit.Test;

/**
 * @ClassName LeetCode108
 * @Author xiechao
 * @Date 2019/3/12
 * @Time 9:36
 * @Description LeetCode108 Convert Sorted Array to Binary Search Tree
 * 将输入数组转换成二叉搜索树并且平衡
 */
public class LeetCode108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length <= 0) return null;
        return helper(nums,0,nums.length-1);
    }
    private TreeNode helper(int[] nums, int start, int end){
        TreeNode node = null;
        if(start <= end){
         int mid = (start + end) /2;
         node = new TreeNode(nums[mid]);
         node.left = helper(nums,start,mid-1);
         node.right = helper(nums, mid + 1, end);
        }
        return node;
    }

}
