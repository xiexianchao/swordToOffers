package com.xiechao.swordToOffers.algorithms.dp;

import org.junit.Test;

/**
 * @ClassName LeetCode303
 * @Author xiechao
 * @Date 2018/10/26
 * @Time 8:33
 * @Description TODO
 */
public class LeetCode303 {
    class NumArray {
        private int[] nums = null;
        public NumArray(int[] nums) {
            this.nums = nums;
        }

        public int sumRange(int i, int j) {
            if(i< 0 || j >= nums.length) return 0;
            int sum = 0;
            for (int k = i; k <=j ; k++) {
                sum += nums[k];
            }
            return sum;
        }
    }
    @Test
    public void test(){
        NumArray obj = new NumArray(new int[]{-2,0,3,-5,2,-1});
        int param_1 = obj.sumRange(0,2);
        System.out.println(param_1);
    }

}
