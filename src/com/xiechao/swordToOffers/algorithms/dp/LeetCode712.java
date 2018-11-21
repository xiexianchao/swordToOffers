package com.xiechao.swordToOffers.algorithms.dp;

/**
 * @ClassName LeetCode712
 * @Author xiechao
 * @Date 2018/10/30
 * @Time 16:40
 * @Description Minimum ASCII Delete Sum for Two Strings
 * 给出两个字符串，删除其中元素两个字符串相等，求删除元素的最小和
 *
 *
 */
public class LeetCode712 {
    //leetCode 大神
    public int minimumDeleteSum(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][ s2.length() + 1];
        for (int i = s1.length() - 1; i >= 0; i--) {
            dp[i][s2.length()] = dp[i+1][s2.length()] + s1.charAt(i);
        }
        for (int i = s2.length() - 1; i >= 0 ; i--) {
            dp[s1.length()][i] = dp[s1.length()][i+1] + s2.charAt(i);
        }
        for (int i = s1.length()-1; i >= 0 ; i--) {
            for (int j = s2.length() -1; j >= 0 ; j--) {
                if(s1.charAt(i) == s2.charAt(j))
                    dp[i][j] = dp[i+1][j+1];
                else
                    dp[i][j] = Math.min(dp[i+1][j]+s1.charAt(i),dp[i][j+1] + s2.charAt(j));
            }
        }
        return dp[0][0];
    }
}
