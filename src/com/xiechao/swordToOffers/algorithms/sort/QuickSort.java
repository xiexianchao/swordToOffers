package com.xiechao.swordToOffers.algorithms.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ClassName QuickSort
 * @Author xiechao
 * @Date 2019/3/5
 * @Time 16:12
 * @Description TODO
 */
public class QuickSort {
    public void quickSort(int[] nums,int start, int end){
        if(nums == null || start >= end) return;
        int mid = partition(nums, start, end);
        quickSort(nums, start, mid - 1);
        quickSort(nums, mid + 1, end);
    }

    private int partition(int[] nums, int start, int end) {
        int temp = nums[start];
        while(start < end){
            while(start < end && nums[end] > temp)
                end --;
            swap(nums, start, end);
            while(start < end && nums[start] <= temp)
                start++;
            swap(nums, start,end);
        }
        nums[start] = temp;
        return start;
    }

    private void swap(int[] nums, int start, int end) {
        int temp = nums[end];
        nums[end] = nums[start];
        nums[start] = temp;
    }
    @Test
    public void test(){
        int[] arr = new int[]{8,7,9,3,0,2,1,4,5,1};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
