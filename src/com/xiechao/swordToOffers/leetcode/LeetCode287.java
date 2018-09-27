package com.xiechao.swordToOffers.leetcode;

/**
 * @author: xiehcao
 * @Date : 2018/9/27
 * @Time : 11:24
 * @description :287. Find the Duplicate Number
 * 剑指Offer原题
 */
public class LeetCode287 {
    public int findDuplicate(int[] nums) {
       if( nums == null || nums.length <=0 ) return -1;
       int start = 1;
       int end = nums.length-1;
        while (start <= end) {
            int mid = start + (end - start)/2;
            int count = countOfRange(nums,start,mid);
            if(start == end){
                if(count >1)
                    return start;
                else
                    break;
            }
            if(count > (mid - start +1))
                end = mid;
            else
                start = mid + 1;
        }
        return -1;

    }

    private int countOfRange(int[] nums,int start, int mid) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] >= start && nums[i] <= mid){
                count++;
            }
        }
        return count;
    }


}
