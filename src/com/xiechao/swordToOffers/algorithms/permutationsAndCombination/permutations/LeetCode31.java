package com.xiechao.swordToOffers.algorithms.permutationsAndCombination.permutations;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author: xiechao
 * @Date : 2018/10/16
 * @Time : 15:59
 * @description :Next Permutation
 * 求输入数组的下一个排列
 */
public class LeetCode31 {
    //11ms
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length < 2) return;
        int lastEle = nums[nums.length -1];
        int k = nums.length - 2;
        /*
         * 从倒数第二个元素开始，从后向前，找到第一个满足(后元素>前元素)的情况
         * 此时，记录前元素下标k。因为在[k+1,n-1]都满足后元素<前元素,则[k+1,n-1]为一个单调非增子序列
         * 那么，这里只需要将一个比nums[k]大的最小数与nums[k]交换
         */
        //找到第一个：后元素<前元素。k指向前元素的索引
        for (; k >=0 ; k--) {
            if(lastEle > nums[k]){
                break;
            }else{
                lastEle = nums[k];
            }
        }
        if(k < 0){   //k<0 说明整个数组都是非递增数组。直接翻转数组得到结果
            reverse(nums,0,nums.length-1);
        }else{
           // int index = 0;
            //找到比num[k]大的最小数，[k+1,n-1]是单调非增的
            for (int i = nums.length - 1; i > k; i--) {
                if(nums[i] > nums[k]){
                    swap(nums,i,k);
                   // index = i;
                    break;
                }
            }

            reverse(nums,k+1,nums.length-1);
           /* int j = nums.length - 1;
            while(j >=0 && nums[j] <= nums[k]) j--;
            swap(nums,k,j);
            reverse(nums,k+1,nums.length-1);*/
        }
    }

    //翻转数组start到end的元素
    private void reverse(int[] nums,int start,int end){
        if(start >= end) return;
        if(start > nums.length) return;
        if(end >= nums.length) return;
        for (int i = start; i < (start + end + 2)/2; i++) {
            swap(nums,i,end - i + start);
        }
    }
    private void swap(int[] nums,int a,int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    @Test
    public void test(){
        int[] nums = new int[]{0,1,2,3,4,5,6,7,8,9,10};
        reverse(nums,0,nums.length-1);
        reverse(nums,0,5);
        System.out.println(Arrays.toString(nums));
        reverse(nums,2,2);
        System.out.println(Arrays.toString(nums));
        reverse(nums,9,10);
        System.out.println(Arrays.toString(nums));
        reverse(nums,8,10);
        System.out.println(Arrays.toString(nums));
        nextPermutation(new int[]{1,5,1});
    }
}
