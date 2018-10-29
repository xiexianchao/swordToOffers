package com.xiechao.swordToOffers.algorithms.dp;

import org.junit.Test;

/**
 * @ClassName LeetCode647
 * @Author xiechao
 * @Date 2018/10/26
 * @Time 8:57
 * @Description Palindromic Substrings
 */
public class LeetCode647 {
    //暴力法 O(n^2)
    public int countSubstrings(String s) {
        if(s == null || s.length() <=0)  return 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if(checkPalindromic(s,i,j)){
                    count++;
                }
            }
        }
        return count;
    }
    private boolean checkPalindromic(String s, int i, int j) {
        if( i == j) return true;
        while(i<j){
            if(s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }

    //LeetCode 16ms
    public int countSubstrings2(String s){
        if(s == null || s.length() <=0) return 0;
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; i - j >=0 && i+j < s.length() && s.charAt(i-j) == s.charAt(i+j); j++) {
                sum++;
            }
            for (int j = 0; i-1-j >=0 && i+j < s.length() && s.charAt(i-1-j) == s.charAt(i+j) ;j++ ) {
                sum++;
            }
        }
     return sum;
    }
    //LeetCode大神 6ms
    public int countSubstrings3(String s){
        if(s == null || s.length() <= 0) return 0;
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += helper(s,i,i);
            sum += helper(s,i-1,i);
        }
        return sum;
    }

    private int helper(String s, int i, int j) {
        int res = 0;
        while( i >=0 && j < s.length() && s.charAt(i--) == s.charAt(j++))
            res++;
        return res;
    }

    @Test
    public void test(){
        System.out.println(countSubstrings3("fdsklf"));
    }
}
