package com.xiechao.swordToOffers.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName LeetCode172
 * @Author xiechao
 * @Date 2018/9/16
 * @Time 14:29
 * @Description Factorial Trailing Zeroes
 * 求n！末尾有几个零
 */
public class LeetCode172 {
    //Time Limit Exceeded
    public int trailingZeroes(int n) {
        if(n < 5) return 0;

        int result = 0;
        for (int i = 5; i <= n ; i=i+5) {
            int temp = i;
            while( temp % 5 == 0){
                result++;
                temp = temp /5;
            }
        }
        return result;
    }
    public int trailingZeroes2(int n){
        int result = 0;
        while(n > 0){
            result += n/5;
            n /= 5;
        }
        return result;
    }


    @Test
    public void test(){
        System.out.println(trailingZeroes2(2147483647));
    }

}
