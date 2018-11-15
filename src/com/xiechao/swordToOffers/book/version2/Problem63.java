package com.xiechao.swordToOffers.book.version2;

import org.junit.Test;

/**
 * @ClassName Problem63
 * @Author xiechao
 * @Date 2018/11/14
 * @Time 14:47
 * @Description 只可买卖一次，求股票的最大利润
 */
public class Problem63 {
    public int getMaxProfit(int[] prices){
        if(prices == null || prices.length <= 0) return 0;
        int maxProfit = 0;
        int minInput = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if(prices[i] < minInput){
                minInput = prices[i];
            }else{
                maxProfit = Math.max(maxProfit,prices[i] - minInput);
            }
        }
        return maxProfit;
    }
    @Test
    public void test(){
        System.out.println(getMaxProfit(new int[]{9,11,8,5,7,12,16,14}));
    }
}
