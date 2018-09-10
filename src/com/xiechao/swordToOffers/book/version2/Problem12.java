package com.xiechao.swordToOffers.book.version2;

import java.util.Arrays;

/**
 * @author: xiehcao
 * @Date : 2018/9/10
 * @Time : 21:26
 * @description :回溯法 矩阵中的路径
 */
public class Problem12 {
    int index = 0;
    boolean hasPath(char[][] matrix,int cols,char[] str){
        if(null == matrix || matrix.length <=0 ||
                matrix[0] == null || matrix[0].length <=0)
            return false;
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < visited.length; i++) {
          visited[i] = new boolean[matrix[0].length];
          Arrays.fill(visited,false);
        }


        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(hasPathCore(matrix,i,j,0,visited,str))
                    return true;
            }
        }
        return false;
    }

    private boolean hasPathCore(char[][] matrix, int i, int j, int position, boolean[][] visited, char[] str) {
        boolean hasPath = false;
        if( position >= str.length) return true;
        if( i >=0 && i < matrix.length && j > 0 && j < matrix[0].length
                && matrix[i][j] == str[position] && !visited[i][j]){
            visited[i][j] = true;
            position++;

            hasPath = hasPathCore(matrix,i,j-1,position,visited,str);


        }
        return hasPath;
    }
}
