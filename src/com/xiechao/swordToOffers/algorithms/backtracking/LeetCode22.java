package com.xiechao.swordToOffers.algorithms.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: xiechao
 * @Date : 2018/10/19
 * @Time : 21:46
 * @description :Generate Parentheses
 * 求n对括号的排列
 * 这道题比较有意思
 */
public class LeetCode22 {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if(n <=0) return result;
        helper(result,n,0,0,"");
        return result;
    }

    private void helper(List<String> result, int n, int open,int close,String str) {
        if(str.length() == n*2){
            result.add(str);
            return;
        }
        if( open < n){
            helper(result,n,open+1,close,str+"(");
        }
        if( close < open){
            helper(result,n,open,close+1,str+")");
        }
    }
}
