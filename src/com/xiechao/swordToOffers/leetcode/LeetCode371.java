package com.xiechao.swordToOffers.leetcode;

import org.junit.Test;

/**
 * @author: xiehcao
 * @Date : 2018/9/13
 * @Time : 16:13
 * @description :两个整数之和，不允许使用+，-
 */
public class LeetCode371 {
    //leetcode 大神
    public int getSum(int a ,int b){
       int carry = 0;
       while( b != 0){
           carry = a&b;
           a = a ^ b;
           b = carry <<1;
       }
       return a;
    }
    //leetcode 大神
    public int getSum2(int a,int b){
        if(a == 0) return b;
        if(b == 0) return a;

        return getSum2(a^b,(a&b) <<1);

    }


    @Test
    public void test(){
        System.out.println(getSum2(1,1));
        System.out.println(getSum2(1,2));
        System.out.println(getSum2(2,3));
        System.out.println(getSum2(100,11));
        System.out.println(getSum2(-1,1));

    }
}
