package com.xiechao.swordToOffers.algorithms.dp;

import org.junit.Test;

/**
 * @ClassName LeetCode931
 * @Author xiechao
 * @Date 2018/11/20
 * @Time 8:56
 * @Description TODO
 */
public class LeetCode931 {
    public int minFallingPathSum(int[][] A) {
        int rows = A.length;
        int cols = A[0].length;
        int[][] dp = new int[rows][cols];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < cols; i++) {
            dp[0][i] = A[0][i];
        }
        for (int i = 1,j = 0; i < rows; i++) {
            j = 0;
            for (; j < cols; j++) {
                dp[i][j] = A[i][j] + Math.min(
                        Math.min(dp[i-1][j],j-1 >= 0 ?dp[i-1][j-1]:Integer.MAX_VALUE),
                        j+1 < cols ? dp[i-1][j+1]:Integer.MAX_VALUE);
            }
        }
        for (int i = 0; i < cols; i++) {
            min = Math.min(min,dp[rows-1][i]);
        }

        return min;
    }
    @Test
    public void test(){
        int[][] array = new int[3][];
        array[0] = new int[]{1,2,3};
        array[1] = new int[]{4,5,6};
        array[2] = new int[]{7,8,9};
        System.out.println(minFallingPathSum(array));
    }
}
