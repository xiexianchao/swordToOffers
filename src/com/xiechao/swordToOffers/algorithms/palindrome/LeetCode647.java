package com.xiechao.swordToOffers.algorithms.palindrome;

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

}
