package com.xiechao.swordToOffers.algorithms.dp;

/**
 * @author: xiechao
 * @Date : 2018/10/24
 * @Time : 11:26
 * @description :
 */
public class LeetCode188 {
    public int maxProfit(int k, int[] prices) {
        if(prices == null || prices.length <=1 || k <=0 || k >= prices.length) return 0;
        int[][] sellandbuy = new int[k][2];
        for (int i = 0; i < sellandbuy.length; i++) {
            sellandbuy[i] = new int[2];
            sellandbuy[i][0] = 0;   //selli
            sellandbuy[i][1] = Integer.MIN_VALUE; //buyi
        }
        for (int i = 0; i < prices.length; i++) {
            for (int j = k-1; j >= 0 ; j--) {
                if (j >= 1) {
                    sellandbuy[j][0] = Math.max(sellandbuy[j][0], sellandbuy[j][1] + prices[i]);
                    sellandbuy[j][1] = Math.max(sellandbuy[j][1], sellandbuy[j-1][0] - prices[i]);
                }else{
                    sellandbuy[j][0] = Math.max(sellandbuy[j][0], sellandbuy[j][1] + prices[i]);
                    sellandbuy[j][1] = Math.max(sellandbuy[j][1],-prices[i]);
                }
            }
        }
        return sellandbuy[k-1][0];
    }
}
