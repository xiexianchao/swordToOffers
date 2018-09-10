package com.xiechao.swordToOffers.leetcode;

/*求出数组中单独出现的那个数

* */



public class LeetCode136 {
    /*最简单方法：异或*/
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int e:nums) {
            result = result^e;
        }
        return result;
    }
}
