package com.xiechao.swordToOffers.leetcode;

import org.junit.Test;

/**
 * @ClassName LeetCode190
 * @Author xiechao
 * @Date 2018/9/17
 * @Time 15:44
 * @Description TODO
 */
public class LeetCode190 {
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i <32 ; i++) {
           int temp = n & 1;
           result += temp << (31-i);
           n = n >>>1;
        }
        return result;
    }
    @Test
    public void test(){
        System.out.println(reverseBits(43261596));
    }

}
