package com.xiechao.swordToOffers.leetcode;

import org.junit.Test;

/**
 * @ClassName LeetCode26
 * @Author xiechao
 * @Date 2018/9/15
 * @Time 15:23
 * @Description Remove Duplicates from Sorted Array
 */
public class LeetCode26 {
    // 10 ms
    public int removeDuplicates(int[] nums) {
        if( null == nums || nums.length <=0)
            return 0;
        int length = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] - nums[i-1] != 0){
                nums[length] = nums[i];
                length ++;
            }
        }
        return length;
    }
    // LeetCode 大神 8ms
    public int removeDuplicates2(int[] nums){
        if( null == nums || nums.length <=0)
            return 0;
        if( nums.length == 1) return 1;
        int slow = 0;
        int fast = 1;
        while( fast < nums.length){
            if( nums[slow] != nums[fast]){
                slow++;
                nums[slow] = nums[fast];
                fast++;
            }else{
                fast++;
            }
        }
        return slow+1;
    }

    @Test
    public void test(){
        removeDuplicates2(new int[]{0,0,1,1,1,2,2,3,3,4});
    }
}
