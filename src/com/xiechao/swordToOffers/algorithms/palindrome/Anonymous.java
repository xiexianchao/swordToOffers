package com.xiechao.swordToOffers.algorithms.palindrome;

import org.junit.Test;

/**
 * @ClassName Anonymous
 * @Author xiechao
 * @Date 2018/10/29
 * @Time 15:00
 * @Description
 * 给你一个字符串s，如果可以在s的任意位置添加字符，最少需要几个字符可以让s整体都是回文字符串
 * 思路：动态规划
 *
 * 矩阵dp[i][j] 存的是给定的字符串 s 的 s[i~j] 最少添加几个字符可以使得 s[i~j] 整体都是回文
 * 如果 i == j， dp[i][j] = 0， 因为 s[i~j] 只有一个字符，就是回文
 * 如果 i == j-1, s[i~j] 只有两个字符， 如果两个字符相等的话，dp[i][j] = 0 ，不等的话 dp[i][j] = 1
 * 如果 i < j-1, s[i~j] 多于两个字符。如果 s[i] == s[j]， dp[i][j] = dp[i+1][j-1]。 如果 s[i] != s[j]，dp[i][j] = Math.min(dp[i][j-1], dp[i+1][j]) + 1;
 * 求出dp矩阵之后，dp[0][s.length()-1] 就是我们的答案。
 */
public class Anonymous {
    int getMin(String s){
        if(s == null || s.length() <= 0) return 0;
        char[] str = s.toCharArray();
        int[][] dp = new int[str.length][str.length];
        for (int j = 1; j < dp.length; j++) {
            dp[j-1][j] = str[j-1] == str[j]?0:1;
            for (int i = j-2; i >= 0 ; i--) {
                if(str[i] == str[j]) dp[i][j] = dp[i+1][j-1];
                else dp[i][j] = Math.min(dp[i+1][j],dp[i][j-1]) + 1;
            }
        }
        return dp[0][dp.length-1];
    }
    @Test
    public void test(){
        System.out.println(getMin("abc"));
    }
}
