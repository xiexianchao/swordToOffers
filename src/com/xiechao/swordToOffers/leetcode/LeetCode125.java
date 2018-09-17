package com.xiechao.swordToOffers.leetcode;

import org.junit.Test;

/**
 * @ClassName LeetCode125
 * @Author xiechao
 * @Date 2018/9/17
 * @Time 16:04
 * @Description Valid Palindrome
 */
public class LeetCode125 {
    public boolean isPalindrome(String s) {
        if( s == null || s.length() <=0) return true;
        StringBuilder sb = new StringBuilder();
        for (char ch:s.toCharArray()) {
            if( (ch >= 'a' && ch <= 'z')   )
                sb.append(ch);
            else if( ch >= 'A' && ch <= 'Z')
                sb.append(Character.toLowerCase(ch));
            else if(ch >='0' && ch <= '9')
                sb.append(ch);
        }
        int  p1 = 0;
        int  p2 = sb.length()-1;
        while(p1 < p2){
            if(sb.charAt(p1) != sb.charAt(p2))
                return false;
            p1++;
            p2--;
        }
        return true;
    }
    @Test
    public void test(){
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }
}
