package com.xiechao.swordToOffers.algorithms.dp;

/**
 * @ClassName LeetCode486
 * @Author xiechao
 * @Date 2018/11/23
 * @Time 9:59
 * @Description Predict the Winner
 * 说实话我没有看懂题目，至今为止。
 * 根据网上的答案，简化一下题目：有没有一种选取策略，使得第一个人的和大于等于数组和的一半
 */
public class LeetCode486 {
    //网上大神
    public boolean PredictTheWinner(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        for (int i = 0; i < dp.length - 1; i++) {
            dp[i][i] = nums[i];
            dp[i][i+1] = Math.max(nums[i],nums[i+1]);
        }
        dp[dp.length-1][dp.length-1] = nums[nums.length-1];
        for (int len = 3; len <= dp.length ; len++) {
            for (int i = 0; i + len <= dp.length; i++) {
                int j = i + len - 1;
                dp[i][j] = Math.max(nums[i] + Math.min(dp[i+1][j-1],dp[i+2][j]),
                        nums[j] + Math.min(dp[i+1][j-1],dp[i][j-2]));
            }
        }
        int sum = 0;
        for (Integer e:nums) {
            sum += e;
        }
        if(dp[0][dp.length - 1] >= (sum+1/2)){
            return true;
        }else
            return false;

        
    }

}
