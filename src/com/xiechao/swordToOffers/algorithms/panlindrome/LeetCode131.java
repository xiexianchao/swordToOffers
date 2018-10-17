package com.xiechao.swordToOffers.algorithms.panlindrome;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: xiechao
 * @Date : 2018/10/17
 * @Time : 10:12
 * @description :Palindrome Partitioning
 */
public class LeetCode131 {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if(s == null || s.length() <=0 ) return result;
        helper(result,s,new ArrayList<String>(),0);
        return result;
    }

    private void helper(List<List<String>> result, String s, ArrayList<String> tempList, int start) {
        if(start == s.length()){
            result.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if(isPalindrome(s,start,i)){
                tempList.add(s.substring(start,i+1));
                helper(result,s,tempList,i+1);
                tempList.remove(tempList.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        if(start == end) return true;
        while(start < end){
            if(s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }
    @Test
    public void test(){
        System.out.println(partition("aab"));
        System.out.println(isPalindrome("ab",0,"ab".length()-1));
    }


}
