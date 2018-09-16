package com.xiechao.swordToOffers.leetcode;

/**
 * @ClassName LeetCode198
 * @Author xiechao
 * @Date 2018/9/15
 * @Time 10:35
 * @Description 198. House Robber
 * 动态规划
 */
public class LeetCode198 {

    // 7ms
    public int rob(int[] nums) {
        if( null == nums || nums.length <= 0) return 0;
        if( nums.length <=1 ) return nums[0];
        int[] max =new int[nums.length];
        int[] f = new int[nums.length];
        f[0] = nums[0];
        f[1] = nums[1];
        max[0] = f[0];
        max[1] = Math.max(f[1],max[0]);
        for (int i = 2; i < nums.length; i++) {
            f[i] = nums[i] + max[i-2];
            max[i] = Math.max(f[i],max[i-1]);
        }
        return max[nums.length-1];
    }
    //LeetCode 大神 5ms
    public int rob2(int[] nums){
        if( null == nums || nums.length <= 0) return 0;
        if( nums.length <=1 ) return nums[0];
        int[] max = new int[nums.length];
        max[0] = nums[0];
        max[1] = Math.max(nums[1],max[0]);
        for (int i = 2; i < nums.length; i++) {
            max[i] = Math.max(max[i-2] + nums[i],max[i-1]);
        }
        return max[nums.length-1];
    }
    //极尽优化 4ms
    public int rob3(int[] nums){
        if( null == nums || nums.length <= 0) return 0;
        if( nums.length <=1 ) return nums[0];

        int f1 = nums[0]; //fn-2
        int f2 = Math.max(nums[1],f1); //fn-1
        int current = f2;
        for (int i = 2; i < nums.length; i++) {
            current = Math.max(nums[i] + f1,f2);
            f1 = f2;
            f2 = current;
        }
        return current;
    }
}
