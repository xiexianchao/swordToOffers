package com.xiechao.swordToOffers.book.version2;

/**
 * @author: xiehcao
 * @Date : 2018/9/5
 * @Time : 15:03
 * @description :二维数组中的查找
 */

//牛客网测试 140ms
public class Problem4 {
    public boolean isExists(int[][] array,int target){
        boolean result = false;
        if( array != null && array.length >0 && array[0] !=null && array[0].length >0){
            int j = 0;
            int i = array.length-1;
            while( i>=0 && j <= (array[0].length-1)){
             if(array[i][j] == target){
                 result = true;
                 break;
             }
             if(array[i][j] > target)
                i--;
             else if(array[i][j] < target){
                j++;
             }
            }
        }
        return result;
    }
}
