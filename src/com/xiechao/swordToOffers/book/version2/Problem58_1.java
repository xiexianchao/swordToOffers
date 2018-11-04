package com.xiechao.swordToOffers.book.version2;

import org.junit.Test;

/**
 * @author: xiechao
 * @Date : 2018/11/4
 * @Time : 11:25
 * @description :左旋转字符串
 */
public class Problem58_1 {
    //直接使用StringBuilder
    public String LeftRotateString(String str,int n) {
        if(str == null || str.length() <= 1 || n <= 0) return str;
        StringBuilder sb = new StringBuilder();
        for (int i = n; i < str.length(); i++) {
            sb.append(str.charAt(i));
        }
        for (int i = 0; i < n ; i++) {
            sb.append(str.charAt(i));
        }
        return sb.toString();

    }
    //三次翻转 数组操作
    public String LeftRotateString2(String str,int n) {
        if(str == null || str.length() <= 1 || n <= 0) return str;
        char[] chars = str.toCharArray();
        reverse(chars,0,n-1);
        reverse(chars,n,str.length() - 1);
        reverse(chars,0,str.length() - 1);
        return new String(chars);
    }

    private void reverse(char[] chars, int low, int high) {
        if(low >= high ) return;
        low = low <0 ? 0:low;
        high = high >= chars.length ? chars.length - 1:high;
        while(low < high){
            char temp = chars[low];
            chars[low] = chars[high];
            chars[high] = temp;
            low ++;
            high --;
        }
        return;
    }
    @Test
    public void test(){
        System.out.println(LeftRotateString2("hello 2 world",5));
    }


}
