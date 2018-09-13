package com.xiechao.swordToOffers.leetcode;

import java.util.Arrays;

/**
 * 回溯法
 * 岛屿最大面积
 */

public class LeetCode695 {
    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length <=0) return 0;
        if( grid[0] == null || grid[0].length <=0) return 0;

        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows ; i++) {
            visited[i] = new boolean[cols];
            Arrays.fill(visited[i],false);
        }
        int maxArea = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int temp = maxAreaOfIslandCore(grid,i,j,rows,cols,visited);
                if(maxArea < temp)
                {
                    maxArea = temp;
                }
            }
        }
        return maxArea;
    }

    private int maxAreaOfIslandCore(int[][] maxArea, int row, int col , int rows, int cols, boolean[][] visited) {
        int result = 0;
       if( row >= 0 && row < rows && col >=0 && col < cols && (maxArea[row][col] == 1) && !visited[row][col])
       {
           visited[row][col] = true;
           result = 1 + maxAreaOfIslandCore(maxArea,row,col+1,rows,cols,visited)
                   + maxAreaOfIslandCore(maxArea,row,col-1,rows,cols,visited)
                   + maxAreaOfIslandCore(maxArea,row-1,col,rows,cols,visited)
                   + maxAreaOfIslandCore(maxArea,row+1,col,rows,cols,visited);
       }
       return result;
    }


}
