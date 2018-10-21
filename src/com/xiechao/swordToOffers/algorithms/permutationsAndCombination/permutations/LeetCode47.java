package com.xiechao.swordToOffers.algorithms.permutationsAndCombination.permutations;

import org.junit.Test;

import java.util.*;

/**
 * @author: xiehcao
 * @Date : 2018/10/16
 * @Time : 11:09
 * @description :求包含重复数字的全排列
 * 1,1,3
 */
public class LeetCode47 {
    //使用set保存结果，再转成list  164ms
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> temp = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length <=0 )  return result;
          helper(nums,0,temp);
       result.addAll(temp);
       return result;
    }
    private void helper(int[] nums, int start,Set<List<Integer>> result){
        if(start == nums.length){
            List<Integer> list = new ArrayList<>();
            for (Integer e:nums) {
                list.add(e);
            }
            result.add(list);
            return;
        }
        for (int i = start; i < nums.length; i++) {
            Integer temp = nums[start];
            nums[start] = nums[i];
            nums[i] = temp;

            helper(nums,start+1,result);

            temp = nums[start];
            nums[start] = nums[i];
            nums[i] = temp;
        }
    }

    //error
    public List<List<Integer>> permuteUnique2(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length <=0 )  return result;
        Arrays.sort(nums);
        helper2(nums,result,0,new boolean[nums.length]);
        return result;
    }

    private void helper2(int[] nums, List<List<Integer>> result, int start,boolean[] used) {
        if(start == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (Integer e : nums) {
                list.add(e);
            }
            result.add(list);
            return;
        }
            for (int i = start; i < nums.length; i++) {
                if((i < nums.length -1)  && nums[i+1] == nums[i] && !used[i+1])
                   continue;
                used[i] = true;
                Integer temp = nums[start];
                nums[start] = nums[i];
                nums[i] = temp;

                helper2(nums, result, start + 1, used);

                temp = nums[start];
                nums[start] = nums[i];
                nums[i] = temp;
                used[i] = false;
            }
    }


    //网上大神 3ms
    public List<List<Integer>> permuteUnique3(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length <=0) return result;
        Arrays.sort(nums);                                  //先排序
        dfs(result,nums,new ArrayList<>(),new boolean[nums.length]);
        return result;
    }
    private void dfs(List<List<Integer>> result,int[] nums,List<Integer> tempList,boolean[] used){
        if(tempList.size() == nums.length){
            result.add(new ArrayList<>(tempList));
            return;
        }else{
            for (int i = 0; i < nums.length; i++) {
                if(used[i]) continue;
                if(i>0 && nums[i] == nums[i-1] && !used[i-1])
                    continue;     //减支
                used[i] = true;
                tempList.add(nums[i]);
                dfs(result,nums,tempList,used);
                tempList.remove(tempList.size()-1);
                used[i] = false;
            }
        }
    }

    // copyOfpermuteUnique3
    public List<List<Integer>> permuteUnique4(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length <=0) return  result;
        Arrays.sort(nums);
        helper4(result,new ArrayList<Integer>(),nums,0,new boolean[nums.length]);
        return result;
    }

    private void helper4(List<List<Integer>> result, ArrayList<Integer> tempList, int[] nums, int start,boolean[] used) {
        if(start == nums.length){
            result.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {  //排列要从0开始，组合从start开始
            if(used[i]) continue;
            if(i>0 && nums[i-1] == nums[i] && !used[i-1]) continue;
            tempList.add(nums[i]);
            used[i] = true;
            helper4(result,tempList,nums,start+1,used);
            used[i] = false;
            tempList.remove(tempList.size() -1);
        }
    }


    @Test
    public void test(){
        System.out.println(permuteUnique4(new int[]{1,2,2}));
    }
}
