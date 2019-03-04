package com.xiechao.swordToOffers.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author: xiehcao
 * @Date : 2018/10/10
 * @Time : 9:59
 * @description :Longest Increasing Subsequence
 */
public class LeetCode300 {
    //和LeetCode334思想一样，O(n*n)的时间复杂度 3ms
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length <=0) return 0;
        int[] copyNums = new int[nums.length];
        Arrays.fill(copyNums,Integer.MAX_VALUE);
        int j = 0;
        int max = 0;
        for (int num:nums) {
            for (j = 0; j < copyNums.length; j++) {
                if(num <= copyNums[j]){
                    copyNums[j] = num;
                    max = Math.max(max,j+1);
                    break;
                }

            }
        }
        return max;
    }
    //LeetCode大神 O(nlogn) 1ms
    public int lengthOfLIS2(int[] nums){
        if(nums == null || nums.length <=0) return 0;
        if(nums.length < 2 ) return nums.length;
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num:nums) {
            int idx = binarySearch(dp,len,num);
            dp[idx] = num;
            if(idx == len)
                len++;
        }
        return len;
    }
    private int binarySearch(int[] nums,int len,int target){
        int start = 0,end = len-1;
        while (start <= end) {
            int mid = (end - start)/2 + start;
            if(nums[mid] > target)
                end = mid -1;
            else if(nums[mid] < target)
                start = mid +1;
            else
                return mid;
        }
        return start;
    }

    @Test
    public void test(){
        System.out.println(lengthOfLIS(new int[]{1,3,6,7,9,4,10,5,6}));
    }
}
