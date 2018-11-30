package com.xiechao.swordToOffers.algorithms.dp;

import org.junit.Test;

/**
 * @ClassName LeetCode740
 * @Author xiechao
 * @Date 2018/11/30
 * @Time 8:46
 * @Description Delete and Earn
 * 从数组中取出一个元素e,删除数组中的e+1和e-1。再接着取元素。
 * 求取出元素和的最大值
 * 大神们的做法，先建立一个count数组，统计元素出现的次数
 * 然后再建立一个dp数组，dp[i]表示遍历到这个i这个数，可以取到的最大值。
 * dp[i] = Math.max(dp[i-1],dp[i-2] + c[i] * i);
 * dp[1] = c[1] * 1;
 * dp[1000]即答案
 */

public class LeetCode740 {

    public int deleteAndEarn(int[] nums) {
       if(nums == null || nums.length <= 0 ) return 0;
       int[] count = new int[10001];
        for (Integer e:nums) {
            count[e]++;
        }
        int[] dp = new int[count.length];
        dp[1] = count[1];
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i-1],dp[i-2] + count[i]*i);
        }
        return dp[1000];
    }
    @Test
    public void test(){
        System.out.println(deleteAndEarn(new int[]{2,2,3,3,3,4}));
    }
}
