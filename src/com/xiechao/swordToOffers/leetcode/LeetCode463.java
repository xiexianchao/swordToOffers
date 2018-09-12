package com.xiechao.swordToOffers.leetcode;

/**
 * @author: xiehcao
 * @Date : 2018/9/12
 * @Time : 11:12
 * @description :岛屿的周长
 */
public class LeetCode463 {
    int result = 0;
    public int islandPerimeter(int[][] grid) {
        if( null == grid || grid.length <=0 || grid[0] == null ||
                grid[0].length <=0)
            return 0;
        int rows = grid.length;
        int cols = grid[0].length;
      //  int result = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(grid[i][j] == 1){
                    result = dfs(grid,i,j,rows,cols);
                    break;
                }
            }
        }
        return result;
    }
    private int dfs(int[][] grid,int row,int col,int rows,int cols){
      //  int result = 0;
        if(row >=0 && row < rows && col >=0 && col < cols && (grid[row][col] ==1 || grid[row][col] == -1)){
           if(grid[row][col] == 1) {
               grid[row][col] = -1;
               result += 4;
               dfs(grid,row-1,col,rows,cols);
               dfs(grid,row+1,col,rows,cols);
               dfs(grid,row,col+1,rows,cols);
               dfs(grid,row,col-1,rows,cols);
           }else{
                result = result-2;
           }

        }
        return result;
    }


}
