package com.xiechao.swordToOffers.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author: xiehcao
 * @Date : 2018/10/2
 * @Time : 10:29
 * @description :334. Increasing Triplet Subsequence
 */
public class LeetCode334 {
    //LeetCode大神 O(3n)  3ms  扩展性更强
    public boolean increasingTriplet(int[] nums) {
        if(nums == null || nums.length <= 2)
            return false;
        int[] comp = new int[3];
        Arrays.fill(comp,Integer.MAX_VALUE);
        for (int num:nums) {
            for (int i = 0; i < 3; i++) {
               if( num <= comp[i]){
                   comp[i] = num;
                   if(i == 2)
                    return true;
                   break;
               }
            }
        }
        return false;
    }

    //LeetCode大神
    public boolean increasingTriplet2(int[] nums) {
        if(nums == null || nums.length <= 2)
            return false;
        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        for (int num : nums) {
            if(num <= min){
                min = num;
            }
            else if( num < secondMin) secondMin = num;
            else if( num > secondMin) return true;
        }
        return false;
    }





    @Test
    public void test(){
        System.out.println(increasingTriplet(new int[]{2,1,5,0,4,6}));
    }
}
