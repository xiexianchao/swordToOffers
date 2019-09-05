package com.xiechao.swordToOffers.book.version2;

import org.junit.Test;

/**
 * @ClassName Problem60
 * @Author xiechao
 * @Date 2018/11/12
 * @Time 9:31
 * @Description n个骰子出现的点数
 */
public class Problem60 {
    //github 大神
    public void printProbability(int n){
        if(n <= 0) return;
        double total =  Math.pow(6,n);
        //dp[i][j]表示i个骰子总和为j的次数
        int[][] dp = new int[n + 1][6 * n + 1];
        for (int i = 1; i <= 6 ; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= n ; i++) {
            for (int j = i; j < 6*n+1 ; j++) {
                for (int k = 1; j - k > 0 && k <= 6; k++) {
                    dp[i][j] += dp[i-1][j-k];
                }
            }
        }
        for (int i = n; i < dp[n].length ; i++) {
            System.out.println(dp[n][i]);
        }
    }

    //github 大神 更节省空间的做法 使用[2][6*n+1]的空间
    public void printProbability2(int n)
    {
        if(n <= 0) return;
        //用dp[flag][j]表示dp过程
        int[][] dp = new int[2][ 6 * n + 1];
        int flag = 0;
        for (int i = 1; i <= 6 ; i++) {
            dp[flag][i] = 1;
        }
        for (int i = 2; i <= n ; i++) {
            for (int j = i; j <= 6*i ; j++) {
                int sum = 0;            //需要重新置为0，防止i-2的值影响
                for (int k = 1; k <= 6  && j - k >= 0; k++) {
                    sum += dp[flag][j-k];
                }
                dp[1- flag][j] = sum;           //赋予新值
            }
            flag = 1 - flag;            //改变flag
        }
        for (int i = n; i <= 6*n ; i++) {
            System.out.println(dp[flag][i]);
        }
    }

    //用一维数组
    public void printProbability3(int n){
        if(n <= 0) return;
        //使用一维数组保存dp过程
        //dp[i]表示总和为i，出现的次数
        //dp[i] = dp[i-1] + ...+ dp[i-6]
        int[] dp = new int[6*n+1];
        for (int i = 1; i <= 6 ; i++) {
            dp[i] = 1;
        }
        for (int i = 2; i <= n ; i++) {
            for (int j = 6*n; j >= i ; j--) {   //因为更新dp[i]时，dp[i-k]必须保持上一轮（i-1个骰子）的值，所以必须倒序进行。
                int sum = 0;
                for (int k = 1; k <= 6 && j-k >= i-1; k++) { //为什么要是i-1，因为数值为此处用上一轮j-k表示i-1个骰子出现的数值（最小值为i-1）
                    sum += dp[j - k];
                }
                dp[j] = sum;
            }
        }
        for (int i = n; i <= 6*n ; i++) {
            System.out.println(dp[i]);
        }
    }


    @Test
    public void test(){
        printProbability(3);
        System.out.println("********************");
        printProbability2(3);
        System.out.println("********************");
        printProbability3(3);
    }



}
