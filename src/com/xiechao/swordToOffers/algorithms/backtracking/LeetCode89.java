package com.xiechao.swordToOffers.algorithms.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: xiechao
 * @Date : 2018/10/22
 * @Time : 9:36
 * @description :Gray Code
 * 求汉明码
 */
public class LeetCode89 {

    //time out 回溯
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        if(n < 0) return result;
        int[] nums = new int[1<<n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i;
        }
        List<Integer> tempList = new ArrayList<>();
        tempList.add(0);
        helper(result,tempList,nums,n,1,new boolean[]{false});
        return result;
    }

    private void helper(List<Integer> result,List<Integer> tempList,int[] nums ,int n, int start,boolean[] isOver) {
        if(isOver[0]) return;
        if( start == nums.length){
            result.clear();
            for (Integer e:tempList) {
                result.add(e);
            }
            isOver[0] = true;
            return;
        }
        for (int i = 1; i < nums.length && !isOver[0]; i++) {
          if(tempList.contains(nums[i])) continue;
          if(!check(nums[i],tempList.get(tempList.size()-1))) continue;
          tempList.add(nums[i]);
          helper(result,tempList,nums,n,start+1,isOver);
          tempList.remove(tempList.size() -1);
        }
    }
    private boolean check(int targt,int pre){
        int count = 0;
        int result = targt ^ pre;
        while(result !=0){
            count++;
            result &= (result - 1);
        }
        return count == 1;
    }

    public List<Integer> grayCode2(int n){
        List<Integer> result = new LinkedList<>();
        if(n < 0) return result;
        for (int i = 0; i < 1<<n; i++) {
            result.add(i ^ (i>>1));
        }
        return result;
    }

    @Test
    public void test(){
        System.out.println(grayCode2(10));
    }
}
