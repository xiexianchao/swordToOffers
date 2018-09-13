package com.xiechao.swordToOffers.leetcode;

import org.junit.Test;

/**
 * @author: xiehcao
 * @Date : 2018/9/13
 * @Time : 16:13
 * @description :两个整数之和，不允许使用+，-
 */
public class LeetCode371 {
    public int getSum(int a ,int b){
        int x = (a & b) <<1;
        int y = a ^ b;
        return x^y;
    }
    @Test
    public void test(){
        System.out.println(getSum(1,1));
        System.out.println(getSum(1,2));
        System.out.println(getSum(2,3));
        System.out.println(getSum(100,11));
        System.out.println(getSum(-1,1));

    }
}
