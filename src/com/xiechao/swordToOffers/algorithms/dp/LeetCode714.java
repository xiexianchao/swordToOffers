package com.xiechao.swordToOffers.algorithms.dp;

import org.junit.Test;

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
    //这样求得并不是最优解，比如{1,3,7,5,10,3}，3 所有方法错误
    public int maxProfit3(int[] prices, int fee) {
        if(prices == null || prices.length <= 1) return 0;
        int sum = 0;
        int input = prices[0];
        for(int i = 1; i < prices.length; i++){
            if(prices[i] < input){
                input = prices[i];
            }else if(prices[i] > (input + fee)){
                sum += prices[i] - input - fee;
                input = Integer.MAX_VALUE;

            }else
                continue;

        }
        return sum;
    }
    @Test
    public void test(){
        System.out.println(maxProfit3(new int[]{1,3,2,8,4,9},2));
        System.out.println(maxProfit3(new int[]{1,3,7,5,10,3},3));
    }



}
