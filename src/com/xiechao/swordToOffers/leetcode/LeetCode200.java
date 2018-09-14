package com.xiechao.swordToOffers.leetcode;

import java.util.Arrays;

/**
 * @author: xiehcao
 * @Date : 2018/9/12
 * @Time : 10:38
 * @description :求岛屿的个数
 */
public class LeetCode200 {

    //自己的方法 8ms

    public int numIslands(char[][] grid) {
        if( null == grid || grid.length <=0 || grid[0] == null ||
                grid[0].length <=0)
            return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] visited = new int[rows][];
        for (int i = 0; i < rows; i++) {
            visited[i] = new int[cols];
            Arrays.fill(visited[i],0);
        }

        int result = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(isIsland(grid,i,j,rows,cols,visited)){
                    result++;
                }
            }
        }
        return result;
    }

    private boolean isIsland(char[][] grid,int row, int col,int rows,int cols,int[][] visited){
        boolean isIsland = false;
        if(row >=0 && row < rows && col >= 0 && col < cols &&
                (grid[row][col] == '1') && (visited[row][col] == 0)){
            visited[row][col] = 1;
            isIsland = true;
            isIsland(grid,row+1,col,rows,cols,visited);
            isIsland(grid,row-1,col,rows,cols,visited);
            isIsland(grid,row,col+1,rows,cols,visited);
            isIsland(grid,row,col-1,rows,cols,visited);
        }
        return isIsland;
    }

    //leetCode大神 4ms

    public int numIslands2(char[][] grid){
        if( null == grid || grid.length <=0 || grid[0] == null ||
                grid[0].length <=0)
            return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int result = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(grid[i][j] == '1') {
                    result++;
                    dfs(grid,i,j,rows,cols);
                }
            }
        }
        return result;
    }
    private void dfs(char[][] grid,int row,int col,int rows,int cols){
        if(row >= 0 && row < rows && col >=0 && col < cols && (grid[row][col] =='1')){
            grid[row][col] = 'x';
            dfs(grid,row-1,col,rows,cols);
            dfs(grid,row+1,col,rows,cols);
            dfs(grid,row,col-1,rows,cols);
            dfs(grid,row,col+1,rows,cols);
        }
    }

}

