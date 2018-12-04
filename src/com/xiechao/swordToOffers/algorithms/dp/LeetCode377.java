package com.xiechao.swordToOffers.algorithms.dp;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ClassName LeetCode377
 * @Author xiechao
 * @Date 2018/12/4
 * @Time 8:45
 * @Description Combination Sum IV
 * 给出一个数组（不包含重复元素且元素都为正数），求有多少种序列组合方式满足和为target
 * 一个元素可以使用多次
 * 第一反应：
 * 暴力法    自己写的暴力法繁琐冗余
 * 看看大神写的暴力法，思路清晰代码简单
 * 暴力法存在冗余计算，用缓存来改善
 * 暴力法是自上而下，改为自下而上dp
 * dp = new int[target+1]
 * dp[i] 表示nums数组中和为i的有多少个组合1
 * dp[target] is result
 * dp[0] = 1;
 * dp[i] += dp[i - num[j]]
 *
 *
 */
public class LeetCode377 {
    //暴力法   Time Limit Exceeded
    public int combinationSum4(int[] nums, int target) {
        if(nums == null || nums.length <=0 || target <=0) return 0;
        int[] count = new int[]{0};
        helper(nums,target,0,count);
        return count[0];
    }

    private void helper(int[] nums, int target,  int tempSum, int[] count) {
        if(target == tempSum){
            count[0]++;
            return;
        }else if(tempSum > target){
            return;
        }else{
            for (int i = 0; i < nums.length; i++) {
                if(tempSum+nums[i] > target) continue;
                helper(nums,target,tempSum+nums[i],count);
            }
        }
    }
    //leetCode 大神 递归 Time Limit Exceeded
    public int combinationSum4_2(int[] nums, int target) {
        if(nums == null || nums.length <=0 || target < 0) return 0;
        if(target == 0) return 1;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if(target >= nums[i]){
               res +=combinationSum4_2(nums,target-nums[i]);
            }
        }
        return res;
    }
    //LeetCode大神 上面的方法存在重复计算问题，拿一个数组来缓存计算结果
    public int combinationSum4_3(int[] nums, int target) {
        if(nums == null || nums.length <=0 || target <= 0) return 0;
        int[] cache = new int[target+1];
        Arrays.fill(cache,-1);
        return  helper2(nums,target,cache);
    }

    private int helper2(int[] nums, int target, int[] cache) {
        if(target < 0) return 0;
        if(target == 0) return 1;
        if(cache[target] != -1){
            return cache[target];
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if(target >= nums[i])
                res += helper2(nums,target-nums[i],cache);
        }
        return res;
    }

    //LeetCode大神  6ms 上面方法是自上而下，改成自下而上。
    public int combinationSum4_4(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if( i - nums[j] >= 0){
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }

    @Test
    public void test(){
        int[] array = new int[]{1,2,3};
        System.out.println(combinationSum4_2(array,32));
        System.out.println(combinationSum4(array,32));
        System.out.println(combinationSum4_3(array,32));
    }

}
