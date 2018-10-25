package com.xiechao.swordToOffers.algorithms.dp;

/**
 * @author: xiechao
 * @Date : 2018/10/24
 * @Time : 9:09
 * @description :Best Time to Buy and Sell Stock II
 * 可以多次买卖，求最大利润
 * 用input表示当前买入的价格，如果price[i]>input就卖出，更新input，如果price[i]<input就不卖出，但也要更新input为最小值
 *
 */
public class LeetCode122 {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1 ) return 0;
        int max = 0;
        int input = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if(prices[i] > input)
            {
                max += prices[i] - input;
                input = prices[i];
            } else{
              input = prices[i];
            }
        }
        return max;
    }
}
