package com.xiechao.swordToOffers.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: xiehcao
 * @Date : 2018/9/27
 * @Time : 9:27
 * @description :4Sum II
 */
public class LeetCode454 {
    //暴力法
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        //int sum = 0;
        int result = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                for (int k = 0; k < C.length; k++) {
                    for (int l = 0; l < D.length; l++) {
                        if((A[i] + B[j] + C[k] +D[l]) == 0)
                            result++;
                    }
                }
            }
        }
        return result;
    }

    //LeetCode 渣神 245ms
    public int fourSumCount2(int[] A, int[] B, int[] C, int[] D){
        int result = 0;
        Map<Integer,Integer> mapAB = getSumMap(A,B);
        Map<Integer,Integer> mapCD = getSumMap(C,D);
        for (Integer e:mapCD.keySet()) {
            if(mapAB.containsKey(-e)){
                result += mapAB.get(-e)*mapCD.get(e);
            }
        }
        return result;
    }
    private Map<Integer,Integer> getSumMap(int[] A, int[] B){
        Map<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                map.merge(A[i]+B[j],1,Integer::sum);
            }
        }
        return map;
    }

    //LeetCode 大神升级  71ms
    public int fourSumCount3(int[] A, int[] B, int[] C, int[] D) {
        int result = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                map.merge(A[i]+B[j],1,Integer::sum);
            }
        }
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                if(map.containsKey(-(C[i]+D[j]))){
                    result += map.get(-(C[i]+D[j]));
                }
            }
        }
        return result;
    }



    @Test
    public void test() {
        int[] A = new int[]{1,2};
        int[] B = new int[]{-2,-1};
        int[] C = new int[]{-1,2};
        int[] D = new int[]{0,2};
        fourSumCount2(A,B,C,D);


    }






}
