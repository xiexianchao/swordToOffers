package com.xiechao.swordToOffers.leetcode;

import org.junit.Test;

/**
 * @ClassName LeetCode28
 * @Author xiechao
 * @Date 2018/9/17
 * @Time 15:05
 * @Description Implement strStr()
 */
public class LeetCode28 {
    public int strStr(String haystack, String needle) {
        if(haystack == null ) return -1;
        if(needle.length() <=0) return 0;
        for (int i = 0; i <= haystack.length()-needle.length(); i++) {
            if(haystack.substring(i,needle.length()+i).equals(needle))
                return i;
        }
        return -1;

    }
    @Test
    public void test(){
        strStr("hello","ll");
    }
}
