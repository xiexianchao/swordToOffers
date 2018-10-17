package com.xiechao.swordToOffers.algorithms.combination;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: xiechao
 * @Date : 2018/10/17
 * @Time : 8:57
 * @description :Combinations
 */
public class LeetCode77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i+1;
        }
        helper(result,nums,new ArrayList<Integer>(),0,k);
        return result;
    }

    private void helper(List<List<Integer>> result, int[] nums, ArrayList<Integer> list, int start,int k) {
        if(list.size() == k){
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            helper(result,nums,list,i+1,k);
            list.remove(list.size() -1 );
        }
    }
    @Test
    public void test(){
        System.out.println(combine(4,2));
    }

}
