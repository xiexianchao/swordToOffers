package com.xiechao.swordToOffers.leetcode;

/**
 * @ClassName LeetCode73
 * @Author xiechao
 * @Date 2018/10/10
 * @Time 20:26
 * @Description Set Matrix Zeroes
 */
public class LeetCode73 {
    //LeetCode大神 1ms
    public void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length <=0 || matrix[0] == null || matrix[0].length <=0)
           return;
        boolean isCol = false;
        for (int i = 0; i < matrix.length; i++) {
            if(matrix[i][0] == 0) isCol = true;
            for (int j = 1; j < matrix[i].length; j++) {
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        if(matrix[0][0] == 0){
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }
        if(isCol){
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
