package com.xiechao.swordToOffers.algorithms.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ClassName MergeSort
 * @Author xiechao
 * @Date 2019/3/5
 * @Time 15:46
 * @Description TODO
 */
public class MergeSort {
    public void mergeSort(int[] nums){
        if(nums == null) return;
        helper(nums,0,nums.length-1);
        return;
    }
    private void helper(int[] nums, int start, int end){
        if(start < end) {
            int mid = (end + start) / 2;
            helper(nums, start, mid);
            helper(nums, mid + 1, end);
            merge(nums, start, mid, end);
        }
    }
    private void merge(int[] nums, int start, int mid, int end) {
        int[] arr = new int[end - start + 1];
        int p1 = 0;
        int p2 = start;
        int p3 = mid + 1;
        while(p2 <= mid && p3 <= end){
            if(nums[p2] < nums[p3]){
                arr[p1++] = nums[p2++];
            }else{
                arr[p1++] = nums[p3++];
            }
        }
        while(p2 <= mid)
            arr[p1++] = nums[p2++];
        while(p3 <= end)
            arr[p1++] = nums[p3++];
        for (int i = 0; i < arr.length; i++) {
            nums[start+i] = arr[i];
        }
    }
    @Test
    public void test(){
        int[] arr = new int[]{8,7,9,3,0,2,1,4,5,1};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
