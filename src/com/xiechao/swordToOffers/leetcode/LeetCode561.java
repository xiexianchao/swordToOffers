package com.xiechao.swordToOffers.leetcode;

import org.junit.Test;

import java.util.Arrays;

public class LeetCode561 {
    public int arrayPairSum(int[] nums){
        if( null == nums || nums.length <= 0 || nums.length % 2 != 0)
            return -1;
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i=i+2) {
            sum += nums[i];
        }
        return sum;
    }

    @Test
    public void test(){
        System.out.println(arrayPairSum(new int[]{1,3,2,4}));
    }
}
