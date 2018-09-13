package com.xiechao.swordToOffers.leetcode;

import org.junit.Test;

import java.util.Arrays;

public class LeetCode204 {
    //Time Limit Exceeded
    public int countPrimes(int n){
        if(n<=1)
            return 0;
        int result = 0;
        for (int i = 2; i < n; i++) {
            if(isPrimes(i))
                result++;
        }
        return result;
    }
    private boolean isPrimes(int i){
        for (int j = 2; j <= Math.sqrt(i);) {
            if( (i % j) == 0){
                return  false;
            }
            if(j == 2)
                j++;
            else
                j +=2;
        }
        return true;
    }
    //LeetCode大神
    public int countPrimes2(int n){
        if(n <= 1) return 0;
        boolean[] isPrimes = new boolean[n];
       Arrays.fill(isPrimes,true);
        int count = 0;
        for (int i = 2; i < n; i++) {
            if(isPrimes[i]){
                count++;
                for (int j = 2; j*i < n; j++) {
                    isPrimes[i*j] = false;
                }

            }
        }
        return count;
    }
    @Test
    public void test(){
        System.out.println(countPrimes2(1500000));
    }

}
