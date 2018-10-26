package com.xiechao.swordToOffers.algorithms.dp;

/**
 * @ClassName LeetCode198
 * @Author xiechao
 * @Date 2018/10/25
 * @Time 17:22
 * @Description House Robber
 */
public class LeetCode198 {
    public int rob(int[] nums) {
        if(nums == null || nums.length <=0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0],nums[1]);

        int[] f = new int[nums.length];
        f[0] = nums[0];
        f[1] = Math.max(f[0],nums[1]);
        for (int i = 2; i < nums.length ; i++) {
            f[i] = Math.max(nums[i] + f[i-2],f[i-1]);
        }
        return f[nums.length-1];
    }
}
