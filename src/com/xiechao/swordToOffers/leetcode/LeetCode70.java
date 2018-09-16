package com.xiechao.swordToOffers.leetcode;

import org.junit.Test;

/**
 * @ClassName LeetCode70
 * @Author xiechao
 * @Date 2018/9/14
 * @Time 18:15
 * @Description 爬楼梯，动态规划,斐波那契数列
 */
public class LeetCode70 {
    public int climbStairs(int n) {
        if( n==0 ) return 0;
        if( n ==1) return 1;
        int f0= 1;
        int f1 = 1;
        int result = 0;
        for (int i = 2; i <= n ; i++) {
            result = f0 + f1;
            f0 = f1;
            f1 = result;
        }
        return result;
    }
    @Test
    public void test(){
        System.out.println(climbStairs(2));
    }
}
