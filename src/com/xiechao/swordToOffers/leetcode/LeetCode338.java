package com.xiechao.swordToOffers.leetcode;

import org.junit.Test;

import java.util.Arrays;

public class LeetCode338 {

    //O(n*sizeof(integer))
    public int[] countBits(int num) {
        if(num < 0) return null;
        int[] bitArray = new int[num + 1];
        for (int i = 0; i < bitArray.length; i++) {
            bitArray[i] = Integer.bitCount(i);
        }
        return bitArray;
    }
    //不适用Integer的函数
    public int[] countBits2(int num){
        if(num < 0 ) return null;
        int[] bitArray = new int[ num + 1];
        bitArray[0] = 0;
        for (int i = 0; i < bitArray.length; i++) {
            bitArray[i] = bitArray[i >>> 1] + (i & 1);
        }
        return bitArray;
    }


    @Test
    public void test(){
        System.out.println(Arrays.toString(countBits2(5)));
    }
}
