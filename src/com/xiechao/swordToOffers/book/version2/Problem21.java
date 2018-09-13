package com.xiechao.swordToOffers.book.version2;

import org.junit.Test;

import java.util.Arrays;

/**
 * 调整数组顺序使奇数位于偶数前面
 *
 */

public class Problem21 {
    //O(n)
    public void reOrderArray(int [] array) {
        if(null == array || array.length <= 0 )
            return;
        int p1 = 0;
        int p2 = array.length-1;
        while(p1 < p2){
            while( (p1 < p2) && (( array[p1] & 1) == 1))
                p1++;
            while((p1 < p2 ) && ((array[p2] & 1) ==0 )){
                p2--;
            }
            int temp = array[p1];
            array[p1] = array[p2];
            array[p2] = temp;
          /*  p1++;
            p2--;*/
        }
    }
 // O(n^2)
    public void reOrderArray2(int[] array){
        if( null == array || array.length <= 0)
            return;
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length-1; j++) {
                if((array[j] & 1) ==0){
                    int temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }



    @Test
    public void test(){
        int[] array = new int[]{1,2,3,4,5,6,7};
        reOrderArray2(array);
        System.out.println(Arrays.toString(array));

    }
}
