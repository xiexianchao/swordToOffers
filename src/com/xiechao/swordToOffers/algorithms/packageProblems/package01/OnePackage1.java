package com.xiechao.swordToOffers.algorithms.packageProblems.package01;

import org.junit.Test;

/**
 * @ClassName OnePackage1
 * @Author xiechao
 * @Date 2019/4/5
 * @Time 10:16
 * @Description n个物品，第i个物品的价值为v[i],重量为w[i]，有一个容量为m的背包，
 * 求能装的最大价值
 * dp[i][j]:表示容量为j的背包装下前i个物品的最大价值
 * if w[i] > j 表示当然容量已经装不下物品i了，所以dp[i][j]=dp[i-1][j]
 * else 当然容器能装下物品i，但是不知道物品i后，是否最大不清楚,
 * 所以 dp[i][j]=Math.max(dp[i-1][j], dp[i-1][j-w[j]] + v[i])
 * 画图填表最重要
 */
public class OnePackage1 {
    public void solution(int n ,int[] v, int[] w,int m){
        int[][] dp = new int[n][m+1];
        for (int i = 1; i <= m; i++) {
            if(w[0] > i){
                dp[0][i] = 0;
            }else{
                dp[0][i] = v[0];
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= m ; j++) {
                dp[i][j] = Math.max(dp[i-1][j], j > w[i] ? dp[i-1][j-w[i]] + v[i]:0);
            }
        }

        System.out.println(dp[n-1][m]);
    }
    @Test
    public void test(){
        solution(5,new int[]{6,4,5,3,6},new int[]{4,5,6,2,2},10);
    }


}
