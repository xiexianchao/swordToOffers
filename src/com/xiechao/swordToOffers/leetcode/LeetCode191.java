package com.xiechao.swordToOffers.leetcode;

/**
 * @ClassName LeetCode191
 * @Author xiechao
 * @Date 2018/9/15
 * @Time 10:20
 * @Description Number of 1 Bits
 */
public class LeetCode191 {
    //16ms
    public int hammingWeight(int n) {
        int result = 0;
        while(n != 0){
            result ++;
            n = n & (n-1);
        }
        return result;
    }

    public int hammingWeight2(int n){
        int result = 0;
        while(n !=0){
            result += n&1;
            n = n>>>1;
        }
        return result;
    }
}
