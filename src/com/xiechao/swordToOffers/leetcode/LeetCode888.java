package com.xiechao.swordToOffers.leetcode;

import org.junit.Test;

import java.util.*;

/**
 * @author: xiehcao
 * @Date : 2018/9/4
 * @Time : 15:43
 * @description :原理上就是two sum的变形。使用一个set存储一个数组，遍历另外一个数组。
 * 判断set中有无需要的元素。
 *
 *
 */
public class LeetCode888 {
    public int[] fairCandySwap(int[] A,int[] B){
        int[] ans = new int[2];
        int sum_A = sum(A);
        int sum_B = sum(B);
        int average = ( sum_A + sum_B ) >>>1;
        /*int average = 0 ;
        for (int e:A) {
            average+=e;
        }
        for (int e:B) {
            average+=e;
        }
        average=average>>>1;*/
        Set<Integer> mapB = new HashSet<>();
        for (Integer num:B) {
            mapB.add(num);
        }
        for (int i = 0; i <= A.length-1; i++) {
           if(mapB.contains(average+A[i]-sum_A)){
               ans[0] = A[i];
               ans[1] = average+A[i]-sum_A;
               break;
            }
        }
        return ans;
    }
    private int sum(int[] nums){
        int sum = 0;
        if(null != nums && nums.length >0){
            for (int e:nums) {
                sum += e;
            }
        }
        return sum;
    }

    @Test
    public void test(){
        int[] result = fairCandySwap(new int[]{1,2},new int[]{2,3});
        System.out.println(Arrays.toString(result));
    }
}
