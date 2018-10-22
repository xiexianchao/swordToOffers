package com.xiechao.swordToOffers.algorithms.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: xiechao
 * @Date : 2018/10/22
 * @Time : 9:05
 * @description :Combination Sum
 */
public class LeetCode39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(candidates == null || candidates.length <=0 || target <= 0) return result;
        helper(result,new ArrayList<>(),candidates,target,0);
        return result;
    }

    private void helper(List<List<Integer>> result,List<Integer> tempList ,int[] candidates, int target,int start) {
        if( start >= candidates.length || target < 0)
            return;
        if(target == 0){
            result.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            tempList.add(candidates[i]);
            helper(result,tempList,candidates,target - candidates[i],i);
            tempList.remove(tempList.size()-1);
        }
    }
    @Test
    public void test(){
        System.out.println(combinationSum(new int[]{2,3,6,7},7));
    }
}
