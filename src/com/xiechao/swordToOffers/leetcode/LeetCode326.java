package com.xiechao.swordToOffers.leetcode;

/**
 * @ClassName LeetCode326
 * @Author xiechao
 * @Date 2018/9/15
 * @Time 10:16
 * @Description Power of Three
 */
public class LeetCode326 {
    public boolean isPowerOfThree(int n) {
        if(n <= 0)
            return false;
        if(n == 1) return true;
        if (n % 3 != 0) return false;
        return isPowerOfThree( n /3);
    }

}
