package com.xiechao.swordToOffers.leetcode;

import org.junit.Test;

/**
 * @ClassName LeetCode268
 * @Author xiechao
 * @Date 2018/9/14
 * @Time 15:41
 * @Description  Missing Number
 */
public class LeetCode268 {
    public int missingNumber(int[] nums) {
        int result = 0;
        if(nums == null || nums.length <= 0) return -1;
        for (int i = 0; i < nums.length; i++) {
            result ^= i;
            result ^= nums[i];
        }
        return result^nums.length;
    }

    @Test
    public void test(){
        missingNumber(new int[]{3,0,1});
    }


}
