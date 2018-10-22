package com.xiechao.swordToOffers.algorithms.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: xiechao
 * @Date : 2018/10/22
 * @Time : 10:40
 * @description :Letter Combinations of a Phone Number
 */
public class LeetCode17 {
    static Map<Character,String> map = new HashMap<>();
    static{
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
    }
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits == null ||digits.length() <=0) return result;
        helper(result,"",0,digits);
        return result;
    }

    private void helper(List<String> result, String s, int start, String digits) {
        if(s.length() == digits.length()){
            result.add(s);
            return;
        }
        for (int i = start; i < digits.length(); i++) {
            String letters = map.get(digits.charAt(i));
            for (int j = 0; j < letters.length(); j++) {
                helper(result,s+letters.charAt(j),i+1,digits);
            }
        }
    }
    @Test
    public void test(){
        System.out.println(letterCombinations("23"));
    }

}
