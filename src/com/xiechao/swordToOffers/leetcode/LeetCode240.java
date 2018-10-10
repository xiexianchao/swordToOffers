package com.xiechao.swordToOffers.leetcode;

/**
 * @author: xiehcao
 * @Date : 2018/10/10
 * @Time : 8:51
 * @description :240. Search a 2D Matrix II
 */
public class LeetCode240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length <=0 || matrix[0] == null || matrix[0].length <=0)
            return false;
        int rows = matrix.length;
        int cols = matrix[0].length;
        if(target < matrix[0][0] || target > matrix[rows - 1][cols - 1]) return false;
        int startX = 0;
        int startY = cols-1;
        while((startX + 1 <= rows) && (startY >= 0)){
            if(matrix[startX][startY] == target) return true;
            else if(matrix[startX][startY] > target) startY--;
            else startX++;
        }
        return false;
    }
}
