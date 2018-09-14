package com.xiechao.swordToOffers.leetcode;

/**
 * @author: xiehcao
 * @Date : 2018/9/14
 * @Time : 10:57
 * @description :Best Time to Buy and Sell Stock II
 * 可以尽可能多的买卖。但是必须卖出后才能买入
 */
public class LeetCode122 {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <=0)
            return 0;
        int maxProfit = 0;
        for (int i = 0; i < prices.length-1; i++) {
            maxProfit +=(prices[i + 1] - prices[i]) >0? (prices[i + 1] - prices[i]):0;
        }
        return maxProfit;
    }
}
