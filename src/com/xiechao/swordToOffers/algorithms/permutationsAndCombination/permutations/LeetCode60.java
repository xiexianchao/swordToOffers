package com.xiechao.swordToOffers.algorithms.permutationsAndCombination.permutations;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: xiechao
 * @Date : 2018/10/16
 * @Time : 20:30
 * @description :Permutation Sequence
 * 求1,2,3,4,...n的全排列中第k个
 */
public class LeetCode60 {
    //大神    10ms
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        List<Integer> array = new ArrayList<>();
        k = k -1;
        int[] nums = new int[n+1];
        int tmp = 1;
        nums[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            tmp *= i;
            nums[i] = tmp;
        }
        //1,2,3,4..n]
        for (int i = 1; i <= n; i++) {
            array.add(i);
        }
        for (int i = 1; i <= n ; i++) {
            int index = k / nums[n-i];
            sb.append(array.get(index));
            array.remove(index);
            k = k % nums[n-i];
        }
        
        return sb.toString();
    }
    @Test
    public void test(){
        System.out.println(getPermutation(4,14));
    }
}
