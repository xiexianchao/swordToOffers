package com.xiechao.swordToOffers.leetcode;

import org.junit.Test;

/**
 * @ClassName LeetCode395
 * @Author xiechao
 * @Date 2018/10/13
 * @Time 9:55
 * @Description Longest Substring with At Least K Repeating Characters
 */
public class LeetCode395 {
    public int longestSubstring(String s, int k) {
        if(s == null || s.length() <= 0 || s.length() < k) return 0;
        int[] array = new int[26];
        for (int i = 0; i < s.length(); i++) {
            array[s.charAt(i) - 'a']++;
        }
        boolean flag = true;
        for (int i = 0; i < array.length; i++) {
            if(array[i] < k && array[i] > 0)
                flag = false;
        }
        if(flag) return s.length();

        int result = 0;
        int start = 0,cur = 0;
        while(cur < s.length()){
            if( array[s.charAt(cur) - 'a'] < k){
                result = Math.max(result,longestSubstring(s.substring(start,cur),k));
                start = cur + 1;
            }
            cur++;
        }
        result = Math.max(result,longestSubstring(s.substring(start),k));
        return result;
    }
    @Test
    public void test(){
        System.out.println(longestSubstring("bbaaacbd",3));
    }
}
