package com.xiechao.swordToOffers.leetcode;

import org.junit.Test;
import org.omg.IOP.ENCODING_CDR_ENCAPS;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: xiehcao
 * @Date : 2018/9/14
 * @Time : 11:32
 * @description :
 */
public class LeetCode242 {

    //90ms
    public boolean isAnagram(String s, String t) {
        if( s == null && t == null) return true;
        if( s == null ) return false;
        if( t == null ) return false;
        if( s.length() != t.length()) return false;
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.merge(s.charAt(i),1,Integer::sum);
        }
        for (int i = 0; i < t.length(); i++) {
            map.merge(t.charAt(i),-1,Integer::sum);
        }
        for (Map.Entry<Character,Integer> entry:map.entrySet()) {
            if(entry.getValue() !=0)
                return false;
        }
        return true;

    }
    public boolean isAnagram2(String s, String t) {
        if( s == null && t == null) return true;
        if( s == null ) return false;
        if( t == null ) return false;
        if( s.length() != t.length()) return false;
        int[] array = new int[26];
       /* for (int i = 0; i < s.length(); i++) {
            array[s.charAt(i) - 'a']++;
            array[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < array.length; i++) {
            if(array[i] !=0)
                return false;
        }*/
        for (char c:s.toCharArray()) {
            array[c-'a']++;
        }
        for (char c:t.toCharArray()) {
            array[c-'a']--;
        }
        for (int e:array) {
            if( e!=0)
                return false;
        }
        return true;
    }

    @Test
    public void test(){
        isAnagram2("anagrazm",
                "nagazram");
    }
}
