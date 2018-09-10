package com.xiechao.swordToOffers.leetcode;

/**
 * @author: xiehcao
 * @Date : 2018/9/6
 * @Time : 19:42
 * @description :
 */
public class LeetCode867 {
    public int[][] transpose(int[][] A) {
        int rows = A.length;
        int clos = A[0].length;

        int[][] result = new int[clos][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < clos; j++) {
                result[j][i] = A[i][j];
            }
        }
        return result;
    }


}
