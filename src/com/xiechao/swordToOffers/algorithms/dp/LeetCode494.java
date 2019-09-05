package com.xiechao.swordToOffers.algorithms.dp;

import com.sun.org.apache.regexp.internal.RE;
import org.junit.Test;
import sun.text.resources.cldr.ii.FormatData_ii;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

/**
 * @ClassName LeetCode494
 * @Author xiechao
 * @Date 2018/11/29
 * @Time 8:52
 * @Description Target Sum
 * 第一反应用dfs
 *
 */
public class LeetCode494 {
    //dfs 643ms 存在冗余计算
    // 冗余计算：对于索引为i处，和为sum。当计算i之后的数字时，[0,i]这些数被计算了很多次
    public int findTargetSumWays(int[] nums, int S) {
        if(S < - 1000 || S > 1000) return 0;
        int[] count = new int[]{0};
        helper(nums,S,0,count,0);
        return count[0];
    }

    private void helper(int[] nums, int s, int start,int[] count,int tempTarget) {
        if(s == tempTarget && start == nums.length){
            count[0]++;
            return;
        }else if(start > nums.length - 1){
            return;
        }
        helper(nums,s,start+1,count,tempTarget - nums[start]);
        helper(nums,s,start+1,count,tempTarget+nums[start]);
    }

    //dfs,消除冗余

    public int findTargetSumWays2(int[] nums, int S) {
       // if (S < -1000 || S > 1000) return 0;
        int[][] memory = new int[nums.length][2001];
        for (int[] rows:memory) {
            Arrays.fill(rows,Integer.MIN_VALUE);
        }

        return  helper2(nums,S,0,0,memory);
    }

    private int helper2(int[] nums, int s, int sum, int start ,int[][] memory) {
        if(start == nums.length){
            if(sum == s){
                return 1;
            }else
                return 0;
        }else {
            if(memory[start][sum + 1000] != Integer.MIN_VALUE) {
                return memory[start][sum + 1000];
            }
            int add = helper2(nums,s,sum + nums[start],start + 1,memory);
            int subtract = helper2(nums,s,sum - nums[start],start + 1,memory);
            memory[start][sum + 1000] = add + subtract;
            return memory[start][sum + 1000];
        }
    }

    //dp  22ms
    public int findTargetSumWays3(int[] nums, int S) {
        if(S > 1000 || S < -1000) return 0;
        int[][] dp = new int[nums.length][2001];
        dp[0][nums[0] + 1000] += 1;
        dp[0][1000-nums[0]] += 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < dp[i-1].length ; j++) {
                if (dp[i - 1][j] != 0) {
                  //  if(nums[i] != 0) {
                        dp[i][j + nums[i]] += dp[i - 1][j];
                        dp[i][j - nums[i]] += dp[i - 1][j];
                   /* }else{
                        dp[i][j + nums[i]] += dp[i - 1][j] + dp[i-1][j];
                    }*/
                }
            }
        }
        return dp[nums.length - 1][S + 1000];
    }
    public int findTargetSumWays4(int[] nums, int S) {
        if (S > 1000 || S < -1000) return 0;
        int[][] dp = new int[nums.length][2001];
        dp[0][nums[0] + 1000] = 1;
        dp[0][1000 - nums[0]] += 1;
        for (int i = 1; i < nums.length ; i++) {
            for (int j = 0; j < dp[i].length ; j++) {
                dp[i][j] = (j >= nums[i]? dp[i-1][j - nums[i]] : 0) + ((j + nums[i]) < dp[i].length?dp[i-1][j + nums[i]]:0);
            }
        }
        return dp[nums.length-1][S+1000];
    }

    @Test
    public void test(){
        System.out.println(findTargetSumWays3(new int[]{0,0,0,0,0,0,0,0,1}
        ,1));
        System.out.println(findTargetSumWays3(new int[]{1,1,1,1,1,},3));
        System.out.println(findTargetSumWays4(new int[]{1,1,1,1,1,},3));
    }

}
