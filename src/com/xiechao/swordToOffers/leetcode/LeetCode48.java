package com.xiechao.swordToOffers.leetcode;

/**
 * @author: xiehcao
 * @Date : 2018/9/28
 * @Time : 16:22
 * @description :
 */
public class LeetCode48 {
    //LeetCode大神
    public void rotate(int[][] matrix) {
        if(matrix == null || matrix.length <=0 || matrix[0] == null || matrix[0].length <=0) return;
        int n = matrix.length - 1;
        for (int i = 0; i <= n/2; i++) {
            for (int j = i; j < n - i; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[n-j][i];
                matrix[n-j][i] = matrix[n-i][n-j];
                matrix[n-i][n-j] = matrix[j][n-i];
                matrix[j][n-i] = t;
            }
        }
    }
}
