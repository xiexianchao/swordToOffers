package com.xiechao.swordToOffers.book.version2;

import org.junit.Test;

/**
 * @ClassName Problem47
 * @Author xiechao
 * @Date 2018/10/31
 * @Time 11:30
 * @Description 礼物的最大价值
 * 两种方法：
 * 1. dfs
 * 2. dp dp比较快
 */
public class Problem47 {
    //dfs
    public int getMax(int[][] gifts){
        if(gifts == null || gifts.length <=0 || gifts[0] == null || gifts[0].length <= 0)
            return 0;
        int[] max = new int[]{0};
        int rows = gifts.length;
        int cols = gifts[0].length;
        helper(max,gifts,rows,cols,0,0,0);
        return max[0];
    }

    private void helper(int[] max, int[][] gifts, int rows, int cols, int i, int j, int sum) {
        if( i == rows -1 && j == cols -1 ){
            max[0] = Math.max(sum+gifts[i][j],max[0]);
            return;
        }
        if( i >= rows || j >= cols)
            return;
        helper(max,gifts,rows,cols,i+1,j,sum+gifts[i][j]);
        helper(max,gifts,rows,cols,i,j+1,sum+gifts[i][j]);
        return;
    }
    //dp
    public int getMax2(int[][] gifts) {
        if(gifts == null || gifts.length <=0 || gifts[0] == null || gifts[0].length <= 0)
            return 0;
        int rows = gifts.length;
        int cols = gifts[0].length;
        int[][] dp = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dp[i][j] = gifts[i][j] + Math.max(i-1>=0 ? dp[i-1][j] : 0,j-1 >= 0 ? dp[i][j-1]:0);
            }
        }
        return dp[rows-1][cols-1];
    }
    @Test
    public void test(){
        int[][] array = new int[][]{{1,2,3},{3,4,5},{5,6,7}};
        System.out.println(getMax2(array));
    }
}
