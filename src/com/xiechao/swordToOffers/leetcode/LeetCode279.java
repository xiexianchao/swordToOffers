package com.xiechao.swordToOffers.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: xiehcao
 * @Date : 2018/10/10
 * @Time : 15:32
 * @description :Perfect Squares
 */
public class LeetCode279 {
    int min = Integer.MAX_VALUE;
    // 当n=61时,Time Limit Exceeded
    public int numSquares(int n) {
        if(n <= 0) return 0;
        helper(n,0);
        return min;
    }
    private void helper(int n, int count) {
        int sqrt = (int)Math.sqrt(n);
        if( sqrt * sqrt == n){
            count++;
            min = Math.min(min,count);
        }else{
            for (int i = sqrt; i >=1 ; i--) {
                //存在重复计算
                helper(n-i*i,count+1);
            }
        }
    }
    //同样存在当n=61时,Time Limit Exceeded
    public int numSquares2(int n){
        if(n <= 0) return 0;
        int sqrt = (int)Math.sqrt(n);
        if(sqrt*sqrt == n) return 1;
        int min = Integer.MAX_VALUE;
        for (int i = sqrt; i >=1; i--) {
            int result = numSquares2(n-i*i);
            result++;
            min = Math.min(min,result);
        }
        return min;
    }

    //做个缓存  302ms
    Map<Integer,Integer> cache = new HashMap<>();
    public int numSquares3(int n){
        if(n <= 0) return 0;
        if(cache.containsKey(n)) return cache.get(n);
        int sqrt = (int)Math.sqrt(n);
        if(sqrt*sqrt == n) return 1;
        int min = Integer.MAX_VALUE;
        for (int i = sqrt; i >=1; i--) {
            int result = numSquares3(n-i*i);
            result++;
            min = Math.min(min,result);
        }
        cache.put(n,min);
        return min;
    }
    //dp  22ms
    public int numSquares4(int n){
        if(n <=0 ) return 0;
        int[] dp = new int[n+1];
        for (int i = 1; i <= Math.sqrt(n); i++) {
            dp[i*i] = 1;
        }
        dp[0] = 0;
        for (int i = 2; i < dp.length; i++) {
            int sqrt = (int) Math.sqrt(i);
            int min = Integer.MAX_VALUE;
            for (int j = 1; j <= sqrt ; j++) {
                min = Math.min(min,dp[i-j*j]);
            }
            dp[i] = min + 1;
        }
        return dp[n];
    }
    @Test
    public void test(){
        System.out.println(numSquares4(61));
    }
}
