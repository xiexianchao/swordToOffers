package com.xiechao.swordToOffers.algorithms.dp;

/**
 * @ClassName LeetCode877
 * @Author xiechao
 * @Date 2019/4/10
 * @Time 9:21
 * @Description TODO
 */
public class LeetCode877 {
    public boolean stoneGame(int[] piles) {
        if(piles == null || piles.length <= 0) return false;
        if(piles.length == 1) return true;
        int[][] dp = new int[piles.length][ piles.length ];
        for (int i = 0; i < piles.length; i++) {
            dp[i][i] = piles[i];
        }
        for (int dist = 1; dist < piles.length; dist++) {
            for (int i = 0; i < piles.length - dist; i++) {
                dp[i][i+dist] = Math.max(piles[i] - dp[i + 1][i + dist], piles[i + dist] - dp[i][ i + dist - 1]);
            }
        }
        return dp[0][piles.length-1] >0;
    }
}
