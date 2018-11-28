package com.xiechao.swordToOffers.algorithms.dp;

import org.junit.Test;

/**
 * @ClassName LeetCode62
 * @Author xiechao
 * @Date 2018/11/28
 * @Time 9:11
 * @Description 62. Unique Paths
 * 第一反映就是dfs来做,发现时间超过限制
 * 第二反映dp,dp[i][j] = dp[i-1][j] + dp[i][j-1]
 */
public class LeetCode62 {
    //dfs Time Limit Exceeded
    public int uniquePaths(int m, int n) {
        if(m <= 0 || n <= 0 ) return 0;
        //int[][] paths = new int[n][m]; //paths[i][j]
        int[] count = new int[1];
        helper(n,m,0,0,count);
        return count[0];
    }
    private void helper(int n,int m, int startX, int startY, int[] count) {
        if(startX == n - 1 && startY == m - 1){
            count[0]++;
        }else if(startX >= n || startY >= m )
            return;
        else{
            helper(n,m,startX + 1, startY, count);
            helper(n,m,startX,startY + 1, count);
        }
    }

    //dp
    public int uniquePaths2(int m, int n) {
        if(m <= 0 || n <= 0) return 0;
        int[][] dp = new int[n][m];
        for (int i = 0; i < m; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[n-1][m-1];
    }


    @Test
    public void test(){
        System.out.println(uniquePaths(7,3));
    }
}
