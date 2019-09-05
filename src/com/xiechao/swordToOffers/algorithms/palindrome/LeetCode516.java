package com.xiechao.swordToOffers.algorithms.palindrome;

import org.junit.Test;

/**
 * @ClassName LeetCode516
 * @Author xiechao
 * @Date 2018/10/29
 * @Time 10:11
     * @Description Longest Palindromic Subsequence
 * 求最长回文子序列，子序列不需要连续，而子字符串需要连续,但子序列相对位置要保持一致
 */
public class LeetCode516 {
    /*
    参考链接:http://www.cnblogs.com/lightwindy/p/8553737.html
    * */
    public int longestPalindromeSubseq(String s) {
        if(s == null || s.length() == 0) return 0;
        int n = s.length();
        //dp[i][j]:表示s[i-j]区间内字符串的最长回文子序列长度
        int[][] dp = new int[n][n];  //不需要new 第二维
        for (int i = n - 1; i >= 0 ; i--) {   //注意要倒叙遍历
            dp[i][i] = 1;  //i==j dp[i][j] = 1
            for (int j = i+1; j < n ; j++) {   // j必须要大于i才有意义
                if(s.charAt(i) == s.charAt(j))
                    dp[i][j] = dp[i+1][j-1] + 2;
                else{
                    dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
                }
            }
        }
        return dp[0][n-1];
    }
    @Test
    public void test(){
        System.out.println(longestPalindromeSubseq("a"));
    }
}
