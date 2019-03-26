package com.xiechao.swordToOffers.algorithms.palindrome;

import org.junit.Test;

/**
 * @ClassName LeetCode647
 * @Author xiechao
 * @Date 2018/10/29
 * @Time 9:52
 * @Description Palindromic Substrings
 * 给出一个字符串，返回其子串符合回文的个数
 */
public class LeetCode647 {
    public int countSubstrings(String s) {
        if( s == null || s.length() <=0) return 0;
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += helper(s,i,i);  //作为奇数中心
            sum += helper(s,i,i+1); //作为偶数中心
        }
        return sum;
    }
    /**
     *
     * @param s 字符串
     * @param i 向左边扩散
     * @param j 向右边扩散
     * @return 回文的个数
     */
    private int helper(String s, int i, int j) {
        int res = 0;
        while(i >=0 && j < s.length() && s.charAt(i--) == s.charAt(j++))
            res++;
        return res;
    }
    //dp也可以做
    public int countSubstrings3(String s){
        if(s == null || s.length() <= 0) return 0;
        if(s.length() <= 1) return 1;
        int sum = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int j = 0; j < s.length() ; j++) {
            for (int i = 0 ; i <= j ; i++) {
                if(i == j) dp[i][j] = true;
                else if(i <= j -2)
                    dp[i][j] = dp[i+1][j-1] && s.charAt(i) == s.charAt(j);
                else
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                if(dp[i][j])
                    sum++;
            }
        }
        return sum;
    }
    @Test
    public void test(){
        System.out.println(countSubstrings3("aaaaa"));
    }




}
