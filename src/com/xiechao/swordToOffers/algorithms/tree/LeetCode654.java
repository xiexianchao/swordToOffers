package com.xiechao.swordToOffers.algorithms.tree;

import com.xiechao.swordToOffers.algorithms.TreeNode;

/**
 * @ClassName LeetCode654
 * @Author xiechao
 * @Date 2019/3/25
 * @Time 10:20
 * @Description LeetCode654 Maximum Binary Tree
 *
 * 给出一个数组，构造二叉树，要求
 * - 根节点是最大值
 * - 左孩子是位于最大值左侧的最大值
 * - 右孩子是位于最大值右侧的最大值
 */
public class LeetCode654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(nums, 0 , nums.length);
    }

    //[start,end)
    private TreeNode helper(int[] nums, int start ,int end){
        if(start >= end)
            return null;
        int max = nums[start];
        int indexOfMax = start;
        for (int i = start; i < end; i++) {
            if(max <= nums[i]){
                max = nums[i];
                indexOfMax = i;
            }
        }
        TreeNode root = new TreeNode( max );
        root.left = helper(nums, start, indexOfMax);
        root.right = helper(nums, indexOfMax + 1 ,end);
        return root;
    }
}
