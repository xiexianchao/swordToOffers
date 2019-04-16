package com.xiechao.swordToOffers.algorithms.dp;

import org.junit.Test;

import java.util.concurrent.ForkJoinPool;

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
    //和LeetCode877一样的题目
    public boolean PredictTheWinner2(int[] nums){
        if(nums == null || nums.length <= 0) return false;
        if(nums.length == 1) return true;
        int[][] dp = new int[nums.length ][nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i][i] = nums[i];
        }
        for (int dist = 1; dist < nums.length ; dist++) {
            for (int i = 0; i < nums.length - dist; i++) {
                dp[i][i + dist] = Math.max(nums[i]- dp[i+1][i+dist], nums[i + dist] - dp[i][i + dist -1]);
                System.out.println("dp[" + i + "][" + (i + dist) + "] =" + dp[i][i+dist]);
            }
        }
        return dp[0][nums.length-1] >0;
    }
    @Test
    public  void test(){
        System.out.println(PredictTheWinner2(new int[]{1,1}));
    }

}
