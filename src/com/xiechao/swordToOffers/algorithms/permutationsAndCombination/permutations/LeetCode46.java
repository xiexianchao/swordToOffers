package com.xiechao.swordToOffers.algorithms.permutationsAndCombination.permutations;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: xiehcao
 * @Date : 2018/10/16
 * @Time : 10:45
 * @description :求不包含重复元素的全排列
 */
public class LeetCode46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length <=0 ) return result;
        helper(nums,0,nums.length-1,result);
        return result;
    }
    private void helper(int[] nums, int start, int end, List<List<Integer>> result) {
        if(start == end){
            List<Integer> list = new ArrayList<>();
            for (Integer e:nums) {
                list.add(e);
            }
            result.add(list);
            return;
        }
        for (int i = start; i <= end ; i++) {
            Integer temp = nums[i];
            nums[i] = nums[start];
            nums[start] = temp;
            helper(nums,start+1,end,result);
            temp = nums[i];
            nums[i] = nums[start];
            nums[start] = temp;
        }
    }

    private List<List<Integer>> permute2(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length <=0 ) return result;
         helper2(result,nums,new ArrayList<>());
        return result;
}

    private void helper2(List<List<Integer>> result, int[] nums, ArrayList<Integer> tempList) {
        if(tempList.size() == nums.length){
            result.add(new ArrayList<>(tempList)); //这一句很关键
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(tempList.contains(nums[i]))               //如果包含重复数字，此处将导致歧义,建议使用used数组来区别
                continue;
            tempList.add(nums[i]);
            helper2(result,nums,tempList);
            tempList.remove(tempList.size()-1);
        }
    }
    public List<List<Integer>> permute3(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length <=0) return result;
        dfs(result,nums,new ArrayList<>(),new boolean[nums.length]);
        return result;
    }

    private void dfs(List<List<Integer>> result, int[] nums, ArrayList<Integer> tempList, boolean[] used) {
        if(tempList.size() == nums.length){
            result.add(new ArrayList<>(tempList));
            return;
        }else{
            for (int i = 0; i < nums.length; i++) {
                if(used[i]) continue;
                used[i] = true;
                tempList.add(nums[i]);
                dfs(result,nums,tempList,used);
                used[i] = false;
                tempList.remove(tempList.size()-1);
            }

        }
    }

    public List<List<Integer>> permute4(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length <= 0) return result;
        helper4(result,new ArrayList<Integer>(),nums,0);
        return result;
    }

    private void helper4(List<List<Integer>> result, ArrayList<Integer> tempList, int[] nums, int start) {
        if(start == nums.length){
            result.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(tempList.contains(nums[i])) continue;
            tempList.add(nums[i]);
            helper4(result,tempList,nums,start+1);
            tempList.remove(tempList.size()-1);
        }
    }


    @Test
    public void test(){
        System.out.println(permute2(new int[]{1,1,3})); //包含重复数字，出现歧义
        System.out.println(permute2(new int[]{1,2,3}));

        System.out.println(permute(new int[]{1,1,3}));  //包含重复数字，输出也存在问题

        System.out.println(permute3(new int[]{1,2,3}));

        System.out.println(permute3(new int[]{1,3,1})); //包含重复数字，输出也存在问题

    }
}
