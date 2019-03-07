package com.xiechao.swordToOffers.algorithms.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ClassName HeapSortClass
 * @Author xiechao
 * @Date 2019/3/5
 * @Time 14:59
 * @Description TODO
 */
public class HeapSortClass {
    public void headSort(int[] nums){
        if(nums == null) return;
        for (int i = (nums.length / 2 )-1; i >= 0; i--) {
            adjustMaxHeap(nums, i, nums.length);
        }
        for (int i = nums.length - 1; i > 0 ; i--) {
            int temp = nums[i];
            nums[i] = nums[0];
            nums[0] = temp;
            adjustMaxHeap(nums, 0,i);
        }
    }
    private void adjustMaxHeap(int[] nums,int start, int length){
        int temp = nums[start];
        for (int i = start * 2 + 1; i < length; i = i * 2) {
            if((i+1) < length && nums[i+1] > nums[i])
                i++;
            if(nums[start] > nums[i]) break;
            nums[start] = nums[i];
            start = i;
        }
        nums[start] = temp;
    }
    @Test
    public void test(){
        int[] arr = new int[]{8,7,9,3,0,2,1,4,5,1};
        headSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
