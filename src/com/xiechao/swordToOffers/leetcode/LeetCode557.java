package com.xiechao.swordToOffers.leetcode;

import org.junit.Test;

public class LeetCode557 {

    //用stringBuilder实现 28ms
    public String reverseWords1(String s) {
        if(null == s) return null;
        if(s.length() ==0 ) return "";

        StringBuilder stringBuilder = new StringBuilder(s);
        stringBuilder.reverse();
        StringBuilder result = new StringBuilder();


        for (int i = stringBuilder.length()-1, start = stringBuilder.length(); i >= 0; i--) {
            if( i==0 ||stringBuilder.charAt(i) == ' '){
               if(start>=i)
               {
                   result.append(stringBuilder.subSequence(i == 0?i:i+1,start));
               }
               start = i;
               if(stringBuilder.charAt(i) == ' ')  //排除第一个字符为空格
                result.append(" ");
            }
        }

        return result.toString();
    }

    //用数组实现 5ms
    public String reverseWords2(String s){
        if(null == s) return null;
        if(s.length() ==0 ) return "";
        char[] chars = s.toCharArray();
        int start = 0;
        for (int i = 0; i < chars.length; i++) {
            if( (chars[i] == ' ')) {
                reverse(chars, start, i);              //旋转start(包括)-i(不包括)
                start = i + 1;
            }
        }
        reverse(chars,start,chars.length);
        return new String(chars);
    }

    private void reverse(char[] chars, int start, int i) {
        i--;
        while(start < i){
            char temp = chars[i];
            chars[i] = chars[start];
            chars[start] = temp;
            start++;
            i--;
        }
    }


    @Test
    public void test(){
        System.out.println(reverseWords2("Let's   take LeetCode contest"));
    }
}
