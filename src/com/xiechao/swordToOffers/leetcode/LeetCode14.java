package com.xiechao.swordToOffers.leetcode;

import org.junit.Test;

/**
 * @ClassName LeetCode14
 * @Author xiechao
 * @Date 2018/9/16
 * @Time 23:54
 * @Description 14. Longest Common Prefix
 */
public class LeetCode14 {
    //10 ms
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length <=0) return "";
        StringBuffer sb = new StringBuffer();
        char[] str0Array = strs[0].toCharArray();
        boolean is = true;
        for (int i = 0; i < str0Array.length && is; i++) {
            int j = 1;
            for (;j < strs.length; j++) {
                if(i >= strs[j].length()) {
                    is = false;
                    break;
                }
                if(strs[j].charAt(i) != strs[0].charAt(i))
                {   is = false;
                    break;
                }
            }
            if(j == strs.length) sb.append(strs[0].charAt(i));
        }
        return sb.toString();
    }

    //LeetCode大神 5ms
    public String longestCommonPrefix2(String[] strs) {
        if(strs == null || strs.length <= 0) return "";
        String pre = strs[0];
        int i = 1;
        while( i < strs.length){
            while(strs[i].indexOf(pre) !=0 ){
                pre = pre.substring(0,pre.length()-1);
            }
            i++;
        }
        return pre;

    }

    @Test
    public void test(){
        System.out.println(longestCommonPrefix2(new String[]{"flower","flow","flight"}));
    }
}
