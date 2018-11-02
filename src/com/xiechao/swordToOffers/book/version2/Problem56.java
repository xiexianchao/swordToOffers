package com.xiechao.swordToOffers.book.version2;

import org.junit.Test;

import java.nio.file.FileSystem;

/**
 * @ClassName Problem56
 * @Author xiechao
 * @Date 2018/11/2
 * @Time 10:42
 * @Description 数组中数字出现的次数
 * 其他都出现两次，有两个元素出现一次，找出这两个元素，要求时间复杂度为n，空间复杂度为1
 */
public class Problem56 {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array == null || array.length <= 1) return;
        int xor = 0;
        for (Integer e:array) {
            xor ^= e;
        }
        int n = getFirstNotZeroFromRight(xor);
        for (int i = 0; i < array.length; i++) {
            if(checkNth(array[i],n)){
                num1[0] ^= array[i];
            }else{
                num2[0] ^= array[i];
            }
        }
    }

    private boolean checkNth(int i, int n) {
        return (i & (1 << (n-1))) == 0;
    }

    //1 - 1；2 - 2
    private int getFirstNotZeroFromRight(int xor) {
        int count = 0;
        while(xor != 0){
            count ++;
            xor = xor >>>1;
        }
        return count;
    }
    @Test
    public void test(){
        FindNumsAppearOnce(new int[]{2,4,3,6,3,2,5,5},new int[]{0},new int[]{0});
    }
}
