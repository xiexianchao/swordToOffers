package com.xiechao.swordToOffers.leetcode;


import org.junit.Test;

/**
 * 求 两个数的汉明距离
 */
public class LeetCode461 {
    public int hammingDistance(int x, int y) {
        int result = 0;
        if(x >= 0 && y >= 0){
            int cout = x^y;
            while(cout != 0){
                result++;
                cout = cout & (cout-1);
            }

        }
        return result;
    }
    @Test
    public void test(){
        System.out.println(hammingDistance(1,4));
    }
}
