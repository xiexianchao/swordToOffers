package com.xiechao.swordToOffers.algorithms.packageProblems.packageArr;

import java.util.concurrent.ForkJoinPool;

/**
 * @ClassName Solution2
 * @Author xiechao
 * @Date 2019/4/5
 * @Time 16:25
 * @Description http://www.rqnoj.cn/problem/622
 * 题目描述
 * 设某一机器由 n个部件组成，每一种部件都可以从m个不同的供应商处购得。设W[i][j]是从供应商j处购得的部件i的重量，C[i][j] 是相应的价格。
 *
 * 试设计一个算法，给出总价格不超过d的最小重量机器设计。
 *
 * 【编程任务】
 *
 * 对于给定的机器部件重量和机器部件价格， 编程计算总价格不超过d的最小重量机器设计。
 *
 * 输入格式
 * 第一行有3 个正整数n，m和d。接下来的 2n 行，每行n个数。前n行是c，后n行是w。
 *
 * 输出格式
 * 计算出的最小重量
 *
 * input:
 * 2 3 4
 * 1 2 3
 * 3 2 1
 * 2 2 2
 * 1 2 3
 *
 * output:
 * 3
 *
 *
 * 和无限背包问题相似，只是参数复杂了一点
 * f[i][j] = min{f[i-1][j - c[i][k]] + w[i][k]}, 1 <= k <= m,j <= d, 1 <= i <= n, 注意编写程序时边界的处理
 */
public class Solution2 {
    public static int solution(int[][] c,int[][] w,int d){
        int m = c[0].length;
        int n = c.length;
        int[][] dp = new int[n+1][d+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= d ; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = 0; k < m ; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j > c[i-1][k] ? j - c[i-1][k] :0] + w[i-1][k]);

                }
                //System.out.println();
            }
           // System.out.println();
        }
        return dp[n][m+1];
    }

    public static void main(String[] args) {
       int result =  solution(new int[][]{{1,2,3},{3,2,1}},new int[][]{{2,2,2},{1,2,3}},4);  //4
        System.out.println(result);
    }


}
