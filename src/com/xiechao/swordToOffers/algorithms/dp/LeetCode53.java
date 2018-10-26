package com.xiechao.swordToOffers.algorithms.dp;

import org.junit.Test;

/**
 * @ClassName LeetCode53
 * @Author xiechao
 * @Date 2018/10/25
 * @Time 17:02
 * @Description Maximum Subarray
 * 求连续子数组的最大和
 */
public class LeetCode53 {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length <=0 ) return 0;
        int cur = 0;
        int pre = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            cur = nums[i] + (pre > 0 ? pre : 0);
            maxSum = Math.max(cur,maxSum);
            pre = cur;
        }
        return maxSum;
    }
    @Test
    public  void test(){
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
