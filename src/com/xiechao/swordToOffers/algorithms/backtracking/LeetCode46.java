package com.xiechao.swordToOffers.algorithms.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: xiechao
 * @Date : 2018/10/19
 * @Time : 22:05
 * @description :Permutations
 */
public class LeetCode46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null) return result;
        helper(nums,result,new ArrayList<Integer>(),0);
        return result;
    }

    private void helper(int[] nums, List<List<Integer>> result, ArrayList<Integer> tempList, int start) {
        if(start == nums.length){
            result.add(new ArrayList<Integer>(tempList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(tempList.contains(nums[i])) continue;
            tempList.add(nums[i]);
            helper(nums,result,tempList,start+1);
            tempList.remove(tempList.size()-1);
        }

    }
}
