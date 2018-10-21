package com.xiechao.swordToOffers.algorithms.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: xiechao
 * @Date : 2018/10/19
 * @Time : 22:12
 * @description :Combination Sum III
 */
public class LeetCode216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        if(n < 1) return result;
        helper(result,new ArrayList<Integer>(),k,n,1);
        return result;
    }

    private void helper(List<List<Integer>> result,List<Integer> tempList ,int k, int n,int start) {
        if( tempList.size() == k){
            if(n == 0)
                result.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = start; i <= 9 ; i++) {
            if(tempList.contains(i)) continue;
            if(i <= n) {
                tempList.add(i);
                helper(result,tempList,k,n-i,i+1);
                tempList.remove(tempList.size()-1);
            }
        }
    }
    @Test
    public void test(){
        System.out.println(combinationSum3(3,9));
    }
}
