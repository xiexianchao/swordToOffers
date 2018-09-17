package com.xiechao.swordToOffers.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ClassName LeetCode238
 * @Author xiechao
 * @Date 2018/9/17
 * @Time 19:54
 * @Description Product of Array Except Self
 */
public class LeetCode238 {
    //LeetCode大神 1ms
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0,temp = 1; i < nums.length; i++) {
            result[i] = temp;
            temp *= nums[i];
        }
        for (int i = nums.length-1,temp = 1; i >=0 ; i--) {
            result[i] *=temp;
            temp *= nums[i];
        }
        return result;
    }
    @Test
    public void test(){
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1,2,3})));
    }

}
