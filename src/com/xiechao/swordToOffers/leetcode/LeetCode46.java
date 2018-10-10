package com.xiechao.swordToOffers.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: xiehcao
 * @Date : 2018/9/27
 * @Time : 9:06
 * @description :46. Permutations
 *
 *
 */
public class LeetCode46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if( nums == null) return result;
        permute(nums,0,result);
        return result;
    }

    private void permute(int[] nums, int start, List<List<Integer>> result) {
        if(start == nums.length-1){
            List<Integer> list = new ArrayList<>();
            for (int e:nums) {
                list.add(e);
            }
            result.add(list);
            return;
        }
        for (int i = start; i < nums.length; i++) {
            int temp = nums[i];
            nums[i] = nums[start];
            nums[start] = temp;

            permute(nums,start+1,result);

            temp = nums[i];
            nums[i] = nums[start];
            nums[start] = temp;
        }
    }

    @Test
    public void test(){
        System.out.println(permute(new int[]{1,2,3}));
    }

}
