package com.xiechao.swordToOffers.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: xiehcao
 * @Date : 2018/9/27
 * @Time : 10:22
 * @description :78. Subsets
 * 求一个数组的所有子数组，典型的组合问题
 *Input: nums = [1,2,3]
Output:
[
[3],
[1],
[2],
[1,2,3],
[1,3],
[2,3],
[1,2],
[]
]
 *
 */
public class LeetCode78 {
    //2ms
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if( nums == null ||nums.length <=0) return result;
        for (int i = 0; i <= nums.length; i++) {
            subsetsCore(nums,result,0,nums.length-1,i);
        }
        return result;
    }

    private Stack<Integer> stack = new Stack<>();
    private void subsetsCore(int[] nums, List<List<Integer>> result, int start, int end, int m){
        if( m == 0){
            List<Integer> list = new ArrayList<>();
            list.addAll(stack);
            result.add(list);
            return;
        }
        if(start > end)
            return;
        stack.push(nums[start]);
        subsetsCore(nums,result,start+1,end,m-1);
        stack.pop();
        subsetsCore(nums,result,start+1,end,m);
    }
    //LeetCode 大神 1ms,这种递归我就写不好,回溯的一种啊
    public List<List<Integer>> subsets2(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null ) return result;
        List<Integer> list = new ArrayList<>();
        result.add(list);
        subsetsCore2(nums,result,list,0);
        return result;
    }
    private void subsetsCore2(int[] nums,List<List<Integer>> result,List<Integer> list,int k){
        if( k == nums.length)
            return;
        for (int i = k; i < nums.length; i++) {
            List<Integer> newList = new ArrayList<>(list);
            newList.add(nums[i]);
            result.add(newList);
            subsetsCore2(nums,result,newList,i+1);
        }

    }




    @Test
    public void test(){
        System.out.println(subsets2(new int[]{1,2,3}));
    }

}
