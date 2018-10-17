package com.xiechao.swordToOffers.algorithms.combination;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: xiechao
 * @Date : 2018/10/16
 * @Time : 22:08
 * @description :SubsetsII
 * 给一个数集（有重复数字），要求列出所有子集。
 */
public class LeetCode90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        helper(result,new ArrayList<>(),0,nums);
        return result;
    }

    private void helper(List<List<Integer>> result, ArrayList<Integer> list, int start, int[] nums) {
       result.add(new ArrayList<>(list));
       if(start > nums.length) return;
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;   //去除重复的字符影响
            list.add(nums[i]);
            helper(result, list, i + 1, nums);
            list.remove(list.size() - 1);
        }
    }
    @Test
    public void test(){
        System.out.println(subsetsWithDup(new int[]{1,2,3,1}));
    }
}
