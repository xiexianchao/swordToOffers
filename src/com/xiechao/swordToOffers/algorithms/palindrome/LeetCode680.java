package com.xiechao.swordToOffers.algorithms.palindrome;

import org.junit.Test;

/**
 * @ClassName LeetCode680
 * @Author xiechao
 * @Date 2018/10/26
 * @Time 11:49
 * @Description Valid Palindrome II
 * 给出一个非空字符串，最多可以删除一个元素，判断是否能成为回文
 */
public class LeetCode680 {
    //暴力法,timeout 代码丑陋不堪
    public boolean validPalindrome(String s) {
        if( s == null || s.length() <= 1) return true;
        StringBuilder sb = new StringBuilder(s);
        if(s.equals(sb.reverse().toString()))
            return true;
        sb.reverse();
        for (int i = 0; i < s.length(); i++) {
            char c = sb.charAt(i);
            StringBuilder temp = sb.deleteCharAt(i);
            String str2 = temp.toString();
            String str = temp.reverse().toString();
            if(str.equals(str2))
                return true;
            temp.reverse();
            sb.insert(i,c);
        }
        return false;
    }
    //LeetCode大神 简单易懂
    public boolean validPalindrome2(String s){
        if(s.isEmpty()) return true;
        if(s.length() == 1) return true;
        int start = 0;
        int end = s.length() - 1;
        while(start < end){
            if(s.charAt(start) == s.charAt(end)){
                start++;
                end--;
            }else{
                return helper(s,start+1,end)||helper(s,start,end-1);
            }
        }
        return true;
    }
    private boolean helper(String s,int start,int end){
        while(start < end){
            if(s.charAt(start ++) != s.charAt(end --)){
                return false;
            }
        }
        return true;
    }


    @Test
    public void test(){
        System.out.println(validPalindrome2("aba"));
        System.out.println(validPalindrome2("abca"));
    }
}
