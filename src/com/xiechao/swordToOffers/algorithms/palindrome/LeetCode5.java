package com.xiechao.swordToOffers.algorithms.palindrome;

import org.junit.Test;

/**
 * @ClassName LeetCode5
 * @Author xiechao
 * @Date 2018/10/29
 * @Time 10:28
 * @Description  Longest Palindromic Substring
 * 求字符串的最长回文子串
 */
public class LeetCode5 {
    //23 ms 受启发与求字符串满足回文的子串数
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 0) return "";
        String[] max = new String[]{""};
        for (int i = 0; i < s.length(); i++) {
            helper(s, i, i, max);
            helper(s, i, i + 1, max);
        }
        return max[0];
    }

    private void helper(String s, int left, int right, String[] max) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        String sub = s.substring(left + 1, right);
        max[0] = max[0].length() <= sub.length() ? sub : max[0];
        return;
    }

    //10ms 流程和上面解法相同，只是把字符串操作变成数字操作
    public String longestPalindrome2(String s) {
        if (s == null || s.length() <= 0) return "";
        // params[0] is startIndex of max_sub
        // params[1] is length of max_sub
        int[] params = new int[]{0,0};
        for (int i = 0; i < s.length(); i++) {
            helper2(s, i, i, params);
            helper2(s, i, i + 1, params);
        }
        return s.substring(params[0],params[0] + params[1]);
    }

    private void helper2(String s, int left, int right, int[] params){
        while( left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        if(params[1] <= (right - left -1)){
            params[1] = right - left - 1;
            params[0] = left+1;
        }
        return;
    }
    //dp
    public String longestPalindrome3(String s) {
        if(s == null || s.length() <= 0) return "";
        int left = 0;
        int right = 0;
        int max = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int j = 0; j < s.length() ; j++) {
            for (int i = 0; i <= j ; i++) {
                if(i == j) dp[i][j] = true;
                else if(i <= j-2)
                    dp[i][j] = dp[i+1][j-1] && s.charAt(i) == s.charAt(j);
                else if(i > j-2)
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                if(dp[i][j] && (j-i+1) >= max){
                    max = j-i+1;
                    left = i;
                    right= j;
                }
            }
        }
        return s.substring(left,right+1);
    }


    @Test
    public void test(){
        System.out.println(longestPalindrome("babad"));
    }

}
