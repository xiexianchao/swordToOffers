package com.xiechao.swordToOffers.leetcode;

/**
 * @author: xiehcao
 * @Date : 2018/9/14
 * @Time : 11:51
 * @description :
 */
public class LeetCode387 {
    public int firstUniqChar(String s) {
        if( s == null || s.length() <= 0)
            return -1;
        int[] array = new int[26];
        char[] strArray = s.toCharArray();
        for (char c:strArray) {
            array[c - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if(array[s.charAt(i) - 'a'] == 1)
                return i;
        }
        return -1;
    }
}
