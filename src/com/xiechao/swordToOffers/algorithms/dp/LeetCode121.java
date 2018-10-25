package com.xiechao.swordToOffers.algorithms.dp;

/**
 * @author: xiechao
 * @Date : 2018/10/24
 * @Time : 8:40
 * @description :Best Time to Buy and Sell Stock
 * 只可买卖一次求最大利润
 * 还用不到动态规划，从索引为1处开始遍历数据，每次记录下此处卖出的最大利润，然后取最大值
 * 求索引为i出的最大利润，price[i] - min
 * min为数组在0-i-1之间的最小值
 *
 */
public class LeetCode121 {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1) return 0;
        int max = 0;            //最大利润
        int min = prices[0];    //当前最小的买入
        for (int i = 1; i < prices.length; i++) {
            max = Math.max(prices[i]-min,max);
            min = Math.min(prices[i],min);
        }
        return max;
    }



}
