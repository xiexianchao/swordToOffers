package com.xiechao.swordToOffers.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: xiehcao
 * @Date : 2018/10/10
 * @Time : 17:08
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
    //4ms dfs
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits == null || digits.length() <=0) return result;
        String str = "";
        char[] numbers = digits.toCharArray();
        helper(result,str,numbers,0);
        return result;
    }
    private void helper(List<String> result,String str,char[] numbers,int idx){
        if(idx == numbers.length){
            result.add(str);
            return;
        }
        char[] chars = map.get(numbers[idx]).toCharArray();
        for (int i = 0; i < chars.length; i++) {
            helper(result,str + chars[i],numbers,idx+1);
        }
        return;
    }
    @Test
    public void test(){
        System.out.println(letterCombinations("23"));
    }
}
