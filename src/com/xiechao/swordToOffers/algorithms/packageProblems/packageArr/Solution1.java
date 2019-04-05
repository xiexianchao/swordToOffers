package com.xiechao.swordToOffers.algorithms.packageProblems.packageArr;

/**
 * @ClassName Solution1
 * @Author xiechao
 * @Date 2019/4/5
 * @Time 15:16
 * @Description 多重背包， 在0/1背包的基础上加了一个条件：第i个物品有arr[i]件
 */
public class Solution1 {
    public static int solution1(int[] arr,int[] weight, int[] values,int M){
        int[][] dp = new int[arr.length][M+1];
        for (int i = 1; i <= M ; i++) {
            dp[0][i] = (i/weight[0] >= arr[0] ? arr[0] : i/weight[0]) * values[0];
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j <= M ; j++) {
                for (int k = 0; k <= arr[i] && k <= j/weight[i] ; k++) {
                    dp[i][j] = Math.max(dp[i][j],dp[i-1][j - k * weight[i]]+ k * values[i]);
                }
            }
        }
        return dp[arr.length-1][M];
    }

    public static void main(String[] args) {
        System.out.println(solution1(new int[]{1,1,1,1,1},new int[]{4,5,6,2,2},new int[]{6,4,5,3,6},10));
    }



}
