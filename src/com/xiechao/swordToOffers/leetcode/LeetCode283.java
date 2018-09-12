package com.xiechao.swordToOffers.leetcode;

import org.junit.Test;

public class LeetCode283 {
    //双头指针，23ms
    public void moveZeroes1(int[] nums) {
       if(null == nums || nums.length <= 1) return;
       int p1 = 0;
       int p2 = 1;
       while(p1 < nums.length && p2 < nums.length){
         while(p1< nums.length && nums[p1]!=0)
             p1++;
         p2 = p1;
         while(p2 < nums.length && nums[p2] == 0)
             p2++;
         if(p2 == nums.length)
             break;
         int temp = nums[p2];
         nums[p2] = nums[p1];
         nums[p1] = temp;
       }
    }


    //简单方法 3ms
    public void moveZeroes2(int[] nums){
        if(null == nums || nums.length <= 1) return;
        int index = 0;
        for (int e : nums) {
            if( e !=0 ){
                nums[index] = e;
                index++;
            }
        }
        while(index < nums.length){
            nums[index] = 0;
            index++;
        }

    }


    @Test
    public void test(){
        int[] array = new int[]{4,2,4,0,0,3,0,5,1,0};
        moveZeroes1(array);
    }
}
