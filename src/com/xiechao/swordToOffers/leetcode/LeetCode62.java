package com.xiechao.swordToOffers.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author: xiehcao
 * @Date : 2018/9/28
 * @Time : 15:37
 * @description :62 Unique Paths
 * 机器人从(0,0)走到(m,n)有多少种走法，每次只能向上或者向右走一步
 *
 *
 */
public class LeetCode62 {
    public int uniquePaths(int m, int n) {
        if(m <=0 || n<=0) return 0;
        // build and init
        int[][] paths = new int[n][m];
        for (int i = 0; i < paths.length; i++) {
            paths[i] = new int[m];
            paths[i][0] = 1;
        }
        Arrays.fill(paths[0],1);
        for (int i = 1; i < paths.length; i++) {
            for (int j = 1; j < paths[0].length; j++) {
                paths[i][j] = paths[i-1][j] + paths[i][j-1];
            }
        }
        return paths[n-1][m-1];
    }
    @Test
    public void test(){
        System.out.println(uniquePaths(7,3));
    }

}
