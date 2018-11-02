package com.xiechao.swordToOffers.book.version2;

import org.junit.Test;

/**
 * @ClassName Problem48
 * @Author xiechao
 * @Date 2018/11/1
 * @Time 8:56
 * @Description 最长不包含重复字符的子字符串的长度
 */
public class Problem48 {
    //基于数组操作比较麻烦
    public int maxSubWithoutDiplicate(String str){
        if(str == null || str.length() <= 0 ) return 0;
        //String maxSub = "";
        char[] chars = str.toCharArray();
        int f = 0,max = 0;
        String cur = "";
        for (int i = 0; i < chars.length ; i++) {
            if(!cur.contains(chars[i]+"")){
                cur += chars[i];
            }else{
                int lastIndex = getLastIndex(cur,chars[i]);
                cur = cur.substring(lastIndex+1) + chars[i];
            }
            f = cur.length();
            max = Math.max(max,f);
        }
        return max;
    }

    private int getLastIndex(String cur, char aChar) {
        for (int i = cur.length() - 1; i >= 0 ; i--) {
            if(cur.charAt(i) == aChar)
                return i;
        }
        return -1;
    }

    public int maxSubWithoutDiplicate2(String str){
        if(str == null || str.length() <= 0) return 0;
        int f = 0;
        int max = 0;
        int[] position = new int[26];  //position记录字符出现的位置，
        for (int i = 0; i < position.length; i++) {
            position[i] = -1;   //position[i] != -1 说明重复出现
        }
        for (int i = 0; i < str.length(); i++) {
            int preIndex = position[str.charAt(i)-'a'];
            if(preIndex == -1 || i - preIndex > f)
                f++;
            else f = i - preIndex;
            position[str.charAt(i)-'a'] = i;
            if(f > max)
                max = f;
        }
        return max;
    }

    @Test
    public void test(){
        System.out.println(maxSubWithoutDiplicate2("arabcacfr"));
    }
}
