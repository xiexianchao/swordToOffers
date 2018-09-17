package com.xiechao.swordToOffers.leetcode;

import org.junit.Test;

/**
 * @ClassName LeetCode189
 * @Author xiechao
 * @Date 2018/9/17
 * @Time 16:33
 * @Description Rotate Array
 */
public class LeetCode189 {
    //100 ms 暴力法
    public void rotate(int[] nums, int k) {
        if( nums == null || nums.length <=0 || k<=0) return;
        k = k % nums.length;
        while( k>0 ){
            int temp = nums[nums.length - 1];
            for (int i = nums.length-1; i >= 1; i--) {
                nums[i] = nums[i-1];
            }
            nums[0] = temp;
            k--;
        }
    }
    //使用额外空间
    public void rotate2(int[] nums,int k){
        if( nums == null || nums.length <=0 || k<=0) return;
        k = k % nums.length;
        int[] array = new int[k];
        for (int i = nums.length - k, index = 0; i < nums.length; i++) {
            array[index++] = nums[i];
        }
        for (int i = nums.length - k -1; i >= 0 ; i--) {
            nums[i+k] = nums[i];
        }
        for (int i = 0; i <k ; i++) {
            nums[i] = array[i];
        }
       }
    //LeetCode大神 0ms 三次旋转
    public void rotate3(int[] nums,int k){
        if( nums == null || nums.length <=0 || k<=0) return;
        k = k % nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k - 1 );
        reverse(nums,k,nums.length-1);
    }

    private void reverse(int[] nums, int start, int end) {
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }


    @Test
    public void test() {
        rotate3(new int[]{1,2,3,4,5,6,7},3);
    }
}
