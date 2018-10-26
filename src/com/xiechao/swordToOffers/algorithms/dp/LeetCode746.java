package com.xiechao.swordToOffers.algorithms.dp;

import org.junit.Test;

/**
 * @ClassName LeetCode746
 * @Author xiechao
 * @Date 2018/10/25
 * @Time 11:50
 * @Description Min Cost Climbing Stairs
 * 典型动态规划问题：爬台阶。
 * 重点在于怎么表示
 */
public class LeetCode746 {
    public int minCostClimbingStairs(int[] cost) {
        if(cost == null || cost.length <=0) return 0;
        int[] dp = new int[cost.length+1];  //dp[i] 到达i个台阶所需的最小cost
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.min(dp[i-1] + cost[i-1],dp[i-2] + cost[i-2]);
        }
        return dp[dp.length-1];
    }
    @Test
    public void test(){
        System.out.println(minCostClimbingStairs(new int[]{10,15,20}));
    }
}
