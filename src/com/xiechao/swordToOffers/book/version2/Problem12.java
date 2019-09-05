package com.xiechao.swordToOffers.book.version2;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author: xiehcao
 * @Date : 2018/9/10
 * @Time : 21:26
 * @description :回溯法 矩阵中的路径
 */
public class Problem12 {
    int index;
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        if( matrix == null || rows <=0 || cols <=0)
            return false;
        boolean[][] visited = new boolean[rows][cols];
        for(int i = 0; i < rows;i++){
            visited[i] = new boolean[cols];
            Arrays.fill(visited[i],false);
        }
        for(int i = 0;i < rows ;i++)
        {
            for(int j = 0;j < cols;j++){
                index = 0;
                if(hasPathCore(matrix,rows,cols,i,j,str,visited))
                    return true;
               /* for(int k = 0; k < rows;k++){                       //这里不用重新设为false，因为当此节点不能包括在路径内时，
                                                                            已经重新设置为false
                    Arrays.fill(visited[k],false);
                }*/
            }
        }
        return false;
    }
    boolean hasPathCore(char[] matrix,int rows,int cols,int i,int j,char[] str,boolean[][] visited){
        boolean hasPath = false;
        if( index >= str.length)
            return true;
        if( i >=0 && i < rows && j >=0 && j < cols && matrix[i*cols+j] == str[index] && !visited[i][j]){
            index++;
            visited[i][j] = true;
            hasPath = hasPathCore(matrix,rows,cols,i+1,j,str,visited) || hasPathCore(matrix,rows,cols,i-1,j,str,visited)
                    ||hasPathCore(matrix,rows,cols,i,j-1,str,visited)||hasPathCore(matrix,rows,cols,i,j+1,str,visited);
            if(!hasPath){
                index --;
                visited[i][j] = false;
            }

        }
        return hasPath;
    }

    @Test
    public void test()
    {
        System.out.println(hasPath("ABCEHJIGSFCSLOPQADEEMNOEADIDEJFMVCEIFGGS".toCharArray(),5,8,"SLHECCEIDEJFGGFIE".toCharArray()));
    }
}
