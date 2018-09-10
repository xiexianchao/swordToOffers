package com.xiechao.swordToOffers.book.version2;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author: xiehcao
 * @Date : 2018/9/5
 * @Time : 15:28
 * @description :合并两个排序过的数组，结果也要求有序。时间复杂度O（n）;
 * @Method: 三个指针，从尾向前遍历
 */
public class Problem5_1 {
    public int[] mergeTwoSortedArray(int[] A1,int lengthOfA1,int[] A2){
        if(A1 ==null || A2 == null){
            return A1;
        }
        if( lengthOfA1 == 0)
            return A2;
        int p1 = lengthOfA1-1;
        int p2 = A1.length-1;
        int p3 = A2.length-1;
        while( p3 >= 0){
         if(p1 < 0){                 // 注意边界情况0
             A1[p2] = A2[p3];
             p2--;
             p3--;
         }
         else{                     //p2,p3,p1皆有可能超出数组索引范围
             if(A2[p3] >= A1[p1]){
                 A1[p2] = A2[p3];
                 p2--;
                 p3--;
             }else{
                 A1[p2] = A1[p1];
                 p1--;
                 p2--;
             }
         }
        }
        return  A1;
    }
    @Test
    public void test1(){
        int[] A1 = new int[]{0,1,3,4,0,0,0,0,0};
        int[] A2 = new int[]{-2,-1,2,3,5};
        System.out.println(Arrays.toString(mergeTwoSortedArray(A1,4,A2)));
    }

}
