package com.xiechao.swordToOffers.algorithms.dp;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ClassName LeetCode338
 * @Author xiechao
 * @Date 2018/10/26
 * @Time 8:47
 * @Description Counting Bits
 *求0-numm 之间每个元素中1的个数
 * bitArray[n] = bitArray[n >>> 1] + ( n & 1 );
 * */
public class LeetCode338 {
    public int[] countBits(int num) {
        int[]  bitArray = new int[num+1];
        bitArray[0] = 0;
        for (int i = 1; i <= num ; i++) {
            bitArray[i] = bitArray[i>>>1] + (i&1);
        }
        return bitArray;
    }
    @Test
    public void test(){
        System.out.println(Arrays.toString(countBits(5)));
    }
}
