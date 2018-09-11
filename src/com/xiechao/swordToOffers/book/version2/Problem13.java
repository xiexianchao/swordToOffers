package com.xiechao.swordToOffers.book.version2;

import org.junit.Test;

import java.util.Arrays;

/**
 * 回溯法
 * 机器人的运动范围
 */
public class Problem13 {

    //11ms
    public int movingCount(int threshold, int rows, int cols)
    {
        if(threshold < 0 || rows <= 0 || cols <=0)
            return 0;
        int result = 0;
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            visited[i] = new boolean[cols];
            Arrays.fill(visited[i],false);
        }

        result = movingCountCore(threshold,rows,cols,0,0,visited);
        return result;


    }

    private int movingCountCore(int threshold, int rows, int cols, int row, int col, boolean[][] visited) {
        int count = 0;
        if(row < rows && row >=0 && col < cols && col >=  0 && !visited[row][col] && checkThreshold(row,col,threshold)){
            visited[row][col] = true;

            count = 1 + movingCountCore(threshold,rows,cols,row-1,col,visited) + movingCountCore(threshold,rows,cols,row+1,col,visited)
                    +movingCountCore(threshold,rows,cols,row,col-1,visited) + movingCountCore(threshold,rows,cols,row,col+1,visited);

        }
        return count;
    }
    private boolean checkThreshold(int row,int col,int threshold){
        boolean result = true;
        if(getDigitSum(row) + getDigitSum(col) > threshold){
            result = false;
        }
        return result;
    }

    private int getDigitSum(int row) {
        int sum = 0;
        while(row > 0){
            sum += row % 10;
            row = row  /10;
        }
        return sum;
    }
    @Test
    public void test(){
        System.out.println(getDigitSum(292));
    }


}
