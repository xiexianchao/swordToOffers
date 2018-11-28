package com.xiechao.swordToOffers.algorithms.dp;

import org.junit.Test;

/**
 * @ClassName LeetCode650
 * @Author xiechao
 * @Date 2018/11/27
 * @Time 9:35
 * @Description 2 Keys Keyboard
 */
public class LeetCode650 {
    //存在冗余计算 75ms
    public int minSteps(int n) {
        if(n <= 1) return 0;
        int[] dp = new int[n+1];
        dp[0] = dp[1] = 0;
        for (int i = 2; i <= n ; i++) {
            int min = Integer.MAX_VALUE;    //不需要比较最小值，因为肯定是j越大，值越小
            for (int j = 1; j < i; j++) {
                if( i % j == 0){
                    min = Math.min(min,dp[j] + i /j);
                }
            }
            dp[i] = min;
        }
        return dp[n];
    }

    public int minSteps2(int n) {
            if (n <= 1) return 0;
            int[] dp = new int[n + 1];
            dp[0] = dp[1] = 0;
            for (int i = 2; i <= n ; i++) {
                for (int j = i/2; j >= 1 ; j--) {
                    if( i % j == 0){
                        dp[i] = dp[j] + i/j;
                        break;
                    }
                }
            }
            return dp[n];
    }

    public int minSteps3(int n) {
        if (n <= 1) return 0;
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 0;
        for (int i = 2; i <= n ; i++) {
            if( (i & 1) == 0)
                dp[i] = dp[i / 2] + 2;
            else{
               dp[i] = i;
            }
        }
        return dp[n];
    }


    @Test
    public void test(){
        System.out.println(minSteps3(3));
    }
}
