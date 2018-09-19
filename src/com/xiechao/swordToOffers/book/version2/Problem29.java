package com.xiechao.swordToOffers.book.version2;

import java.util.ArrayList;

/**
 * @author: xiehcao
 * @Date : 2018/9/18
 * @Time : 11:01
 * @description :顺时针打印矩阵
 */
public class Problem29 {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        if (null == matrix || matrix.length <= 0 || null == matrix[0] || matrix[0].length <= 0)
            return list;
        int start= 0;
        int raws = matrix.length;
        int cols = matrix[0].length;
        while( raws > (start *2) && cols >(start *2)){
            int endX = cols - 1 - start;
            int endY = raws - 1 - start;
            for (int i = start; i <= endX; i++) {
                list.add(matrix[start][i]);
            }
            if(start < endY){
                for (int i = start+1; i <= endY ; i++) {
                    list.add(matrix[i][endX]);
                }
            }
            if( start < endX && start < endY){
                for (int i = endX-1; i >= start ; i--) {
                    list.add(matrix[endY][i]);
                }
            }
            if(start < endX && start < endY -1){
                for (int i = endY - 1; i >= start+1 ; i--) {
                    list.add(matrix[i][start]);
                }
            }
            start++;
        }
        return list;
    }

}
