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
                    result = result + 4;
                    if(((j+1) < cols )&& grid[i][j+1] == 1)
                        result = result-2;
                    if(((i+1) < rows && grid[i+1][j] == 1))
                        result = result - 2;

                }
            }
        }
        return result;
    }

    public int islandPerimeter2(int[][] grid) {
        if( null == grid || grid.length <=0 || grid[0] == null ||
                grid[0].length <=0)
            return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0 ;
        for (int i = 0; i < rows ; i++) {
            for (int j = 0; j < cols; j++) {
                if(grid[i][j] == 1) {
                    if((j == 0 && i ==0 )|| (j == cols -1 && i==0) ||(j==cols-1 && i == rows-1)||(i == rows-1 && j == 0 )){
                        count +=2;
                    }
                    if((i == 0 || i == rows-1 )&&(j !=0 || j !=cols-1))
                       count++;
                   else{
                       if(grid[i-1][j] == 0)
                           count++;
                       if(grid[i+1][j] == 0)
                           count++;

                   }
                   if(j == 0 || j == cols -1) {
                       if((j == 0 && i !=0 )|| (j == cols -1 && i!=0) ||(j==cols-1 && i != rows-1)||(i != rows-1 && j == 0 )){
                           count++;
                       }else{
                           if(grid[i][j-1] == 0)
                               count++;
                           if(grid[i][j+1] == 0)
                               count++;
                       }

                   }
                }else{

                }

            }
        }
        return count;

    }


}
