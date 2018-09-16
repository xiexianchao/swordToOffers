package com.xiechao.swordToOffers.leetcode;

import org.junit.Test;

/**
 * @ClassName LeetCode53
 * @Author xiechao
 * @Date 2018/9/15
 * @Time 9:56
 * @Description TODO
 */
public class LeetCode53 {
    //14ms
    public int maxSubArray(int[] nums) {
        if( null == nums || nums.length <= 0) return 0;

        int cur = 0;
        int pre = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            cur = nums[i] + (pre >0?pre:0);
            if(max < cur)
                max = cur;
            pre = cur;
        }
        return max;
    }
    public int maxSubArray1(int[] nums) {
        if( null == nums || nums.length <=0) return 0;
        int max = nums[0];
        int[] f = new int[nums.length];
        f[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            f[i] = nums[i] + (f[i-1] > 0 ? f[i-1] : 0);
            if(max < f[i])
                max = f[i];
        }
        return max;
    }



    @Test
    public void test(){
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
