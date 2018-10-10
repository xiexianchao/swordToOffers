package com.xiechao.swordToOffers.leetcode;

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
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits == null || digits.length() <=0) return result;
        char[] numbers = digits.toCharArray();
        return null;



    }
}
