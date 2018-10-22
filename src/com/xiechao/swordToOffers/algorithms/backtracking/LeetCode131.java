package com.xiechao.swordToOffers.algorithms.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: xiechao
 * @Date : 2018/10/22
 * @Time : 11:14
 * @description :Palindrome Partitioning
 */
public class LeetCode131 {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if(s == null || s.length() <=0) return result;
        helper(result,new ArrayList<String>(),s,0);
        return result;
    }

    private void helper(List<List<String>> result, ArrayList<String> tempList, String s, int start) {
        if(start == s.length()){
            result.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if(isPalindrome(s,start,i)){
                tempList.add(s.substring(start,i+1));
                helper(result, tempList, s, i+1);
                tempList.remove(tempList.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        if(start == end) return true;
        while(start < end){
            if(s.charAt(start++) != s.charAt(end--))
                return false;
        }
        return true;
    }
    @Test
    public void test(){
        System.out.println(partition("aab"));
    }
}
