package com.xiechao.swordToOffers.algorithms.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: xiechao
 * @Date : 2018/10/22
 * @Time : 10:59
 * @description :Combination Sum II
 */
public class LeetCode40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(candidates == null || candidates.length <=0 || target <= 0) return result;
        Arrays.sort(candidates);
        helper(result,new ArrayList<>(),candidates,target,0);
        return result;
    }

    private void helper(List<List<Integer>> result, ArrayList<Integer> tempList, int[] candidates, int target, int start) {
        if(target == 0){
            result.add(new ArrayList<>(tempList));
            return;
        }
        if(start >= candidates.length) return;
        for (int i = start; i < candidates.length; i++) {

            if( i > start && candidates[i] == candidates[i-1]) continue;
            if(candidates[i] > target) continue;
            tempList.add(candidates[i]);
            helper(result,tempList,candidates,target - candidates[i],i+1);
            tempList.remove(tempList.size() - 1);
        }

    }
    @Test
    public void test(){
        System.out.println(combinationSum2(new int[]{10,1,2,7,6,1,5},8));
    }
}
