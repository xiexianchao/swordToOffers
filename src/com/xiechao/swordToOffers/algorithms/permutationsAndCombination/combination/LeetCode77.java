package com.xiechao.swordToOffers.algorithms.permutationsAndCombination.combination;

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


    public List<List<Integer>> combine2(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if(n<1 || k < 1) return result;
        helper2(result,new ArrayList<Integer>(),n,1,k);
        return result;
    }

    private void helper2(List<List<Integer>> result, ArrayList<Integer> tempList, int n,int start,int k) {
        if(tempList.size() == k){
            result.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = start; i <=n ; i++) {
            tempList.add(i);
            helper2(result,tempList,n,i+1,k);
            tempList.remove(tempList.size()-1);
        }
    }

    //另一种迭代方法，按照剑指offer上的思路，因为本题递归函数参数是两个整型数据，如果是数组，操作起来就比较麻烦了。不如使用dfs
    public List<List<Integer>> combine3(int n, int k){
        List<List<Integer>> result = new ArrayList<>();
        if(n <1 || k <1) return result;
        if(n == k){
            List<Integer> tempList = new ArrayList<>();
            for (int i = 1; i <= n ; i++) {
                tempList.add(i);
            }
            result.add(tempList);
            return result;

        }
        if(k == 1){
            for (int i = 1; i <= n ; i++) {
                List<Integer> tempList = new ArrayList<>();
                tempList.add(i);
                result.add(tempList);
            }
            return result;
        }else{
            List<List<Integer>> list1 = combine3(n - 1, k);
            List<List<Integer>> list2 = combine3(n - 1, k-1);
            for (List list:list2) {
                list.add(n);
                result.add(list);
            }
            for (List list:list1) {
                result.add(list);
            }
            return result;
        }
    }


    @Test
    public void test(){
        System.out.println(combine3(4,3));
    }

}
