package com.xiechao.swordToOffers.algorithms.dp;

/**
 * @ClassName LeetCode718
 * @Author xiechao
 * @Date 2018/12/5
 * @Time 10:13
 * @Description Maximum Length of Repeated Subarray
 * 求两个字符串(或者数组)的最长公共子串（子数组）
 *
 */
public class LeetCode718 {
    //LeetCode 答案 62ms
    public int findLength(int[] A, int[] B) {
        if(A == null || B == null || A.length <= 0 || B.length <= 0) return 0;
        int res = 0;
        int[][] dp = new int[A.length+1][B.length+1];
        for (int i = A.length - 1; i >= 0 ; i--) {
            for (int j = B.length - 1; j >= 0 ; j--) {
                if(A[i] == B[j])
                    dp[i][j] = dp[i+1][j+1] + 1;
                else
                    dp[i][j] = 0;
                res = Math.max(res,dp[i][j]);
            }
        }
        return res;
    }
    //LeetCode大神 优化,dp[j]表示以B[j]开头的公共子串长度
    public int findLength2(int[] A, int[] B) {
        if(A == null || B == null || A.length <= 0 || B.length <= 0) return 0;
        int res = 0;
        int[] dp = new int[B.length + 1];
        for (int i = A.length -1; i >= 0 ; i--) {
            for (int j = 0; j < dp.length; j++) {
                res = Math.max(res,dp[j] = (A[i] == B[j]? 1 + dp[j+1]:0));
            }
        }
        return res;
    }


}
