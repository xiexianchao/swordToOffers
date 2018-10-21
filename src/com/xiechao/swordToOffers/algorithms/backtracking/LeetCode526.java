package com.xiechao.swordToOffers.algorithms.backtracking;

import org.junit.Test;

/**
 * @author: xiechao
 * @Date : 2018/10/19
 * @Time : 20:56
 * @description :Beautiful Arrangement
 */
public class LeetCode526 {
    int result = 0;
    //99ms
    public int countArrangement(int N) {
        if(N < 1) return result;
        boolean[] used = new boolean[N+1];
        helper(N,used,1);
        return result;
    }

    //start 表示第start个位置，i表示第i个位置上的值
    private void helper(int N, boolean[] used, int start) {
        if(start == N+1){
            result++;
            return;
        }
        for (int i = 1; i < N+1; i++) {
            if(used[i]) continue;

            used[i] = true;
            if(((i % start) ==0) || (((start % i) ==0))){
                helper(N,used,start+1);
            }
            used[i] = false;

        }
    }

    //LeetCode大神 4ms
    public int countArrangement2(int N) {
        int[] count = new int[]{0};       //这样传值避免了放到实例域中
        int[] nums = new int[N+1];
        for (int i = 1; i < nums.length; i++) {
            nums[i] = i;
        }
        helper2(nums,count,N);
        return count[0];
    }

    private void helper2(int[] nums, int[] count, int n) {
        if( n ==  0){
            count[0]++;
            return;
        }
        for (int i = n; i > 0 ; i--) {
            swap(nums,i,n);
            if(nums[n] % n == 0 || n % nums[n] == 0)
            helper2(nums,count,n-1);
            swap(nums,i,n);
        }
    }

    private void swap(int[] nums, int i, int n) {
        int temp = nums[i];
        nums[i] = nums[n];
        nums[n] = temp;
    }


    @Test
    public void test(){
        System.out.println(countArrangement(2));
    }

}
