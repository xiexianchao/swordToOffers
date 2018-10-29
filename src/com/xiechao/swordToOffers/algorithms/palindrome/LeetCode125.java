package com.xiechao.swordToOffers.algorithms.palindrome;

import org.junit.Test;

/**
 * @ClassName LeetCode125
 * @Author xiechao
 * @Date 2018/10/26
 * @Time 10:52
 * @Description Valid Palindrome
 * 判断一个字符串是否是回文，只考虑数字字母字符，并忽略大小写
 */
public class LeetCode125 {
    public boolean isPalindrome(String s) {
        if(s == null || s.length() <=0 ) return true;
        int start = 0;
        int end = s.length() - 1;
        while(start < end){
            while(start < end &&!(Character.isLetter(s.charAt(start)) || Character.isDigit(s.charAt(start)))){
                start++;
            }
            while(start < end && !(Character.isLetter(s.charAt(end)) || Character.isDigit(s.charAt(end)))){
                end --;
            }
            char c = s.charAt(start);
            char e = s.charAt(end);
            if(Character.isLetter(c)) c = Character.toLowerCase(c);
            if(Character.isLetter(e)) e = Character.toLowerCase(e);
            if(c != e) return false;
            start++;
            end--;
        }
        return true;
    }

    public boolean isPalindrome2(String s){
        if(s == null || s.length() <=0) return true;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(Character.isLetter(s.charAt(i)) || Character.isDigit(s.charAt(i))){
                sb.append(s.charAt(i));
            }
        }
        String origin = sb.toString().toLowerCase();
        String reverse = sb.reverse().toString().toLowerCase();
        return origin.equals(reverse);
    }
    @Test
    public void test(){
        System.out.println(isPalindrome2("A man, a plan, a canal: Panama"));
    }
}
