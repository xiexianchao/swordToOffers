package com.xiechao.swordToOffers.algorithms.packageProblems.packageInfinite;

import java.util.Scanner;

/**
 * @ClassName Solution1
 * @Author xiechao
 * @Date 2019/4/5
 * @Time 14:59
 * @Description:
 * ALEJ并不是财迷，但是作为纯洁党的伟大领袖，不挣钱，纯洁的事业怎么能坚持下去！纯洁党现在已经有M(1<=M<=100000)元经费了。ALEJ有一个富II代朋友，叫做HSW，HSW特别喜欢高价收藏一些餐巾纸（毛泽东用过的）、袜子（恐龙穿过的）、马桶垫（还珠格格坐过的）、红领巾（毛新宇戴过的）等等，总之，没有他不买的。因此ALEJ想借HSW这个大财主，通过倒买倒卖拥有尽可能多的钱。
 *
 * 有N(1<=N<=100)件物品供他选择，每件物品的买入价为c[i](1<=c[i]<=100000)元，HSW的收藏价为r[i](1<=r[i]<=100000)元。每向HSW卖出一件物品i之后，还要向政府上交c[i]元的税。每种物品的数量都是无限的。
 *
 * ALEJ想知道，通过一次买卖（种类、数量没有限制）后，纯洁党的经费能有多少。

 */
public class Solution1 {
    public static int getMaxValue(int[] r,int[] c, int M){
        int[][] dp = new int[r.length][ M + 1];
        for (int i = 1; i <= M ; i++) {
            dp[0][i] = (r[0] - c[0] - c[0]) * (i/c[0]);
        }

        for (int i = 1;i < r.length; i++) {
            for (int j = 1; j <= M ; j++) {
                for (int k = 0; k <= j/c[i] ; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j - k * c[i]] + k * (r[i] - c[i] - c[i]));
                }
            }
        }
        return dp[r.length - 1][M] + M;
    }
    public static void main(String...args){
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[] c = new int[N];
        int[] r = new int[N];
        for (int i = 0; i < N; i++) {
            c[i] = scanner.nextInt();
            r[i] = scanner.nextInt();
        }
        System.out.println(getMaxValue(r,c,M));
    }


}
