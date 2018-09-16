package com.xiechao.swordToOffers.leetcode;

import org.junit.Test;

import java.util.Stack;

/**
 * @ClassName LeetCode20
 * @Author xiechao
 * @Date 2018/9/16
 * @Time 15:23
 * @Description 20. Valid Parentheses
 * 匹配括号
 */
public class LeetCode20 {
    public boolean isValid(String s) {
        if( null == s || s.length() <= 0)
            return true;
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char c: chars) {
            if( c == '{' || c == '(' || c == '[')
                stack.push(c);
            else {
                if(stack.isEmpty())
                    return false;
                char temp = stack.pop();
                if(!valid(c,temp))
                    return false;
            }
        }
        return stack.isEmpty();
    }

    private boolean valid(char c, char temp) {
        if( temp == '[' && c == ']') return true;
        if( temp == '(' && c == ')') return true;
        if( temp == '{' && c == '}') return true;
        else return false;
    }
    @Test
    public void test(){
        System.out.println(isValid("["));
    }
}
