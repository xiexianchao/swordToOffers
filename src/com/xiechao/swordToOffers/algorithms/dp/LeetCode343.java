package com.xiechao.swordToOffers.algorithms.dp;

import org.junit.Test;

/**
 * @ClassName LeetCode343
 * @Author xiechao
 * @Date 2018/11/22
 * @Time 8:48
 * @Description Integer Break
 * 将一个整数拆成多个数相加（至少两个数），求这些数乘积的最大值
 */
public class LeetCode343 {
    //动态规划
    public int integerBreak(int n) {
            int[] dp = new int[n+1];
            dp[1] = 1;
            dp[2] = 1;
        for (int i = 3; i <=n; i++) {
            int temp = 0;
            for (int j = 1; j < i ; j++) {
                temp = Math.max(temp,j * (dp[i-j] >= (i-j)?dp[i-j]:i-j));
            }
            dp[i] = temp;
        }
        return dp[n];
    }
    //LeetCode大神 贪心，和剑指offer上剪绳子那题是同一题
    public int integerBreak2(int n){
        if(n < 3) return 1;
        if(n == 3) return 2;
        int product = 1;
        while(n >4) {
            product *=3;
            n -=3;
        }
        return product*n;
    }
    @Test
    public void test(){
        System.out.println(integerBreak(34));
        System.out.println(integerBreak2(34));
    }

}
