package com.xiechao.swordToOffers.book.version2;

import org.junit.Test;

/**
 * @author: xiehcao
 * @Date : 2018/9/14
 * @Time : 9:33
 * @description :
 */
public class Problem11 {
    public int getMin(int[] nums) throws Exception {
        if(nums == null || nums.length <= 0)
            throw new Exception();
        int p1 = 0;
        int p2 = nums.length - 1;
        while( (p1+1) < p2){
            int mid = ( p1 + p2) >>>1;
            if( nums[mid] > nums[p1])
                p1 = mid;
            if( nums[mid] < nums[p2])
                p2 = mid;
        }
        return nums[p2];
    }

    @Test
    public void test() throws Exception {
        System.out.println(getMin(new int[]{3,4,5,1,2}));
    }
}
