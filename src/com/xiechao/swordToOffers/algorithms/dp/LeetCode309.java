package com.xiechao.swordToOffers.algorithms.dp;

import org.junit.Test;

/**
 * @ClassName LeetCode309
 * @Author xiechao
 * @Date 2018/12/6
 * @Time 9:07
 * @Description
 * 可以任意次买卖，但是要求每次卖出后一天不能买入，需要冷却1天
 * 同理，对于某一天考虑是否持有彩票两种情况
 * dp[i][0] 表示第i天不持有彩票最大利润     dp[i][1]表示第i天持有彩票利润
 * dp[0][0] = 0; dp[0][1] = -prices[i];
 * i>= 2时，dp[i][1] = Math.max(dp[i-1][1],dp[i-2][0] - prices[i]);
 * i< 2 时，dp[i][1] = Math.max(dp[i-1][1],-prices[i]);
 * dp[i][0] =  Math.max(dp[i-1][0],dp[i-1][1] + prices[i]);
 * dp[prices.length-1][0] is result
 */
public class LeetCode309 {
    public int maxProfit(int... prices) {
        if(prices == null || prices.length <= 0) return 0;
        int[][] dp = new int[prices.length][2];
        dp[0][1] = - prices[0];
        dp[0][0] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][1] = Math.max(dp[i-1][1],i >= 2 ?dp[i-2][0] - prices[i]:-prices[i]);
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] + prices[i]);
        }
        return dp[prices.length - 1][0];
    }
    @Test
    public void test(){
        int[] prices = new int[]{1,2,3,0,2};
        System.out.println(maxProfit(prices));

        System.out.println(maxProfit(1,2,4));
    }
}
