package com.xiechao.swordToOffers.book.version2;

import org.junit.Test;

/**
 * @ClassName Problem67
 * @Author xiechao
 * @Date 2018/11/15
 * @Time 10:04
 * @Description 把字符串转成整数,
 *
 */
public class Problem67 {
    public int StrToInt(String str) {
        if(str == null || str.length() <= 0) return 0;
        char[] chars = str.toCharArray();
        int sum = 0;
        boolean isUpperZero = false;
        if( !Character.isDigit(chars[0]) ){
            if(chars[0] == '+') isUpperZero = true;
            else if(chars[0] != '-') return 0;
            for (int i = 1; i < chars.length ; i++) {
                if(!Character.isDigit(chars[i]))
                    return 0;
                else
                    sum = sum * 10 + chars[i] - '0';
            }
            return isUpperZero ? sum:-sum;
        }else{
            for (int i = 0; i < chars.length ; i++) {
                if(!Character.isDigit(chars[i]))
                    return 0;
                else
                    sum += ( chars[i] - '0') * Math.pow(10,chars.length - 1 -i);
            }
            return sum;
        }
    }
    @Test
    public void test(){
        System.out.println(StrToInt("-2147483648"));
    }
}
