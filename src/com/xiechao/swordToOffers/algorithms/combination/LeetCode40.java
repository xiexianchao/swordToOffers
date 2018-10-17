package com.xiechao.swordToOffers.algorithms.combination;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: xiechao
 * @Date : 2018/10/17
 * @Time : 9:42
 * @description :Combination Sum II
 */
public class LeetCode40 {
    //29ms
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(candidates == null || candidates.length <=0 || target <=0)return result;
        Arrays.sort(candidates);
        helper(result,new ArrayList<Integer>(),candidates,target,0,new boolean[candidates.length]);
        return result;
    }

    private void helper(List<List<Integer>> result, ArrayList<Integer> tempList, int[] candidates, int target, int start,boolean[] used) {
        if(target == 0){
            result.add(new ArrayList<>(tempList));
            return;
        }
        if( start >= candidates.length||target <0 ){
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if(i >0 && candidates[i] == candidates[i-1] && !used[i-1]) continue;
            tempList.add(candidates[i]);
            used[i] = true;
            helper(result,tempList,candidates,target-candidates[i],i+1,used);
            used[i] = false;
            tempList.remove(tempList.size() - 1);
        }
    }
    //剪枝 优化 10ms
    public List<List<Integer>> combinationSum22(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(candidates == null || candidates.length <=0 || target <=0) return result;
        Arrays.sort(candidates);
        helper2(result,new ArrayList<Integer>(),candidates,target,0);
        return result;
    }

    private void helper2(List<List<Integer>> result, ArrayList<Integer> tempList, int[] candidates, int target, int start) {
        if(target == 0){
            result.add(new ArrayList<>(tempList));
            return;
        }
        if(start > candidates.length -1){
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if(i > start && candidates[i] == candidates[i-1]) continue;
            if(candidates[i] > target) continue;
            tempList.add(candidates[i]);
            helper2(result,tempList,candidates,target-candidates[i],i+1);
            tempList.remove(tempList.size() - 1);
        }


    }


    @Test
    public void test(){
        System.out.println(combinationSum22(new int[]{2,5,2,1,2},5));
    }
}
