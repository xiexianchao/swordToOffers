package com.xiechao.swordToOffers.algorithms.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: xiechao
 * @Date : 2018/10/22
 * @Time : 11:40
 * @description : Permutations II
 */
public class LeetCode47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length <=0) return result;
        Arrays.sort(nums);
        helper(result,new ArrayList<Integer>(),nums,0,new boolean[nums.length]);
        return result;
    }

    private void helper(List<List<Integer>> result, ArrayList<Integer> tempList, int[] nums, int start,boolean[] used) {
        if(start == nums.length){
            result.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(used[i]) continue;
            if( i > 0 && nums[i] == nums[i-1] && !used[i-1]) continue;
            tempList.add(nums[i]);
            used[i] = true;
            helper(result,tempList,nums,start+1,used);
            used[i] = false;
            tempList.remove(tempList.size() - 1);
        }
    }

}
