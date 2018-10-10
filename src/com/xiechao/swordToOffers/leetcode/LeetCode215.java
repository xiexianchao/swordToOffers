package com.xiechao.swordToOffers.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author: xiehcao
 * @Date : 2018/9/28
 * @Time : 17:26
 * @description :215. Kth Largest Element in an Array
 */
public class LeetCode215 {
    public int findKthLargest(int[] nums, int k) {
        if( nums == null || nums.length <=0 || nums.length < k) return -1;
        return findKthLargest(nums,0,nums.length-1,k);
    }

    private int findKthLargest(int[] nums,int start,int end,int k){
        int index = Partition(nums,start,end);
        if( index == start){
            Arrays.sort(nums,start,end+1);
            return nums[end - k + 1];
        }
        if( k  == (end - index +1))
            return nums[index];
        else if( k < (end - index +1)) {
           return findKthLargest(nums,index+1,end,k);
        }
        else{
           return findKthLargest(nums,start,index-1,k - (end -index +1));
        }
    }
    private int Partition(int[] nums,int start,int end){
        int val = nums[start];
        while(start < end){
            while((start  < end ) && (nums[end] >= val))
                end--;
            swap(nums,start,end);
            while((start < end) && (nums[start] < val))
              start++;
            swap(nums,start,end);
        }
        nums[start] = val;
        return start;
    }

    private void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }

    @Test
    public void test(){
        System.out.println(findKthLargest(new int[]{-1,2,0},
        1));
    }


}
