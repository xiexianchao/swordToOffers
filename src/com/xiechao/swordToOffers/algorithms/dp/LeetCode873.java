package com.xiechao.swordToOffers.algorithms.dp;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName LeetCode873
 * @Author xiechao
 * @Date 2018/12/7
 * @Time 9:04
 * @Description  Length of Longest Fibonacci Subsequence
 * 给定一个递增的正数组A,求满足斐波那契的最长子序列（不是子数组）
 * 暴力+回溯：肯定可以做，但Time Limit Exceeded
 */
public class LeetCode873 {
    public int lenLongestFibSubseq(int[] A) {
        if(A == null || A.length < 3) return 0;
        int N = A.length;
        Map<Integer,Integer> index = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            index.put(A[i],i);
        }
        Map<Integer,Integer> longest = new HashMap<>();
        int ans = 0;
        for (int k = 0; k < A.length; k++) {
            for (int j = 0; j < k; j++) {
                int i = index.getOrDefault(A[k] - A[j],-1);
                if(i >= 0 && i < j){
                    int cand = longest.getOrDefault(i * N + j,2) + 1;
                    longest.put( j * N + k ,cand);
                    ans = Math.max(ans,cand);
                }
            }
        }
        return ans >= 3 ? ans:0;
    }
    @Test
    public void test(){
        System.out.println(lenLongestFibSubseq(new int[]{1,2,3,4,5,6,7,8,9}));
    }
}
