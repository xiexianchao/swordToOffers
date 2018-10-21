package com.xiechao.swordToOffers.algorithms.permutationsAndCombination.combination;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: xiechao
 * @Date : 2018/10/17
 * @Time : 9:22
 * @description :39. Combination Sum
 */
public class LeetCode39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(candidates == null || candidates.length <=0 || target <=0) return result;
        helper(result,new ArrayList<Integer>(),candidates,target,0);

        return result;
    }

    private void helper(List<List<Integer>> result, ArrayList<Integer> tempList, int[] candidates, int target,int start) {
        if(target == 0){
            result.add(new ArrayList<>(tempList));
            return;
        }
        if(target<0){
            return;
        }

        for (int i = start; i < candidates.length; i++) {

            tempList.add(candidates[i]);
            helper(result,tempList,candidates,target-candidates[i],i);
            tempList.remove(tempList.size()-1);
        }
    }
    @Test
    public void test(){
        System.out.println(combinationSum(new int[]{2,3,5},8));
    }
}
