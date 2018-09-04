package com.xiechao.swordToOffers.leetcode;

import org.junit.Test;

public class LeetCode832 {
    public int[][] flipAndInvertImage(int[][] A){
        if( null == A || A.length <=0 || A[0].length <=0){
            return null;
        }
        int[][] result = new int[A.length][A[0].length];

        for (int i = 0; i < A.length; i++) {
            int piexs = A[i].length;
            for (int j = 0; j < piexs; j++) {
                result[i][j] = A[i][piexs-1 -j] ^ 1;
            }
        }
        return result;
    }
    @Test
    public void test(){
        /*[[1,1,0],[1,0,1],[0,0,0]]*/
        int[][] arr = new int[3][3];
        arr[0] = new int[]{1,1,0};
        arr[1] = new int[]{1,0,1};
        arr[2] = new int[]{0,0,0};

        flipAndInvertImage(arr);

    }

}
