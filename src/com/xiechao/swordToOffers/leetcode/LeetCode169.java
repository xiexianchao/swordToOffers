package com.xiechao.swordToOffers.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * Majority Element
 */
public class LeetCode169 {
    public int majorityElement(int[] nums) {
       Arrays.sort(nums);
       return nums[(nums.length-1)/2];

    }
    public int majorityElement2(int[] nums){
        int candidate = nums[0];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
           if( count == 0 )
               candidate = nums[i];
           if( candidate != nums[i])
               count +=-1;
           else
               count ++;
        }
        return candidate;

    }
    @Test
    public void test(){
        System.out.println(majorityElement2(new int[]{2,1,3,1,4,2,3,4,1,1,1,1,5,1,1}));
    }
}
