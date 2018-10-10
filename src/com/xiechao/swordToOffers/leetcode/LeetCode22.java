package com.xiechao.swordToOffers.leetcode;

import org.junit.Test;

import java.util.*;

/**
 * @ClassName LeetCode22
 * @Author xiechao
 * @Date 2018/9/26
 * @Time 22:21
 * @Description Generate Parentheses
 * 求出n对括号的全部组合
 * n=3
 *[
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 */
public class LeetCode22 {

    //全排列 当n=7 的时候Time Out
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if(n <=0)
            return result;
        if(n == 1) {
          result.add("()");
          return result;
        }
        Set<String> set = new HashSet<>();
        char[] array = new char[2*(n-1)];
        for (int i = 0; i < array.length; i++) {
            if(( i &1 )== 0)
                array[i] = '(';
            else
                array[i] = ')';
        }
        permutation(array,0,set);
        result.addAll(set);
        return result;
    }
    private void permutation(char[] array, int start, Set<String> result) {
        if(start == array.length -1){
            if(checkParentesis(array)){
                result.add('('+new String(array)+')');
            }
        }
        for (int i = start; i < array.length; i++) {
            char temp =array[i];
            array[i] = array[start];
            array[start] = temp;

            permutation(array,start+1,result);

            temp =array[i];
            array[i] = array[start];
            array[start] = temp;
        }
    }
    private boolean checkParentesis(char[] array) {
          Stack<Character> stack = new Stack<>();
          stack.push('(');
        for (int i = 0; i < array.length; i++) {
            if(array[i] == '(')
                stack.push('(');
            else
            {
                if(stack.isEmpty()){
                    return false;
                }
                stack.pop();
            }
        }
        stack.pop();
        return stack.isEmpty();
    }

    //LeetCode大神 回溯 2ms
    public List<String> generateParenthesis2(int n){
        List<String> result = new ArrayList<>();
        if(n <= 0) return result;

        permutation2(result,"",0,0,n);
        return result;
    }
    private void permutation2(List<String> result, String str, int open, int close, int n){
        if(str.length() == n * 2){
            result.add(str);
            return;
        }
        if( open < n)
            permutation2(result,str + "(",open+1,close,n);
        if( close < open)
            permutation2(result,str + ")",open,close+1,n);
    }
    @Test
    public void test(){
        System.out.println(generateParenthesis2(3));
    }


}
