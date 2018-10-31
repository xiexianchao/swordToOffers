package com.xiechao.swordToOffers.algorithms.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: xiechao
 * @Date : 2018/10/22
 * @Time : 10:24
 * @description :Subsets
 */
public class LeetCode78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        if(nums == null || nums.length <=0) return result;
        helper(result,new ArrayList<>(),nums,0);
        return result;
    }

    private void helper(List<List<Integer>> result, ArrayList<Integer> tempList, int[] nums, int start) {
        result.add(new LinkedList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            helper(result,tempList,nums,i+1);
            tempList.remove(tempList.size()-1);
        }
    }
    @Test
    public void test(){
        System.out.println(subsets(new int[]{1,2,3}));
    }
}
