package com.xiechao.swordToOffers.algorithms.dp;

/**
 * @author: xiechao
 * @Date : 2018/10/24
 * @Time : 9:18
 * @description :Best Time to Buy and Sell Stock III
 */
public class LeetCode123 {
    //分段 0-i-prices.length-1  620ms
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1) return 0;
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            max = Math.max(max,maxProfit(prices,0,i) + maxProfit(prices,i,prices.length-1));
        }
        return max;
    }
    private int maxProfit(int[] prices,int start ,int end){
        if(start >= end) return 0;
        int max = 0;
        int input = prices[start];
        for (int i = start; i <= end ; i++) {
            max = Math.max(max,prices[i] - input);
            input = Math.min(input,prices[i]);
        }
        return max;
    }
    //动态规划

    /*
Buy1[i]表示前i天做第一笔交易买入股票后剩下的最多的钱；

Sell1[i]表示前i天做第一笔交易卖出股票后剩下的最多的钱；

Buy2[i]表示前i天做第二笔交易买入股票后剩下的最多的钱；

Sell2[i]表示前i天做第二笔交易卖出股票后剩下的最多的钱；

那么：

Sell2[i]=max{Sell2[i-1],Buy2[i-1]+prices[i]}
Buy2[i]=max{Buy2[i-1],Sell[i-1]-prices[i]}
Sell1[i]=max{Sell[i-1],Buy1[i-1]+prices[i]}
Buy1[i]=max{Buy[i-1],-prices[i]}
     *
     */
    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        int sell2 = 0;
        int sell1 = 0;
        int buy2 = Integer.MIN_VALUE;
        int buy1 = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            sell2 = Math.max(sell2, buy2 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy1 = Math.max(buy1, -prices[i]);
        }
        return sell2;
    }
}
