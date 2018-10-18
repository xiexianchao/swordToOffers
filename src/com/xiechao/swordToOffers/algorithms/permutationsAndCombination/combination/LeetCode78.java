package com.xiechao.swordToOffers.algorithms.permutationsAndCombination.combination;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: xiechao
 * @Date : 2018/10/16
 * @Time : 21:09
 * @description :Subsets
 */
public class LeetCode78 {
    //1ms
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null ) return result;
        List<Integer> list = new ArrayList<>();
        result.add(list);
        helper(nums,result,0,list);
        return result;
    }

    private void helper(int[] nums, List<List<Integer>> result, int start,List<Integer> list) {
        if(start == nums.length){
            return;
        }
        for (int i = start; i < nums.length; i++) {
            List<Integer> newList = new ArrayList<>(list);
            newList.add(nums[i]);
            result.add(newList);
            helper(nums,result,i+1,newList);
        }
    }

    public List<List<Integer>> subsets2(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null ) return result;
        List<Integer> list = new ArrayList<>();
        helper2(result,list,nums,0);
        return result;
    }

    private void helper2(List<List<Integer>> result, List<Integer> list, int[] nums, int start) {
        result.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            helper2(result,list,nums,i+1);
            list.remove(list.size()-1);
        }

    }


    @Test
    public void  test(){
        System.out.println(subsets2(new int[]{1,2,3}));
    }
}
