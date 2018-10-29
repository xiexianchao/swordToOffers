package com.xiechao.swordToOffers.algorithms.palindrome;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName LeetCode131
 * @Author xiechao
 * @Date 2018/10/29
 * @Time 9:40
 * @Description Palindrome Partitioning
 */
public class LeetCode131 {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if(s == null || s.length() <= 0) return result;
        helper(result,new ArrayList<String>(),s,0);
        return result;
    }

    private void helper(List<List<String>> result, ArrayList<String> tempList, String s, int start) {
        if(start == s.length()){
            result.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            String str = s.substring(start,i+1);
            if(isPalindrome(str)){
                tempList.add(str);
                helper(result,tempList,s,i+1);
                tempList.remove(tempList.size()-1);
            }
        }
    }

    private boolean isPalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;
        while(start < end){
            if(str.charAt(start++) != str.charAt(end--)){
                return false;
            }
        }
        return true;
    }
}
