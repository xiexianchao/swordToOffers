package com.xiechao.swordToOffers.algorithms.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: xiechao
 * @Date : 2018/10/22
 * @Time : 9:16
 * @description : Combinations
 */
public class LeetCode77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if(n < 1 || n < k) return result;
        helper(result,new ArrayList<>(),n,k,1);
        return result;
    }

    private void helper(List<List<Integer>> result, ArrayList<Integer> tempList, int n, int k, int start) {
        if(tempList.size() == k){
            result.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = start; i <= n ; i++) {
            tempList.add(i);
            helper(result,tempList,n,k,i+1);
            tempList.remove(tempList.size()-1);
        }

    }
    @Test
    public void test(){
        System.out.println(combine(4,2));
    }
}
