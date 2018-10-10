package com.xiechao.swordToOffers.leetcode;

import org.junit.Test;

import java.util.*;

/**
 * @author: xiehcao
 * @Date : 2018/9/29
 * @Time : 9:32
 * @description :49. Group Anagrams
 * Given an array of strings, group anagrams together.
 *
 */
public class LeetCode49 {
    //LeetCode大神 30ms
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for (String s:strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);  //valueOf 比 new String()要快上很多
            map.putIfAbsent(key,new ArrayList<>());
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }

    private int compareTwoStr(String str1,String str2) {
        if(str1.length() != str2.length()) return str1.length()-str2.length();
        int p1 = 0,p2 = 0;
        int result = 0;
        for (; p1 < str1.length() && p2 < str2.length(); p1++,p2++) {
            result ^= (str1.charAt(p1) ^ str2.charAt(p2));

        }
        if(p1 != str1.length() || p2 != str2.length() || result !=0){
            return p1 - p2 + result;

        }else
            return 0;
    }
    @Test
    public void test(){
        System.out.println(groupAnagrams(new String[]{"tea","and","ace","ad","eat","dans"}));
        System.out.println(compareTwoStr("ate","eat"));


    }




}
