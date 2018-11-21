package com.xiechao.swordToOffers.algorithms.dp;

/**
 * @ClassName LeetCode714
 * @Author xiechao
 * @Date 2018/11/20
 * @Time 10:04
 * @Description Best Time to Buy and Sell Stock with Transaction Fee
 */
public class LeetCode714 {
    public int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0; //不持有股票
        dp[0][1] = - prices[0]; //持有股票
        for (int i = 1; i < prices.length ; i++) {
            dp[i][0] = Math.max(dp[i-1][0],dp[0][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
        }
        return dp[prices.length-1][0];
    }

    public int maxProfit2(int[] prices, int fee) {
        int cash = 0 ,hold = -prices[0];
        for (int i = 1; i < prices.length ; i++) {
            cash = Math.max(cash,hold + prices[i] - fee);
            hold = Math.max(hold,cash - prices[i]);
        }
        return cash;
    }

}
