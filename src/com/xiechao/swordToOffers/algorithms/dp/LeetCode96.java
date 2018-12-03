package com.xiechao.swordToOffers.algorithms.dp;

import org.junit.Test;

/**
 * @ClassName LeetCode96
 * @Author xiechao
 * @Date 2018/12/3
 * @Time 8:57
 * @Description  Unique Binary Search Trees
 * 这是一道见过的面试题，求[1,n]能够组成多少棵二叉搜索树，其实是求连续的n节点能组成多棵二叉搜索树
 * int[] dp = new int[n+1];
 * dp[i]表示连续i个节点能组成多少棵二叉搜索树,
 * dp[i] = sum(dp[j-1] * dp[i-j]), 1 <= j <= i //以j为根节点
 * dp[0] = 1,dp[1] = 1
 * dp[n]即为所求答案
 */
public class LeetCode96 {
    public int numTrees(int n) {
        if(n <= 0 ) return 0;
        int[] dp = new int[n+1];    //dp[i] 表示连续的i个节点的搜索二叉树有多少个
        dp[0] = 1;                  //答案就是dp[n]
        dp[1] = 1;
        for (int i = 2; i < dp.length ; i++) {
            int temp= 0;

            for (int j = 1; j <= i ; j++) {
                temp += (dp[j-1] * dp[i-j]);
            }
            dp[i] = temp;
        }
        return dp[n];
    }
    @Test
    public void test(){
        System.out.println(numTrees(3));
    }
}
