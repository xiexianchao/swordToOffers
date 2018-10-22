package com.xiechao.swordToOffers.algorithms.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: xiechao
 * @Date : 2018/10/22
 * @Time : 10:30
 * @description :
 */
public class LeetCode90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        if(nums == null || nums.length <=0) return result;
        Arrays.sort(nums);
        helper(result,new LinkedList<Integer>(),nums,0);
        return result;
    }
    private void helper(List<List<Integer>> result, LinkedList<Integer> tempList, int[] nums, int start){
       if(start > nums.length) return;
        result.add(new LinkedList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            if(i > start && nums[i] == nums[i-1]) continue;
            tempList.add(nums[i]);
            helper(result,tempList,nums,i+1);
            tempList.remove(tempList.size()-1);
        }
    }
    @Test
    public void test(){
        System.out.println(subsetsWithDup(new int[]{1,2,2}));
    }
}
