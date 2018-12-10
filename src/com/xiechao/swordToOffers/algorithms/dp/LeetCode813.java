package com.xiechao.swordToOffers.algorithms.dp;

import org.junit.Test;

/**
 * @ClassName LeetCode813
 * @Author xiechao
 * @Date 2018/12/10
 * @Time 8:51
 * @Description  Largest Sum of Averages
 * 给出一个数组，求最多拆分成k个子数组，每个子数组平均数的最大和
 * 参考大神：Leetcode 813. Largest Sum of Averages
 */
public class LeetCode813 {
    public double largestSumOfAverages(int[] A, int K) {
        if(A == null || A.length <= 0 || A.length < K) return 0;
        double[][] dp = new double[K+1][A.length];
        double[] sum = new double[A.length];
        sum[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            sum[i] =sum[i-1] + A[i];
        }
        for (int i = 0; i < A.length ; i++) {
            dp[1][i] = (sum[i] / (i+1));
        }
        for (int i = 2; i <= K ; i++) {
            for (int j = i-1; j < A.length; j++) {
                for (int p = 0; p <= j-1; p++) {
                    dp[i][j] = Math.max(dp[i][j],dp[i-1][p] + ( sum[j] - sum[p] )/(j-p)  );
                }
            }
        }
        return dp[K][A.length-1];
    }
    @Test
    public void test(){
        System.out.println(largestSumOfAverages(new int[]{9,1,2,3,9},3));
        System.out.println(largestSumOfAverages(new int[]{4,1,7,5,6,2,3},4));
    }
}
