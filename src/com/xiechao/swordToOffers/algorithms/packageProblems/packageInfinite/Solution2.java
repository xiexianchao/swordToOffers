package com.xiechao.swordToOffers.algorithms.packageProblems.packageInfinite;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;

/**
 * @ClassName Solution2
 * @Author xiechao
 * @Date 2019/4/5
 * @Time 15:40
 * @Description http://www.rqnoj.cn/problem/117
 * NaCN_JDavidQ要在下个月交给老师n篇论文，论文的内容可以从m个课题中选择。由于课题数有限，NaCN_JDavidQ不得不重复选择一些课题。完成不同课题的论文所花的时间不同。具体地说，对于某个课题i，若NaCN_JDavidQ计划一共写x篇论文，则完成该课题的论文总共需要花费Ai*x^Bi个单位时间（系数Ai和指数Bi均为正整数）。给定与每一个课题相对应的Ai和Bi的值，请帮助NaCN_JDavidQ计算出如何选择论文的课题使得他可以花费最少的时间完成这n篇论文。
 *
 * 输入格式
 * 第一行有两个用空格隔开的正整数n和m，分别代表需要完成的论文数和可供选择的课题数。
 *
 * 　　以下m行每行有两个用空格隔开的正整数。其中，第i行的两个数分别代表与第i个课题相对应的时间系数Ai和指数Bi。
 *
 * 　　对于30%的数据，n<=10,m<=5；
 *
 * 　　对于100%的数据，n<=200，m<=20，Ai<=100，Bi<=5。
 *
 * 输出格式
 * 输出完成n篇论文所需要耗费的最少时间。
 * input:
 * 10 3
 * 2 1
 * 1 2
 * 2 1
 * output:
 * 19
 *
 */
//类似于无限背包，f[i][j] = min{f[i-1][j-x] + A[i] * k^B[i]}, 0<=x<=j,0<= 1 <n
public class Solution2 {
    public static int getMinTime(int[] A,int[] B,int M){
        int[][] dp = new int[A.length][M+1];
        for (int i = 1; i <= M ; i++) {
            dp[0][i] = A[0] * (int)Math.pow(i,B[0]);
        }
        for (int i = 1; i < A.length; i++) {
            for (int j = 1; j <= M ; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = 0; k <= j ; k++) {
                    dp[i][j] = Math.min(dp[i-1][j-k] + A[i] * (int)Math.pow(k,B[i]),dp[i][j]);
                }
            }
        }
        return dp[A.length - 1][M];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] A = new int[m];
        int[] B = new int[m];
        for (int i = 0; i < m; i++) {
            A[i] = scanner.nextInt();
            B[i] = scanner.nextInt();
        }
        System.out.println(getMinTime(A, B,n));
    }
}
