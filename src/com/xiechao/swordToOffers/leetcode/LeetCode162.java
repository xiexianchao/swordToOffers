package com.xiechao.swordToOffers.leetcode;

import org.junit.Test;

import java.util.PriorityQueue;

/**
 * @author: xiehcao
 * @Date : 2018/9/29
 * @Time : 16:43
 * @description :Find Peak Element
 */
public class LeetCode162 {
    //O(n)的时间复杂度 6ms
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length <=0 ) return -1;
        if(nums.length == 1) return 0;
        int[] array = new int[nums.length + 1];
        array[0] = 1;
        array[array.length -1] = -1;
        for (int i = 1; i < nums.length; i++) {
            array[i] = nums[i] - nums[i-1];
        }
        for (int i = 1; i < array.length; i++) {
            if(array[i-1] > 0 && array[i] <0){
                return i-1;
        }

        }
        return -1;
    }

    //LeetCode大神 3ms 但时间复杂度为O（n）
    public int findPeakElement2(int[] nums){
        if(nums == null || nums.length <=0 ) return -1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] < nums[i-1]) return i-1;
        }
        return nums.length-1;                   //6啊，巧妙的解决了nums[n]的问题
    }

    //LeetCode大神 时间复杂度为O(logn)
    public int findPeakElement3(int[] nums){
        if(nums == null || nums.length <=0 ) return -1;
        if(nums.length == 0) return 0;
        int low = 0,high = nums.length-1;
        while( ( low+1 < high)){
            int mid = low + (high - low)/2;
            if(mid < nums.length -1 && mid >0 && nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]){
                return mid;
            }else if(mid < nums.length-1 && mid >0 && nums[mid] > nums[mid-1]){
                low = mid;
            }else
                high = mid;
        }
        return nums[low] > nums[high]?low:high;

    }



    @Test
    public void test(){
        System.out.println(findPeakElement3(new int[]{1,2}));
    }
}
